package com.br.schoolreyfow.aws;


import com.amazonaws.services.sns.AmazonSNS;
import com.br.schoolreyfow.student.Student;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SNSSend {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SNSSend(AmazonSNS amazonSns) {
        this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    public void pubTopic(Object student, Map header) {
        this.notificationMessagingTemplate.convertAndSend("events", student, header);
        log.info("Send message to topic");
    }

}
