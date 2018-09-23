package cn.study.entity;

import lombok.*;

import javax.persistence.*;
@ToString

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="status")
    private int status;
}