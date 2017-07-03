package bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by glady on 2/7/17.
 * Return SessionFactory, which gives us a session
 */
public class HibernateUtil {

    //from hibernate cfg file
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}