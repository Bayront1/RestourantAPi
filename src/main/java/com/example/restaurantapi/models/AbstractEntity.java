package com.example.restaurantapi.models;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    public long id;


    public void setId(Long id) {
        this.id = id;
    }


}

