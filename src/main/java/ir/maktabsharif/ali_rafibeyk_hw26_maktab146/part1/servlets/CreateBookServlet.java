package ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.servlets;

import ir.maktabsharif.ali_rafibeyk_hw26_maktab146.part1.service.BooksService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CreateBookServlet extends HttpServlet {

    private int maxBooksLimit;
    private BooksService booksService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        booksService = (BooksService) config.getServletContext().getAttribute("BooksService");

        String maxBooksLimitParam = config.getInitParameter("maxBooksLimit");
        this.maxBooksLimit = Integer.parseInt(maxBooksLimitParam);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

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
                        
                        <form method="post" action="create" border="1">
                            <label>Title :</label><br>
                            <input type="text" name="title" placeholder="Enter The Title" required> <br>
                            <label>Author :</label><br>
                            <input type="text" name="author" placeholder="Enter Name Of The Author :" required> <br>
                            <label>Category :</label><br>
                            <input type="text" name="category" placeholder="Enter The Category Of The Book : " required> <br>
                             <label>Price :</label><br>
                            <input type="text" name="price" placeholder="Enter The Price Of The Book : $ " required> <br>
                            <button type="submit">Add</button>
                        </form>
                        </body>
                        </html>
                        """
        );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        String priceStr = req.getParameter("price");
        Double price = Double.valueOf(priceStr);

        booksService.addBook(title , author , category , price);
        resp.sendRedirect(req.getContextPath() +"/allBooks");

    }
}
