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
@ContextConfiguration("classpath:encore_config.xml")
public class EncoreableTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    public Performance player;

    @Test
    public void testEncoreable() {
        // Performance自己的方法
        player.perform();
        // 通过AOP增加的方法
        ((Encoreable) player).performEncore();

        assertEquals("playing...\r\nnew feature\r\n", log.getLog());
    }

}