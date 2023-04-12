package hb05.uni_manytoone;

import hb04.bi_onetoone.Dairy04;
import hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {

        // create student object

        Student05 student1 =  new Student05();
        student1.setId(1001);
        student1.setName("burak");
        student1.setGrade(90);

        Student05 student2 =  new Student05();
        student2.setId(1002);
        student2.setName("Cem");
        student2.setGrade(90);

        Student05 student3 =  new Student05();
        student3.setId(1003);
        student3.setName("malike");
        student3.setGrade(95);

        Student05 student4 =  new Student05();
        student4.setId(1004);
        student4.setName("Fatih");
        student4.setGrade(100);

        // create university object

        University university = new University();
        university.setId(101);
        university.setName("TechproEdu University ");

        // set university for student object

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);
        student4.setUniversity(university);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml");
//                 addAnnotatedClass(Student05.class)
//                .addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // save university object
        session.save(university);
        // save student object
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();

    }
}
