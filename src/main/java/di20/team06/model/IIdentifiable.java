package di20.team06.model;

/**
 * Interface representing uniquely identifiable objects
 */
public interface IIdentifiable {

    /**
     * Get this object's id
     * Any ID has to be unique
     *
     * @return This object's unique id
     */
    String getID();
}
