package com.example.book.service;

//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.entity.Book;
import com.example.book.util.PageRequest;
import com.example.book.util.PageResult;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book findBookById(Integer id);

//    IPage<Book> selectBookPage(Page<Book> page, Integer state);
    PageResult findPage(PageRequest pageRequest);

    Integer insertBook(Book book);

    int delete(int id);

    Boolean deleteBatch(Integer[] idList);

    int update(Book book);
}
