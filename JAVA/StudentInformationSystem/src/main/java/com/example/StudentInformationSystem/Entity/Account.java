package com.example.StudentInformationSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Account_seq")
    @SequenceGenerator(name = "Account_seq",initialValue = 701,allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;

    private String role;

    @OneToOne
    @JoinColumn(name="student_id",referencedColumnName = "sid")
    private Student student;

    @ManyToMany
    @JoinTable(name = "account_authority",
    joinColumns = {@JoinColumn(name="account_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();


}
