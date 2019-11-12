package com.sda.ams.service;

import com.sda.ams.model.Room;
import com.sda.ams.model.RoomType;
import com.sda.ams.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllTypes() {
        return roomTypeRepository.findAll();
    }

    public Optional<RoomType> get(Integer id) {
        return roomTypeRepository.findById(id);
    }

    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void delete(Integer id) {
        Optional<RoomType> optionalRoomType = get(id);
        if (optionalRoomType.isPresent()) {
            roomTypeRepository.delete(optionalRoomType.get());
        }
    }

}