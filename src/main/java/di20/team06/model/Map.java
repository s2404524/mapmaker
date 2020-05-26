package di20.team06.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Map implements IIdentifiable {

    /**
     * Get this object's id
     * Any ID has to be unique
     *
     * @return This object's unique id
     */
    @Override public String getID() {
        return null; //TODO
    }
}
