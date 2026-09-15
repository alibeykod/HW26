package ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.service;

import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.model.Book;
import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.repository.BookRepo;

import java.util.List;

public class BooksService {
    private final BookRepo bookRepo ;

    public BooksService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAllWithValidation() {
        if (bookRepo.findAll().isEmpty()) {
            throw new RuntimeException("There Is No Book To Show");
        }
        return bookRepo.findAll();
    }
    public List<Book> findByCategory(String category){
        List<Book> foundBooksByCategory = bookRepo.findBooksByCategory(category);
        if (category == null || category.isBlank()){
            throw new RuntimeException("Category Did Not Found !");
        }
        if (foundBooksByCategory == null || foundBooksByCategory.isEmpty()){
            throw new RuntimeException("[" + category + "] Did Not Found");
        }
        return foundBooksByCategory;
    }

    public void addBook(String title, String author, String category, Double price){

        if (title == null || title.isBlank()){
            throw new RuntimeException("Title Can Not Be Empty Or Null !");
        }
        if (author == null || author.isBlank()){
            throw new RuntimeException("Author Can Not Be Empty Or Null !");
        }
        if (category == null ||  category.isBlank()){
            throw new RuntimeException("Category Can Not Be Empty Or Null !");
        }
        if (price == null || price < 0){
            throw new RuntimeException("Price Can Not Be Negative !");
        }
        bookRepo.addBook( title , author , category  , price );
    }
}
