package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.mapper.StudentMapper;
import edu.miu.courseregistrationsystem.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto registerStudent(StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
//        Student student = modelMapper.map(studentDto, Student.class);
        System.out.println(student);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public void dropStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentMapper.studentFromStudentDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public StudentDto getStudent(long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = studentMapper.studentDtoFromStudent(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = studentMapper.studentDtosFromStudents(students);
        return studentDtos;
    }

    /**
     * @author Rediet
     * @param students
     * admin can add students
     * @return
     */
    @Override
    public List<Student> addStudents(List<StudentDto> students) {

        return studentRepository.saveAll(studentMapper.studentsFromStudentDtos(students));
    }
    public void addStudent(StudentDto studentDto){
        System.out.println("new student ");
        if (studentDto.getId() == null) {
            throw new IllegalArgumentException("StudentDto must have a non-null id");
        }
        Student student = studentMapper.studentFromStudentDto(studentDto);
        studentRepository.save(student);

    }
}
