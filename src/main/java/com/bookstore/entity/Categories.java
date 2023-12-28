package com.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public enum Categories {
	
	Adventure("Adventure"),
	Romance("Romance"),
	Self_Improvement("Self Improvement"),
	Comics("Comics"),
	Mystery("Mystery"),
	Horror("Horror"),
	Fantasy("Fantasy"),
	BioGraphy("Biography"),
	Sci_Fi("Science Fiction"),
	ShortStories("Short Story");
	
	private String displayName;
	
	Categories(String displayName) {
		this.displayName = displayName;
	}
	
	public String displayName() { return displayName; }
	
	public static List<String> getDisplayNames() {
		List<String> categories = new ArrayList<>();
		for (Categories c : Categories.values()) {
			categories.add(c.displayName());
		}
		return categories;
	}

}
