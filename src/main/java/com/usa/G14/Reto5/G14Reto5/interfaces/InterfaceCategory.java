/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.interfaces;

import com.usa.G14.Reto5.G14Reto5.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author edgarchaparro
 */
public interface InterfaceCategory extends CrudRepository<Category, Integer> {
    
}
