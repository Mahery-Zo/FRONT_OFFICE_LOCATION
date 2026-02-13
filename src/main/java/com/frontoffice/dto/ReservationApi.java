package com.frontoffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class ReservationApi implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomHotel")
    private String Hotel;

    @JsonProperty("idClient")
    private String idClient;

    @JsonProperty("nbPassager")
    private Integer nbPassager;

    @JsonProperty("dateHeure")
    private String dateHeure;

    public ReservationApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String Hotel) {
        this.Hotel = Hotel;
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

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getFormatedDate() {
        if (this.dateHeure == null || this.dateHeure.isEmpty()) {
            return null;
        }

        try {
            Date date = null;
            
            // Essayer plusieurs formats possibles
            String[] formats = {
                "yyyy-MM-dd HH:mm:ss.SSSSSS",  // Format avec 6 chiffres (microsecondes)
                "yyyy-MM-dd HH:mm:ss.SSS",      // Format avec 3 chiffres (millisecondes)
                "yyyy-MM-dd'T'HH:mm:ss.SSS",    // Format ISO avec T
                "yyyy-MM-dd'T'HH:mm:ss.SSSSSS"  // Format ISO avec 6 chiffres
            };
            
            for (String format : formats) {
                try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat(format);
                    date = inputFormat.parse(this.dateHeure);
                    break;  // Si le parsing réussit, sortir de la boucle
                } catch (ParseException e) {
                    // Continuer avec le prochain format
                }
            }
            
            if (date == null) {
                return this.dateHeure;  // Retourner la chaîne originale si aucun format ne marche
            }

            // Formater sans millisecondes (jusqu'aux secondes uniquement)
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return outputFormat.format(date);
        } catch (Exception e) {
            // En cas d'erreur, retourner la chaîne originale
            return this.dateHeure;
        }
    }
}
