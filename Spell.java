/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:05 AM
 * @Description: using to represent spell
 */
public class Spell extends Equipment {
    private int manaCost;
    private String spellType;
    private int damage;

    public Spell(String name, int cost, int levelRequirement, int manaCost, String spellType, int damage) {
        super(name, cost, levelRequirement);
        this.manaCost = manaCost;
        this.spellType = spellType;
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void printSpellInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getLevelRequirement() + "   " +"Mana Cost: " + getManaCost() + "   " + "Spell Type: " + getSpellType() + "   " + "Damage: " + getDamage());
    }
}
