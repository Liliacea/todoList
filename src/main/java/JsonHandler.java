import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import model.Person;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonHandler extends HttpServlet {



    private static final long serialVersionUID = 1L;

    private final static String index = "/WEB-INF/json.jsp";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Controller controller = new Controller();

      //  resp.getWriter().write(controller.createJson());
        req.getRequestDispatcher(index).forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String data = req.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(data);
        Person person = objectMapper.readValue(data, Person.class);
        System.out.println(person);

        doGet(req, resp);
        System.out.println(data);

    }
}



