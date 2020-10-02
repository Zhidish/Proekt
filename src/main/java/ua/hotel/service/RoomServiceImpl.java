package ua.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hotel.dao.Room;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    Room room;

    @Transactional
    @Override
    public void addRoom(Room room) {

    }

    @Transactional
    @Override
    public List<Room> getRooms() {

         return room.getRooms();
    }
}
