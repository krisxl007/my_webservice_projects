package dao;

import java.util.List;

/**
 * Element data access interface
 */
public interface ElementDao {

    void add(int toAdd);
    void delete(int toDelete);
    void update(int id, int newValue);
    String getById(int id);
    List<String> getAll();

}
