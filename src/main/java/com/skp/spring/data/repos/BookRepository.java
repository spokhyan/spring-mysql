package com.skp.spring.data.repos;

import com.skp.spring.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByPublishDateAfter(Date date);

    public List<Book> findByPublishDateBefore(Date date);

    public List<Book> findByPublishDateBetween(Date date1, Date date2);
    /*
        For named query, comment out @Query from below methods
     */
    //@Query methods

    @Query("select b from Book b")
    public List<Book> getOne();

    @Query("select b from Book b where b.pageCount > ?1")
    public List<Book> queryTwo(int pageCount);

    @Query("select b from Book b where b.title = :title")
    public List<Book> queryThree(@Param("title") String title);



}
