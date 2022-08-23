package com.fei.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class KafkaUtil {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, Object msg){
        kafkaTemplate.send(topic, msg);
    }

    /**
     * 自动ack
     */
//    @KafkaListener(topics = "wj0jddu6-default")
//    @KafkaListener(topics = "${cloudkarafka.topic}")
//    public void processMessage(String message,
//                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
//                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
//                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
//        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
//    }

    /**
     * 手动ack
     * 需要KafkaConfig文件的配合
     */
    @KafkaListener(topics = "${cloudkarafka.topic}", containerFactory = "ackContainerFactory")
    public void handleMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
        try {
            String message = (String) record.value();
            log.info("收到消息: {}", message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }
}
