package mx.edu.utez.ExamenU1B.models.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String title;
    @Column(length = 13, nullable = false)
    private Long isbn;
    @Column(length = 45, nullable = false)
    private String authorName;
    @Column(length = 45, nullable = false)
    private String authorSurname;
    @Column(length = 20, nullable = false)
    private Long pages;
    @Column(length = 45, nullable = false)
    private String category;
    @Column(length = 45, nullable = false)
    private LocalDate publicationDate;
    @Column(length = 45, nullable = false)
    private String folio;

    public Book(String title, Long isbn, String authorName, String authorSurname, Long pages, String category, LocalDate publicationDate) {
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.pages = pages;
        this.category = category;
        this.publicationDate = publicationDate;
    }

    public Book(String title, Long isbn, String authorName, String authorSurname, Long pages, String category, LocalDate publicationDate, String folio) {
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.pages = pages;
        this.category = category;
        this.publicationDate = publicationDate;
        this.folio = folio;
    }

    public Book(Long id, String title, Long isbn, String authorName, String authorSurname, Long pages, String category, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.pages = pages;
        this.category = category;
        this.publicationDate = publicationDate;
    }
}
