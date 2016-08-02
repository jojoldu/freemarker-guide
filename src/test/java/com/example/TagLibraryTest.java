package com.example;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@zuminternet.com on 2016-08-02.
 */
public class TagLibraryTest {

    private TagLibrary tagLibrary;

    @Before
    public void setup() throws Exception {
        tagLibrary = new TagLibrary();
    }

    @Test
    public void test_nowTimeWithKo() throws Exception{
        LocalDateTime am = LocalDateTime.parse("2016-08-02 01:00:00", DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss")));
        assertThat(tagLibrary.toKoreaTimeWith12Hour(am), is("2016-08-02 오전 01:00:00"));

        LocalDateTime pm = LocalDateTime.parse("2016-08-02 14:00:00", DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss")));
        assertThat(tagLibrary.toKoreaTimeWith12Hour(pm), is("2016-08-02 오후 02:00:00"));
    }
}
