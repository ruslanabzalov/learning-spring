package abzalov.ruslan.sfgpetclinic.services;

import java.util.Set;

public interface BasicService<T> {

    T findById(Long id);

    T save(T t);

    Set<T> findAll();
}
