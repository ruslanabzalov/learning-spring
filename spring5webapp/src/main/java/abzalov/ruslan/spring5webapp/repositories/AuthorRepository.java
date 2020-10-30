package abzalov.ruslan.spring5webapp.repositories;

import abzalov.ruslan.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
