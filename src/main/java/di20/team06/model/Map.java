package di20.team06.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Map implements IIdentifiable {

    private String id;
    private String name;
    private String description;
    private String mapData;
    private Date   lastEdited;
    private String lastEditedBy;
    private List<String> relatedActivities;

    /**
     * Create a new map
     *
     * @param name The map's name
     * @param activities List of activities related to this map, may be null
     */
    public Map(String id, String name, String description, String mapData, Date lastEdited, String lastEditedBy, List<String> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mapData = mapData;
        this.lastEdited = lastEdited;
        this.lastEditedBy = lastEditedBy;
        this.relatedActivities = new ArrayList<>(activities); //Store a local copy, not the actual list
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapData() {
        return mapData;
    }

    public void setMapData(String mapData) {
        this.mapData = mapData;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(String lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public void setRelatedActivities(List<String> relatedActivities) {
        this.relatedActivities = new ArrayList<>(relatedActivities);
    }
}
