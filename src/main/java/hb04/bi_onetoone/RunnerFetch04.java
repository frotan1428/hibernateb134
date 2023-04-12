package hb04.bi_onetoone;

import hb03.uni_onetoone.Dairy;
import hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Dairy04.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get student and dairy by Id using  get method
//
//        Student04 student1 =  session.get(Student04.class,1001);
//        System.out.println(student1);
//        System.out.println("------------------------");
//        Dairy04 dairy1 =  session.get(Dairy04.class,101);
//        System.out.println(dairy1);

        // continue for here !!!!!
        System.out.println("********** get dairy object over students ****************");

         Dairy04 dairy1 = session.get(Dairy04.class,101);
         System.out.println(dairy1);
         System.out.println(dairy1.getStudent());

        System.out.println("********** get students object over dairy ****************");

        Student04 student1 = session.get(Student04.class,1002);
        System.out.println(student1);
        System.out.println(student1.getDairy());

        System.out.println("********** get students  name  object over dairy object  ****************");

        System.out.println(dairy1.getStudent().getName() + dairy1.getStudent().getGrade());

/*
      An inner join is commonly used to retrieve data from two or more tables based on a common column between them.
     */
        System.out.println("********** INNER JOIN ***************");















        String hql1= "SELECT s.name, d.name FROM  Student04 s INNER JOIN FETCH Dairy04 d ON s.id = d.student.id ";

       List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
       resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));
         /*
        In Hibernate, a left join is a type of SQL join operation that returns all the rows from the left table
        and the matching rows from the right table, based on a specified join condition.





         */

        System.out.println("********** LEFT JOIN ***************");






         String hql2= "SELECT s.name, d.name FROM  Student04 s LEFT JOIN FETCH Dairy04 d ON s.id = d.student.id ";
        List<Object[]> resultList2 =  session.createQuery(hql2).getResultList();
        resultList2.forEach(obj-> System.out.println(Arrays.toString(obj)));






          /*
        In Hibernate, a right join is a type of SQL join operation that returns all the rows from the right table
        and the matching rows from the left table, based on a specified join condition.
         */

        System.out.println("********** Right JOIN ***************");

        String hql3= "SELECT s.name, d.name FROM  Student04 s RIGHT JOIN FETCH Dairy04 d ON s.id = d.student.id ";
        List<Object[]> resultList3 =  session.createQuery(hql3).getResultList();
        resultList3.forEach(obj-> System.out.println(Arrays.toString(obj)));


        /*
         A full join can be used to retrieve all the data from both tables,
        including data that does not have a match in the other table.
         */
        System.out.println("********** FULL JOIN ***************");

        String hql4= "SELECT s.name, d.name FROM  Student04 s RIGHT JOIN FETCH Dairy04 d ON s.id = d.student.id ";
        List<Object[]> resultList4 =  session.createQuery(hql4).getResultList();
        resultList4.forEach(obj-> System.out.println(Arrays.toString(obj)));
































        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
