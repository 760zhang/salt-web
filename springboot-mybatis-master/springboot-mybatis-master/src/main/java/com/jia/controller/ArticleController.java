package com.jia.controller;

import com.jia.mapper.ArticleMapper;
import com.jia.mapper.UserMapper;
import com.jia.pojo.Article;
import com.jia.pojo.User;
import com.jia.uils.ToHtmlTableConverter;
import com.jia.vo.ReponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleMapper articleMapper;


    //查询所有
    @GetMapping("article/query")
    @ResponseBody
    public ReponseBody query(@RequestParam(required = false)  String fn){
        Article article  = new Article();
        article.setTI(fn);
        System.out.println("正在搜索");
        List<Article> articles = articleMapper.selectAll(article);


        ReponseBody responseBody = new ReponseBody();
        responseBody.setCode(200);
        responseBody.setData(ToHtmlTableConverter.convertToHtmlTable(articles));
        return  responseBody;

    }
}
