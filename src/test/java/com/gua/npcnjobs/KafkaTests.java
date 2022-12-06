package com.gua.npcnjobs;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaTests.class)
@EmbeddedKafka(count = 4,ports = {9092,9093,9094,9095})
public class KafkaTests {
    @Test
    public void contextLoads()throws IOException {
        System.in.read();
    }
}