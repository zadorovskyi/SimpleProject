package com.softserv.todolist.entity;


public class Reminder {
    private int reminderId;
    private String text;
    private int status;

    public Reminder() {
        this.status = 0;
    }

    public Reminder(int reminderId, String text, int status) {
        this.reminderId = reminderId;
        this.text = text;
        this.status = status;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reminder)) return false;

        Reminder reminder = (Reminder) o;

        if (reminderId != reminder.reminderId) return false;
        if (status != reminder.status) return false;
        return text != null ? text.equals(reminder.text) : reminder.text == null;
    }

    @Override
    public int hashCode() {
        int result = reminderId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", text='" + text + '\'' +
                ", status=" + status +
                '}';
    }
}
