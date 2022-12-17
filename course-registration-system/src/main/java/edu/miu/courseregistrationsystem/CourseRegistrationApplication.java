package edu.miu.courseregistrationsystem;

import edu.miu.courseregistrationsystem.config.ConfigFileExternalizationConfig;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.repository.AddressRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableScheduling
@SpringBootApplication(scanBasePackages = {"edu.miu.courseregistrationsystem"})
@EntityScan(basePackages = {"edu.miu.courseregistrationsystem"})
@EnableJpaRepositories(basePackages = {"edu.miu.courseregistrationsystem"})
public class CourseRegistrationApplication implements CommandLineRunner {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private StudentRepository studentRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRegistrationApplication.class);

	public static void main(String[] args) {
		if (ConfigFileExternalizationConfig.createConfigFiles()
				!= ConfigFileExternalizationConfig.CONFIG_FILES_ERROR_STATE) {
			ConfigurableApplicationContext app = new SpringApplicationBuilder(
					CourseRegistrationApplication.class)
					.build().run(ConfigFileExternalizationConfig.enhanceArgs(args));
			Environment env = app.getEnvironment();
			String protocol = "http";
			if (env.getProperty("server.ssl.key-store") != null) {
				protocol = "https";
			}
			LOGGER.info("\n----------------------------------------------------------\n\t"
							+ "Application '{}' is running! Access URLs:\n\t"
							+ "Local: \t\t{}://localhost:{}\n\t"
							+ "Profile(s): \t{}\n----------------------------------------------------------",
					env.getProperty("spring.application.name"),
					protocol,
					env.getProperty("server.port"),
					env.getActiveProfiles());
		} else {
			LOGGER.error("Please proceed to manually creation of configuration files!");
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address( "1000 N 4th St", "Fairfield","5227", "Iowa", "Usa");
		addressRepository.save(address);
		Student student = new Student(1,"John",  "john@miu.edu", address);
		studentRepository.save(student);
	}
}
