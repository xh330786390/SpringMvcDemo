package com.tengxh.component.ealsticsearch;

import com.tengxh.entity.ArticleInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<ArticleInfo, String>, CustomRepository {
    public ArticleInfo findByArticleTitle(String articleTitle);

//    public ArticleInfo findByArticleTitle2(String articleTitle);
}

