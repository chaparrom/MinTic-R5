/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.G14.Reto5.G14Reto5.services;

import com.usa.G14.Reto5.G14Reto5.model.Category;
import com.usa.G14.Reto5.G14Reto5.repository.RepositoryCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class ServicesCategory {
    @Autowired
    private RepositoryCategory metodCrud;
    
    public List<Category> getAll(){
        return metodCrud.getAll();
    }
    
    public Optional<Category> getCategory(int idCategory){
        return metodCrud.getCategory(idCategory);
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return metodCrud.save(category);
        }
        else {
            Optional<Category> evt=metodCrud.getCategory(category.getId());
            if(evt.isEmpty()){
                return metodCrud.save(category);
            }
            else{
                return(category);
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> evt=metodCrud.getCategory(category.getId());
            if(!evt.isEmpty()){
                if(category.getDescription()!=null){
                    evt.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    evt.get().setName(category.getName());
                }
                return metodCrud.save(evt.get());
            }
        }
        return category;
    }
    public boolean delete(int idCategory){
        Boolean result=getCategory(idCategory).map(category -> {
            metodCrud.delete(category);
            return true;
        }).orElse(false);
        return result;
    }
    
}
