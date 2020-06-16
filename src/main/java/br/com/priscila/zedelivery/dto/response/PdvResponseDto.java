package br.com.priscila.zedelivery.dto.response;

import br.com.priscila.zedelivery.domain.Address;
import br.com.priscila.zedelivery.domain.CoverageArea;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private CoverageArea coverageArea;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Address address;
}


