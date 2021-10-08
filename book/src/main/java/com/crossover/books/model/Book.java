package com.crossover.books.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Book model class.
 *
 * @author Simon Ghobreil.
 */
@Document(collection = "Book")
public class Book {

    @Id
    private String id;

    @Field("Title")
    private String title;
    @Field("Publisher")
    private String publisher;
    @Field("Description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
