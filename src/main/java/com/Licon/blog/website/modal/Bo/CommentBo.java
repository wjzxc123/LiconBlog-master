package com.Licon.blog.website.modal.Bo;


import com.Licon.blog.website.modal.Vo.CommentVo;

import java.util.List;


  /**  返回页面的评论，包含父子评论内容
    * @ClassName: CommentBo  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月5日  
    *    
    */      
public class CommentBo extends CommentVo {

       /**  
	    * @Fields field:field:{todo}
	    */  
	private static final long serialVersionUID = -8104625723819024852L;
	private int levels;
    private List<CommentVo> children;

    public CommentBo(CommentVo comments) {
        setAuthor(comments.getAuthor());
        setMail(comments.getMail());
        setCoid(comments.getCoid());
        setAuthorId(comments.getAuthorId());
        setUrl(comments.getUrl());
        setCreated(comments.getCreated());
        setAgent(comments.getAgent());
        setIp(comments.getIp());
        setContent(comments.getContent());
        setOwnerId(comments.getOwnerId());
        setCid(comments.getCid());
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public List<CommentVo> getChildren() {
        return children;
    }

    public void setChildren(List<CommentVo> children) {
        this.children = children;
    }
}
