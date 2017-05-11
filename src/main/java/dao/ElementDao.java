package dao;

/**
 * Element data access interface
 */
public interface ElementDao {
    void add(int toAdd);
    void delete(int toDelete);
    void update(int id);
    int get(int id);
}
