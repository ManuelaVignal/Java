/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    //5 prorpietà dell'utente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonbProperty(value="first_name")
    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstname;

     @JsonbProperty(value="last_name")
    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Size(min = 4)
    @Column(nullable = false)
    private String pwd;

    //niente costruttore
    //inserire metodi get-setter-hash-code e toString
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", email=" + email + ", pwd=" + pwd + '}';
    }

}
