package cn.lei.book.service;

import cn.lei.book.pojo.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectAll();
    //分页查询
    PageInfo<Article> selectPage(int pageNum, int pageSize);
}
