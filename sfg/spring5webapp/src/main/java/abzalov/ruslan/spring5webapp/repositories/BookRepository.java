package abzalov.ruslan.spring5webapp.repositories;

import abzalov.ruslan.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
