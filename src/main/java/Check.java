import model.TaskObject;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

public class Check {


  public static void main(String[] args) {

      CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
      TaskObject doingSomething = new TaskObject("aaa", "aaa");

      crudao.add(doingSomething);
      System.out.println(crudao.select());


  }


}
