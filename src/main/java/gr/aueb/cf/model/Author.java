package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    //one author has many books
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//Το mappedBy πρέπει να
    // αντιστοιχεί ακριβώς στο όνομα της μεταβλητής στη Book(που είναι private Author author;)
    private Set<Book> books = new HashSet<>();

    //methods
    //add a book
    public void addBook(Book book){
        if(books == null) books = new HashSet<>();
        books.add(book);
        book.setAuthor(this);
    }

    //remove a book
    public void removeBook(Book book){
        if(books == null) books = new HashSet<>();
        books.remove(book);
        book.setAuthor(null);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }
}
