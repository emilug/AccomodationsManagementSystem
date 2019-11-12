package com.sda.ams.controller;

import com.sda.ams.model.Room;
import com.sda.ams.model.RoomType;
import com.sda.ams.service.RoomService;
import com.sda.ams.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("room", rooms);
        List<RoomType> roomTypeList = roomTypeService.getAllTypes();
        model.addAttribute("roomTypeList", roomTypeList);
        return "room/list";
    }

    @GetMapping("/show/{roomId}")
    public String getById(Model model, @PathVariable Integer roomId, @PathVariable Integer roomTypeId) {
        Optional<Room> roomOptional = roomService.get(roomId);
        if (roomOptional.isPresent()) {
            model.addAttribute("room", roomOptional.get());
            List<RoomType> roomTypeList = roomTypeService.getAllTypes();
            model.addAttribute("roomTypeList", roomTypeList);
            return "room/show";
        } else {
            return "exceptions/404";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        List<RoomType> roomTypeList = roomTypeService.getAllTypes();
        model.addAttribute("roomTypeList", roomTypeList);
        return "room/create";
    }

    @GetMapping("/edit/{roomId}")
    public String edit(Model model, @PathVariable Integer roomId) {
        Optional<Room> roomOptional = roomService.get(roomId);

        if (roomOptional.isPresent()) {
            model.addAttribute("room", roomOptional.get());
            List<RoomType> roomTypeList = roomTypeService.getAllTypes();
            model.addAttribute("roomTypeList", roomTypeList);
            return "room/edit";
        } else {
            return "exceptions/404";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Room room, Model model) {
        room = roomService.save(room);
        model.addAttribute("room", room);
        List<RoomType> roomTypeList = roomTypeService.getAllTypes();
        model.addAttribute("roomTypeList", roomTypeList);

        return "room/show";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Room room, Model model) {
        room = roomService.save(room);
        model.addAttribute("room", room);
        List<RoomType> roomTypeList = roomTypeService.getAllTypes();
        model.addAttribute("roomTypeList", roomTypeList);
        return "room/show";
    }

    @GetMapping("/delete/{roomId}")
    public String delete(@PathVariable Integer roomId) {
        roomService.delete(roomId);
        return "redirect:/room/list";
    }
}
