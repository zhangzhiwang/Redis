package com.asiainfo.entity;

/**
 * 微博的评论
 *
 * @author zhiwangzhang
 * @date 2016年11月5日 下午2:16:54
 */
public class Comment {
	private String author;
	private String time;
	private String content;
	private String email;

	public Comment(String author, String time, String content, String email) {
		super();
		this.author = author;
		this.time = time;
		this.content = content;
		this.email = email;
	}

	public Comment() {
		super();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", time=" + time + ", content=" + content + ", email=" + email + "]";
	}

}
