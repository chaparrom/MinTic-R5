/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.services;

import com.usa.G14.Reto5.G14Reto5.model.Client;
import com.usa.G14.Reto5.G14Reto5.repository.RepositoryClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class ServicesClient {
    @Autowired
    private RepositoryClient metodCrud;
    
    public List<Client> getAll(){
        return metodCrud.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return metodCrud.getClient(idClient);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodCrud.save(client);
        }
        else {
            Optional<Client> evt=metodCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodCrud.save(client);
            }
            else{
                return(client);
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evt = metodCrud.getClient(client.getIdClient());
            if(!evt.isEmpty()){
                if(client.getEmail()!=null){
                    evt.get().setEmail(client.getEmail());
                }
                if(client.getName()!=null){
                    evt.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evt.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt.get().setPassword(client.getPassword());
                }
                metodCrud.save(evt.get());
                return evt.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int idClient) {
        Boolean result = getClient(idClient).map(client -> {
            metodCrud.delete(client);
            return true;
        }).orElse(false);
        return result;
    }
}
