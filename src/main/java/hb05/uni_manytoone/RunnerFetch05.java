package hb05.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml");
//                 addAnnotatedClass(Student05.class)
//                .addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //using get method fetch student and university Object

        Student05 student1 =  session.get(Student05.class,1001);
        System.out.println(student1);
        System.out.println(student1.getUniversity());
        System.out.println(student1.getUniversity().getName());
        System.out.println("_____________________________");
        University university =   session.get(University.class,102);
        System.out.println(university);
        // fetch student whose university id is 101 using HQL

        System.out.println("********* Students whose university id is 101 ********************");

          String hqlQuery1 = "FROM Student05 s WHERE s.university.id = 101";
          List<Student05> resultList1 =  session.createQuery(hqlQuery1,Student05.class).getResultList();
          resultList1.forEach(obj-> System.out.println(obj));

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
