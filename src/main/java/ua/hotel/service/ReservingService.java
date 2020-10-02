package ua.hotel.service;

import ua.hotel.model.Booking;
import ua.hotel.model.Hotel;

import java.util.List;

public interface ReservingService {

    List<Booking> getreservationByUserId(int id);


    void addReservation(Booking booking);


    List<Hotel> getHotelsByCountry(String country);

    List<Booking> getRoomsByDate(String date_to, String date_from);

    List<Booking> getHotelByCountryAnd(String date_to,String date_from,String country);
}
