package com.straw.nettycore.solrj;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author fengzy
 * @date 3/12/2018
 */
public class Apple implements Serializable {
    @Field
    private String title;
    @Field
    private Long id;

    @Override
    public String toString() {
        return "Apple[" +
                "title='" + title + '\'' +
                ", id=" + id +
                ']';
    }

    public Apple(String title) {
        this.title = title;
        this.id = System.currentTimeMillis();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
