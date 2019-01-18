package ru.javabegin.training.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    private String name;

    @ManyToOne                // для FOREIGN
    @JoinColumn               // связать поле с конкретным обьектом типа Author
    private Author author;

}
