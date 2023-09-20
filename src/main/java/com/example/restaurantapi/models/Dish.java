package com.example.restaurantapi.models;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "dish")
public class Dish extends AbstractEntity implements Serializable, GenericEntity<Dish> {
    @NotBlank(message = "Ошибка! Поле не должно быть пустым")
    @Size(min = 1, max = 500, message = "Ошибка! Диапозон от 1 до 500")
    private String name;

    @NotBlank(message = "Ошибка! Поле не должно быть пустым")
    @Size(min = 1, max = 500, message = "Ошибка! Диапозон от 1 до 500")
    private String image;
    @Size(min = 1, max = 500, message = "Ошибка! Диапозон от 1 до 500")
    @NotBlank(message = "Ошибка! Поле не должно быть пустым")
    private String description;
    @Range(min = 1, max = 10000, message = "Ошибка! Диапозон от 1 до 10000")
    @NotNull(message = "Ошибка! Поле не должно быть пустым")
    private int price;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Orders> order;
    @ManyToMany
    @JoinTable(name="dish_ingredient",
            joinColumns=@JoinColumn(name="dish_id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredient;
    @Override
    public void update(Dish source) {
        this.name = source.name;
        this.image = source.image;
        this.description = source.description;
        this.price = source.price;
        this.order =source.order;

    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Dish createNewInstance() {
        Dish newInstance = new Dish();
        newInstance.update(this);

        return newInstance;
    }

}
