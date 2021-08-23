package com.example.book.service;

//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.entity.Book;
import com.example.book.mapper.BookMapper;
import com.example.book.util.PageRequest;
import com.example.book.util.PageResult;
import com.example.book.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> getAllBook(){
        return bookMapper.getAllBook();
    }

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
    /**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<Book> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Book> bookLists = bookMapper.selectPage();
        return new PageInfo<Book>(bookLists);
    }

    @Override
    public Integer insertBook(Book book) {
//        book.setCreateTime(new Date());
        return bookMapper.insertBook(book);
    }

    @Override
    public int delete(int id) {
        return bookMapper.delete(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] idList) {
        return bookMapper.deleteBatch(idList);
    }

    @Override
    @Transactional
    public int update(Book book) {
        return bookMapper.update(book);
    }

}

