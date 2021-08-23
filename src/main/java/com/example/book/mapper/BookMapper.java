package com.example.book.mapper;

import com.example.book.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {


    List<Book> getAllBook();

    List<Book> selectPage();

    int insertBook(Book book);


    int delete(int id);

    Boolean deleteBatch(Integer[] idList);

    int update(Book book);

    Book findBookById(Integer id);
}

