package com.tengxh.service;

import com.tengxh.entity.ArticleInfo;

public interface ArticleService {

    public void save(ArticleInfo order);

    public ArticleInfo findOneById(String id);

    public ArticleInfo findOneByArticleTitle(ArticleInfo articleInfo);

    public boolean deleteData(ArticleInfo articleInfo);

//    public ArticleInfo findOneByArticleTitle2(ArticleInfo articleInfo);
}
