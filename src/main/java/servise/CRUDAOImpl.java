package servise;

import model.TaskObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public class CRUDAOImpl implements CRUDao<TaskObject, Integer> {
    SessionFactory sessionFactory;

    public CRUDAOImpl(SessionFactory sessionFactory) {
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
    public TaskObject add (TaskObject taskObject){
        return tx(session -> {
            session.save(taskObject);
            return taskObject;
        });
    }

    @Override
    public List<TaskObject> select() {
        return tx(session -> {
            List<TaskObject> balanceObjects = null;
            Criteria criteria = session.createCriteria(TaskObject.class);
            balanceObjects = criteria.list();
            for (TaskObject balanceObject : balanceObjects) {
                System.out.println(balanceObject.toString());
            }
            return balanceObjects;
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
}
