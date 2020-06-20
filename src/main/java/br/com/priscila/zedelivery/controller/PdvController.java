package br.com.priscila.zedelivery.controller;


import br.com.priscila.zedelivery.dto.request.PdvRequestDto;
import br.com.priscila.zedelivery.dto.response.PdvResponseDto;
import br.com.priscila.zedelivery.services.PdvService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{tradingName}")
    public List<PdvResponseDto> getPdvByTrandingName(@PathVariable("tradingName") String trandingName) {
        return service.findByName(trandingName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PdvResponseDto createPdv(@Valid @RequestBody PdvRequestDto pdvRequestDto){
        return service.create(pdvRequestDto);
    }
}
