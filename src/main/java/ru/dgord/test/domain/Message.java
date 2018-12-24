package ru.dgord.test.domain;

public class Message {
    private Long id;
    private String text;

    public Message(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
