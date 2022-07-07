/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.entity;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    @JsonbProperty(value = "first_name")
    @NotBlank
    @Column(name = "nome", nullable = false)
    private String firstName;

    @JsonbProperty(value = "last_name")
    @NotBlank
    @Column(name = "cognome", nullable = false)
    private String lastName;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 4)
    @Column(nullable = false)
    private String pwd;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    
    /*associazione inversa
    @OneToMany(mappedBy  = "author")
    private List<Bookmark> posts = new ArrayList<>();*/
     
    /*
    getter setter
     */
    public void setPwd(String pwd) {    
        this.pwd = pwd;
    }

    
    /*public List<Bookmark> getPosts() {
      return posts;
      }
      public void setPosts(List<Bookmark> posts) {
      this.posts = posts;
    }*/
     

    @Override
    public String toString() {
        return "Author{"+ "id=" + id +",firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", pwd=" + pwd + '}';
    }
  

    public JsonObject toJsonSlice() {

        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("nome", this.firstName)
                .add("cognome", this.lastName)
                .add("email", this.email)
                .build();
    }

}
