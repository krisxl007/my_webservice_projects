package dao;

import constant.QueryValueConstant;
import model.Element;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import tool.HibernateHelper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ElementDaoImpl implements ElementDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void add(int toAdd) {
//        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Element element = new Element();
//        element.setValue(toAdd);
//        session.save(element);
//
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();
        Element element = new Element();
        element.setValue(toAdd);
        hibernateTemplate.save(element);
    }

    @Override
    public void delete(int toDelete) {
        Element element = new Element();
        element.setValue(toDelete);
        hibernateTemplate.delete(element);
    }

    @Override
    public void update(int id, int newValue) {
        Element element = new Element();
        element.setId(id);
        element.setValue(newValue);
        hibernateTemplate.update(element);
    }

    @Override
    public String getById(int id) {
//        SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Element element = (Element)session.get(Element.class, id);
//
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();

        Element element = hibernateTemplate.get(Element.class, id);
        return Optional.ofNullable(element).isPresent()
                ? String.valueOf(element.getValue())
                : QueryValueConstant.VALUE_NOT_FOUND;
    }

    @Override
    public List<String> getAll() {
        List<Element> list = (List<Element>) hibernateTemplate.find("from Element");
        return list.parallelStream()
                .map(element -> String.valueOf(element.getValue()))
                .collect(Collectors.toList());
    }
}
