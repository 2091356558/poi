package com.baizhi.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String username;
    private Double salary;
    private Integer age;
    private String department;
    private String user;
    private String book;
    private String name;
    private Date bir;
}

