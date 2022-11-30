/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:14 AM
 * @Description: parent class for all inventory type, each inventory type has cost and level levelRequirement attribute
 */
public class Equipment extends Entity {
    private int cost;
    private int levelRequirement;

    public Equipment(String name, int cost, int levelRequirement) {
        super(name);
        this.cost = cost;
        this.levelRequirement = levelRequirement;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

}
