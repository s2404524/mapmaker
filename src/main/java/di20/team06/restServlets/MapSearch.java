package di20.team06.restServlets;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class MapSearch {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMaps(
            @QueryParam("a") String activities
    ) {
        //TODO get maps from the DAO
        return "";
    }
}
