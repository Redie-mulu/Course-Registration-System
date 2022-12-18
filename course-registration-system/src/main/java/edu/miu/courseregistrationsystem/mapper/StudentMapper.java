package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import org.mapstruct.Mapper;
import java.util.List;

/** @author: Redie
 * @Version: 1.0
 * @created: 10/12/2020 10:00 AM
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

    public Student getStudentFromStudentDto(StudentDto studentDto);

    public StudentDto getStudentDtoFromStudent(Student student);

    public List<StudentDto> getStudentDtosFromStudents(List<Student> students);

    public List<Student> getStudentsFromStudentDtos(List<StudentDto> studentDtos);
}


