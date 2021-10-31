/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.services;

import java.util.List;
import java.util.Optional;
import com.usa.G14.Reto5.G14Reto5.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.G14.Reto5.G14Reto5.repository.RepositoryCabin;

/**
 *
 * @author edgarchaparro
 */
@Service
public class ServicesCabin {
    
    @Autowired
    private RepositoryCabin metodCrud;
    
    public List<Cabin> getAll(){
        return metodCrud.getAll();
    }
    
    public Optional<Cabin> getCabin(int idCabin){
        return metodCrud.getCabin(idCabin);
    }
    
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return metodCrud.save(cabin);
        }
        else {
            Optional<Cabin> evt=metodCrud.getCabin(cabin.getId());
            if(evt.isEmpty()){
                return metodCrud.save(cabin);
            }
            else{
                return(cabin);
            }
        }
    }

    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> evt=metodCrud.getCabin(cabin.getId());
            if(!evt.isEmpty()){
                if(cabin.getName()!=null){
                    evt.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    evt.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    evt.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    evt.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    evt.get().setCategory(cabin.getCategory());
                }
                metodCrud.save(evt.get());
                return evt.get();
            }
            else{
                return cabin;
            }
        }
        else{
            return cabin;
        }
    }

    public boolean delete(int idCabin) {
        Boolean result = getCabin(idCabin).map(cabin -> {
            metodCrud.delete(cabin);
            return true;
        }).orElse(false);
        return result;
    }
}
