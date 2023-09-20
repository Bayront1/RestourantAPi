package com.example.restaurantapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.criterion.Order;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "orders")

public class Orders extends AbstractEntity implements Serializable, GenericEntity<Orders>{




    @ManyToOne(fetch = FetchType.EAGER)
    private Dish dish;

    @Override
    public void update(Orders source) {

        this.dish = source.dish;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Orders createNewInstance() {
        Orders newInstance = new Orders();
        newInstance.update(this);
        return newInstance;
    }
}
