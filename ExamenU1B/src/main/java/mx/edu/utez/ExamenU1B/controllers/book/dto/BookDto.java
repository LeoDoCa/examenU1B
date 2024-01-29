package mx.edu.utez.ExamenU1B.controllers.book.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenU1B.models.book.Book;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
public class BookDto {
    private Long id;

    private String title;

    @Size(min=4, max=13, message="ISBNSizeError")
    private Long isbn;

    private String authorName;

    private String authorSurname;

    private Long pages;

    private String category;

    private LocalDate publicationDate;

    public Book toEntity(){
        return new Book(title, isbn, authorName, authorSurname, pages, category, publicationDate);
    }
}
