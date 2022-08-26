package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class NewsLetter {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "exception_seq_generator")
    @SequenceGenerator(name = "exception_seq_generator", sequenceName = "exception_seq", allocationSize=1)
    private Long id;

    @Column(name = "category_id")
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "NewsLetter_Categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "newsletter_id"))
    private Set<Category> newLetterCategories;

    @Column(name = "title")
    private String title;

    // TODO: User_ID
//    @Column(name = "title")
//    private String title;

    @Column(name = "price")
    private float price;

}
