package ua.hotel.service;

import ua.hotel.dao.Hotel;

import java.util.List;

public interface HotelService {



    List<Hotel> getHotells();



    void addHotel(Hotel hotel );


}
