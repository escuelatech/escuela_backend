package com.escuela.api.db.models;

import javax.persistence.*;

@Entity
@Table(name="video_details")
public class VideoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="video_id")
    int id;

    @Column(name="link")
    String link;

    @Column(name="watch")
    String watch;

    @Column(name="image")
    String image;

    @Column(name="title")
    String title;

    @Column(name="description")
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

