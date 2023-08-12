import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.CRUDServlet;
import servise.CRUDServletImpl;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TaskObject> taskObjectGroup = CRUDServletImpl.getInstance().findAll();
        resp.getWriter().write(taskObjectGroup.toString());
    }
}
