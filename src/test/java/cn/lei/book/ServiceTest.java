package cn.lei.book;

import cn.lei.book.dao.ArticleDao;
import cn.lei.book.dao.UserDao;
import cn.lei.book.pojo.Article;
import cn.lei.book.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName ServiceTest
 * @Description TODO
 * @Author lei
 * @Date 2020/9/18 16:16
 * @Version 1.0
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private ArticleDao articleDao;
    @Test
    void contextLoads() {

        PageHelper.startPage(1, 3);
        List<Article> articles = articleDao.selectAll();
        PageInfo<Article> pageInfo = new PageInfo<Article>(articles);
        System.out.println(pageInfo.getList());

    }
}
