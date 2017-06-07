package pl.humberd.dwi2017.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.humberd.dwi2017.models.Book;
import pl.humberd.dwi2017.services.BookDB;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
    private final BookDB bookDB;

    @Autowired
    public BookController(BookDB bookDB) {
        this.bookDB = bookDB;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooksList() {
        return ResponseEntity.ok(this.bookDB.getList());
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable String bookId) {
        Book result = Flux.fromIterable(this.bookDB.getList())
                .filter(book -> Objects.equals(book.getBookId(), bookId))
                .blockFirst();

        if (result == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.ok(result);
        }

    }
}
