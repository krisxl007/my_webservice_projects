package dao;

import model.Element;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tool.HibernateHelper;

public class ElementDaoImpl implements ElementDao {

    @Override
    public void add(int toAdd) {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Element element = new Element();
        element.setValue(toAdd);
        session.save(element);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public void delete(int toDelete) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public int get(int id) {
        return 0;
    }
}
