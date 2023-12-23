package book.example.persistence;

import book.example.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BooksRepository extends JpaRepository<Book, Long> {

}
