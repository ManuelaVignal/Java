/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.boundary;

import it.tss.bkmapp.control.BookmarkStore;
import it.tss.bkmapp.control.EtichettaStore;
import it.tss.bkmapp.entity.Bookmark;
import it.tss.bkmapp.entity.Etichetta;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/bookmarks")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(
        name = "Gestione bookmarks", description = "Permetti ad ogni utente di gestire i propri bookmark"
)
public class BookmarkResource {

    @Inject
    BookmarkStore bookmarkstore;
    
    
    @Inject
    EtichettaStore  etichettastore;
    
    /*@Inject
    CommentStore commentStore;
       */
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bookmark> all() {
        return bookmarkstore.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bookmark find(@PathParam("id") Long id) {
        return bookmarkstore.find(id).orElseThrow(() -> new NotFoundException());
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bookmark update(@PathParam("id") Long id, @Valid Bookmark entity) {
        return bookmarkstore.save(entity);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }

    /*@GET
    @Path("{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> comments(@PathParam("id") Long id) {
        return commentStore.byPost(id);
    }

    @POST
    @Path("{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createComment(@PathParam("id") Long id, @Valid Comment entity) {
        commentStore.save(entity);
    }*/

    @GET
    @Path("{id}/etichette")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Etichetta> tags(@PathParam("id") Long id) {
        return etichettastore.byBookmark(id);
    }

    @PATCH
    @Path("{id}/etichette")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addTag(@PathParam("id") Long id, @NotBlank String etichetta) {
        Bookmark found = bookmarkstore.find(id).orElseThrow(() -> new NotFoundException());
        bookmarkstore.addEtichetta(found, etichetta);
    }

    @DELETE
    @Path("{id}/etichette")
    @Consumes(MediaType.TEXT_PLAIN)
    public void removeEtichetta(@PathParam("id") Long id, String etichetta) {
        bookmarkstore.removeEtichetta(id, etichetta);
    }
}
