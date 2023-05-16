package com.example.adminusersite.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User {
    private int id;
    private String u_name;
    private String u_pass;
    private String u_type;
}
