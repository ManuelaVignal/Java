/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import it.tss.blogapp.control.PostStore;
import it.tss.blogapp.control.TagStore;
import it.tss.blogapp.entity.Post;
import it.tss.blogapp.entity.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/posts")
public class PostResources {

    @Inject
    private PostStore store;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> all() {
        return store.all();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid Post entity) {
        store.save(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post find(@PathParam("id") Long id) {

        return store.find(id).orElseThrow(() -> new NotFoundException("post non trovato id = " + id));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {

        Post found = store.find(id).orElseThrow(() -> new NotFoundException("post non trovato id = " + id));
        store.delete(found.getId());
    }
}
