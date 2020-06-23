package br.com.priscila.zedelivery.services;

import br.com.priscila.zedelivery.domain.Pdv;
import br.com.priscila.zedelivery.dto.request.PdvRequestDto;
import br.com.priscila.zedelivery.dto.request.PdvUpdateRequestDTO;
import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
import br.com.priscila.zedelivery.exception.DatabaseException;
import br.com.priscila.zedelivery.exception.HttpMessageNotReadableException;
import br.com.priscila.zedelivery.exception.ResourceNotFoundException;
import br.com.priscila.zedelivery.mapper.PdvMapper;
import br.com.priscila.zedelivery.repository.PdvRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
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
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv);
    }

    public List<PdvResponseDto> findByName(String tradingName) {
        return repository.findByTradingNameContainingIgnoreCase(tradingName).stream()
                .map(pdv -> PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv))
                .collect(Collectors.toList());
    }

    public PdvResponseDto insert(PdvRequestDto pdvRequestDto) {
        Pdv pdv = PdvMapper.INSTANCE.pdvRequestDtoToPdv(pdvRequestDto);
        pdv = repository.save(pdv);
        return PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public PdvResponseDto update(Long id, PdvUpdateRequestDTO pdvUpdateRequestDTO) {
        try {
            Pdv pdv = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            pdv.setOwnerName(pdvUpdateRequestDTO.getOwnerName());
            pdv.setTradingName(pdvUpdateRequestDTO.getTradingName());
            pdv.setCoverageArea(pdvUpdateRequestDTO.getCoverageArea());
            pdv = repository.save(pdv);
            return PdvMapper.INSTANCE.pdvToPdvResponseDto(pdv);
        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        }
    }

    public PdvResponseDto search(Double lat, Double lgn) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(lat,lgn));

        List<Pdv> list = repository.findAll();

        Double pdvDistance = 0.0;
        Double lessDistant = Double.MAX_VALUE;
        Pdv closestPDV = null;

        for (Pdv pdv: list) {
            if(!point.equalsExact(pdv.getAddress())){
                pdvDistance = Point2D.distance(lat, pdv.getAddress().getX(), lgn, pdv.getAddress().getY());
                System.out.println(pdvDistance);
                if (pdvDistance < lessDistant) {
                    lessDistant = pdvDistance;
                    closestPDV = pdv;
                }
            }
        }
        System.out.println(closestPDV);
        return PdvMapper.INSTANCE.pdvToPdvResponseDto(closestPDV);
    }

}
