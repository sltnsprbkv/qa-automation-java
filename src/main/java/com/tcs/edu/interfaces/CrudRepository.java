package com.tcs.edu.interfaces;

import java.util.Optional;

/**
 * {@code com.tcs.edu.interfaces.Repository} CRUD repository
 *
 * @author s.saparbekov
 * **/

public interface CrudRepository<T, ID> {

    /**
     *     Returns the number of entities available.
     *
     * **/
    long count();

    /**
     *    Deletes a given entity.
     * **/
    void delete(T entity);

    /**
     *    Deletes all entities managed by the repository.
     * **/
    void deleteAll();

    /**
     *    Deletes the given entities.
     * **/
    void deleteAll(Iterable<? extends T> entities);

    /**
     *    Deletes all instances of the type T with the given IDs.
     * **/
    void deleteAllById(Iterable<? extends ID> ids);

    /**
     *    Deletes the entity with the given id.
     * **/
    void deleteById(ID id);

    /**
     *    Returns whether an entity with the given id exists.
     * **/
    boolean	existsById(ID id);

    /**
     *    Returns all instances of the type.
     * **/
    Iterable<T>	findAll();

    /**
     *    Returns all instances of the type T with the given IDs.
     * **/
    Iterable<T>	findAllById(Iterable<ID> ids);

    /**
     *    Retrieves an entity by its id.
     * **/
    Optional<T> findById(ID id);

    /**
     *    Saves a given entity.
     * **/
    <S extends T>
    S save(S entity);

    /**
     *    Saves all given entities.
     * **/
    <S extends T>
    Iterable<S>	saveAll(Iterable<S> entities);
}
