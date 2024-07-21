package org.example.springsecurewebservicev2.repository;
import org.example.springsecurewebservicev2.dto.book.BookAndMoreDto;
import org.example.springsecurewebservicev2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
//    @Query("SELECT '*' FROM Book INNER JOIN BookPublisher on Book.id = BookPublisher.book.id ")
//    @Query("select b from Book b inner join b.bookPublishers d where b.id = d.publisher.id")
//    @Query("from Book b JOIN FETCH b.bookPublishers ")
//    @Query("FROM Student s FETCH JOIN s.studyGroups")
//    @Query(" SELECT b FROM Book b JOIN FETCH  b.bookPublishers p ")
//    public List<Book> findAllBooksWithPublishers();

    @Query("select b from Book b join fetch b.bookPublishers bp" )
    public List<Book> getAllBooks();


}
