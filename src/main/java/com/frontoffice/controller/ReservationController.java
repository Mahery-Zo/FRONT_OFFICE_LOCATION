package com.frontoffice.controller;

import com.frontoffice.dto.ApiResponse;
import com.frontoffice.dto.ReservationApi;
import com.frontoffice.model.Reservation;
import com.frontoffice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String listReservations(Model model) {
        try {
            String apiUrl = "http://localhost:8084/api/reservations";
            ApiResponse apiResponse = restTemplate.getForObject(apiUrl, ApiResponse.class);
            
            if (apiResponse != null && apiResponse.getData() != null) {
                model.addAttribute("reservations", apiResponse.getData());
            } else {
                model.addAttribute("reservations", new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("reservations", new ArrayList<>());
        }
        
        return "reservation/list";
    }
}
