/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.boundary;

import it.tss.bkmapp.control.EtichettaStore;
import it.tss.bkmapp.entity.Etichetta;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author tss
 */
@Path("/etichette")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(
        name = "Gestione etichette", description = "Permette di visualizzare le etichette presenti"
)
public class EtichettaResources {

    @Inject
    EtichettaStore store;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etichetta> all() {
        return store.all();
    }

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Etichetta findByName(@QueryParam("name") String name) {
        return store.byName(name).orElseThrow(() -> new NotFoundException("Etichetta non trovata"));
    }

}
