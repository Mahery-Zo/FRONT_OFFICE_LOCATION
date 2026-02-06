package com.frontoffice.service.impl;

import com.frontoffice.model.Reservation;
import com.frontoffice.service.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    // Stockage en mémoire (à remplacer par un Repository JPA plus tard)
    private final Map<Long, Reservation> reservations = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ReservationServiceImpl() {
        // Données de démonstration
        initDemoData();
    }

    private void initDemoData() {
        Reservation r1 = new Reservation(idGenerator.getAndIncrement(), "Jean Dupont", "jean.dupont@email.com",
                LocalDate.now(), LocalDate.now().plusDays(7));
        r1.setClientPhone("0612345678");
        r1.setStatus("CONFIRMEE");
        reservations.put(r1.getId(), r1);

        Reservation r2 = new Reservation(idGenerator.getAndIncrement(), "Marie Martin", "marie.martin@email.com",
                LocalDate.now().plusDays(3), LocalDate.now().plusDays(10));
        r2.setClientPhone("0698765432");
        r2.setStatus("EN_ATTENTE");
        reservations.put(r2.getId(), r2);
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations.values());
    }

    @Override
    public Reservation findById(Long id) {
        return reservations.get(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        if (reservation.getId() == null) {
            reservation.setId(idGenerator.getAndIncrement());
            reservation.setCreatedAt(LocalDateTime.now());
        }
        reservation.setUpdatedAt(LocalDateTime.now());
        reservations.put(reservation.getId(), reservation);
        return reservation;
    }

    @Override
    public void deleteById(Long id) {
        reservations.remove(id);
    }

    @Override
    public List<Reservation> findByStatus(String status) {
        return reservations.values().stream()
                .filter(r -> r.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByClientName(String clientName) {
        return reservations.values().stream()
                .filter(r -> r.getClientName().toLowerCase().contains(clientName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
