package ua.hotel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.hotel.model.Booking;
import ua.hotel.model.Hotel;
import ua.hotel.model.Roles;
import ua.hotel.model.User;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ReservationImpl implements Reservation {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Booking> getreservationByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();

        List users =
                session.createNativeQuery(" SELECT * FROM booking_dates where user_id=:user_id").
                        addEntity(Booking.class).
                        setParameter("user_id", id).getResultList();

        return users;
    }

    @Override
    public void addReservation(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.save(booking);

    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        Session session = sessionFactory.getCurrentSession();

        List hotels =
                session.createNativeQuery(" SELECT * FROM hotel where country=:country").
                        addEntity(Hotel.class).
                        setParameter("country", country).getResultList();

        return hotels;

    }

    @Override
    public List<Booking> getRoomsByDate(String date_from, String date_to) {
        Session session = sessionFactory.getCurrentSession();
        List roomsByDate = session.createNativeQuery("SELECT * FROM booking_dates WHERE !(date_to <:date_from and date_from>:date_to)").
                addEntity(Booking.class).
                setParameter("date_from", date_from).
                setParameter("date_to", date_to).getResultList();

        return roomsByDate;
    }

    @Override
    public List<Booking> getHotelByCountryAnd(String date_from, String date_to, String country) {
        Session session = sessionFactory.getCurrentSession();
        List<Booking> roomsByDate =  (List<Booking>) session.createNativeQuery("SELECT  *  FROM booking_dates inner \n" +
                "    join \n" +
                "    hotel on hotel.country =:country WHERE !(date_to <:date_from and date_from>:date_to)").
                addEntity(Booking.class).
                setParameter("date_from", date_from).
                setParameter("date_to", date_to).
                setParameter("country", country).
                getResultList();

        return roomsByDate;
    }


}
