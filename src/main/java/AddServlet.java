import com.fasterxml.jackson.databind.ObjectMapper;
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



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
        ObjectMapper objectMapper = new ObjectMapper();
        TaskObject[] person = objectMapper.readValue(req.getInputStream(), TaskObject[].class);
        crudao.add(person[0]);
        resp.getWriter().write(person[0].toString());
    }
}
