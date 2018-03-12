package com.straw.nettycore.solrj;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * http://blog.csdn.net/qq_28988969/article/details/76022082
 * @author fengzy
 * @date 3/12/2018
 */
public class BaseTest {
    private static final String SOLR_URL = "http://localhost:8080/solr/core0";
    private static final String SOLR_URL_MYSQL = "http://localhost:8080/solr/mysql";
    @Test
    public void addDocument() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL);
        SolrInputDocument document = new SolrInputDocument();
        document.addField("title","from java");
        document.addField("id",System.currentTimeMillis());
        UpdateResponse response = solrClient.add( document);
        System.out.println(response.getStatus());
        solrClient.commit();
        solrClient.close();
    }
    @Test
    public void queryIndex() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(0);
        query.setRows(100);
        QueryResponse response = solrClient.query(query);
        System.out.println(response.getStatus());
        SolrDocumentList results = response.getResults();
        soutResult(results);
    }

    private void soutResult(SolrDocumentList results) {
        for (int i=0;i<results.size();i++){
            System.out.println("数据:"+i);
            SolrDocument document = results.get(i);
            for (String name : document.getFieldNames()) {
                System.out.println("   "+name+":"+document.getFieldValue(name));
            }
        }
    }

    @Test
    public void delIndex() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL);
        UpdateResponse updateResponse = solrClient.deleteById("1520843177845");
        System.out.println(updateResponse.getStatus());
        solrClient.commit();
    }
    @Test
    public void addIndexByBean() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL);
        solrClient.addBean(new Apple("红富士"));
        solrClient.commit();
    }
    @Test
    public void deleteByQuery() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL);
        UpdateResponse updateResponse = solrClient.deleteByQuery("title:红");
        System.out.println(updateResponse);
        solrClient.commit();
    }
    @Test
    public void testDocumentObjectBinder(){
        DocumentObjectBinder build = new DocumentObjectBinder();
        SolrInputDocument document = build.toSolrInputDocument(new Apple("tiele"));
        System.out.println(document);
    }
    @Test
    public void query() throws IOException, SolrServerException {
        SolrClient solrClient =new HttpSolrClient(SOLR_URL_MYSQL);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setFilterQueries("categoryName:连衣裙");
        query.setFields("goodsName","categoryName","goodsPrice","id","createDate");
        query.setStart(0);
        query.setRows(100);
        SolrQuery.SortClause sortClause = new SolrQuery.SortClause("createDate", SolrQuery.ORDER.desc);
       // query.set("createDate", String.valueOf(SolrQuery.ORDER.asc));
        query.setSort(SolrQuery.SortClause.asc("goodsPrice"));
        query.setSort(sortClause);

        query.setHighlight(true);
        QueryResponse response = solrClient.query(query);
        soutResult(response.getResults());
    }
}

