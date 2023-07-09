package servise;

import java.util.List;

public interface CRUDao<T,R>{

    T add(T t);
    List<T> select ();
    T update(T t);
    T delete(T t);
    List<T> findById(R id);

}
