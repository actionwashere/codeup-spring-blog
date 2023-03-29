package com.codeup.codeupspringblog.models.posts;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.*;



@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 500, nullable = false, columnDefinition = "MEDIUMTEXT")
    private String body;
    @OneToOne
    private User owner;

    public Post () {

    }

    public Post (String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
