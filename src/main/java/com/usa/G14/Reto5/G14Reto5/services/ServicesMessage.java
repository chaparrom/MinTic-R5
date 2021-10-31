/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.services;

import com.usa.G14.Reto5.G14Reto5.model.Message;
import com.usa.G14.Reto5.G14Reto5.repository.RepositoryMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class ServicesMessage {
    
    @Autowired
    private RepositoryMessage metodCrud;
    
    public List<Message> getAll(){
        return metodCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodCrud.getMessage(idMessage);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodCrud.save(message);
        }
        else {
            Optional<Message> evt=metodCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return metodCrud.save(message);
            }
            else{
                return(message);
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evt= metodCrud.getMessage(message.getIdMessage());
            if(!evt.isEmpty()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                if(message.getCabin()!=null){
                    evt.get().setCabin(message.getCabin());
                }
                if(message.getClient()!=null){
                    evt.get().setClient(message.getClient());
                }
                metodCrud.save(evt.get());
                return evt.get();
            }
            else{
                return message;
            }
        }
        else{
            return message;
        }
    }

    public boolean delete(int idMessage) {
        Boolean result = getMessage(idMessage).map(message -> {
            metodCrud.delete(message);
            return true;
        }).orElse(false);
        return result;
    }
    
}
