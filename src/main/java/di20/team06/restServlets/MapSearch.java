package di20.team06.restServlets;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/maps")
public class MapSearch {

    /**
     * Get a list of maps matching the search criteria
     *
     * @param activities The activities the maps have to be for
     *                   If empty, all maps will be returned
     * @return All maps related to the given activities
     */
    @Path("/search")
    @GET @Produces(MediaType.APPLICATION_JSON)
    public String getMaps(
            @QueryParam("a") String activities
    ) {
        //TODO get maps from the DAO
        return "";
    }
}
