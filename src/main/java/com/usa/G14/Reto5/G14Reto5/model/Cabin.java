 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author edgarchaparro
 */
@Entity
@Table(name = "cabin")
/***
 * Class that identify the Cabaña of the application
 */
public class Cabin {
    //Cabin's ID autonumbering 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Cabin's Name
    @Column(length = 45)
    private String name;
    //Cabin's Brand to identify the cabin 
    @Column(length = 45)
    private String brand;
    //Number of rooms of the Cabin
    private Integer rooms;
    //Description of the Cabin
    @Column(length = 250)
    private String description;
    //Relation with the category's table to select the type of the cabin.
    @ManyToOne
    @JoinColumn(name="CategoryId")
    @JsonIgnoreProperties("cabins")
    private Category category; 
    //Relation with the Messages Table leaved of the customer.
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="cabin")
    @JsonIgnoreProperties({"cabin","client"})
    private List<Message> messages; 
    //Reservations that the Cabin has had.
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="cabin")
    @JsonIgnoreProperties({"cabin","client"})
    private List<Reservation> reservations; 

    //Getter of the Cabin's ID
    public Integer getId() {
        return id;
    }
    //Setter of the Cabin's ID
    public void setId(Integer id) {
        this.id = id;
    }
    //Getter of the Cabin's Name
    public String getName() {
        return name;
    }
    //Setter of the Cabin's Name
    public void setName(String name) {
        this.name = name;
    }
    //Getter of the Cabin's Brand
    public String getBrand() {
        return brand;
    }
    //Setter of the Cabin's Brand
    public void setBrand(String brand) {
        this.brand = brand;
    }
    //Getter of the Cabin's Rooms
    public Integer getRooms() {
        return rooms;
    }
    //Setter of the Cabin's Rooms
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    //Getter of the Cabin's Description
    public String getDescription() {
        return description;
    }
    //Setter of the Cabin's Description
    public void setDescription(String description) {
        this.description = description;
    }
    //Getter of the Cabin's Category
    public Category getCategory() {
        return category;
    }
    //Setter of the Cabin's Category
    public void setCategory(Category category) {
        this.category = category;
    }
    //Getter of the Cabin's Messages
    public List<Message> getMessages() {
        return messages;
    }
    //Setter of the Cabin's Messages
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    //Getter of the Cabin's Reservations
    public List<Reservation> getReservations() {
        return reservations;
    }
    //Setter of the Cabin's Reservations
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
