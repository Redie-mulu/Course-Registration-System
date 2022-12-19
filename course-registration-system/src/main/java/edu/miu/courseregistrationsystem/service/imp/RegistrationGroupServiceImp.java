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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 18-Dec-2022 5:59 PM
 */
@Service
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
        List<Student> students = new ArrayList<>();
        for (Long studentId : studentIds) {
            Student student = studentRepository.findById(studentId).get();
            students.add(student);
        }
        List<AcademicBlock> academicBlocksForRegistrationGroup = registrationGroup.getAcademicBlocks();
        AcademicBlock academicBlock = academicBlockRepository.findById(academicBlockId).get();
        academicBlocksForRegistrationGroup.add(academicBlock);
        registrationGroupRepository.save(registrationGroup);
    }

    @Override
    public RegistrationGroup getRegistrationGroupById(long id) {
        return registrationGroupRepository.findById(id).get();
    }

    @Override
    public List<RegistrationGroup> getAllRegistrationGroupsByStudentId(long studentId) {
        return null;
    }
}
