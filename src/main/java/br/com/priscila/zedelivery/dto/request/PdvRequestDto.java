package br.com.priscila.zedelivery.dto.request;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdvRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Name must not be less than 2 characters")
    private String tradingName;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Trading Name must not be less than 2 characters")
    private String ownerName;

    @NotNull(message = "Document cannot be null")
    @Size(min = 2, message = "Document must not be less than 2 characters")
    private String document;


    @Getter
    @Setter
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point address;

}
