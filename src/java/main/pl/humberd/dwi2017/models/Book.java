package pl.humberd.dwi2017.models;

public class Book {
    private String bookId;
    private String title;
    private String authorId;

    public Book(String bookId, String title, String authorId) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
    }

    public String getBookId() {
        return bookId;
    }

    public Book setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Book setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
