package cn.lei.book;

import cn.lei.book.dao.UserDao;
import cn.lei.book.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        User user = userDao.selectByPrimaryKey(1L);
        System.out.println(user);

    }

}
