package servise;

import model.Person;
import model.TaskObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.function.Function;

public class CRUDaoImplTasks implements CRUDao<TaskObject,Integer>{
static SessionFactory sessionFactory;

    public CRUDaoImplTasks(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> T tx(Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    @Override
    public TaskObject add(TaskObject taskObject) {
        return tx(session -> {
            session.save(taskObject);
            return taskObject;
        });
    }

    @Override
    public List<TaskObject> select() {
        return tx(session -> {
            List<TaskObject> taskObjectGroup = null;
            Criteria criteria = session.createCriteria(TaskObject.class);
            taskObjectGroup = criteria.list();
            for (TaskObject taskObject : taskObjectGroup) {
                System.out.println(taskObject.toString());
            }
            return taskObjectGroup;
        });
    }

    @Override
    public TaskObject update(TaskObject taskObject) {
        return tx(session -> {

            session.update(taskObject);
            return taskObject;
        });
    }

    @Override
    public TaskObject delete(TaskObject taskObject) {
        return tx(session -> {

            session.delete(taskObject);
            return taskObject;
        });
    }

    @Override
    public List<TaskObject> findById(Integer id) {
        return tx(session -> {
            List<TaskObject> taskObjectGroup = null;
            Criteria criteria = session.createCriteria(TaskObject.class);
            criteria.add(Restrictions.eq("id", id));
            taskObjectGroup = criteria.list();
            for (TaskObject taskObject : taskObjectGroup) {
                System.out.println(taskObject.toString());


            }
            return taskObjectGroup;
        });
    }
}
