package demo.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里的main()方法基于 knights. xml文件创建了 Spring应用上下文。随后它调用该应用上下文
 * 获取一个为 knight的bean。得到 Knight对象的引用后,只需简单调用 embarkOnQuest()方法就
 * 可以执行所赋予的探险任务了。注意这个类完全不知道我们的英雄骑士接受哪种探险任务,而且完全
 * 没有意识到这是由 BraveKnight来执行的。只有 knights.xml文件知道哪个骑士执行哪种探险任务。
 */

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

}
