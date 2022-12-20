package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.mapper.RegistrationGroupMapper;
import edu.miu.courseregistrationsystem.repository.AcademicBlockRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationGroupRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 18-Dec-2022 5:59 PM
 */
@Service
@Transactional
public class RegistrationGroupServiceImp implements RegistrationGroupService {
    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;
    @Autowired
    private RegistrationGroupMapper registrationGroupMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    /**
     * @author Rediet
     * @param registrationGroupDto
     * @return RegistrationGroupDto
     * adming can create empty registration group
     */
    @Override
    public RegistrationGroupDto creatRegistrationGroup(RegistrationGroupDto registrationGroupDto) {
        System.out.println(registrationGroupMapper.registrationGroupFromRegistrationGroupDto(registrationGroupDto));
        registrationGroupRepository.save(registrationGroupMapper.registrationGroupFromRegistrationGroupDto(registrationGroupDto));
        return registrationGroupDto;
    }

    @Override
    public void updateRegistrationGroup(long registrationGroupId, List<Long> studentIds, Long academicBlockId) {
        /**
         * @param registrationGroupId
         * @param studentIds
         * @param academicBlockId
         * admin can update registration group by adding students and academic block
         * admin will add acadamic block to the existing academic block
         * admin will add a list of registered students to registration group
         */
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(registrationGroupId).get();
        HashMap<Long, Student> existingStudent  = new HashMap<>();
        for (Student student: registrationGroup.getStudents()) {
            existingStudent.put(student.getId(), student);
        }

        for (Long studentId : studentIds) {
            Student student = studentRepository.findById(studentId).get();
            if (!existingStudent.containsKey(studentId)) {
                registrationGroup.getStudents().add(student);
            }
        }
        List<AcademicBlock> academicBlocksForRegistrationGroup = registrationGroup.getAcademicBlocks();
        AcademicBlock academicBlock = academicBlockRepository.findById(academicBlockId).get();
        academicBlocksForRegistrationGroup.add(academicBlock);
        registrationGroup.setAcademicBlocks(academicBlocksForRegistrationGroup);

        registrationGroupRepository.save(registrationGroup);
    }

    @Override
    public RegistrationGroup getRegistrationGroupById(long id) {
        return registrationGroupRepository.findById(id).get();
    }

    @Override
    public List<RegistrationGroupDto> getAllRegistrationGroups() {
        List<RegistrationGroup> registrationGroups = registrationGroupRepository.findAll();
        List<RegistrationGroupDto> registrationGroupDtos = registrationGroupMapper.registrationGroupDtosFromRegistrationGroups(registrationGroups);
        return registrationGroupDtos;
    }


    /**
     * @author Rediet
     * student can get all the registration group he/she is registered
     */
    @Override
    public List<RegistrationGroup> getRegistrationGroupByStudentIds(long studentId) {
        List<RegistrationGroup> registrationGroups = registrationGroupRepository.findAll();
        List<RegistrationGroup> registrationGroupsForStudent = new ArrayList<>();
        for(RegistrationGroup registrationGroup : registrationGroups){
            List<Student> students = registrationGroup.getStudents();
            for(Student student : students){
                if(student.getId() == studentId){
                    registrationGroupsForStudent.add(registrationGroup);
                }
            }
        }
        return registrationGroupsForStudent;
    }
}
