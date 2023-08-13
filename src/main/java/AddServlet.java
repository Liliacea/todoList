import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskObject;
import servise.*;

import java.io.IOException;
import java.io.PrintWriter;


public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



            TaskObject taskObject = objectMapper.readValue(req.getInputStream(), TaskObject.class);
            CRUDServletImpl.getInstance().add(taskObject);
            resp.getWriter().write(taskObject.toString());


    }
}
