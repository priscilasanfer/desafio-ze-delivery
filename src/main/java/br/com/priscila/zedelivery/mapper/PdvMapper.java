package br.com.priscila.zedelivery.mapper;

import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
import br.com.priscila.zedelivery.domain.Pdv;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PdvMapper {

    PdvMapper INSTANCE = Mappers.getMapper(PdvMapper.class);

    Pdv pdvDtoToPdv(PdvResponseDto pdvResponseDto);
    PdvResponseDto pdvToPdvDto(Pdv pdv);
}
