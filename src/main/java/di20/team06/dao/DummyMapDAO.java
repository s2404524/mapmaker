package di20.team06.dao;

import di20.team06.model.Map;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dummy DAO for handling maps
 */
public class DummyMapDAO implements IDAO<Map> {

    private final List<Map> maps = new ArrayList<>();

    public static DummyMapDAO INSTANCE = new DummyMapDAO();

    private DummyMapDAO() {
        maps.add(new Map(
                "testMap1",
                "Test Map 1",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis()),
                "The devs",
                Arrays.asList("test", "odd", "1")
        ));

        maps.add(new Map(
                "testMap2",
                "Test Map 2",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "even", "2")
        ));

        maps.add(new Map(
                "testMap3",
                "Test Map 3",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "odd", "3")
        ));

        maps.add(new Map(
                "testMap4",
                "Test Map 4",
                "This is a dummy map, used to test the application. Also, this one tests longer amounts of text, in case brevity isn't an option. Hopefully the site handles this well!",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "even", "4")
        ));
        maps.add(new Map(
                "testMap5",
                "Test Map 5",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis()),
                "The devs",
                Arrays.asList("test", "odd", "5")
        ));

        maps.add(new Map(
                "testMap6",
                "Test Map 6",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "even", "6")
        ));

        maps.add(new Map(
                "testMap7",
                "Test Map 7",
                "This is a dummy map, used to test the application",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "odd", "7")
        ));

        maps.add(new Map(
                "testMap8",
                "Test Map 8",
                "This is a dummy map, used to test the application. Also, this one tests longer amounts of text, in case brevity isn't an option. Hopefully the site handles this well!",
                "{}",
                new Date(System.currentTimeMillis() - 60_000),
                "The devs",
                Arrays.asList("test", "even", "8")
        ));
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
        if (activities.isEmpty())
            return new ArrayList<>(maps);

        return maps.stream()
                .filter(map -> map.getRelatedActivities().stream()
                        .anyMatch(activities::contains))
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
