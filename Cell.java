import Enums.UnitType;

/**
 * @Author: Jun Zhu
 * @Date: 10/29/2022 5:04 PM
 * @Description: represent a unit on the map
 */
public class Cell {

    private UnitType unitType;

    private Monster monster;

    private Hero hero;

    public Cell(UnitType unitType, Monster monster, Hero hero) {
        this.unitType = unitType;
        this.monster = monster;
        this.hero = hero;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}