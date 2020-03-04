package demo.knights;

public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {  //Quest被注入进来
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
