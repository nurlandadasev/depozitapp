package az.depozit.depozitapp.db.services;

import java.util.List;
import java.util.Optional;

public interface DataBaseServices<T,E> {

    Optional<T> getById(E e);

    Optional<List<T>> getAll();

    Optional<T> save(T t);

    Optional<T> update(T t);

    void delete(T t);
}
