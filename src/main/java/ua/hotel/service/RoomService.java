package ua.hotel.service;

import ua.hotel.dao.Room;

import java.util.List;

public interface RoomService {



    void addRoom(Room room);

    List<Room> getRooms();

}
