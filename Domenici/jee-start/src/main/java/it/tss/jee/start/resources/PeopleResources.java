/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jee.start.resources;

import it.tss.jee.start.entity.Person;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("people")
public class PeopleResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> all() {
        return Stream.of(new Person(1, "Manuela", "Vignal", 45), new Person(2, "Arjent", "Krasnisqui", 24)).collect(Collectors.toList());
    }

    @GET
    @Path("lastnames")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray allCognomi() {
        return Stream.of(new Person(1, "Manuela", "Vignal", 45), new Person(2, "Arjent", "Krasnisqui", 24))
                .map(Person::toJsonMin)
                .collect(JsonCollectors.toJsonArray());
    }
    
    
    //DA JSON A JAVA E SI PROVA CON HTML E NON BROWSER
    //USARE COMNADO DA TERMINALE CURL
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Person p){
    System.out.println(p);
    }
}
