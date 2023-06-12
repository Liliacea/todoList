import com.fasterxml.jackson.databind.ObjectMapper;
import model.TaskObject;
import model.TaskState;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

//@WebServlet( "/hello")
public class HelloServlet extends HttpServlet {


    //   public void init() {
    //     message = "Hello World!";
    //  }

    private static final long serialVersionUID = 1L;
    CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //INDEX.JSP
        ObjectMapper objectMapper = new ObjectMapper();

        if (req.getParameter("Add new todo") != null) {
            TaskObject taskObject = new TaskObject.Builder()
                    .name(req.getParameter("name"))
                    .description(req.getParameter("description"))
                    .state(TaskState.CLOSED)
                    .build();


            crudao.add(taskObject);
            objectMapper.writeValue(new File("target/todo.json"), taskObject);

            resp.sendRedirect("list.html");
          /*  req.setAttribute("list",userDAO.getAll());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.html");
            requestDispatcher.forward(request,response);

         */
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*  String firstName = req.getParameter("firstName");
       String lastName = req.getParameter("lastName");
       HttpSession session = req.getSession();
       session.setAttribute("firstName",firstName);
       session.setAttribute("lastName", lastName);
       User user = new User();
       user.setFirstName(firstName);
       user.setLastName(lastName);
        new UserDAO().createUser(user);
        RequestDispatcher rd = req.getRequestDispatcher("welcome jsp");
        rd.forward(req,resp);


    }

    public void destroy() {
    }
    */

    }
}
