package br.com.priscila.zedelivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pdv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;

    private CoverageArea coverageArea;

    private Address address;

    public Pdv() {
    }

    public Pdv(Long id, String tradingName, String ownerName, String document, CoverageArea coverageArea, Address address) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.coverageArea = coverageArea;
        this.address = address;
    }

    public Pdv(Long id, String tradingName, String ownerName, String document,  Address address) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.address = address;
    }

    public Pdv(Long id, String tradingName, String ownerName, String document) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(CoverageArea coverageArea) {
        this.coverageArea = coverageArea;
    }

    public Address getEndereco() {
        return address;
    }

    public void setEndereco(Address address) {
        this.address = address;
    }

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
