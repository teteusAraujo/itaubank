package br.com.itau.itaubank.adapter.notification;

import br.com.itau.itaubank.adapter.notification.presentation.NotificationTransactionDTO;
import br.com.itau.itaubank.application.ports.out.NotificationSns;
import br.com.itau.itaubank.domain.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Notification implements NotificationSns {


    private final SnsTemplate snsTemplate;
    private final ObjectMapper objectMapper;
    @Value("${aws.sns.topic}")
    private String snsTopicArn;

    public Notification(SnsTemplate snsTemplate, ObjectMapper objectMapper) {
        this.snsTemplate = snsTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void execute(Transaction transaction) {
        try {
            snsTemplate.convertAndSend(snsTopicArn,
                    objectMapper.writeValueAsString(NotificationTransactionDTO.fromDomain(transaction)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
