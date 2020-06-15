package br.com.priscila.zedelivery.services;

import br.com.priscila.zedelivery.domain.Pdv;
import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
import br.com.priscila.zedelivery.mapper.PdvMapper;
import br.com.priscila.zedelivery.repository.PdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PdvService {

    private PdvRepository repository;

    public List<PdvResponseDto> findAll() {
        return repository.findAll().stream()
                .map(pdv -> PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv))
                .collect(Collectors.toList());
    }

    public PdvResponseDto findById(Long id) {
        Pdv pdv = repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv);
    }

    public List<PdvResponseDto> findByName(String tradingName) {
        return repository.findByTradingNameContainingIgnoreCase(tradingName).stream()
                .map(pdv -> PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv))
                .collect(Collectors.toList());
    }

    public Pdv insert(PdvResponseDto pdvResponseDto) {
        return repository.save(PdvMapper.INSTANCE.pdvResponseDtoToPdv(pdvResponseDto));
    }
}
