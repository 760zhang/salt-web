package com.jia.mapper;

import com.jia.pojo.Article;
import com.jia.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    int insert(Article article);
    int deleteByNo(Long no);
    int update(Article article);
    Article selectByNo(Long no);
    List<Article> selectAll(Article article);
}
