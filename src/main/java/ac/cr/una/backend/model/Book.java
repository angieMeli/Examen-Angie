/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Tuti
 */
@Entity
@Table(name = "book", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idBook")})
public class Book {
    
  @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBook")
    private int idBook;
  
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author author;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idType", nullable = false)
    private BookType Type;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "calendar", unique = false, nullable = false)
    private Calendar dateRealease;
    
    @Column(name = "price", unique = false, nullable = false)
    private float price;

    public Book() {
    }

    public Book(int idBook, Author author, BookType Type, String name, Calendar dateRealease, float price) {
        this.idBook = idBook;
        this.author = author;
        this.Type = Type;
        this.name = name;
        this.dateRealease = dateRealease;
        this.price = price;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookType getType() {
        return Type;
    }

    public void setType(BookType Type) {
        this.Type = Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateRealease() {
        return dateRealease;
    }

    public void setDateRealease(Calendar dateRealease) {
        this.dateRealease = dateRealease;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idBook;
        hash = 17 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 17 * hash + (this.Type != null ? this.Type.hashCode() : 0);
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.dateRealease != null ? this.dateRealease.hashCode() : 0);
        hash = 17 * hash + Float.floatToIntBits(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.author != other.author && (this.author == null || !this.author.equals(other.author))) {
            return false;
        }
        if (this.Type != other.Type && (this.Type == null || !this.Type.equals(other.Type))) {
            return false;
        }
        if (this.dateRealease != other.dateRealease && (this.dateRealease == null || !this.dateRealease.equals(other.dateRealease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", author=" + author + ", Type=" + Type + ", name=" + name + ", dateRealease=" + dateRealease + ", price=" + price + '}';
    }

    
    
   
    
  
    
    
    
}
