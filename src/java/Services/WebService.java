
package Services;

import java.util.List;


public interface WebService<T> {
    List<T> FindAll();
    T FindById(long id);
    void Insert(T element);
    void Delete(long id);
    void Update(long id,T element);
            
}
