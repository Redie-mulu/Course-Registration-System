package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import edu.miu.courseregistrationsystem.entity.CourseOffering;
import edu.miu.courseregistrationsystem.mapper.AcademicBlockMapper;
import edu.miu.courseregistrationsystem.repository.AcademicBlockRepository;
import edu.miu.courseregistrationsystem.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AcademicBlockServiceImp implements AcademicBlockService {

    private AcademicBlockMapper academicBlockMapper;
    @Autowired
    AcademicBlockRepository academicBlockRepository;
    @Override
    public AcademicBlockDto createAcademicBlock(AcademicBlockDto academicBlockDto) {
        AcademicBlock academicBlock = academicBlockMapper.academicBlockFromAcademicBlockDto(academicBlockDto);
        academicBlockRepository.save(academicBlock);
        return academicBlockDto;
    }

    @Override
    public AcademicBlockDto getAcademicBlock(long id) {
        AcademicBlock academicBlock = academicBlockRepository.findById(id).get();
        AcademicBlockDto academicBlockDto = academicBlockMapper.academicBlockDtoFromAcademicBlock(academicBlock);
        return  academicBlockDto;
    }

    @Override
    public AcademicBlockDto updateAcademicBlock(long id, AcademicBlockDto academicBlockDto) {
        AcademicBlock academicBlock = academicBlockMapper.academicBlockFromAcademicBlockDto(academicBlockDto);
        academicBlockRepository.save(academicBlock);
        return academicBlockDto;
    }

    @Override
    public void deleteAcademicBlock(long id) {
        academicBlockRepository.deleteById(id);
    }

    @Override
    public List<AcademicBlockDto> getAllAcademicBlocks() {
        List<AcademicBlock> academicBlocks = academicBlockRepository.findAll();
        List<AcademicBlockDto> academicBlockDtos = academicBlockMapper.academicBlockDtosFromAcademicBlocks(academicBlocks);
        return academicBlockDtos;
    }

    /**
     * @author Rediet
     * @param studentId
     * @return
     * student can get all the academic blocks he/she is registered
     */
    @Override
    public List<AcademicBlockStudentDto> getAcademicBlocksByStudent(long studentId) {
        List<AcademicBlock> academicBlocks = academicBlockRepository.findAll();
        List<AcademicBlock> academicBlocksByStudent = new ArrayList<>();
        for (AcademicBlock academicBlock: academicBlocks) {
            List<CourseOffering> courseOfferings = academicBlock.getCourseOfferings();
            for (CourseOffering courseOffering: courseOfferings) {
                if (courseOffering.getStudents().contains(studentId)) {
                    academicBlocksByStudent.add(academicBlock);
                }
            }

        }
       // return academicBlockMapper.academicBlockStudentDtosFromAcademicBlocks(academicBlocksByStudent);
       return null;
    }
}
