package com.frontoffice.controller;

import com.frontoffice.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private RestTemplate restTemplate;

    @org.springframework.beans.factory.annotation.Value("${api.base.url}")
    private String apiBaseUrl;

    @org.springframework.beans.factory.annotation.Value("${api.token}")
    private String apiToken;

    @GetMapping
    public String listReservations(@RequestParam(required = false) String date, Model model) {
        try {
            String apiUrl = apiBaseUrl + "/api/reservations?token=" + apiToken;
            
            // Ajouter le paramètre date si fourni
            if (date != null && !date.isEmpty()) {
                apiUrl += "&dateStr=" + date;
                model.addAttribute("selectedDate", date);
            }
            
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
