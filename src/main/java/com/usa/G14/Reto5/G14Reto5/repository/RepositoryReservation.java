/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.repository;

import com.usa.G14.Reto5.G14Reto5.ReportClasses.ReportClients;
import com.usa.G14.Reto5.G14Reto5.interfaces.InterfaceReservation;
import com.usa.G14.Reto5.G14Reto5.model.Client;
import com.usa.G14.Reto5.G14Reto5.model.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgarchaparro
 */
@Repository
public class RepositoryReservation {
    @Autowired
    private InterfaceReservation crud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservation(int id) {
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    public void delete(Reservation reservation){
        crud.delete(reservation);
    }

    public List<Reservation> ReservationStatus (String status){
         return crud.findAllByStatus(status);
     }
     
     public List<Reservation> TimeReservation (Date dateFrom, Date dateTo){
         return crud.findAllByStartDateAfterAndStartDateBefore(dateFrom, dateTo);
     }
   
     public List<ReportClients> getReportClients(){
         List<ReportClients> result = new ArrayList<>();
         List<Object[]> report = crud.getCountClients();
         for(int i=0; i<report.size();i++){
             result.add(new ReportClients((Client)report.get(i)[0],(Long)report.get(i)[1]));
         }
         return result;
     }    
}
