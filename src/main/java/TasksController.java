import com.fasterxml.jackson.databind.ObjectMapper;
import controller.JsonCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TasksController extends HttpServlet {


    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
        ObjectMapper objectMapper = new ObjectMapper();
      /*  String id = req.getParameter("id");
        Integer id_ = parseInt(id);

        List<TaskObject> taskObject = crudao.findById(id_);

        resp.getWriter().write(objectMapper.writeValueAsString(taskObject));
        resp.getWriter().write(taskObject.toString());
        doGet(req, resp);


       */




        TaskObject[] person = objectMapper.readValue(req.getInputStream(), TaskObject[].class);
            crudao.select();
            crudao.add(person[0]);
            System.out.println(person[0]);
            resp.getWriter().write(person[0].toString());
            doGet(req, resp);







        }
    }



