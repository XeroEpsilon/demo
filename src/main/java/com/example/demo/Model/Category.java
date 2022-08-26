package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Category {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "exception_seq_generator")
    @SequenceGenerator(name = "exception_seq_generator", sequenceName = "exception_seq", allocationSize=1)
    private Long id;

    @Column(name = "category_name", unique=true)
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "newLetterCategories")
    private Set<NewsLetter> newsLetters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
