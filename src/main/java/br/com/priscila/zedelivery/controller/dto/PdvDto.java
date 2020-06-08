package br.com.priscila.zedelivery.dto;

import br.com.priscila.zedelivery.model.Address;
import br.com.priscila.zedelivery.model.CoverageArea;
import br.com.priscila.zedelivery.model.Pdv;

import java.util.List;
import java.util.stream.Collectors;

public class PdvDto {
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;

    private CoverageArea coverageArea;

    private Address address;


    public PdvDto(Pdv pdv) {
        this.id = pdv.getId();
        this.tradingName = pdv.getTradingName();
        this.ownerName = pdv.getOwnerName();
        this.document = pdv.getDocument();
        this.coverageArea = pdv.getCoverageArea();
        this.address = pdv.getEndereco();
    }

    public static List<PdvDto> converter(List<Pdv> pdvs){
        return pdvs.stream().map(PdvDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDocument() {
        return document;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }

    public Address getAddress() {
        return address;
    }
}


