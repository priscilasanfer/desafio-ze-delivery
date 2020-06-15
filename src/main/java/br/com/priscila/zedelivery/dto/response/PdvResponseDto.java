package br.com.priscila.zedelivery.dto.response;

import br.com.priscila.zedelivery.domain.Address;
import br.com.priscila.zedelivery.domain.CoverageArea;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdvResponseDto {
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;

    private CoverageArea coverageArea;

    private Address address;
}


