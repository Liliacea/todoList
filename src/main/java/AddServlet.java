import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EmptyTask;
import model.TaskObject;
import servise.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ObjectMapper objectMapper = new ObjectMapper();

    TaskObject taskObject;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        taskObject = objectMapper.readValue(req.getInputStream(), TaskObject.class);

        if (Objects.isNull(taskObject)){
        resp.getWriter().write((new EmptyTask("Empty", "Пустой объект") ).toString());

        } else {



            CRUDServletImpl.getInstance().add(taskObject);
            resp.getWriter().write(taskObject.toString());
        }


    }
}
