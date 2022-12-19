package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "Spring")
public interface AcademicBlockMapper {
    public AcademicBlock getAcademicBlockFromAcademicBlockDto(AcademicBlockDto academicBlockDto);

    public AcademicBlockDto getAcademicBlockDtoFromAcademicBlock(AcademicBlock academicBlock);

    public List<AcademicBlockDto> getAcademicBlockDtoFromAcademicBlocks(List<AcademicBlock> academicBlocks);

    public List<AcademicBlock> getAcademicBlocksFromAcademicBlockDto(List<AcademicBlockDto> academicBlockDto);
}
