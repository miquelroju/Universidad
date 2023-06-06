package com.tecnocampus.chatgptapi.application;


import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class StoryController {

    private final ChatgptService chatgptService;

    public StoryController(ChatgptService chatgptService) {
        this.chatgptService = chatgptService;
    }

    public StoryDTO generateStory(String description) {
        String imageURL = generateImage(description);
        String storyText = generateStoryText(description);
        return new StoryDTO(imageURL, storyText);
    }

    private String generateStoryText(String description) {
        List<MultiChatMessage> messageList = Arrays.asList(
                new MultiChatMessage("system", "Act like you are an storyteller and never leave that role"),
                new MultiChatMessage("user", "Write me an story of 50 words maxim."),
                new MultiChatMessage("user", "The story has to be inspiring and funny. Remember to include one joke"),
                new MultiChatMessage("user", "Has to be based on this concept:"),
                new MultiChatMessage("user", description));
        return chatgptService.multiChat(messageList);

    }

    private String generateImage(String description) {
        return chatgptService.imageGenerate(description);
    }
}
