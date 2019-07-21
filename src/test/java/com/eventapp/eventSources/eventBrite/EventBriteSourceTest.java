package com.eventapp.eventSources.eventBrite;

import com.eventapp.App;
import com.eventapp.models.CommonEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class EventBriteSourceTest {

    @Autowired
    private EventBriteSource eventBriteSource;

    @Test
    public void getEventData() throws IOException {
        List<CommonEvent> result = eventBriteSource.getEventData();
        assertNotNull(result);
    }
}