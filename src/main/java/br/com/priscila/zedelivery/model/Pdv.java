package br.com.priscila.zedelivery.model;

import lombok.*;

import javax.persistence.*;
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

    private String tradingName;

    private String ownerName;

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
