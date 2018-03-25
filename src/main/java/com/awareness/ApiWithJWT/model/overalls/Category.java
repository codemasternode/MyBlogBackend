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

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
