package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;

import java.util.List;

public interface AcademicBlockService {
    public AcademicBlockDto createAcademicBlock(AcademicBlockDto academicBlockDto);
    public AcademicBlockDto getAcademicBlock(long id);
    public AcademicBlockDto updateAcademicBlock(long id, AcademicBlockDto academicBlockDto);
    public void deleteAcademicBlock(long id);
    public List<AcademicBlockDto> getAllAcademicBlocks();
}
