package com.frontoffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ReservationApi implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idHotel")
    private Long idHotel;

    @JsonProperty("idClient")
    private String idClient;

    @JsonProperty("nbPassager")
    private Integer nbPassager;

    @JsonProperty("dateHeure")
    private Object dateHeure;

    public ReservationApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Integer getNbPassager() {
        return nbPassager;
    }

    public void setNbPassager(Integer nbPassager) {
        this.nbPassager = nbPassager;
    }

    public Object getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Object dateHeure) {
        this.dateHeure = dateHeure;
    }
}
