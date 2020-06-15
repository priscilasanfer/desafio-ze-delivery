package br.com.priscila.zedelivery.controller;

import br.com.priscila.zedelivery.controller.dto.PdvDto;
import br.com.priscila.zedelivery.services.PdvService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pdvs")
@AllArgsConstructor
public class PdvController {

    private PdvService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PdvDto> listaTodos() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public PdvDto findById(@PathVariable Long id){
        return service.findById(id);
    }

}
