package tool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        return configuration.configure().buildSessionFactory();
    }
}
