package book.entity;

import java.util.HashSet;
import java.util.Set;

public class Books  implements java.io.Serializable {
    private Integer id;
    private Authors authors;
    private String title;
    private String year;
    private Genres genre;
    private Set<Languages> languages  = new HashSet<Languages>();

    public Books() { }
	
    public Books(Authors authors, String title, String year, Genres genre) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Authors getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public Genres getGenre() {
        return this.genre;
    }
    
    public void setGenre(Genres genre) {
        this.genre = genre;
    }
    
    public Set<Languages> getLanguages() {
        return this.languages;
    }
    
    public void setLanguages(Set<Languages> languages) {
        this.languages = languages;
    }
}


