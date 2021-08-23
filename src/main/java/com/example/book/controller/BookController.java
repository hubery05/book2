package com.example.book.controller;

//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.entity.Book;
import com.example.book.entity.BookList;
import com.example.book.entity.IdList;
import com.example.book.response.Result;
import com.example.book.service.BookService;
import com.example.book.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
     private BookService bookService;

    @GetMapping("/getall")
    public Result getAll(){
        List<Book> booklist = bookService.getAllBook();
        return Result.ok().data("books", booklist).data("total", 25);
    }
    @PostMapping(value="/findBookById")
    public Book findBookById(@RequestBody Book book) {
        return bookService.findBookById(book.getId());
    }
    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody PageRequest pageQuery) {
        return bookService.findPage(pageQuery);
    }
//    public List<Book> getAll(){
//        return bookService.getAllBook();
//    }

//    @GetMapping("/pagelist")
//    public List<Book> selectPage(@RequestParam(required = true, defaultValue = "1") Integer current,
//                                 @RequestParam(required = true, defaultValue = "6") Integer size){
//        Page<Book> page = new Page<>(current, size);
//    }
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
//    public Result batchDelete(@RequestBody BookList bookList) {
//        System.out.println(bookList.getBookList());
//        for(Book book : bookList.getBookList()) {
//            bookService.delete(book.getId());
//        }
//        return Result.ok();
//    }
    public Result batchDelete(@RequestBody Integer[] idList) {
//        System.out.println(idList);
        bookService.deleteBatch(idList);
        return Result.ok();
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam Integer id) {
        bookService.delete(id);
        return Result.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody Book book) {
        bookService.update(book);
        return Result.ok();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result insert(@RequestBody @Validated Book book) {
        bookService.insertBook(book);
        return Result.ok();
    }
}
