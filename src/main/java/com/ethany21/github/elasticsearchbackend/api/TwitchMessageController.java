package com.ethany21.github.elasticsearchbackend.api;

import com.ethany21.github.elasticsearchbackend.document.TwitchMessage;
import com.ethany21.github.elasticsearchbackend.service.TwitchMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TwitchMessageController {

    private final TwitchMessageService twitchMessageService;

    @GetMapping("/streamer/{streamer}")
    public List<TwitchMessage> getStreamers(@PathVariable("streamer") String streamer) {
        return twitchMessageService.getStreamer(streamer);
    }


}
