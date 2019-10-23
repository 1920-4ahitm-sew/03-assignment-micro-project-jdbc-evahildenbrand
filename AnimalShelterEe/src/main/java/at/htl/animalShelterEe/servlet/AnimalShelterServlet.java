package at.htl.animalShelterEe.servlet;

import at.htl.animalShelterEe.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("animalServlet")
public class AnimalShelterServlet extends HttpServlet {

    static Database db = new Database();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<html>");
            printWriter.println("<head>");
                printWriter.println("<title>Animal Species</title>");
                printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("</head>");
            printWriter.println("<body>");
                printWriter.println("<h1>Animal Species</h1>");
            printWriter.println("</body>");
        printWriter.println("</html>");
    }

}
