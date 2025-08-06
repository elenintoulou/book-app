package gr.aueb.cf;


import gr.aueb.cf.model.Author;
import gr.aueb.cf.model.Book;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public class App {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookApp");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

//        Author alice = new Author();
//        alice.setFirstname("Alice");
//        alice.setLastname("W");
//
//        Author bill = new Author();
//        bill.setFirstname("Bill");
//        bill.setLastname("York");
//
//        Author alice = em.find(Author.class, 1L);  // id της Alice
//        Author bill = em.find(Author.class, 2L);  // id του Bill
//
//        Book book1 = new Book(null, "Alone", bill);
//        Book book2 = new Book(null, "GEIA", alice);
//
//        Book book1ToRemove = em.find(Book.class, 3L);
//        Book book2ToRemove = em.find(Book.class, 4L);

//        em.getTransaction().begin();
//        //create Authors
//        em.persist(alice);
//        em.persist(bill);
//        em.persist(book1);
//        em.persist(book2);
//        em.remove(book1ToRemove);
//        em.remove(book2ToRemove);
//        em.getTransaction().commit();

        //JPQL
        //get all books written by Alice
        TypedQuery<Book> query1 = em.createQuery("SELECT b FROM Book b WHERE b.author.firstname = :firstname", Book.class);
        query1.setParameter("firstname", "Alice");
        List<Book> books = query1.getResultList();
        books.forEach(System.out::println);

        //get all books
        TypedQuery<Book> query2 = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> getAllBooks = query2.getResultList();
        getAllBooks.forEach(System.out::println);

        //bring all the books with title "Alone"
        TypedQuery<Book> query3 = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        query3.setParameter("title", "Alone");
        List<Book> getBookByTitle = query3.getResultList();
        getBookByTitle.forEach(System.out::println);

        //count how many books are in my db
        TypedQuery<Long> query4 = em.createQuery("SELECT COUNT (b) FROM Book b", Long.class);
        Long countOfBooks = query4.getSingleResult();
        System.out.println("Number of books in DB: " + countOfBooks);
    }
}
