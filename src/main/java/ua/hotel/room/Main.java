package ua.hotel.room;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import ua.hotel.model.*;

import org.hibernate.annotations.*;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
/*        System.out.println(" turn on");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appplicationContext.xml");

        Object obj = context.getBean("testBean", Room.class);
Object obj_1 = context.getBean("sessionFactory", SessionFactory.class);





        context.close();*/

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(User.class);

/*

      User user= (User) session.createNativeQuery(" SELECT * from User where username = :username and password = :password").
                addEntity(User.class).
                setParameter("username","Vova").
              setParameter("password","bateman").uniqueResult();
*/


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        User user = (User) session.createNativeQuery(" SELECT * from User where username = :username and password = :password").
                addEntity(User.class).
                setParameter("username", "Vova").
                setParameter("password", "bateman").uniqueResult();


        List hotels =
                session.createNativeQuery(" SELECT * FROM hotel where country=:country").
                        addEntity(Hotel.class).
                        setParameter("country", "Ukrain").getResultList();

        for (Object type_vc : hotels) {

            System.out.println(type_vc.toString());

        }

        List<Room> vova_room = user.getRooms();


        for (Room room : vova_room) {
            for (Hotel hotel : room.getHotel()) {
                System.out.println(hotel.getCountry());
            }

        }
String date_from="2020-10-05";
        String date_to="2020-10-05";

        List<Booking> roomsByDate =  (List<Booking>) session.createNativeQuery("SELECT  *  FROM booking_dates inner \n" +
                "    join \n" +
                "    hotel on hotel.country =:country WHERE !(date_to <:date_from and date_from>:date_to)").
                addEntity(Booking.class).
                setParameter("date_from", date_from).
                setParameter("date_to", date_to).
                setParameter("country", "Ukrain").
                getResultList();
        Set<Booking> set  =new HashSet<>(roomsByDate);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Hotel> cq = cb.createQuery(Hotel.class);
        Root<Hotel> root = cq.from(Hotel.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Hotel> rooms = query.getResultList();


        for (Hotel obj : rooms) {
            System.out.println(obj.toString());
            for (Room param_1 : obj.getRooms()) {
                System.out.println(param_1.toString());

            }

        }


        Transaction tr = session.beginTransaction();

        tr.commit();
    }
}
/*
 * @Cpmpoment  добавляє склас в пакет класів спрінга
 *
 *
 * */