package com.sopromadze.blogapi.payload;

import java.util.List;

import com.sopromadze.blogapi.model.Photo;
import com.sopromadze.blogapi.model.user.User;
import lombok.Data;

@Data
public class PhotoResponse {
	private Long id;
	private String title;
	private String url;
	private String thumbnailUrl;
	private Long albumId;

	public PhotoResponse(Long id, String title, String url, String thumbnailUrl, Long albumId) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		this.albumId = albumId;
	}

	public User getUser() {
		return null; // This method is not applicable for PhotoResponse, as it does not contain a User field.
	}

	public List<Photo> getPhoto() {
		return null; // Photos do not have a list of photos, so returning null
	}

}
