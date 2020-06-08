package br.com.priscila.zedelivery.model;

import br.com.priscila.zedelivery.model.enums.Type;
import org.geojson.MultiPolygon;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CoverageArea implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Type type;
    private Set<MultiPolygon> coordinates = new HashSet<>();

    public CoverageArea() {
    }

    public CoverageArea(Long id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<MultiPolygon> getCoordinates() {
        return coordinates;
    }

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
