package di20.team06.dao;

import di20.team06.model.Map;

/**
 * DAO for handling maps
 * TODO: Needs implementation
 */
public class MapDAO implements IDAO<Map> {

    public static MapDAO INSTANCE = new MapDAO();

    private MapDAO() {}

    /**
     * Adds an element to the underlying data source
     *
     * @param element The element to add
     */
    @Override public void add(Map element) {

    }

    /**
     * Get an element from the underlying data source,
     * or a default value if no element with the given id can be found.
     *
     * @param id           The element's unique id
     * @param defaultValue The value to return in case {@code id} is null
     * @return The element with the given id, or {@code defaultValue} if it's not present
     */
    @Override public Map getOrDefault(String id, Map defaultValue) {
        return null;
    }

    /**
     * Delete an element from the underlying data source,
     * based on its id
     *
     * @param id The element's unique id
     */
    @Override public void delete(String id) {

    }
}
