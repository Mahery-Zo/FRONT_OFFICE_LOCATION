package com.frontoffice.service;

import com.frontoffice.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    Reservation findById(Long id);

    Reservation save(Reservation reservation);

    void deleteById(Long id);

    List<Reservation> findByStatus(String status);

    List<Reservation> findByClientName(String clientName);
}
