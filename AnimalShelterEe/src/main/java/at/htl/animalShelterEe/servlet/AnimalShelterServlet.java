package at.htl.animalShelterEe.servlet;

import at.htl.animalShelterEe.database.Database;
import at.htl.animalShelterEe.model.AnimalSpecies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("animalServlet")
public class AnimalShelterServlet extends HttpServlet {

    static Database db = new Database();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();

        List<AnimalSpecies> speciesList = db.selectAllAnimalSpecies();

        printWriter.println("<html>");
            printWriter.println("<head>");
                printWriter.println("<title>Animal Species</title>");
                printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("</head>");
            printWriter.println("<body>");
                printWriter.println("<h1>Animal Species</h1>");
                printWriter.println("<table>");
                    printWriter.println("<tr>");
                        printWriter.println("<th>Breed</th>");
                        printWriter.println("<th>Species</th>");
                        printWriter.println("<th>Genus</th>");
                    printWriter.println("</tr>");
                    for(AnimalSpecies species : speciesList){
                        printWriter.println("<tr>");
                            printWriter.println("<td>" + species.getBreed() + "</td>");
                            printWriter.println("<td>" + species.getSpecies() + "</td>");
                            printWriter.println("<td>" + species.getGenus() + "</td>");
                        printWriter.println("</tr>");
                    }
                printWriter.println("</table>");
            printWriter.println("</body>");
        printWriter.println("</html>");
    }

}
