import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDServletImpl;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskObject taskObject = new ObjectMapper().readValue(req.getInputStream(), TaskObject.class);
        CRUDServletImpl.getInstance().update(taskObject);
        resp.getWriter().write(taskObject.toString());
    }
}
