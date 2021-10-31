/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.ReportClasses;

import com.usa.G14.Reto5.G14Reto5.model.Client;

/**
 *
 * @author edgarchaparro
 */
public class ReportClients {
    
    private Long total;
    private Client client;
 
    public ReportClients(Client client, Long total) {
        this.total = total;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    
    
    
    
    

    
    
}
