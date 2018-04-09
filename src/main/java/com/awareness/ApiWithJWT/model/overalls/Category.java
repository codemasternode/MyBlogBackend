package com.awareness.ApiWithJWT.model.overalls;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
public abstract class Category implements Serializable{

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    private String color;

    public Category() {
    }

    public Category(@NotBlank @Size(max = 30) String name, @NotBlank String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
