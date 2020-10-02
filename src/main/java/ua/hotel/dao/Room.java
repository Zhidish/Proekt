package ua.hotel.dao;

import java.util.List;

public interface Room {

    public void addRoom(ua.hotel.model.Room room);

    void addRoom(Room room);

    List<Room> getRooms();


}
