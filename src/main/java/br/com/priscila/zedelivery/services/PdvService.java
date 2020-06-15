package br.com.priscila.zedelivery.services;

import br.com.priscila.zedelivery.controller.dto.PdvDto;
import br.com.priscila.zedelivery.mapper.PdvMapper;
import br.com.priscila.zedelivery.model.Pdv;
import br.com.priscila.zedelivery.repository.PdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PdvService {

    private PdvRepository repository;

    public List<PdvDto> findAll() {
        return repository.findAll().stream()
                .map(pdv -> PdvMapper.INSTANCE.pdvToPdvDto(pdv))
                .collect(Collectors.toList());
    }

    public PdvDto findById(Long id) {
        Optional<Pdv> obj = repository.findById(id);
        return PdvMapper.INSTANCE.pdvToPdvDto(obj.get());
    }



//    public PaymentResponse findById(Long id) {
//        Payment payment = paymentRepository
//                .findById(id)
//                .orElseThrow(ResourceNotFoundException::new);
//        return PaymentMapper.INSTANCE.paymentToPaymentResponse(payment);
//    }
}
