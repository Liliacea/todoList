import com.fasterxml.jackson.core.JsonProcessingException;
import controller.JsonCreator;
import model.Person;
import model.TaskObject;

import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

public class Check {


  public static void main(String[] args) throws JsonProcessingException {
    /*  TaskContext taskObject = new TaskContext();


      System.out.println(taskObject);
      // taskObject.setiState(new NewState());
      taskObject.wip();
      System.out.println(taskObject.getStatusName());



      System.out.println(taskObject);

     */

     //CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
      CRUDaoImplTasks cruDaoImplTasks = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
      Person person = new Person("aaa","bbb");
      TaskObject doingSomething = new TaskObject("doingSomething", "do_do_do_do");
      TaskObject doingSomething1 = new TaskObject("doingSomething", "do_do_do_do");

     /* List<TaskObject> taskObjects =  person.getTaskObjectSet();
      taskObjects.add(doingSomething);
      taskObjects.add(doingSomething1);
      person.setTaskObjectSet(taskObjects);
      crudao.add(person);
      crudao.select();

      */




     // CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
    //  TaskObject doingSomething = new TaskObject("aaa", "aaa");



     String t = JsonCreator.createJson();

     System.out.println(t);
      System.out.println(cruDaoImplTasks.findById(58));




     // final Person[] person1 = new ObjectMapper().readValue(t, Person[].class);
     // System.out.println(person1[0]);





  }


}
