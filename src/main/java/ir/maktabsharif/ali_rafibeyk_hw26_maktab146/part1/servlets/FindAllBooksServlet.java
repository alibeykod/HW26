package ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.servlets;

import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.model.Book;
import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.service.BooksService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindAllBooksServlet extends HttpServlet {
    private BooksService booksService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        booksService = (BooksService) config.getServletContext().getAttribute("BooksService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


            List<Book> allBooks = booksService.findAllWithValidation();


        out.println(
                """
                        <!doctype html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport"
                                  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                            <meta http-equiv="X-UA-Compatible" content="ie=edge">
                            <title>Document</title>
                        </head>
                        <body>
                        
                        <table border = "1">
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Category</th>
                                <th>Price</th>
                            </tr>  
                        """
        );

        for (Book book : allBooks) {
            out.println("<tr>");
            out.println("<td>" + book.getId() + "</td>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getAuthor() + "</td>");
            out.println("<td>" + book.getCategory() + "</td>");
            out.println("<td>" + book.getPrice() + "</td>");
            out.println("</tr>");
        }

        out.println(
                """
                        </table>
                        
                        </body>
                        </html>
                        """
        );
    }
}
