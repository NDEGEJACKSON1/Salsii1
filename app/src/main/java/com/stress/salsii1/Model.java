package com.stress.salsii1;

public class Model {

    private int imageView1;
    private String textView;
    private String timeView;
    private String messageView;


    public Model(int imageView1, String textView, String timeView, String messageView) {
        this.imageView1 = imageView1;
        this.textView = textView;
        this.timeView = timeView;
        this.messageView = messageView;
    }

    public int getImageView1() {
        return imageView1;
    }

    public String getTextView() {
        return textView;
    }

    public String getTimeView() {
        return timeView;
    }

    public String getMessageView() {
        return messageView;
    }
}
