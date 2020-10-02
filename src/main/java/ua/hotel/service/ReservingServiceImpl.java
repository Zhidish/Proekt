package ua.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hotel.dao.Reservation;
import ua.hotel.model.Booking;
import ua.hotel.model.Hotel;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservingServiceImpl implements ReservingService {


    @Autowired
    Reservation reservation;

    @Transactional
    @Override
    public List<Booking> getreservationByUserId(int id) {
        return reservation.getreservationByUserId(id);
    }

    @Transactional
    @Override
    public void addReservation(Booking booking) {
        reservation.addReservation(booking);
    }

    @Transactional
    @Override
    public List<Hotel> getHotelsByCountry(String country) {
    return reservation.getHotelsByCountry(country);

    }

    @Transactional
    @Override
    public List<Booking> getRoomsByDate(String date_to, String date_from) {
     return reservation.getRoomsByDate(date_to,date_from);
    }

    @Override
    public List<Booking> getHotelByCountryAnd(String date_to, String date_from, String country) {
   return reservation.getHotelByCountryAnd(date_to,date_from,country);
    }
}
