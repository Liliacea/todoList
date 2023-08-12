package servise;

import model.TaskObject;

import java.util.List;

public interface CRUDServlet {
    TaskObject add(TaskObject taskObjects);
    TaskObject update (TaskObject taskObject);
    TaskObject delete (TaskObject taskObject);
    List<TaskObject> findAll();
    List<TaskObject> findById (Integer id);
}
