package io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * UserAccount
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen",
                            date = "2016-07-25T15:10:43.065Z")
public class UserAccount {

    private String email = null;
    private Boolean enabled = null;
    private String fullname = null;
    private String id = null;
    private String password = null;

    /**
     * Gets or Sets roles
     */
    public enum RolesEnum {
        USER("USER"), ADMIN("ADMIN");

        private String value;

        RolesEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private RolesEnum roles = null;
    private String status = null;
    private String username = null;

    /**
     **/
    public UserAccount email(String email) {
        this.email = email;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     **/
    public UserAccount enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     **/
    public UserAccount fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     **/
    public UserAccount id(String id) {
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
    public UserAccount password(String password) {
        this.password = password;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     **/
    public UserAccount roles(RolesEnum roles) {
        this.roles = roles;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("roles")
    public RolesEnum getRoles() {
        return roles;
    }

    public void setRoles(RolesEnum roles) {
        this.roles = roles;
    }

    /**
     **/
    public UserAccount status(String status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     **/
    public UserAccount username(String username) {
        this.username = username;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAccount userAccount = (UserAccount) o;
        return Objects.equals(this.email, userAccount.email) && Objects.equals(this.enabled, userAccount.enabled)
                && Objects.equals(this.fullname, userAccount.fullname) && Objects.equals(this.id, userAccount.id)
                && Objects.equals(this.password, userAccount.password) && Objects.equals(this.roles, userAccount.roles)
                && Objects.equals(this.status, userAccount.status)
                && Objects.equals(this.username, userAccount.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, enabled, fullname, id, password, roles, status, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserAccount {\n");

        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
