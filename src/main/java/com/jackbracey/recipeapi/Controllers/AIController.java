package com.jackbracey.recipeapi.Controllers;

import com.jackbracey.recipeapi.Helpers.Response;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ai")
public class AIController {

    @GetMapping
    public Response getResponseFromAI(@RequestHeader("input") String input) {
        OpenAiApi openAiApi = new OpenAiApi("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");

        ChatClient client = new OpenAiChatClient(openAiApi)
                .withDefaultOptions(OpenAiChatOptions.builder()
                        .withModel("gpt-35-turbo")
                        .withTemperature(0.4f)
                        .withMaxTokens(200)
                        .build());

        ChatResponse response = client.call(
                new Prompt(input)
        );

        return Response.Success(response.getResult());
    }

}
