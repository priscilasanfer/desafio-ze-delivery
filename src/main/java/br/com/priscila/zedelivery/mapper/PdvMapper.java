package br.com.priscila.zedelivery.mapper;

import br.com.priscila.zedelivery.controller.dto.PdvDto;
import br.com.priscila.zedelivery.model.Pdv;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PdvMapper {

    PdvMapper INSTANCE = Mappers.getMapper(PdvMapper.class);

    Pdv pdvDtoToPdv(PdvDto pdvDto);
    PdvDto pdvToPdvDto(Pdv pdv);
}
