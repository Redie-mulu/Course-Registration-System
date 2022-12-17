package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hermann.tipoh@gmail.com">Koffi Adolf Hermann Tipoh </a>
 * @version %I% %G%
 * @since 12/17/2022
 *
 * Interface to map StudentDto to Student and vice versa
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student studentDtoToStudent(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);

    List<StudentDto> studentsToStudentDtos(List<Student> students);
}
