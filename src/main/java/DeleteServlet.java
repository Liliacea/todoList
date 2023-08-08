import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
    ObjectMapper objectMapper = new ObjectMapper();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskObject[] taskObjectGroup = objectMapper.readValue(req.getInputStream(), TaskObject[].class);
        crudao.delete(taskObjectGroup[0]);
        resp.getWriter().write(taskObjectGroup[0].toString());
    }
}
