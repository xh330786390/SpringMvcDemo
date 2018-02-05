package com.tengxh.entity;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Simple type to test facets
 *
 * @author Artur Konczak
 * @author Mohsin Husen
 */
@Document(indexName = "test-index-articles", type = "article", shards = 1, replicas = 0, refreshInterval = "-1")
public class ArticleEntity {

    @Id
    private String id;
    private String title;
    @Field(type = FieldType.String, store = true)
    private String subject;

    @MultiField(
            mainField = @Field(type = FieldType.String),
            otherFields = {
                    @InnerField(suffix = "untouched", type = FieldType.String, store = true, indexAnalyzer = "ik"),
                    @InnerField(suffix = "sort", type = FieldType.String, store = true, indexAnalyzer = "ik")
            }
    )
    private List<String> authors = new ArrayList();

    @Field(type = FieldType.Integer, store = true)
    private List<Integer> publishedYears = new ArrayList();

    private int score;

    public ArticleEntity() {

    }

    public ArticleEntity(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<Integer> getPublishedYears() {
        return publishedYears;
    }

    public void setPublishedYears(List<Integer> publishedYears) {
        this.publishedYears = publishedYears;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
