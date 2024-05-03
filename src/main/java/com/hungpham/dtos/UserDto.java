package com.hungpham.dtos;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto extends baseDto {
    private String userName;
    private String password;
    private String role;
}
