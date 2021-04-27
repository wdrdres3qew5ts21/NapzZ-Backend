package com.napzz.entity.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Review {

    @Id
    @JsonProperty("reviewId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private double rating;

    private String name;

    @Column(length = 1000)
    private String comment;

    public Review() {
    }

    public Review( double rating, String name, String comment) {
        this.rating = rating;
        this.name = name;
        this.comment = comment;
    }

    public Review(int reviewId, double rating, String name, String comment) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.name = name;
        this.comment = comment;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review [comment=" + comment + ", name=" + name + ", rating=" + rating + ", reviewId=" + reviewId + "]";
    }
}
