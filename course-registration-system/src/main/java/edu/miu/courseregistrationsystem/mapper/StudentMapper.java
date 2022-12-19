package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import org.mapstruct.Mapper;
import java.util.List;

/** @author: Rediet
 * @Version: 1.0
 * @created: 10/12/2020 10:00 AM
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

    public Student studentFromStudentDto(StudentDto studentDto);

    public StudentDto studentDtoFromStudent(Student student);

    public List<StudentDto> studentDtosFromStudents(List<Student> students);

    public List<Student> studentsFromStudentDtos(List<StudentDto> studentDtos);
}


