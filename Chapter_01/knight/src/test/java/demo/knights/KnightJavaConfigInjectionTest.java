package demo.knights;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;


/**
 * java类配置Spring 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KnightConfig.class, loader = AnnotationConfigContextLoader.class)
public class KnightJavaConfigInjectionTest {
    @Autowired
    Knight knight;

    @Autowired
    FakePrintStream printStream;

    @After
    public void clearPrintStream() {
        printStream.clear();
    }

    @Test
    public void shouldInjectKnightWithSlayDragonQuest() {
        knight.embarkOnQuest();
        assertEquals(
                "Embarking on quest to slay the dragon!\n",
                printStream.getPrintedString());
    }

}