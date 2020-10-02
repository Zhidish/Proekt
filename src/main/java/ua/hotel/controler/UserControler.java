package ua.hotel.controler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.web.bind.annotation.*;
import ua.hotel.dao.ReservationImpl;
import ua.hotel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ua.hotel.service.*;

import javax.persistence.Query;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserControler {


    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserService userService;


    @Autowired
    HotelService hotelService;

    @Autowired
    ReservingService reservingService;


    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }


    @GetMapping("/registry")
    public String registry_0(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping("/show_users")
    public String show_user() {

        return "show_user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "log_in";
    }


    @GetMapping("/Manager")
    public String admin(Model model) {
        model.addAttribute("users", userService.getUsers());

        return "showAll";
    }

    @GetMapping("Manager/add_room")
    public String add_room() {


        return "add_room";
    }

    @Transactional
    @PostMapping("Manager/add_room")
    public String add_room_(@RequestParam(name = "room_number")
                                    int room_number,
                            @RequestParam(name = "type_room") int type_room,
                            @RequestParam(name = "id_hotel") int id_hotel) {

        Session session = sessionFactory.getCurrentSession();

        Room room = new Room();
        room.setRoom_number(room_number);
        room.setRoom_type(type_room);
        session.save(room);


        HotelsAndRooms hotelsAndRooms = new HotelsAndRooms();
        hotelsAndRooms.setId_hotel(id_hotel);
        hotelsAndRooms.setId_room(room.getId_room());
        session.save(hotelsAndRooms);
        return "add_room";
    }

    @GetMapping("Manager/add_hotel")
    public String add_hotel() {


        return "add_hotel";
    }

    @Transactional

    @PostMapping("Manager/add_hotel")
    public String add_hotel_(@ModelAttribute("hotel") Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);

        return "add_hotel";
    }


    @GetMapping("/search")
    public String search_hotel() {


        return "search_hotel";
    }

    @Transactional
    @PostMapping("/search")
    public String search_hotel_(@RequestParam(name = "country") String country,
                                @RequestParam(name = "date_from") String date_to,
                                @RequestParam(name = "date_to") String date_from, Model model
    ) {

        Set<Booking> booking = new HashSet<>(reservingService.getHotelByCountryAnd(date_to, date_from, country));


        model.addAttribute("set", booking);
        model.addAttribute("room", roomService.getRooms());
        model.addAttribute("date_from", Date.valueOf(date_from));
        model.addAttribute("date_to", Date.valueOf(date_to));
        model.addAttribute("UserService", userService);
        return "show_search";
    }


    @Transactional
    @PostMapping("/add_booking")
    public String bookings(
            @RequestParam(name = "room_id") int id,
            @RequestParam(name = "date_from") String date_from,
            @RequestParam(name = "date_to") String date_to, Model model
            , @RequestParam(name = "user_name") String str) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = new Booking();
        booking.setDate_from(Date.valueOf(date_from));
        booking.setDate_to(Date.valueOf(date_to));
        booking.setRoom_id(id);
        booking.setUser_id(userService.findUser(str).getId());
        session.save(booking);
        return "welcome";
    }
}
