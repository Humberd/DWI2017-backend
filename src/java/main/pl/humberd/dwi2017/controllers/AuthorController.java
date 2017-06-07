package pl.humberd.dwi2017.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.humberd.dwi2017.models.Author;
import pl.humberd.dwi2017.services.AuthorDB;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class AuthorController {
    private final AuthorDB authorDB;

    @Autowired
    public AuthorController(AuthorDB authorDB) {
        this.authorDB = authorDB;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthorsList() {
        return ResponseEntity.ok(this.authorDB.getList());
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable String authorId) {
        Author result = Flux.fromIterable(this.authorDB.getList())
                .filter(author -> Objects.equals(author.getAuthorId(), authorId))
                .blockFirst();

        if (result == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}
