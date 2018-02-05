package com.tengxh.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "my_index", type = "article_type")
public  class ArticleInfo implements Serializable {
    @Id
//    @Field(index = FieldIndex.not_analyzed, store = true)
    private String articleId;

    @Field(type = FieldType.String, searchAnalyzer = "ik", analyzer = "ik", store = true)
    private String articleTitle;

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}