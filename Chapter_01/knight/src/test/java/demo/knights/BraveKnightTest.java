package demo.knights;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * 你可以使用mock框架 Mockito去创建一个 Quest接口的mock实现。通过这个mock对象,就可以
 * 创建一个新的 Braveknight实例,并通过构造器注入这个 mock Quest。当调用 embarkonQuest()方法时,
 * 你可以要求 Mockito框架验证 Quest的mock实现的 embark()方法仅仅被调用了一次。
 */

public class BraveKnightTest {
    // 为了测试BraveKnight，需要注入一个mock Queue
    @Test
    public void embarkOnQuest() {
        Quest mockQuest = mock(Quest.class);  // 创建mock Quest
        BraveKnight knight = new BraveKnight(mockQuest);  //注入mock Queue
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}