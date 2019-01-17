package ru.javabegin.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javabegin.training.hibernate.entity.Author;
import ru.javabegin.training.hibernate.entity.Author_;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class AuthorHelper {



    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){

        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selection = {root.get(Author_.id), root.get(Author_.name)}; // выборка полей, в классе Author должен быть конструктор с этими параметрами

        ParameterExpression<String> nameParam = cb.parameter(String.class,"name"); // создали параметр

//        cq.select(cb.construct(Author.class, selection));// необязательный оператор, если просто нужно получить все значения
     // параметр будет применяться к полю Author_.name like это не строго равно
        cq.select(cb.construct(Author.class, selection))
                .where(cb.like(root.get(Author_.name), nameParam));



        // этап выполнения запроса
        Query query = session.createQuery(cq);
//        query.setParameter("name","%1%"); // все имена где есть параметр 1
        query.setParameter("name","%имя%"); // все имена где есть параметр 1

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }

    // добавляют нового автора в таблица Author
    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i=1; i<=200; i++){
            Author a = new Author("name"+i);
            a.setSecondName("sec_name"+i);
            if (i % 20==0){
                session.flush();
            }
            session.save(a); // сгенерит ID и вставит в объект
        }

        session.getTransaction().commit();

        session.close();

        return author;

    }

    public void delete(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaDelete<Author> criteriaDelete = cb.createCriteriaDelete(Author.class);

        Root<Author> root = criteriaDelete.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        ParameterExpression<String> nameParam = cb.parameter(String.class,"name"); // создали параметр
        ParameterExpression<String> secondNameParam = cb.parameter(String.class,"secondName"); // создали параметр

        // нет select, сразу where так как мы делаем удаление
        criteriaDelete.where(cb.or(
                cb.and(cb.like(root.get(Author_.name), nameParam),
                        cb.like(root.get(Author_.secondName), secondNameParam)
                ),
                cb.equal(root.get(Author_.name), "sec_name83")
                )
        );

        // этап выполнения запроса
        Query query = session.createQuery(criteriaDelete);
        query.setParameter("name","%2%"); // все имена где есть параметр 1
        query.setParameter("secondName","%t%"); // все имена где есть параметр 1

        query.executeUpdate();

//        session.getTransaction().commit();

        session.close();
    }

    public Author getAuthor(String name){
        return null;
    }


    
}
