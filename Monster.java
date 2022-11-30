/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 12:09 PM
 * @Description: Monster class
 */
public class Monster extends Creature{

    private String monsterType;

    private boolean isDead;

    public Monster(String name, int hp,int level, int strength, int defense, int agility, String monsterType,boolean isDead) {
        super(name, level, strength, defense, agility,hp,0,0);
        this.monsterType = monsterType;
        this.isDead = isDead;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public void printMonsterInfo(){
        System.out.println(getName() + "   (" + monsterType + ")" + "   " + "Level: " + getLevel());
        System.out.println("      " + "Strength: " +getStrength() + "   " + "Defense: "+ getDefense() + "   " + "Health: " + getCurrentHp() + "/100");
    }
}
