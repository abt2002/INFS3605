package com.example.infs3605.model;

import com.example.infs3605.database.Users;

public class Session {

    private static String current;

    public static void setCurrent(String current) {
        Session.current = current;
    }

    public static String getCurrent() {
        return current;
    }
}
