package main_factory;

import DAO.AuthorDAO;
import DAO.BookDAO;
import DAO.LanguageDAO;
import book.entity.Authors;
import book.entity.Books;
import book.entity.Genres;
import book.entity.Languages;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorDAO authorDAO = Factory.getInstance().getAuthorDAO();
        LanguageDAO languageDAO = Factory.getInstance().getLanguageDAO();
        BookDAO bookDAO = Factory.getInstance().getBookDAO();
        
        //----------CRUD - Authors--------
        System.out.println("Adding an author...");
        authorDAO.addAuthor(new Authors("Feodor", "Dostoievski"));
        
        System.out.println("Updating an author...");
        authorDAO.updateAuthor(25, "Tudor", "Vianu");
        
        System.out.println("Deleting an author...");
        authorDAO.deleteAuthor(authorDAO.getAuthorByID(8)); 
        
        List allAuthors = Factory.getInstance().getAuthorDAO().getAllAuthors();
        Iterator iterator3 = allAuthors.iterator();
        System.out.println("All Authors from DB:");
        System.out.println("------------------------------------");
        while (iterator3.hasNext()) {
            Authors author1 = (Authors)iterator3.next();
            System.out.println("ID: " + author1.getId() + "\nFirst Name : " + author1.getFirstName() + "\nLast Name: " + author1.getLastName());
        }
      
        //----------CRUD - Languages--------
        System.out.println("Adding a language...");
        languageDAO.addLanguage(new Languages("fr", "Franch"));
        
        System.out.println("Updating a language...");
        languageDAO.updateLanguage("fr", "French");
        
        System.out.println("Deleting a language...");
        languageDAO.deleteLanguage(languageDAO.getLanguageByID("fr")); 
        
        List allLanguages = Factory.getInstance().getLanguageDAO().getAllLanguages();
        Iterator iterator4 = allLanguages.iterator();
        System.out.println("All Languages from DB:");
        System.out.println("------------------------------------");
        while (iterator4.hasNext()) {
            Languages lang = (Languages)iterator4.next();
            System.out.println("Code: " + lang.getCode() + "   Name : " + lang.getName());
        }
        
        //----------CRUD - Books------------
        Authors auth = authorDAO.getAuthorByLastName("Remarque");
        
        Books b1 = new Books(auth, "Three Comrades", "1936", Genres.war_novel);
        
        Set<Books> books = new HashSet<Books>();
        books.add(b1);
        
        auth.setBooks(books);
        
        authorDAO.updateAuthor(auth);
        
        Languages lang1 = languageDAO.getLanguageByID("ru");
        Languages lang2 = languageDAO.getLanguageByID("ro");
        
        Books b2 = bookDAO.getBookByTitle("The Catcher in the Rye");
        
        Set<Books> setBooks1 = new HashSet<Books>();
        setBooks1.add(b1);
        setBooks1.add(b2);
        lang1.setBooks(setBooks1);
        
        Set<Books> setBooks2 = new HashSet<Books>();
        setBooks2.add(b2);
        lang2.setBooks(setBooks2);
        
        Set<Languages> setLanguages1 = new HashSet<Languages>();
        setLanguages1.add(lang1);
        b1.setLanguages(setLanguages1);
        
        Set<Languages> setLanguages2 = new HashSet<Languages>();
        setLanguages2.add(lang1);
        setLanguages2.add(lang2);
        b2.setLanguages(setLanguages2);
        
        bookDAO.updateBook(b1);
        bookDAO.updateBook(b2);
        
        String author = "Remarque";
        List booksList = Factory.getInstance().getBookDAO().getBooksByAuthor(author);
        Iterator iterator = booksList.iterator();
        System.out.println();
        System.out.println("Books written by " + author);
        System.out.println("------------------------------------");
        while (iterator.hasNext()) {
            Books book = (Books) iterator.next();
            Authors author2 = Factory.getInstance().getAuthorDAO().getAuthorByID(book.getAuthors().getId());
            System.out.println("Title : " + book.getTitle() + "\nYear : " + book.getYear()  + "\nGenre: " + book.getGenre() + "\nAuthor: " + author2.getLastName() + " " + author2.getFirstName());
        }
        
        String title = "Arch of Triumph";
        Books bookByTitle = Factory.getInstance().getBookDAO().getBookByTitle(title);
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Found:");
        System.out.println("------------------------------------");
        System.out.println("Title : " + bookByTitle.getTitle() + "  Year : " + bookByTitle.getYear());
          
        String year = "1934";
        List booksByYear = Factory.getInstance().getBookDAO().getBooksByYear(year);
        Iterator iterator2 = booksByYear.iterator();
        System.out.println();
        System.out.println("Year: " + year);
        System.out.println("Found:");
        System.out.println("------------------------------------");
        while (iterator2.hasNext()) {
            Books book = (Books)iterator2.next();
            System.out.println("Title : " + book.getTitle() + "  Year : " + book.getYear());
            Set<Languages> booksLang = book.getLanguages();
            for (Languages lang : booksLang) {
                System.out.println("Languages : " + lang.getName());
            }  
          
        bookDAO.deleteBook(bookDAO.getBookByID(30));
        
        languageDAO.deleteLanguage(languageDAO.getLanguageByID("ru")); 
        }
    }
}
