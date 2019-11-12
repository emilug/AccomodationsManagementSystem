package com.sda.ams.service;

import java.util.List;
import java.util.Optional;

import com.sda.ams.model.Room;
import com.sda.ams.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> get(Integer id) {
        return roomRepository.findById(id);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void delete(Integer id) {
        Optional<Room> optionalRoom = get(id);
        if (optionalRoom.isPresent()) {
            roomRepository.delete(optionalRoom.get());
        }
    }
}
