package pl.humberd.dwi2017.services;

import org.springframework.stereotype.Service;
import pl.humberd.dwi2017.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookDB {
    private final List<Book> list = new ArrayList<>();

    public BookDB() {
        list.addAll(Arrays.asList(
                new Book("1", "Władca Pierścieni", "1"),
                new Book("2", "Hobbit", "1"),
                new Book("3", "Zielona Mila", "2"),
                new Book("4", "Romeo i Julia", "4"),
                new Book("5", "Harry Potter", "3")
        ));
    }

    public List<Book> getList() {
        return list;
    }
}
