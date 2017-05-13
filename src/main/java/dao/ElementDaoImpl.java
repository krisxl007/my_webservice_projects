package dao;

import constant.QueryValueConstant;
import model.Element;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tool.HibernateHelper;

import java.util.List;
import java.util.stream.Collectors;

@Repository
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
        //TODO
    }

    @Override
    public void update(int id) {
        //TODO
    }

    @Override
    public String getById(int id) {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Element element = (Element)session.get(Element.class, id);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return null != element ? String.valueOf(element.getValue()) : QueryValueConstant.VALUE_NOT_FOUND;
    }

    @Override
    public List<String> getAll() {
        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Element> list = session.createQuery("from Element").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list.parallelStream()
                .map(element -> String.valueOf(element.getValue()))
                .collect(Collectors.toList());
    }
}
