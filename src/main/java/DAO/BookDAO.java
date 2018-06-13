package DAO;

import book.entity.Authors;
import book.entity.Books;
import book.entity.Genres;
import book.entity.Languages;
import book.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class BookDAO {
    Session session = null;

    public BookDAO(){ }
    
    public Books getBookByID(int id) {
        Books book = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Books as b where b.id = '"+ id +"'");
            book = (Books)q.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }
    
    public List getBooksByYear(String year) {
        List<Books> booksList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Books as books where books.year = '"+ year +"'");
            booksList = (List<Books>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booksList;
    }
    
    public List getBooksByAuthor(String Author){
        List<Books> booksList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Books as b join fetch b.authors a where a.lastName = '" + Author + "'");
            booksList = (List<Books>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booksList;
    }
    
    public List getBooksByGenre(String Genre){
        List<Books> booksList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Books as books where books.genres in (select genre.id from Genres as genre where genre.name='" + Genre + "')");
            booksList = (List<Books>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return booksList;
    }
    
    public Books getBookByTitle(String Title){
        Books book = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Books as books where books.title = '" + Title + "'");
            book = (Books)q.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }
    
    
    public void addBook(Books book) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
          }
        }
    }
    
    public void updateBook(int id, String title, Authors author, Genres genre, Set<Languages> language, String year) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Books b = new Books();
            b.setId(id);
            b.setTitle(title);
            b.setAuthors(author);
            b.setGenre(genre);
            b.setLanguages(language);
            b.setYear(year);
            session.beginTransaction();
            session.update(b);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
          }
        }
    }
    
    public void updateBook(Books book) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void deleteBook(Books book) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
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
