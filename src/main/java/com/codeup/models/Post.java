package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
/**
 * Created by everardosifuentes on 6/19/17.
 */

@Entity
@Table(name="posts")

public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @OneToOne
    private User owner;





    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {

        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getId() {
        return (int)id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
