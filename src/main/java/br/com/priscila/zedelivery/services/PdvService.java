package br.com.priscila.zedelivery.services;

import br.com.priscila.zedelivery.model.Pdv;
import br.com.priscila.zedelivery.repository.PdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PdvService {

    @Autowired
    private PdvRepository repository;

    public List<Pdv> findAll(){
        return repository.findAll();
    }

    public Pdv findById(Long id){
        Optional<Pdv> obj = repository.findById(id);
        return obj.get();
    }

}
