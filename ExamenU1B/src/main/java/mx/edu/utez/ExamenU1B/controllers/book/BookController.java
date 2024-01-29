package mx.edu.utez.ExamenU1B.controllers.book;

import jakarta.validation.Valid;
import mx.edu.utez.ExamenU1B.config.ApiResponse;
import mx.edu.utez.ExamenU1B.controllers.book.dto.BookDto;
import mx.edu.utez.ExamenU1B.controllers.book.dto.FolioDto;
import mx.edu.utez.ExamenU1B.controllers.book.dto.IsbnDto;
import mx.edu.utez.ExamenU1B.controllers.book.dto.UpdateDto;
import mx.edu.utez.ExamenU1B.services.book.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        return service.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody BookDto dto){
        System.out.println(dto.getPublicationDate().toString());
        return service.save(dto.toEntity());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> getByIsbn(@RequestBody IsbnDto dto) {
        return service.getByIsbn(dto.getIsbn());
    }
    @GetMapping("//")
    public ResponseEntity<ApiResponse> getByFolio(@RequestBody FolioDto dto) {
        return service.getByFolio(dto.getFolio());
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> update(@RequestBody UpdateDto dto){
        return service.update(dto.toEntity());
    }

}
