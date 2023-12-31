package servise;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EmptyTask;
import model.TaskObject;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CRUDServletImpl implements CRUDServlet{
    private static final long serialVersionUID = 1L;
    private static final CRUDServlet INSTANSE = new CRUDServletImpl();
    private static final CRUDao crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());



    public static CRUDServlet getInstance(){

        return INSTANSE;
    }



    @Override
    public TaskObject add(TaskObject taskObject) {

            crudao.add(taskObject);

    return taskObject;
    }

    @Override
    public TaskObject update(TaskObject taskObject) {
        crudao.update(taskObject);
        return taskObject;
    }

    @Override
    public TaskObject delete(TaskObject taskObject) {
        crudao.delete(taskObject);
        return taskObject;
    }

    @Override
    public List<TaskObject> findAll() {
        return  crudao.select();

    }

    @Override
    public List<TaskObject> findById(Integer id) {
        return crudao.findById(id);
    }
}
