package com.jaws;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Comments {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
id;
    @Persistent private String postDesc;
    
    @Persistent(defaultFetchGroup = "true")
    private Text commentText;
    
    @Persistent
    private User author;
  
    @Persistent
    private Date postDate;
    
    public String getEntryDate() {
    	
    	return Util.dateDiff(this.postDate,new Date());
	}

	public String getCommentText() {
		String result="";
		if(commentText != null){
			result=commentText.getValue();
		}
		return result;
	}

	public void setCommentText(Text commentText) {
		this.commentText = commentText;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
    @NotPersistent
	private String entryDate;

      public Comments(String postDesc,User author,Date postDate) {
          //   this.postDesc = postDesc;
             this.author = author;
             this.postDate = postDate;
             commentText = new Text(postDesc);
      }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

    
}

