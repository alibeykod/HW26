package ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.repository;
import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    private final static List<Book> books = new ArrayList<>(
            List.of(
                    new Book(1L, "Clean Code", "Robert C. Martin", "Programming", 45.0),
                    new Book(2L, "Effective Java", "Joshua Bloch", "Programming", 55.0),
                    new Book(3L, "Sapiens", "Yuval Noah Harari", "History", 30.0),
                    new Book(4L, "Atomic Habits", "James Clear", "Self-Help", 25.0),
                    new Book(5L, "Dune", "Frank Herbert", "Sci-Fi", 35.0)

            )
    );

    public List<Book> findAll() {
        return books;
    }

    public void addBook(String title, String author, String category, Double price) {
        Long id = (long) (books.size() + 1);
            books.add(new Book(id, title, author, category, price ));
    }

    public List<Book> findBooksByCategory(String category) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


}
