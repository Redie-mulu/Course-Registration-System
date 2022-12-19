package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.dto.CourseOfferingDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;

public interface AcademicBlockService {
    public AcademicBlockDto createAcademicBlock(AcademicBlockDto academicBlockDto);
    public AcademicBlockDto getAcademicBlock(long id);
    public AcademicBlockDto updateAcademicBlock(long id, AcademicBlockDto academicBlockDto);
    public void deleteAcademicBlock(long id);
}
