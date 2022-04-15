package com.br.schoolreyfow.matter.model.mapper;

import com.br.schoolreyfow.matter.model.Matter;
import com.br.schoolreyfow.matter.model.dto.MatterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatterMapper {

    @Mapping(target = "teacher.id",source = "teacherId")
    Matter matterDTOToMatter(MatterDTO matterDTO);

    @Mapping(target = "teacherId", source = "teacher.id")
    MatterDTO matterToMatterDTO(Matter matter);
}
