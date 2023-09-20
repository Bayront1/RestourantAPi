package com.example.restaurantapi.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "ingredient")
public class Ingredient extends AbstractEntity implements Serializable, GenericEntity<Ingredient>  {
    @Size(min = 1, max = 500, message = "Ошибка! Диапозон от 1 до 500")
    @NotBlank(message = "Ошибка! Поле не должно быть пустым")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "ingredient")
    private List<Dish> dish;

    @Override
    public void update(Ingredient source) {
        this.name = source.name;
        this.dish = source.dish;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Ingredient createNewInstance() {
        Ingredient newInstance = new Ingredient();
        newInstance.update(this);
        return newInstance;
    }
}
