package demo.knights;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * 一个单元测试用例执行顺序为： @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 */

// 为了让单元测试在Spring容器环境下执行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class KnightXMLInjectionTest {

    // @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    // 通过 @Autowired的使用来消除 set ，get方法。
    @Autowired
    Knight knight;

    @Autowired
    FakePrintStream printStream;

    // @After：释放资源
    @After
    public void clearPrintStream() {
        printStream.clear();
    }

    /**
     * AOP 应用测试
     */
    @Test
    public void shouldInjectKnightWithSlayDragonQuest() {
        knight.embarkOnQuest();
        // assertEquals 如果预期值与真实值相等，则运行success，反之Failure
        assertEquals(
                "Fa la la, the knight is so brave!\n" +
                        "Embarking on quest to slay the dragon!\n" +
                        "Tee hee hee, the brave knight did embark on a quest!\n",
                printStream.getPrintedString());
    }

}