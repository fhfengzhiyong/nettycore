package com.straw.email.mail.model;

/**
 * @author fengzy
 * @date 2/12/2018
 */
public class MailMessage {
    private String title;
    private String context;

    public MailMessage(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
