package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "exception_seq_generator")
    @SequenceGenerator(name = "exception_seq_generator", sequenceName = "exception_seq", allocationSize=1)
    private Long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;
}
