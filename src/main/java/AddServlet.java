import com.fasterxml.jackson.databind.ObjectMapper;
import controller.JsonConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;


public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
   ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskObject[] taskObjectGroup = objectMapper.readValue(req.getInputStream(), TaskObject[].class);
        if(taskObjectGroup[0]!=null) {
            crudao.add(taskObjectGroup[0]);
            resp.getWriter().write(taskObjectGroup[0].toString());
        } else {
            req.getRequestDispatcher("/findAllTasks").forward(req, resp);
        }
    }

}
