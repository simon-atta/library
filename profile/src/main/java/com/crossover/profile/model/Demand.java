package com.crossover.profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Demand model class.
 *
 * @author Simon Ghobreil.
 */
@Document(collection = "Demand")
public class Demand {

    @Id
    private String id;

    private String bookName;

    private DemandStatus status;

    private String userName;

    public Demand() {

    }

    public Demand(String bookName, DemandStatus status, String userName) {
        super();
        this.bookName = bookName;
        this.status = status;
        this.userName = userName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     *        the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the status
     */
    public DemandStatus getStatus() {
        return status;
    }

    /**
     * @param status
     *        the status to set
     */
    public void setStatus(DemandStatus status) {
        this.status = status;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *        the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
