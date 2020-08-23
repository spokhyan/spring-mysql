package com.skp.spring.data.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor @ToString
@Entity
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    @Column(name = "PAGE_COUNT")
    private int pageCount;

    @Column(name="PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;





}
