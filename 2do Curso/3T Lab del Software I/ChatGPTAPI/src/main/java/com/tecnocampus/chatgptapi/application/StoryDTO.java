package com.tecnocampus.chatgptapi.application;

public class StoryDTO {

    private String imageURL;
    private String story;

    public StoryDTO() {

    }

    public StoryDTO(String imageURL, String story) {
        this.imageURL = imageURL;
        this.story = story;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getStory() {
        return story;
    }
}
