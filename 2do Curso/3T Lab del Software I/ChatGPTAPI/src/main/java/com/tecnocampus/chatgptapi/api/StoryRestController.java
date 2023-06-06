package com.tecnocampus.chatgptapi.api;

import com.tecnocampus.chatgptapi.application.StoryController;
import com.tecnocampus.chatgptapi.application.StoryDTO;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StoryRestController {

    private StoryController controller;

    public StoryRestController(StoryController controller) {
        this.controller = controller;
    }

    @PostMapping("/stories")
    public StoryDTO generateStory(@RequestBody String json) {
        JSONObject jsonObject = new JSONObject(json);
        String description = jsonObject.getString("description");
        return controller.generateStory(description);
    }

}
