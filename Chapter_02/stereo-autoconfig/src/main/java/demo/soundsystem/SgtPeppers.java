package demo.soundsystem;

import org.springframework.stereotype.Component;

/* @Component注解表明该类会作为组件类，并告知Spring要为这个类创建bean
 * 没有必要显式配置SgtPeppersbean，因为这个类使用@Component注解，所以Spring会为你把事情处理妥当
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
