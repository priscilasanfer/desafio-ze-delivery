package br.com.priscila.zedelivery.mapper;

import br.com.priscila.zedelivery.domain.Pdv;
import br.com.priscila.zedelivery.dto.request.PdvRequestDto;
import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PdvMapper {

    PdvMapper INSTANCE = Mappers.getMapper(PdvMapper.class);

    Pdv pdvRequestDtoToPdv(PdvRequestDto pdvRequestDto);
    PdvResponseDto pdvToPdvResponseDto(Pdv pdv);
}
