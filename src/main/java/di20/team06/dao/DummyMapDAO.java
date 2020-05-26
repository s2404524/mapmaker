package di20.team06.dao;

import di20.team06.model.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dummy DAO for handling maps
 */
public class DummyMapDAO implements IDAO<Map> {

    private final List<Map> maps = new ArrayList<>();

    public static DummyMapDAO INSTANCE = new DummyMapDAO();

    private DummyMapDAO() {

    }

    /**
     * Adds an element to the underlying data source
     *
     * @param element The element to add
     */
    @Override public void add(Map element) {
        maps.add(element);
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
        return maps.stream()
                .filter(m -> m.getID().equals(id))
                .findFirst()
                .orElse(defaultValue);
    }

    public List<Map> getMaps(List<String> activities) {
        return maps.stream()
                .filter(m -> activities.containsAll(m.getRelatedActivities()))
                .collect(Collectors.toList());
    }

    /**
     * Delete an element from the underlying data source,
     * based on its id
     *
     * @param id The element's unique id
     */
    @Override public void delete(String id) {
        maps.removeIf(m -> m.getID().equals(id));
    }
}
