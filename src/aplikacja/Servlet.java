package aplikacja;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nazwa = request.getParameter("NazwaPiosenki");
        String autor = request.getParameter("NazwaAutora");
        out.println("aplikacja.Servlet.Pies: " + nazwa + " " + autor + " bedzie dodany do bazy danych.");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/new_schema";
            String user      = "root";
            String password  = "";
            conn = DriverManager.getConnection(url, user, password);

            Statement stmt = null;

            stmt = conn.createStatement();

            String sql = "INSERT INTO piosenka " +
                    "VALUES ('" + nazwa + "','" + autor + "')";

            stmt.executeUpdate(sql);


            sql = "SELECT * FROM piosenka";
            ResultSet rst;
            rst = stmt.executeQuery(sql);

            List<Piosenka> piosenki = new ArrayList<Piosenka>();

            while (rst.next()) {
                Piosenka Piosenka = new Piosenka();
                Piosenka.setNazwa(rst.getString("nazwa"));
                Piosenka.setAutor(rst.getString("autor"));
                piosenki.add(Piosenka);
            }

            request.setAttribute("piosenki", piosenki);
            request.getRequestDispatcher("lista.jsp").forward(request, response);

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static class Piosenka {
        String nazwa;
        String autor;

        public String getNazwa() {
            return nazwa;
        }

        public String getAutor() {
            return autor;
        }

        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }
    }
}
