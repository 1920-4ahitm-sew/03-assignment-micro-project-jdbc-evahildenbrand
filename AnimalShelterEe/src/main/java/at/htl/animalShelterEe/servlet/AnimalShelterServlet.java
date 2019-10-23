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

        String htmlOutput;

        htmlOutput = "<html>";
            htmlOutput += "<head>";
                htmlOutput += "<title>Animal Species</title>";
                htmlOutput += "<meta charset='UTF-8'>";
            htmlOutput += "</head>";
            htmlOutput += "<body>";
                htmlOutput += "<h1>Animal Species</h1>";
            htmlOutput += "</body>";
        htmlOutput += "</html>";

        printWriter.println(htmlOutput);
    }

}
