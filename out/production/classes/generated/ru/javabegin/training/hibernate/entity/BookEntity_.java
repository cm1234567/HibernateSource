package ru.javabegin.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookEntity.class)
public abstract class BookEntity_ {

	public static volatile SingularAttribute<BookEntity, String> name;
	public static volatile SingularAttribute<BookEntity, Long> id;
	public static volatile SingularAttribute<BookEntity, Long> authorId;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AUTHOR_ID = "authorId";

}

