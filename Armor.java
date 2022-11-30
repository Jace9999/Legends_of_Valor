/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:04 AM
 * @Description: Armor type extends from Equipment
 */
public class Armor extends Equipment {
    private int damageReduction;

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public Armor(String name, int cost, int levelRequirement, int damageReduction) {
        super(name, cost, levelRequirement);
        this.damageReduction = damageReduction;
    }

    public void printArmorInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getLevelRequirement()
        +"   " + "Damage Reduction: " + getDamageReduction());
    }
}
