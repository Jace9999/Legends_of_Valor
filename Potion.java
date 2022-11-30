/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:05 AM
 * @Description: using to store potion
 */
public class Potion extends Equipment {
    private String increaseType;
    private int increaseAmount;

    public String getIncreaseType() {
        return increaseType;
    }

    public void setIncreaseType(String increaseType) {
        this.increaseType = increaseType;
    }

    public int getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    public Potion(String name, int cost, int levelRequirement, String increaseType, int increaseAmount) {
        super(name, cost, levelRequirement);
        this.increaseType = increaseType;
        this.increaseAmount = increaseAmount;
    }

    public void printPotionInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getLevelRequirement()+"   " + "Increase Type: " + getIncreaseType() + "   " + "Increase Amount: " + getIncreaseAmount());
    }
}
