package dao;

import entity.Booking;
import entity.CoworkingSpace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.CompositeOwner;
import util.HibernateUtils;

import java.util.List;

public class CoworkingSpaceDao {
    public void saveCoworkingSpace(CoworkingSpace coworkingSpace) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(coworkingSpace);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public CoworkingSpace getCoworkingSpaceById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(CoworkingSpace.class, id);
        }
    }

    // Get All Users
    public List<CoworkingSpace> getAllCoworkingSpaces() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from CoworkingSpace", CoworkingSpace.class).list();
        }
    }

    // Update User
    public void updateCoworkingSpace(CoworkingSpace coworkingSpace) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(coworkingSpace);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Delete User
    public void deleteCoworkingSpace(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CoworkingSpace coworkingSpace = session.get(CoworkingSpace.class, id);
            if (coworkingSpace != null) {
                session.remove(coworkingSpace);
                System.out.println("Coworking Space deleted successfully!");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
