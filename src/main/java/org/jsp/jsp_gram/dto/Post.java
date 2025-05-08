package org.jsp.jsp_gram.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imageUrl;
	private String caption;
	@UpdateTimestamp
	private LocalDateTime postedTime;
	@ManyToOne
	private User user;
	@Transient
	private MultipartFile image;
	@ManyToMany(fetch = FetchType.EAGER)
	List<User> likedUsers = new ArrayList<User>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Comment> comments = new ArrayList<Comment>();

	public boolean hasLiked(int id) {
		for (User likedUser : likedUsers) {
			if (likedUser.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public LocalDateTime getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(LocalDateTime postedTime) {
		this.postedTime = postedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public List<User> getLikedUsers() {
		return likedUsers;
	}

	public void setLikedUsers(List<User> likedUsers) {
		this.likedUsers = likedUsers;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
