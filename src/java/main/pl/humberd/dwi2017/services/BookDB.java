package pl.humberd.dwi2017.services;

import org.springframework.stereotype.Service;
import pl.humberd.dwi2017.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class BookDB {
    private int counter = 6;
    private final List<Book> list = new ArrayList<>();

    public BookDB() {
        list.addAll(Arrays.asList(
                new Book("1", "Murzynek Bambo", "Julian Tuwim"),
                new Book("2", "Lokomotywa", "Julian Tuwim"),
                new Book("3", "Stefek Burczymucha", "Maria Konopnicka"),
                new Book("4", "Rzepka", "Julian Tuwim"),
                new Book("5", "Na Straganie", "Jan Brzechwa")
        ));
    }

    public List<Book> getList() {
        return list;
    }

    public void addBook(Book newBook) {
        newBook.setBookId(Integer.toString(++counter));
        this.list.add(newBook);
    }

    public void removeBook(String bookId) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getBookId(), bookId)) {
                list.remove(i);
                i--;
            }
        }
    }
}
