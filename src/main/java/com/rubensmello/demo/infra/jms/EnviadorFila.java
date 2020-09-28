package com.rubensmello.demo.infra.jms;

import com.rubensmello.demo.infra.jms.dto.MensagemJmsDto;
import com.rubensmello.demo.model.Mensagem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnviadorFila {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void enviarMensagem(Mensagem mensagem) {
        log.info("Enviando mensagem JMS com título: {}", mensagem.getTitulo());
        jmsTemplate.convertAndSend(JmsConstants.DESTINATION, new MensagemJmsDto(mensagem));
    }
}
