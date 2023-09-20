package com.example.restaurantapi.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Data
@Entity
public class Booking extends AbstractEntity implements Serializable, GenericEntity<Booking> {
    public Booking(){}

    private String serving_time;
    private int num_people;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orders_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_zone_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeZone typeZone;

    @Override
    public void update(Booking source) {
        this.serving_time = source.serving_time;
        this.num_people = source.num_people;
        this.orders = source.orders;
        this.typeZone = source.typeZone;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Booking createNewInstance() {
        Booking newInstance = new Booking();
        newInstance.update(this);
        return newInstance;
    }


}
