package it.tss.bkmapp;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "ping.message")
    String message;    

    @GET
    public String ping() {
        return this.message + " Jakarta EE 8 with MicroProfile 3+!";
    }

}
