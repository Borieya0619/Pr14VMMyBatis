package org.example.pr14vmmybatis.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//html입력폼 <-> DTO <-> DAO(Entity) <-> XML(Repo클래스) <-> DB

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long productId;
    private String productName;
    private Integer productPrice;
}