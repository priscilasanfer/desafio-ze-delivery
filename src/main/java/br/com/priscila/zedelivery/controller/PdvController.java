package br.com.priscila.zedelivery.controller;


import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
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
    public List<PdvResponseDto> listaTodos() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public PdvResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
//
//    @GetMapping("/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<PdvResponseDto> getPdvByName(@PathVariable("name") String name) {
//        return service.findByName(name);
//    }
}
