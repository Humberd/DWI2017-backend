package pl.humberd.dwi2017.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.humberd.dwi2017.models.Book;
import pl.humberd.dwi2017.services.BookDB;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
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

    @PostMapping("/books")
    public ResponseEntity addBook(@RequestBody Book book) {
        this.bookDB.addBook(book);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity removeBook(@PathVariable String bookId) {
        this.bookDB.removeBook(bookId);
        return ResponseEntity.status(200).build();
    }
}
