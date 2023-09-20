package com.example.restaurantapi.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "type_zone")
public class TypeZone extends AbstractEntity implements Serializable, GenericEntity<TypeZone> {
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message = "Size must be between 1 and 100")
    @Column(name = "name")
    private String name;


    @Override
    public void update(TypeZone source) {
        this.name = source.name;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public TypeZone createNewInstance() {
        TypeZone newInstance = new TypeZone();
        newInstance.update(this);

        return newInstance;
    }
}

