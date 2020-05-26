package di20.team06.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Map implements IIdentifiable {

    private String id;
    private String name;
    private List<String> relatedActivities;

    /**
     * Create a new map
     *
     * @param name The map's name
     * @param activities List of activities related to this map, may be null
     */
    public Map(String name, List<String> activities) {
        this.id = "";
        this.name = name;
        this.relatedActivities = new ArrayList<>(activities);
    }

    /**
     * Default constructor, required for {@link XmlRootElement} to work properly
     */
    public Map() {

    }

    /**
     * Get this object's id<br>
     * Any ID has to be unique
     *
     * @return This object's unique id
     */
    @Override public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRelatedActivities() {
        return relatedActivities;
    }

    public void setRelatedActivities(List<String> relatedActivities) {
        this.relatedActivities = new ArrayList<>(relatedActivities);
    }
}
