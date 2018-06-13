package book.entity;

import java.util.HashSet;
import java.util.Set;

public class Authors  implements java.io.Serializable {
     private Integer id;
     private String firstName;
     private String lastName;
     private Set<Books> books = new HashSet<Books>();

    public Authors() { }
	
    public Authors(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Set<Books> getBooks() {
        return this.books;
    }
    
    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}


