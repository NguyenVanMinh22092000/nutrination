package com.galaxy.dto.response;

import com.galaxy.entity.Bmi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDtoResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Bmi bmi;
    private boolean isStatus;

}
