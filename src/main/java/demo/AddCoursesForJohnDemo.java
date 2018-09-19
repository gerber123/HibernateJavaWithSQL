package demo;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForJohnDemo
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{



            session.beginTransaction();

            Student studentJohn = (Student) session.createQuery("from Student where firstName = 'John'").getSingleResult();
            System.out.println(studentJohn);
            System.out.println(studentJohn.getCourses());
            Course course1 = new Course("Unity - Game Development for begginers");
            Course course2 = new Course("Playing baseball on Pegasus");

            course1.addStudent(studentJohn);
            course2.addStudent(studentJohn);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
