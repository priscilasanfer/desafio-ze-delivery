package br.com.priscila.zedelivery.domain;

import br.com.priscila.zedelivery.domain.enums.Type;
import com.vividsolutions.jts.geom.MultiPolygon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CoverageArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type;

    private MultiPolygon coordinates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoverageArea)) return false;
        CoverageArea that = (CoverageArea) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
