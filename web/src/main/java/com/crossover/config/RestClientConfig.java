package com.crossover.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Rest Client Config.
 *
 * @author Simon Ghobreil.
 */
@Component
@PropertySource("classpath:configuration/rest_client_conf.properties")
public class RestClientConfig {

    @Value("${profile.server.url}")
    private String profileBaseUrl;

    @Value("${profile.server.username}")
    private String profileUserName;

    @Value("${profile.server.password}")
    private String profilePassword;

    @Value("${books.server.url}")
    private String booksBaseUrl;

    @Value("${books.server.username}")
    private String booksUserName;

    @Value("${books.server.password}")
    private String booksPassword;

    /**
     * @return the booksBaseUrl
     */
    public String getBooksBaseUrl() {
        return booksBaseUrl;
    }

    /**
     * @param booksBaseUrl
     *        the booksBaseUrl to set
     */
    public void setBooksBaseUrl(String booksBaseUrl) {
        this.booksBaseUrl = booksBaseUrl;
    }

    /**
     * @return the booksUserName
     */
    public String getBooksUserName() {
        return booksUserName;
    }

    /**
     * @param booksUserName
     *        the booksUserName to set
     */
    public void setBooksUserName(String booksUserName) {
        this.booksUserName = booksUserName;
    }

    /**
     * @return the booksPassword
     */
    public String getBooksPassword() {
        return booksPassword;
    }

    /**
     * @param booksPassword
     *        the booksPassword to set
     */
    public void setBooksPassword(String booksPassword) {
        this.booksPassword = booksPassword;
    }

    /**
     * @return the profileBaseUrl
     */
    public String getProfileBaseUrl() {
        return profileBaseUrl;
    }

    /**
     * @param profileBaseUrl
     *        the profileBaseUrl to set
     */
    public void setProfileBaseUrl(String profileBaseUrl) {
        this.profileBaseUrl = profileBaseUrl;
    }

    /**
     * @return the profileUserName
     */
    public String getProfileUserName() {
        return profileUserName;
    }

    /**
     * @param profileUserName
     *        the profileUserName to set
     */
    public void setProfileUserName(String profileUserName) {
        this.profileUserName = profileUserName;
    }

    /**
     * @return the profilePassword
     */
    public String getProfilePassword() {
        return profilePassword;
    }

    /**
     * @param profilePassword
     *        the profilePassword to set
     */
    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

}
