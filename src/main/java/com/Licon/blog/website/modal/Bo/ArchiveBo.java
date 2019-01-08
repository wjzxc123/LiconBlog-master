package com.Licon.blog.website.modal.Bo;


import com.Licon.blog.website.modal.Vo.ContentVo;

import java.io.Serializable;
import java.util.List;

public class ArchiveBo implements Serializable {

       /**  
	    * @Fields field:field:{todo}
	    */  
	private static final long serialVersionUID = 5038677577088641879L;
	private String date;
    private String count;
    private List<ContentVo> articles;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ContentVo> getArticles() {
        return articles;
    }

    public void setArticles(List<ContentVo> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Archive [" +
                "date='" + date + '\'' +
                ", count='" + count + '\'' +
                ", articles=" + articles +
                ']';
    }
}
