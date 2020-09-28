package cn.lei.book.controller;

import cn.lei.book.pojo.Article;
import cn.lei.book.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author lei
 * @Date 2020/9/26 16:58
 * @Version 1.0
 */
@RequestMapping("/article")
@ResponseBody
@Controller
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/selectArticles")
    public PageInfo<Article> selectArticles(@RequestBody Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        System.out.println(pageNum + "____" + pageSize);
        return articleService.selectPage(pageNum, pageSize);
    }
}
