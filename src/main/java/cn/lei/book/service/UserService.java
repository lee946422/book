package cn.lei.book.service;

import cn.lei.book.pojo.User;

public interface UserService {
    User findByName(String name);

}
