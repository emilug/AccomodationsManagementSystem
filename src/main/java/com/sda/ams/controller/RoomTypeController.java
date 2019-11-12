package com.sda.ams.controller;

import com.sda.ams.model.RoomType;
import com.sda.ams.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/list")
    public String getAll(Model model) {
        List<RoomType> roomTypes = roomTypeService.getAllTypes();
        model.addAttribute("roomType", roomTypes);
        return "roomType/list";
    }

    @GetMapping("/show/{roomTypeId}")
    public String getById(Model model, @PathVariable Integer roomTypeId) {
        Optional<RoomType> roomTypeOptional = roomTypeService.get(roomTypeId);
        if (roomTypeOptional.isPresent()) {
            model.addAttribute("roomType", roomTypeOptional.get());
            return "roomType/show";
        } else {
            return "exceptions/404";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("roomType", new RoomType());
        return "roomType/create";
    }

    @GetMapping("/edit/{roomTypeId}")
    public String edit(Model model, @PathVariable Integer roomTypeId) {
        Optional<RoomType> roomTypeOptional = roomTypeService.get(roomTypeId);
        if (roomTypeOptional.isPresent()) {
            model.addAttribute("roomType", roomTypeOptional.get());
            return "roomType/edit";
        } else {
            return "exceptions/404";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RoomType roomType, Model model) {
        roomType = roomTypeService.save(roomType);
        model.addAttribute("room", roomType);
        return "roomType/show";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute RoomType roomType, Model model) {
        roomType = roomTypeService.save(roomType);
        model.addAttribute("roomType", roomType);
        return "roomType/show";
    }

    @DeleteMapping("/delete/{roomTypeId}")
    public String delete(@PathVariable Integer roomTypeId) {
        roomTypeService.delete(roomTypeId);
        return "redirect:/roomType/list";
    }
}
