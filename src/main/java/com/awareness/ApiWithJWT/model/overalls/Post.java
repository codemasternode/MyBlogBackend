package com.awareness.ApiWithJWT.model.overalls;



import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@MappedSuperclass
public abstract class Post extends DateAudit implements Serializable{

    @NotBlank
    @Size(min = 4,max = 50)
    private String title;

    private String imageUrl;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String overview;

    @NotBlank
    @Lob
    private String content;

    public Post() {
    }

    public Post(String title, String imageUrl, String overview,String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.overview = overview;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
