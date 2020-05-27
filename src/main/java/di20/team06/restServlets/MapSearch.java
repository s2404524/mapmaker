package di20.team06.restServlets;

import di20.team06.dao.DummyMapDAO;
import di20.team06.model.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/maps")
public class MapSearch {

    /**
     * Get a list of maps matching the search criteria
     *
     * @param activities The activities the maps have to be for
     *                   If empty, all maps will be returned
     * @return All maps related to the given activities
     */
    @GET @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map> getMaps(@QueryParam("a") String activities) {

        List<String> actList;

        if (activities == null || activities.isBlank()) {
            actList = new ArrayList<>();
        } else {
            //Split on semicolons not preceded by a backslash (double-escaped for regex)
            actList = Arrays.asList(activities.split("(?<!\\\\);"));
            actList.replaceAll(s -> s.replace("\\;", ";"));
        }

        return DummyMapDAO.INSTANCE.getMaps(actList);
    }
}
