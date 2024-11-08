package com.cybersport.Player_Service.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTOResponse {
    private Long id;
    private String nickname;
    private Integer elo;
}
