package com.ethany21.github.elasticsearchbackend.service;

import com.ethany21.github.elasticsearchbackend.document.TwitchMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TwitchMessageServiceTest {

    @Autowired
    private TwitchMessageService twitchMessageService;

    List<TwitchMessage> twitchMessageServiceStreamer;

    @BeforeEach
    void setTwitchMessageService() {
        twitchMessageServiceStreamer = twitchMessageService.getStreamer("jungtaejune");
    }

    @Test
    void getTwitchMessageLengthTest() {
        assertThat(twitchMessageServiceStreamer.size()).isEqualTo(50);
    }


    @Test
    void getStreamerCorrectTest() {
        assertThat(twitchMessageServiceStreamer.get(0).getStreamer()).isEqualTo("#jungtaejune");
    }

    @Test
    void getViewerNotNullTest() {
        assertThat(twitchMessageServiceStreamer.get(0).getViewer()).isNotNull();
    }

    @Test
    void getMessageNotNullTest() {
        assertThat(twitchMessageServiceStreamer.get(0).getMessage()).isNotNull();
    }

}