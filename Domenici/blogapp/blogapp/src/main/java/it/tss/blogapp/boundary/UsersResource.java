/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import it.tss.blogapp.control.UserStore;
import it.tss.blogapp.entity.User;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/users")
public class UsersResource {

//UserStore fa interazione con data base
    //creazione oggetto con Inject e dire quanto deve durate l'oggetto con il comando Scoped
    //Request
    @Inject
    private UserStore store;

    //ricevere elenco di tutti gli utenti
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all() {
        return store.all();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid User entity) {
     store.save(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id) {

        return store.find(id).orElseThrow(() -> new NotFoundException("user non trovato id = " + id));
    }

}
