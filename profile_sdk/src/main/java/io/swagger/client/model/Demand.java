package io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Demand
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen",
                            date = "2016-07-25T15:10:43.065Z")
public class Demand {

    private String bookName = null;
    private String id = null;

    /**
     * Gets or Sets status
     */
    public enum StatusEnum {
        NEW("NEW"), APPROVED("APPROVED"), DONE("DONE");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private StatusEnum status = null;
    private String userName = null;

    /**
     **/
    public Demand bookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("bookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     **/
    public Demand id(String id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     **/
    public Demand status(StatusEnum status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("status")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     **/
    public Demand userName(String userName) {
        this.userName = userName;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Demand demand = (Demand) o;
        return Objects.equals(this.bookName, demand.bookName) && Objects.equals(this.id, demand.id)
                && Objects.equals(this.status, demand.status) && Objects.equals(this.userName, demand.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, id, status, userName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Demand {\n");

        sb.append("    bookName: ").append(toIndentedString(bookName)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
