package com.br.schoolreyfow.matter;

import com.br.schoolreyfow.matter.model.dto.MatterDTO;
import com.br.schoolreyfow.matter.model.mapper.MatterMapper;
import com.br.schoolreyfow.matter.repository.MatterRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatterService {

    private final MatterRepository matterRepository;
    private final MatterMapper mapperInstance = Mappers.getMapper(MatterMapper.class);

    @Transactional
    public void create(MatterDTO matterDTO) {
        var matter = mapperInstance.matterDTOToMatter(matterDTO);
        this.matterRepository.save(matter);
    }

    public List<MatterDTO> findAll(Pageable pageable) {
        var matterPage = this.matterRepository.findAll(pageable);
        var matters = matterPage.getContent();
        return matters.stream().map(mapperInstance::matterToMatterDTO)
                .collect(java.util.stream.Collectors.toList());
    }


}

