import java.util.List;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 10:54 AM
 * @Description: contains four list to store hero's weapon, armor, potion and spell
 */
public class Inventories {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Potion> potions;

    private List<Spell> spells;

    @Override
    public String toString() {
        return "Inventories{" +
                "weapons=" + weapons +
                ", armors=" + armors +
                ", potions=" + potions +
                ", spells=" + spells +
                '}';
    }



    public Inventories(List<Weapon> weapons, List<Armor> armors, List<Potion> potions, List<Spell> spells) {
        this.weapons = weapons;
        this.armors = armors;
        this.potions = potions;
        this.spells = spells;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public void printWeapon(){
        for(Weapon weapon: weapons){
            weapon.printWeaponInfo();
        }
    }

    public void printArmor(){
        for(Armor armor: armors){
            armor.printArmorInfo();
        }
    }

    public void printPotion(){
        for(Potion potion: potions){
            potion.printPotionInfo();
        }
    }

    public void printSpell(){
        for(Spell spell: spells){
            spell.printSpellInfo();
        }
    }
}
