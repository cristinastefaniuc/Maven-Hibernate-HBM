package DAO;

import book.entity.Languages;
import book.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class LanguageDAO {
    Session session = null;

    public LanguageDAO(){ }
    
    public Languages getLanguageByID(String id) {
        Languages language = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Languages as l where l.code = '"+ id +"'");
            language = (Languages)q.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return language;
    }
    
    public List getAllLanguages() {
        List<Languages> languagesList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            org.hibernate.query.Query q = session.createQuery ("from Languages");
            languagesList = (List<Languages>)q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return languagesList;
    }
    
    public void addLanguage(Languages language) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(language);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
          }
        }
    }
    
    public void updateLanguage(String id, String name) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Languages l = new Languages();
            l.setCode(id);
            l.setName(name);
            session.beginTransaction();
            session.update(l);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
          }
        }
    }
    
    public void deleteLanguage(Languages language) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(language);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
          }
        }
    }
}
