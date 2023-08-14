import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.EmptyTask;
import model.Person;
import model.TaskObject;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
      //CRUDaoImplTasks cruDaoImplTasks = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
       ObjectMapper objectMapper = new ObjectMapper();
      Person person = new Person("aaa","bbb");
      TaskObject doingSomething = new TaskObject("doingSomething", "do_do_do_do");
     /* EmptyTask emptyTask = new EmptyTask(code, reason);
      emptyTask.setCode("emptyTask");
      emptyTask.setReason("Пустойобъект");
      System.out.println(emptyTask);
      List<EmptyTask> personList = new CopyOnWriteArrayList<>();
      personList.add(emptyTask);
      System.out.println(objectMapper.writeValueAsString(personList));

      */
     //   CRUDServletImpl.getInstance().add(doingSomething1);
     /* List<TaskObject> taskObjects =  person.getTaskObjectSet();
      taskObjects.add(doingSomething);
      taskObjects.add(doingSomething1);
      person.setTaskObjectSet(taskObjects);
      crudao.add(person);
      crudao.select();

      */




     // CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
    //  TaskObject doingSomething = new TaskObject("aaa", "aaa");



   /*  String t = JsonCreator.createJson();

     System.out.println(t);

    */
     // System.out.println(cruDaoImplTasks.findById(58));






     // final Person[] person1 = new ObjectMapper().readValue(t, Person[].class);
     // System.out.println(person1[0]);





  }


}
