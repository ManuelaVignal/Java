/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.entity;

import java.util.Optional;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "etichetta")
public class Etichetta extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    public Etichetta() {
    }

    public Etichetta(String name) {
        this.name = name;
    }

    /*
    getter setter
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Etichetta{" + "name=" + name + '}';
    }

    public JsonObject toJsonSlice() {

        return Json.createObjectBuilder()
                .add("id", this.id)
                .build();
    }

}
