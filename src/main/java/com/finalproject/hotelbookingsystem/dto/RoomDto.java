

package com.finalproject.hotelbookingsystem.dto;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    @NotEmpty(message = "Room Type can not be empty. Enter room Type")
    private String roomType;
    @NotNull
    @Min(value=0,message = "Hotel Id should be positive")
    private int hotelId;
    private String status="vacant";

}
