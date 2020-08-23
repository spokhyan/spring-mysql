package com.skp.spring.data.service;

import com.skp.spring.data.model.Book;
import com.skp.spring.data.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Book findById(Long bookId){
        System.out.println("bookId :: " +bookId);
        Book book = bookRepository.getOne(bookId);
        if(book!= null) return book;
        return new Book();
    }

    public List<Book> findBooksByPublishDateBetween(Date date1, Date date2 ){
        List<Book> books = bookRepository.findByPublishDateBetween(date1, date2);
        return books;
    }


    public List<Book> getAll() {
        return bookRepository.getOne();
    }
}
