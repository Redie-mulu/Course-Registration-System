package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:04 AM
 */
@Mapper(componentModel = "spring")
public interface AcademicBlockMapper {
    public AcademicBlock getAcademicBlockFromAcademicBlockDto(AcademicBlockDto academicBlockDto);
    public AcademicBlockDto getAcademicBlockDtoFromAcademicBlock(AcademicBlock academicBlock);
    public List<AcademicBlockDto> getAcademicBlockDtosFromAcademicBlocks(List<AcademicBlock> academicBlocks);
    public List<AcademicBlock> getAcademicBlocksFromAcademicBlockDtos(List<AcademicBlockDto> academicBlockDtos);

}
