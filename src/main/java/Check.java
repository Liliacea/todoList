import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import model.Person;
import model.TaskContext;
import model.TaskObject;
import servise.CRUDAOImpl;

import servise.HibernateUtil;

import java.util.List;

public class Check {


  public static void main(String[] args) throws JsonProcessingException {
    /*  TaskContext taskObject = new TaskContext();


      System.out.println(taskObject);
      // taskObject.setiState(new NewState());
      taskObject.wip();
      System.out.println(taskObject.getStatusName());



      System.out.println(taskObject);

     */

      /*CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
      Person person = new Person.Builder()
              .firstName("aaa")
              .lastName("bbb")
              .build();
      TaskObject doingSomething = new TaskObject("doingSomething", "do_do_do_do");
      TaskObject doingSomething1 = new TaskObject("doingSomething", "do_do_do_do");

      List<TaskObject> taskObjects =  person.getTaskObjectSet();
      taskObjects.add(doingSomething);
      taskObjects.add(doingSomething1);
      person.setTaskObjectSet(taskObjects);
      crudao.add(person);
      crudao.select();*/

      CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
    //  TaskObject doingSomething = new TaskObject("aaa", "aaa");

      String t = Controller.createJson();

      System.out.println(t);

      final Person person = new ObjectMapper().readValue(t, Person.class);
      System.out.println(person);



  }


}
