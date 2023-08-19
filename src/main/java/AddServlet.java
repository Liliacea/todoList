import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
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
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            TaskObject taskObject = objectMapper.readValue(req.getInputStream(), TaskObject.class);

            CRUDServletImpl.getInstance().add(taskObject);
            resp.getWriter().write(taskObject.toString());
        } catch (Exception e) {
            resp.getWriter().write((new EmptyTask("Empty", "Пустой объект")).toString());
        }
    }
}

