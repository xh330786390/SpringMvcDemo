package com.tengxh.service.impl;

import com.tengxh.component.ealsticsearch.ArticleRepository;
import com.tengxh.entity.ArticleInfo;
import com.tengxh.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void save(ArticleInfo articleInfo) {
        articleRepository.save(articleInfo);
    }

    public ArticleInfo findOneById(String id) {
        return articleRepository.findOne(id);
    }

    public ArticleInfo findOneByArticleTitle(ArticleInfo articleInfo) {
        return articleRepository.findByArticleTitle(articleInfo.getArticleTitle());
    }

    public boolean deleteData(ArticleInfo articleInfo) {
        articleRepository.delete(articleInfo.getArticleId());
        return true;
    }

//    public ArticleInfo findOneByArticleTitle2(ArticleInfo articleInfo)
//    {
//        return articleRepository.findByArticleTitle2(articleInfo.getArticleTitle());
//    }
}
