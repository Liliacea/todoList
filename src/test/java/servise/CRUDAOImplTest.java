package servise;

import junit.framework.TestCase;
import model.Person;
import model.TaskObject;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CRUDAOImplTest {
    CRUDAOImpl crudao = new CRUDAOImpl(HibernateRollBack.create(HibernateUtil.getSessionFactory()));
    Person person = new Person();
    TaskObject doingSomething = new TaskObject("aaa","aaa");

    TaskObject doingSomething1 = new TaskObject("aaa","aaaa");

   /* List<TaskObject> taskObjects = person.getTaskObjectSet();

    @Test
   public void add() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);
        assertThat(crudao.add(person).getFirstName(), is("aaa"));
    }
    @Test
    public void findById() {

        crudao.add(person);
        assertThat(crudao.findById(person.getId()).size(), is(1));
    }
    @Test
    public void addWithTasks() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);

        assertThat(crudao.add(person).getTaskObjectSet().size(), is(2));
    }

    @Test
    public void updatePerson() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);

        crudao.add(person);
        person.setFirstName("qwerty");

        assertThat(crudao.update(person).getFirstName(), is("qwerty"));


    }

    @Test
    public void updateTask() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);

        crudao.add(person);
        taskObjects.get(1).setName("doNothing");
        assertThat(crudao.update(person).getTaskObjectSet().get(1).getName(), is("doNothing"));
    }


    @Test
    public void select() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);

        crudao.add(person);


        assertThat(crudao.select().contains(person), is(true));


    }


    @Test
    public void delete() {
        taskObjects.add(doingSomething);
        taskObjects.add(doingSomething1);
        person.setTaskObjectSet(taskObjects);

        crudao.add(person);
        crudao.delete(person);
        assertThat(crudao.select().contains(person), is(false));


    }

    */

}