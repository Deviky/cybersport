package com.cybersport.room.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRoomDTO {
    private Long creatorId;
    private Integer minPlayers;
}