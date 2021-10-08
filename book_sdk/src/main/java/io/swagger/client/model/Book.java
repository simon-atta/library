package io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Book
 */
public class Book {

	private String description = null;
	private String publisher = null;
	private String title = null;

	/**
	 **/
	public Book description(String description) {
		this.description = description;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 **/
	public Book publisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 **/
	public Book title(String title) {
		this.title = title;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return Objects.equals(this.description, book.description) && Objects.equals(this.publisher, book.publisher)
				&& Objects.equals(this.title, book.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, publisher, title);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Book {\n");

		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
