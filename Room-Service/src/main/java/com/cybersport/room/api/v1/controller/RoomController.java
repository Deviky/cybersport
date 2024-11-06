package com.cybersport.room.api.v1.controller;

import com.cybersport.room.api.v1.dto.CreateRoomDTO;
import com.cybersport.room.api.v1.dto.RoomDTO;
import com.cybersport.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestBody CreateRoomDTO request) {
        int minPlayers = request.getMinPlayers();
        if (minPlayers < 2 || minPlayers > 6 || minPlayers%2!=0)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Bad players count");

        String response = roomService.createRoom(request.getCreatorId(), request.getMinPlayers());
        if (response.startsWith("ERROR"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        else
            return ResponseEntity.ok(response);
    }
    @GetMapping("/getAllRoomsNow")
    public ResponseEntity<List<RoomDTO>> getAllRoomNow(){
        return ResponseEntity.ok(roomService.getAvailableRooms());
    }

    @PostMapping("/joinToRoom/{roomId}")
    public ResponseEntity<String> joinToRoom(@RequestBody Long playerId, @PathVariable Long roomId){
        String response = roomService.joinToRoom(playerId, roomId);
        if (response.startsWith("ERROR"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        else
            return ResponseEntity.ok(response);
    }

    @DeleteMapping("/leaveFromRoom/{roomId}")
    public ResponseEntity<String> leaveFromRoom(@RequestBody Long playerId, @PathVariable Long roomId){
        String response = roomService.leaveFromRoom(playerId, roomId);
        if (response.startsWith("ERROR"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        else
            return ResponseEntity.ok(response);
    }


    @PostMapping("/startGame/{roomId}")
    public ResponseEntity<String> startGame(@RequestBody Long playerId, @PathVariable Long roomId){
        String response = roomService.startGame(playerId, roomId);
        if (response.startsWith("ERROR"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        else
            return ResponseEntity.ok(response);
    }

    @PostMapping("/acceptGame/{roomId}")
    public ResponseEntity<String> acceptGame(@RequestBody Long playerId, @PathVariable Long roomId){
        String response = roomService.acceptGame(playerId, roomId);
        if (response.startsWith("ERROR"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        else
            return ResponseEntity.ok(response);
    }

}
