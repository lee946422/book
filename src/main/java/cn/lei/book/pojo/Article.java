package cn.lei.book.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class Article implements Serializable {
    /**
     * 博文ID
     */
    private String articleId;

    /**
     * 发表用户ID
     */
    private Long userId;

    /**
     * 博文标题
     */
    private String articleTitle;

    /**
     * 博文内容
     */
    private String articleContent;

    /**
     * 浏览量
     */
    private Long articleViews;

    /**
     * 评论总数
     */
    private Long articleCommentCount;

    /**
     * 发表时间
     */
    private Date articleDate;
    /**
     * 点赞数
     */
    private Long articleLikeCount;
    /**
     * 文章缩略展示
     */
    private String articleAbbreviation;
    private static final long serialVersionUID = 1L;
}