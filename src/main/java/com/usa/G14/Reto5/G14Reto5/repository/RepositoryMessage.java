/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.repository;

import com.usa.G14.Reto5.G14Reto5.interfaces.InterfaceMessage;
import com.usa.G14.Reto5.G14Reto5.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgarchaparro
 */
@Repository
public class RepositoryMessage {
    @Autowired
    private InterfaceMessage crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    public Optional <Message> getMessage(int id) {
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    }

    public void delete(Message message){
        crud.delete(message);
    }
    
}
