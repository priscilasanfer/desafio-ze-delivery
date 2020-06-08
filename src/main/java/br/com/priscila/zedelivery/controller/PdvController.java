package br.com.priscila.zedelivery.controller;


import br.com.priscila.zedelivery.model.Pdv;
import br.com.priscila.zedelivery.services.PdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/pdvs")
public class PdvController {

    @Autowired
    private PdvService service;

    @GetMapping
    public ResponseEntity<List<Pdv>> listaTodos() {
        List<Pdv> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pdv> findById(@PathVariable Long id){
        Pdv obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
