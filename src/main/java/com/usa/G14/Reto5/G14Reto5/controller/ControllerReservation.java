/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.controller;

import com.usa.G14.Reto5.G14Reto5.ReportClasses.ReportClients;
import com.usa.G14.Reto5.G14Reto5.ReportClasses.ReportStatus;
import com.usa.G14.Reto5.G14Reto5.model.Reservation;
import com.usa.G14.Reto5.G14Reto5.services.ServicesReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edgarchaparro
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerReservation {
    
    @Autowired
    private ServicesReservation services;
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return services.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation){
        return services.getReservation(idReservation);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return services.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return services.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        return services.delete(idReservation);
    }
    
    @GetMapping("/report-status")
    public ReportStatus getReportStatus(){
        return services.getReportStatus();
    }
    
    @GetMapping("/report-dates/{dateFrom}/{dateTo}")
    public List<Reservation> getReportDates (@PathVariable("dateFrom")String dateFrom, @PathVariable("dateTo")String dateTo){
        return services.getReportDates(dateFrom, dateTo);
    }
    
    @GetMapping("/report-clients")
    public List<ReportClients> getReportClients(){
        return services.getReportClients();
    
    }
    
}
