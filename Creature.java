/**
 * @Author: Jun Zhu
 * @Date: 11/7/2022 1:22 PM
 * @Description: parent class for Hero and Monster, since every creature in this game has some common value
 */
public class Creature extends Entity{
    private int level;

    private int strength;
    private int defense;
    private int agility;

    private int currentHp;

    private int positionRow;
    private int positionCol;

    public Creature(String name, int level, int strength, int defense, int agility, int currentHp, int positionRow, int positionCol) {
        super(name);
        this.level = level;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.currentHp = currentHp;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }
}
