import com.tengxh.entity.ArticleEntity;
import com.tengxh.entity.ArticleInfo;
import com.tengxh.service.ArticleService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.terms;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class AppTest {
    private String indexName = "my_index";
    private String typeName = "article_type";
    public static final String RIZWAN_IDREES = "Rizwan Idrees";
    public static final String MOHSIN_HUSEN = "Mohsin Husen";
    public static final String JONATHAN_YAN = "Jonathan Yan";
    public static final String ARTUR_KONCZAK = "Artur Konczak";
    public static final int YEAR_2002 = 2002;
    public static final int YEAR_2001 = 2001;
    public static final int YEAR_2000 = 2000;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void selectUser() {
    }


    @Test
    public void printfTest() {

        String[] arrays = new String[3];
        arrays[0] = "0";
        arrays[1] = "1";
        arrays[2] = "2";

        List<String> lt = Arrays.asList(arrays);
        for (String str : lt) {
            System.out.println(str);
        }

        List<String> list = Arrays.asList("a", "b", "c", "d");
        for (String str : list) {
            System.out.println(str);
        }
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("a")) {
                iter.remove();
            }
        }

        for (String str : list) {
            System.out.println(str);
        }

        List<String> lt1 = new ArrayList<String>();


        String str = null;
        if (null != str && !"".equals(str)) {
            System.out.println("not is null");

        } else {
            System.out.println("is null");
        }
    }

    @Test
    public void saveEsData() {


        IndexQuery indexQuery = new IndexQuery();
        Long id = 100000000L;
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleId("003");
        articleInfo.setArticleTitle("title003");

//        indexQuery.setId("004");
//        indexQuery.setIndexName("my_index");
//        indexQuery.setType("article_type");
//        indexQuery.setObject(articleInfo);
//        elasticsearchTemplate.index(indexQuery);
        articleService.save(articleInfo);

        shouldReturnAggregatedResponseForGivenSearchQuery();
    }

    @Test
    public void findOneById() {
        ArticleInfo articleInfo = articleService.findOneById("002");
        System.out.println(articleInfo.getArticleId() + " " + articleInfo.getArticleTitle());
    }

    @Test
    public void findOneByArticleTitle() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleId("003");
        articleInfo.setArticleTitle("title003");
        ArticleInfo articleInfo1 = articleService.findOneByArticleTitle(articleInfo);
        System.out.println(articleInfo1.getArticleId() + " " + articleInfo1.getArticleTitle());
    }

    /*
     * 没有articTitle2属性，所有无法查找
     */
    @Test
    public void findOneByArticleTitle2() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleId("001");
        articleInfo.setArticleTitle("title001");
//        ArticleInfo articleInfo1 = articleService.findOneByArticleTitle2(articleInfo);
//        System.out.println(articleInfo1.getArticleId() + " " + articleInfo1.getArticleTitle());
    }

    @Test
    public void deleteData() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleId("001");
        articleInfo.setArticleTitle("title001");
        articleService.deleteData(articleInfo);
    }

    @Test
    public void shouldReturnAggregatedResponseForGivenSearchQuery() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withSearchType(SearchType.COUNT)
                .withIndices(indexName).withTypes(typeName)
                .addAggregation(terms("titleAgg").field("articTitle"))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse response) {
                return response.getAggregations();
            }
        });

        Map<String, Aggregation> aggMap = aggregations.asMap();
        StringTerms titleTerms = (StringTerms) aggMap.get("titleAgg");

    }

    @Test
    public void testAggregation() {
//        SearchRequestBuilder srb = NesUtils.getSearcher("school");
//        srb.setTypes("student");
//        srb.setSearchType(SearchType.COUNT);
//
//        TermsBuilder gradeTermsBuilder = AggregationBuilders.terms("gradeAgg").field("grade");
//        TermsBuilder classTermsBuilder = AggregationBuilders.terms("classAgg").field("class");
//
//        gradeTermsBuilder.subAggregation(classTermsBuilder);
//
//        srb.addAggregation(gradeTermsBuilder);
//
//        SearchResponse sr = srb.execute().actionGet();
//
//        Map<String, Aggregation> aggMap = sr.getAggregations().asMap();
//
//        StringTerms gradeTerms = (StringTerms) aggMap.get("gradeAgg");
//
//        Iterator<Bucket> gradeBucketIt = gradeTerms.getBuckets().iterator();
//
//        while (gradeBucketIt.hasNext()) {
//            Bucket gradeBucket = gradeBucketIt.next();
//            System.out.println(gradeBucket.getKey() + "年级有" + gradeBucket.getDocCount() + "个学生。");
//
//            StringTerms classTerms = (StringTerms) gradeBucket.getAggregations().asMap().get("classAgg");
//            Iterator<Bucket> classBucketIt = classTerms.getBuckets().iterator();
//
//            while (classBucketIt.hasNext()) {
//                Bucket classBucket = classBucketIt.next();
//                System.out.println(gradeBucket.getKey() + "年级" + classBucket.getKey() + "班有" + classBucket.getDocCount() + "个学生。");
//            }
//            System.out.println();
//        }

    }

}





