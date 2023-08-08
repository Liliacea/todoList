import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        TaskObject[] taskObjectGroup = objectMapper.readValue(req.getInputStream(), TaskObject[].class);
        crudao.update(taskObjectGroup[0]);
        resp.getWriter().write(taskObjectGroup[0].toString());
    }
}
