package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //one book has many authors
    @ManyToOne()
    private Author author;


    @Override
    public String toString() {
        return "Book {" +
                "title='" + title + '\'' +
                ", author=" + author.getFirstname() + " " + author.getLastname() +
                '}';
    }
}
