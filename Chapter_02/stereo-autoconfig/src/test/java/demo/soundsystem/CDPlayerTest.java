package demo.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)  // 指定配置文件
public class CDPlayerTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        // 使用StandardOutputStreamLog，这是源于system Rules库的一个JUnit规则，该规则能够基于控制台的输出编写断言
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n", log.getLog());  // 注意这里可能有个编码问题 \r\n != \n
    }

}