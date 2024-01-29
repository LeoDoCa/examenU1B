package mx.edu.utez.ExamenU1B.services.book;

import mx.edu.utez.ExamenU1B.config.ApiResponse;
import mx.edu.utez.ExamenU1B.models.book.Book;
import mx.edu.utez.ExamenU1B.models.book.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Book book){
        Optional<Book> foundBook = repository.findByFolio(book.getFolio());
        if (foundBook.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "RecordAlreadyExist"), HttpStatus.BAD_REQUEST);
        }
        Optional<Book> foundBook2 = repository.findByIsbn(book.getIsbn());
        if (foundBook2.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "RecordAlreadyExist"), HttpStatus.BAD_REQUEST);
        }

        String titleX = book.getTitle().substring(0,1);
        String authorNX = book.getAuthorName().substring(0,1);
        String authorSX = book.getAuthorSurname().substring(0,2);
        String dateX = book.getPublicationDate().toString();
        System.out.println(dateX);
        String year = dateX.substring(0,4);
        String month = dateX.substring(5,7);
        String day = dateX.substring(8,10);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        String isbnX = book.getIsbn().toString().substring(0,4);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        char c = alphabet.charAt(r.nextInt(alphabet.length()));
        Random r2 = new Random();
        char c2 = alphabet.charAt(r2.nextInt(alphabet.length()));
        String folioX = titleX + authorNX + authorSX + year + month + day + isbnX + c + c2;
        String folioU = folioX.toUpperCase();
        System.out.println(folioU);
        book.setFolio(folioU);
        book = repository.saveAndFlush(book);
        return new ResponseEntity<>(new ApiResponse(book, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ApiResponse> delete(Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(id, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getByIsbn(Long isbn){
        return new ResponseEntity<>(new ApiResponse(repository.findByIsbn(isbn), HttpStatus.OK), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getByFolio(String folio){
        return new ResponseEntity<>(new ApiResponse(repository.findByFolio(folio), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(Book book){
        Optional<Book> foundBook = repository.findById(book.getId());
        if (foundBook.isEmpty()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "NotDataFound"), HttpStatus.BAD_REQUEST);
        }
        String titleX = book.getTitle().substring(0,1);
        String authorNX = book.getAuthorName().substring(0,1);
        String authorSX = book.getAuthorSurname().substring(0,2);
        String dateX = book.getPublicationDate().toString();
        System.out.println(dateX);
        String year = dateX.substring(0,4);
        String month = dateX.substring(5,7);
        String day = dateX.substring(8,10);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        String isbnX = book.getIsbn().toString().substring(0,4);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        char c = alphabet.charAt(r.nextInt(alphabet.length()));
        Random r2 = new Random();
        char c2 = alphabet.charAt(r2.nextInt(alphabet.length()));
        String folioX = titleX + authorNX + authorSX + year + month + day + isbnX + c + c2;
        String folioU = folioX.toUpperCase();
        System.out.println(folioU);
        book.setFolio(folioU);
        book = repository.saveAndFlush(book);
        return new ResponseEntity<>(new ApiResponse(book, HttpStatus.OK), HttpStatus.OK);
    }

}
