package ru.javabegin.training.hibernate;

import org.jboss.logging.Logger;

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {

//        new AuthorHelper().getAuthorList();
//        new AuthorHelper().delete();
//        new AuthorHelper().update();
//        new BookHelper().getBookList();

        new AuthorHelper().getAuthor(202);
    }

}
