package ru.javabegin.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile ListAttribute<Author, Book> books;
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, Long> id;
	public static volatile SingularAttribute<Author, String> secondName;

	public static final String BOOKS = "books";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SECOND_NAME = "secondName";

}

