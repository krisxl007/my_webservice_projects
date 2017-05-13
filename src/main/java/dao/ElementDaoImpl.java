package dao;

import model.Element;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tool.HibernateHelper;

@Repository
public class ElementDaoImpl implements ElementDao {

    private static final Logger LOGGER = Logger.getLogger(ElementDaoImpl.class);

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
