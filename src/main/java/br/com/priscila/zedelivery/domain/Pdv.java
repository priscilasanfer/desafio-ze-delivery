package br.com.priscila.zedelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pdv {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pdv)) return false;
        Pdv pdv = (Pdv) o;
        return getId().equals(pdv.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
