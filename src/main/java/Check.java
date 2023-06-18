import com.fasterxml.jackson.databind.ObjectMapper;
import model.TaskObject;
import model.TaskState;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

import java.io.File;
import java.io.IOException;

public class Check {


  public static void main(String[] args) {

      CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
      TaskObject doingSomething = new TaskObject.Builder()
              .name("doingSomething")
              .description("do_do_do_do")
              .state(TaskState.CLOSED)

              .build();
      System.out.println(crudao.select());


  }


}
