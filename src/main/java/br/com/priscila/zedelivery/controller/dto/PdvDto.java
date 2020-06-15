package br.com.priscila.zedelivery.controller.dto;

import br.com.priscila.zedelivery.model.Address;
import br.com.priscila.zedelivery.model.CoverageArea;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdvDto {
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;

    private CoverageArea coverageArea;

    private Address address;
}


