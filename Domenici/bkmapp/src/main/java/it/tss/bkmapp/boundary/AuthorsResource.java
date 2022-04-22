/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.boundary;

import it.tss.bkmapp.control.AuthorStore;
import it.tss.bkmapp.control.BookmarkStore;
import it.tss.bkmapp.entity.Author;
import it.tss.bkmapp.entity.JWTManager;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author tss
 */
@Path("/authors")
@Tag(name = "Gestione Users", description = "Permette di gestire gli utenti di bookmark")
public class AuthorsResource {

    @Inject
    private AuthorStore store;

    @Inject
    BookmarkStore bookmarkStore;

    @Context
    ResourceContext rc;
    
    @Inject
    JWTManager jwtManager;

    @Inject
    JsonWebToken token;

    @Context
    UriInfo uriInfo;

    @Claim(value = "sub")
    String sub;
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public JsonObject login(@Valid Credential credential) {
        var u = store.login(credential).orElseThrow(() -> new NotAuthorizedException(
                Response.status(Response.Status.UNAUTHORIZED).build()));
        var jwt = jwtManager.generate(u);
        return Json.createObjectBuilder()
                .add("jwt", jwt)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce l'elenco di tutti gli utenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo")
    })
    public List<Author> all(@DefaultValue("1")
            @QueryParam("page") int page, @DefaultValue("10")
            @QueryParam("size") int size) {
        return store.allPaginated(page, size);
    }

    @GET
    @Path("allslice")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce l'elenco con informazioni ridotte di tutti gli utenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo")
    })
    @RolesAllowed("users")
    public JsonArray allSlice() {
        return store.all().stream().map(Author::toJsonSlice).collect(JsonCollectors.toJsonArray());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Permette la registrazione di un nuovo utente")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "Nuovo utente creato con successo")
    })
    public Response create(@Valid Author entity) {
        Author saved = store.create(entity);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }

    @Path("{id}")
    @RolesAllowed("users")
    public AuthorResource find(@PathParam("id") Long id) {
        if (Long.parseLong(token.getSubject()) != id) {
            System.out.println("id utente non corrispondente");
            throw new ForbiddenException();
        }

        AuthorResource sub = rc.getResource(AuthorResource.class);
        sub.setId(id);
        return sub;

    }
}
