/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:04 AM
 * @Description: Weapon type extends from Equipment
 */
public class Weapon extends Equipment {
    private int damage;

    public Weapon(String name, int cost, int levelRequirement, int damage) {
        super(name, cost, levelRequirement);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void printWeaponInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getLevelRequirement()
                +"   " + "Damage: " + getDamage() + "   ");
    }
}
