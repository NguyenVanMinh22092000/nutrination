package com.galaxy.dto.response;

import com.galaxy.entity.Bmi;
import com.galaxy.entity.Order;
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
    private Order order;
    private String password;
    private boolean isStatus = true;

}
