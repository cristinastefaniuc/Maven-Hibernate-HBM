package book.entity;

import java.util.HashSet;
import java.util.Set;

public class Languages  implements java.io.Serializable {
    private String code;
    private String name;
    private Set<Books> books = new HashSet<Books>();

    public Languages() { }
	
    public Languages(String code, String name) {
        this.code = code;
        this.name = name;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Books> getBooks() {
        return this.books;
    }
    
    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}


