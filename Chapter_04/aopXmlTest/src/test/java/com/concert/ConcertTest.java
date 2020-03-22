package com.concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop_config.xml")
public class ConcertTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private Performance play;

    @Test
    public void test() {
        play.perform();

        /*assertEquals("Silencing cell phones\r\n" +
                "Taking seats\r\n" +
                "playing...\r\n" +
                "CLAP CLAP CLAP!!!\r\n", log.getLog());*/
        assertEquals("Silencing cell phones\r\n" +
                "Taking seats\r\n" +
                "Silencing cell phones\r\n" +
                "Taking seats\r\n" +
                "playing...\r\n" +
                "CLAP CLAP CLAP!!!\r\n" +
                "CLAP CLAP CLAP!!!\r\n", log.getLog());
    }

}