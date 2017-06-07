package pl.humberd.dwi2017.services;

import org.springframework.stereotype.Service;
import pl.humberd.dwi2017.models.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorDB {
    private final List<Author> list = new ArrayList<>();

    public AuthorDB() {
        list.addAll(Arrays.asList(
                new Author("1", "J.R.R", "Tolkien", "2"),
                new Author("2","Stephen", "King", "1" ),
                new Author("3", "J.K.", "Rowling", "3"),
                new Author("4","William", "Shakespeare","1")
        ));
    }

    public List<Author> getList() {
        return list;
    }
}
