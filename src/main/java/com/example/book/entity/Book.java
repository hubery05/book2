package com.example.book.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Book {

    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookPress;
    private Boolean onlyRead;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

//    private Integer page;
//    private Integer state;
//    private Integer age;
//    private String name;
//    private String address;
//    private Integer salary;

//    private Integer id;
//    private Integer sex;
//    private String username;
//    private String email;
//    private String departmentId;

}