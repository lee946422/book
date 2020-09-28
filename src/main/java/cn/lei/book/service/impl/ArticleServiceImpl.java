package cn.lei.book.service.impl;

import cn.lei.book.dao.ArticleDao;
import cn.lei.book.pojo.Article;
import cn.lei.book.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author lei
 * @Date 2020/9/26 16:56
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;
    @Override
    public int deleteByPrimaryKey(String articleId) {
        return 0;
    }

    @Override
    public int insert(Article record) {
        return 0;
    }

    @Override
    public int insertSelective(Article record) {
        return 0;
    }

    @Override
    public Article selectByPrimaryKey(String articleId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return 0;
    }

    @Override
    public List<Article> selectAll() {
        return null;
    }

    @Override
    public PageInfo<Article> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleDao.selectAll();
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return articlePageInfo;
    }
}
