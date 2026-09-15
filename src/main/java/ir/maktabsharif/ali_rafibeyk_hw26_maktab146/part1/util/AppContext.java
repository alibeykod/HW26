package ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.util;

import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.repository.BookRepo;
import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.service.BooksService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        BookRepo bookRepo = new BookRepo();

        BooksService booksService = new BooksService(bookRepo);
        ServletContext context = sce.getServletContext();

        context.setAttribute("BooksService" , booksService);
    }
}
