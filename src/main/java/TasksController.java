import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Person;
import servise.CRUDAOImpl;
import servise.HibernateUtil;


import java.io.IOException;
import java.io.PrintWriter;

public class TasksController extends HttpServlet {



    private static final long serialVersionUID = 1L;
    String t = Controller.createJson();
    private final static String index = "/WEB-INF/json.jsp";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Controller controller = new Controller();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
       // resp.getWriter().write(t);
       // req.getRequestDispatcher(index).forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       //final String data = req.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();

       // System.out.println(data);
        Person[] person = objectMapper.readValue(req.getInputStream(), Person[].class);
        CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
        crudao.add(person[0]);
        System.out.println(person[0]);
        resp.getWriter().write(person[0].toString());
        doGet(req, resp);
     //   System.out.println(data);



    }
}



