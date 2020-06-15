package br.com.priscila.zedelivery.dto.request;

import br.com.priscila.zedelivery.domain.Address;
import br.com.priscila.zedelivery.domain.CoverageArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdvRequestDto {

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Name must not be less than 2 characters")
    private String tradingName;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Trading Name must not be less than 2 characters")
    private String ownerName;

    @NotNull(message = "Document cannot be null")
    @Size(min = 2, message = "Document must not be less than 2 characters")
    private String document;

    private CoverageArea coverageArea;

    private Address address;


}
