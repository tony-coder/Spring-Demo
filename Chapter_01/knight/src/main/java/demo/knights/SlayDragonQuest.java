package demo.knights;

import java.io.PrintStream;

/**
 * SlayDragonQuest是要注入到 BraveKnight中的 Quest实现
 */

public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
