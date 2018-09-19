package demo;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo
{
    public static void main(String args[])
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{

//            Instructor instructor = new Instructor("Susan","Public","susan.public@luv2code.com");
//            InstructorDetail instructorDetail = new InstructorDetail("youtube.pl/gamerPL","gamer");

             int TheId=1;
//            instructor.add(course);


            session.beginTransaction();

//            Course course1=new Course("Kurs grania w gry");
//            Course course2=new Course("Kurs grania w skłosza");
            Instructor instructor=session.get(Instructor.class,1);
            Course course1= session.get(Course.class,12);
            Course course2 = session.get(Course.class,13);
//            instructor.add(course1);
//            instructor.add(course2);

              instructor.add(course1);
              instructor.add(course2);
//            session.save(course1);
//            session.save(course2);

            session.getTransaction().commit();


        }
        finally
        {
            factory.close();
        }
    }

}
