package com.skp.spring.data.resources;

import com.skp.spring.data.model.Book;
import com.skp.spring.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mysql/books/")
public class BookResource {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public ResponseEntity createUser(@Valid @RequestBody Book book){
        Book savedBook = bookService.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedBook
                        .getBookId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{bookId}")
    public Book getBook(@PathVariable Long bookId){
        Book book = bookService.findById(bookId);
        return book;

    }

    @GetMapping("{date1}/{date2}")
    public List getBooksForDateRange(@PathVariable String date1, @PathVariable String date2)
            throws ParseException
            {

                System.out.println(date1 + " date 2 :" + date2);
        return bookService.findBooksByPublishDateBetween(
                new SimpleDateFormat("MM-dd-yyyy").parse(date1),
                new SimpleDateFormat("MM-dd-yyyy").parse(date2));
    }

    @GetMapping("all")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }
}
