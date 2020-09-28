package cn.lei.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName RourtController
 * @Description TODO
 * @Author lei
 * @Date 2020/9/18 16:03
 * @Version 1.0
 */
@Controller
public class RourtController {
    @RequestMapping({"/","","toIndex"})
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/toComments")
    public String toComments(){
        return "comments";
    }
    @RequestMapping("/toArticle")
    public String toArticle(){
        return "article";
    }
}



