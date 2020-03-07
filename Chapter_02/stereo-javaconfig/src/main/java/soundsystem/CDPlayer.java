package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通过自动装配，将一个CompactDisc注入到CDPlayer之中
 */

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    // 自动装配
    @Autowired
    //@Autowired(required = false) //如果没有匹配的bean的话，Spring将会让这个bean处于未装配的状态
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    /* 或者
    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
    */

    @Override
    public void play() {
        cd.play();
    }
}
