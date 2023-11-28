package com.db.userdb.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID", nullable = false)
    private Integer id;

    @Column(name = "USR_NAME", nullable = false)
    private String name;

    @Column(name = "USR_AGE", nullable = false)
    private Integer age;

    @Column(name = "USR_EMAIL", unique = true)
    private String email;
}
