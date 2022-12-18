package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;

import java.util.ArrayList;
import java.util.List;

public class AcademicBlockMapper {
    public static AcademicBlock getAcademicBlockFromAcademicBlockDto(AcademicBlockDto academicBlockDto) {
        AcademicBlock academicBlock = new AcademicBlock(academicBlockDto.getId(), academicBlockDto.getCode(), academicBlockDto.getName(), academicBlockDto.getSemester(),
                academicBlockDto.getStartDate(), academicBlockDto.getEndDate(),CourseOfferingMapper.getCourseOfferingsFromCourseOfferingDtos(academicBlockDto.getCourseOfferings()));
        academicBlock.setId(academicBlockDto.getId());
        return academicBlock;
    }
    public static AcademicBlockDto getAcademicBlockDtoFromAcademicBlock(AcademicBlock academicBlock) {
        AcademicBlockDto academicBlockDto = new AcademicBlockDto(academicBlock.getId(), academicBlock.getCode(), academicBlock.getName(), academicBlock.getSemester(),
                academicBlock.getStartDate(), academicBlock.getEndDate(),CourseOfferingMapper.getCourseOfferingDtosFromCourseOfferings(academicBlock.getCourseOfferings()));
        return academicBlockDto;
    }
    public static List<AcademicBlockDto> getAcademicBlockDtosFromAcademicBlocks(List<AcademicBlock> academicBlocks) {
        List<AcademicBlockDto> academicBlockDtos = new ArrayList<>();
        for (AcademicBlock academicBlock : academicBlocks) {
            academicBlockDtos.add(getAcademicBlockDtoFromAcademicBlock(academicBlock));
        }
        return academicBlockDtos;
    }
    public static List<AcademicBlock> getAcademicBlocksFromAcademicBlockDtos(List<AcademicBlockDto> academicBlockDtos) {
        List<AcademicBlock> academicBlocks = new ArrayList<>();
        for (AcademicBlockDto academicBlockDto : academicBlockDtos) {
            academicBlocks.add(getAcademicBlockFromAcademicBlockDto(academicBlockDto));
        }
        return academicBlocks;
    }
}
