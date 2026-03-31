package ie.atu.kebabreviewplatform.model;

import jakarta.persistence.*;

@Entity
public class KebabReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String restaurant;
    private String comment;
    private int rating;

    public KebabReview() {}

    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRestaurant() { return restaurant; }
    public void setRestaurant(String restaurant) { this.restaurant = restaurant; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}