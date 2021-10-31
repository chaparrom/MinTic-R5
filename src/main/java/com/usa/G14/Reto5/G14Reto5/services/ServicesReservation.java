/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.services;

import com.usa.G14.Reto5.G14Reto5.ReportClasses.ReportClients;
import com.usa.G14.Reto5.G14Reto5.ReportClasses.ReportStatus;
import com.usa.G14.Reto5.G14Reto5.model.Reservation;
import com.usa.G14.Reto5.G14Reto5.repository.RepositoryReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */

/*
Class to implement the Reservation Service
*/
@Service
public class ServicesReservation {
/**
 *
 * Instance of the CRUD metod which access de DataBase through the Repository
 */
    @Autowired
    private RepositoryReservation metodCrud;
/**
 *
 *   Function to get all reservations from DataBase
 */
    public List<Reservation> getAll(){
        return metodCrud.getAll();
    }
/**
 *
 *    Function to get an specific reservation from DataBase
 *   @parm: idReservation receive a identification of the Reservation.
 */
  public Optional<Reservation> getReservation(int idReservation){
        return metodCrud.getReservation(idReservation);
    }
/**
 *
 *   
 *   Function to add an reservation in the DataBase
 *   @parm: Receive the Reservation Object from a JSON structure
 */
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodCrud.save(reservation);
        }
        else {
            Optional<Reservation> event=metodCrud.getReservation(reservation.getIdReservation());
            if(event.isEmpty()){
                return metodCrud.save(reservation);
            }
            else{
                return reservation;
            }
        }
    }
/**
 *
 *   Function to update a reservation in the DataBase
 *   @parm: Receive the Reservation Object from a JSON structure
 */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> event = metodCrud.getReservation(reservation.getIdReservation());
            if(!event.isEmpty()){

                if(reservation.getStartDate()!=null){
                    event.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    event.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    event.get().setStatus(reservation.getStatus());
                }
                if(reservation.getScore()!=null){
                    event.get().setScore(reservation.getScore());
                }
                if(reservation.getCabin()!=null){
                    event.get().setCabin(reservation.getCabin());
                }
                if(reservation.getClient()!=null){
                    event.get().setClient(reservation.getClient());
                }
                metodCrud.save(event.get());
                return event.get();
            }
            else{
                return reservation;
            }
        }
        else{
            return reservation;
        }
    }
/**
 *
 *      Function to delete a reservation in the DataBase
 *           @arm: Receive the id of a Reservation 
 */
    public boolean delete(int idReservation) {
        return getReservation(idReservation).map(reservation -> {
            metodCrud.delete(reservation);
            return true;
        }).orElse(false);
        
    }
    
    
    public ReportStatus getReportStatus(){
        List<Reservation>completed= metodCrud.ReservationStatus("completed");
        List<Reservation>cancelled= metodCrud.ReservationStatus("cancelled");
        return new ReportStatus(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReportDates(String dateFrom, String dateTo){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date dateWFrom = new Date();
        Date dateWTo = new Date();
        
        try{
            dateWFrom = parser.parse(dateFrom);
            dateWTo = parser.parse(dateTo);
        }catch(ParseException event){
            event.printStackTrace();
        }if(dateWFrom.before(dateWTo)){
            return metodCrud.TimeReservation(dateWFrom, dateWTo);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ReportClients> getReportClients(){
        return metodCrud.getReportClients();
    }

}
