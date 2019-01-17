package ru.javabegin.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuthorEntity.class)
public abstract class AuthorEntity_ {

	public static volatile SingularAttribute<AuthorEntity, String> name;
	public static volatile SingularAttribute<AuthorEntity, Long> id;
	public static volatile SingularAttribute<AuthorEntity, String> secondName;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SECOND_NAME = "secondName";

}

