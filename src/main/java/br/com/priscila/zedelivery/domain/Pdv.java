package br.com.priscila.zedelivery.domain;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pdv  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, max = 30,  message = "Trading Name must not be less than 2 characters or more than 30 characters")
    private String tradingName;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, max = 30,  message = "Owner Name must not be less than 2 characters or more than 30 characters")
    private String ownerName;

    @NotNull(message = "Document cannot be null")
    @Size(min = 2, max = 30,  message = "Document must not be less than 2 characters or more than 30 characters")
    private String document;

    @NotNull(message = "Please provide the address")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point address;

}
