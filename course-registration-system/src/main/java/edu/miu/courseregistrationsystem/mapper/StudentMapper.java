package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * * @author: Redie
 * @author <a href="mailto:hermann.tipoh@gmail.com">Koffi Adolf Hermann Tipoh </a>
 * @version %I% %G%
 * @since 12/17/2022
 *
 * Interface to map StudentDto to Student and vice versa
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {


    public Student studentFromStudentDto(StudentDto studentDto);

    public StudentDto getStudentDtoFromStudent(Student student);

    public List<StudentDto> getStudentDtosFromStudents(List<Student> students);

    public List<Student> getStudentsFromStudentDtos(List<StudentDto> studentDtos);

}


