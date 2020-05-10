package com.codegeek.day2;

public class MessageSender {

    private MessageService messageService;

    /**
     * 构造器注入
     * @param messageService messageService
     */
    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}
