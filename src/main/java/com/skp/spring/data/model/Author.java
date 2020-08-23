package com.skp.spring.data.model;




import lombok.*;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "COUNTRY")
    private String country;



}
