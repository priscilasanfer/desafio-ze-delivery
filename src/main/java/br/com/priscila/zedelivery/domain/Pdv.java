package br.com.priscila.zedelivery.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pdv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Trading Name must not be less than 2 characters")
    private String tradingName;

    @NotNull(message = "Trading Name cannot be null")
    @Size(min = 2, message = "Trading Name must not be less than 2 characters")
    private String ownerName;

    @NotNull(message = "Document cannot be null")
    @Size(min = 2, message = "Document must not be less than 2 characters")
    private String document;

    @OneToOne(cascade = CascadeType.ALL)
    private CoverageArea coverageArea;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
