package com.asiainfo.entity;

/**
 * 文章实体类
 *
 * @author zhiwangzhang
 * @date 2016年11月5日 下午1:47:39
 */
public class Article {
	private String id;
	private String title;
	private String author;
	private String content;
	private String time;
	private String slug;
	private String tags;

	public Article(String id, String title, String author, String content, String time, String slug) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.time = time;
		this.slug = slug;
	}

	public Article(String id, String title, String author, String content, String time, String slug, String tags) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.time = time;
		this.slug = slug;
		this.tags = tags;
	}

	public Article() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", time=" + time + ", slug=" + slug + ", tags=" + tags + "]";
	}

}
