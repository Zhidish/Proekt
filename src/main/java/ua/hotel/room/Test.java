package ua.hotel.room;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.hotel.model.Room;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Test {

    List<Room> rooms = new ArrayList<>();

    @GetMapping("/")
    public String view(@RequestParam(value = "name", required = false, defaultValue = "Omnissiah") String str, Model model) {
        model.addAttribute("room", rooms);
        model.addAttribute("msg", str);
        return "index";
    }

    @ResponseBody
    public String Raw() {
        return "Belisarius Cawl";

    }

    @GetMapping("/new_room")
    public String redirect_1() {
        return "new_room";
    }


    @PostMapping("/new_room")
    public String redirect_2(@ModelAttribute Room room, Model model) {
        rooms.add(room);
        model.addAttribute("room",rooms);
        return "room";
    }


}
