package com.codegeek.ioc.day2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
@Data
@NoArgsConstructor
public class MessageSender {

    private MessageService messageService;

    private List<String> list;
    private Map<String, Object> map;
    private Set<String> set;
    private Properties properties;

    /**
     * 构造器注入
     *
     * @param messageService messageService
     */
    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}
