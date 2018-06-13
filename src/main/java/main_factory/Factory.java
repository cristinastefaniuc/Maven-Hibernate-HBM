package main_factory;

import DAO.AuthorDAO;
import DAO.BookDAO;
import DAO.LanguageDAO;

public class Factory {
    private static BookDAO bookDAO = null;
    private static AuthorDAO authorDAO = null;
    private static LanguageDAO languageDAO = null;
    private static Factory instance = null;
    
    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }
    
    public BookDAO getBookDAO(){
        if (bookDAO == null){
            bookDAO = new BookDAO();
        }
        return bookDAO;
    }
    
    public AuthorDAO getAuthorDAO(){
        if (authorDAO == null){
            authorDAO = new AuthorDAO();
        }
        return authorDAO;
    }
    
    public LanguageDAO getLanguageDAO(){
        if (languageDAO == null){
            languageDAO = new LanguageDAO();
        }
        return languageDAO;
    }
}
