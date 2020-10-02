package ua.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hotel.dao.Hotel;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    Hotel hotel;
    @Transactional
    @Override
    public List<Hotel> getHotells() {

        return null;
    }


@Transactional
    @Override
    public void addHotel(Hotel hotel) {
        hotel.addHotel(hotel);
    }
}
