package com.example;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;

/**
 * Created by jojoldu@zuminternet.com on 2016-08-02.
 */
@Component
public class TagLibrary {

    public String toKoreaTimeWith12Hour(LocalDateTime date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd a hh:mm:ss").toFormatter();
        return formatter.format(date);
    }

    public String getValueOrEmpty(String s){
        return Optional.ofNullable(s).orElse("");
    }
}
