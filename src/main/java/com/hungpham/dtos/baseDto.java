package com.hungpham.dtos;

import lombok.*;


import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class baseDto {
    private String id;
    private Date createdDate;
    private Date updatedDate;
}
