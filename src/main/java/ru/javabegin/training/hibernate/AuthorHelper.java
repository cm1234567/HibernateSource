package ru.javabegin.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javabegin.training.hibernate.entity.Author;
import ru.javabegin.training.hibernate.entity.Author_;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;


public class AuthorHelper {



    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){

        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        session.get(Author.class, 1L); // получение объекта по id

        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selection = {root.get(Author_.id), root.get(Author_.name)}; // выборка полей, в классе Author должен быть конструктор с этими параметрами

        cq.select(cb.construct(Author.class, selection));// необязательный оператор, если просто нужно получить все значения


        // этап выполнения запроса
        Query query = session.createQuery(cq);

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

    public Author getAuthor(String name){
        return null;
    }


    
}
