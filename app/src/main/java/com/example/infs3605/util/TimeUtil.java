package com.example.infs3605.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtil {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat(FORMAT);
        return format.format(new Date());
    }
}
