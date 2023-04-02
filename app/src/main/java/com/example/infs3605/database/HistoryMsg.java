package com.example.infs3605.database;

public class HistoryMsg {

    private String username;

    private String msg;

    private String sendtime;

    private String sendfrom;

    public HistoryMsg(String username, String msg, String sendtime, String sendfrom) {
        this.username = username;
        this.msg = msg;
        this.sendtime = sendtime;
        this.sendfrom = sendfrom;
    }


    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }

    public String getSendtime() {
        return sendtime;
    }

    public String getSendfrom() {
        return sendfrom;
    }
}
