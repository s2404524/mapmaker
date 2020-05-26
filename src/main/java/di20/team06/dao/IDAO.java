package di20.team06.dao;

import di20.team06.model.IIdentifiable;

import java.util.Optional;

/**
 * Interface representing a Data Access Object (DAO)
 * @param <T> The type of object controlled by this DAO
 */
public interface IDAO<T extends IIdentifiable> {

    /**
     * Adds an element to the underlying data source
     * @param element The element to add
     */
    void add(T element);

    /**
     * Get an element from the underlying data source,
     * or a default value if no element with the given id can be found.
     *
     * @param id The element's unique id
     * @param defaultValue The value to return in case {@code id} is null
     * @return The element with the given id, or {@code defaultValue} if it's not present
     */
    T getOrDefault(String id, T defaultValue);

    /**
     * Get an element from the underlying data source
     *
     * @param id The element's unique ID
     * @return The element with the given id
     */
    default Optional<T> get(String id) {
        return Optional.ofNullable(getOrDefault(id, null));
    }

    /**
     * Delete an element from the underlying data source,
     * based on its id
     *
     * @param id The element's unique id
     */
    void delete(String id);

    /**
     * Delete an element from the underlying data source
     *
     * @param element The element to delete
     */
    default void delete(T element) {
        delete(element.getID());
    }
}
