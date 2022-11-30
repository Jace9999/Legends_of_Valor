import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jun Zhu
 * @Date: 11/7/2022 8:08 PM
 * @Description: using to process a transaction between hero and market
 */
public class Transaction implements TransactionOperationInterface{
    private Hero hero;
    private Market market;

    private boolean quitGame;

    public Transaction(Hero hero, Market market) {
        quitGame = false;
        this.hero = hero;
        this.market = market;
    }

    /*
     * @Author Jun Zhu
     * @Date  11/9/2022
     * @Param []
     * @return boolean
     * @Description //return true while player want to quit game
     **/
    public boolean processTransaction(){
        while (true){
            System.out.println();
            System.out.println("Press S to sell, B to Buy or X to switch hero to transact or exit market");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                case "S":
                    sellItem();
                    if (this.quitGame){
                        return true;
                    }
                    break;
                case "B":
                    buyItem();
                    if (this.quitGame){
                        return true;
                    }
                    break;
                case "X":
                    return false;
                case "H":
                    Database.printHelpMenu();
                    break;
                case "I":
                    hero.printHeroState();
                    hero.printInventories();
                    break;
                case "Q":
                    return true;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    /*
     * @Author Jun Zhu
     * @Date  11/9/2022
     * @Param []
     * @return void
     * @Description // hero buy item in the market
     **/
    public void buyItem(){
        Scanner scanner = new Scanner(System.in);
        market.printSellItem();
        while(true){
            System.out.println("Enter the inventory name to buy this item, or enter X to return to the previous menu");
            String itemName = scanner.nextLine();
            if (itemName.equals("I")){
                hero.printHeroState();
                hero.printInventories();
            }else if (itemName.equals("H")){
                Database.printHelpMenu();
            }else if (itemName.equals("Q")){
                quitGame = true;
                return;
            }else if (itemName.equals("X")){
                return;
            }else {
                Weapon weapon = market.searchWeaponByName(itemName);
                Spell spell = market.searchSpellByName(itemName);
                Armor armor = market.searchArmorByName(itemName);
                Potion potion = market.searchPotionByName(itemName);
                if(weapon == null && spell == null && armor == null && potion == null){
                    System.out.println("Cant find this item");
                }else if(weapon!=null){
                    int cost = weapon.getCost();
                    if(cost > hero.getGold()){
                        System.out.println(hero.getName() + " does not have enough money to buy this item");
                    }else if(hero.getLevel() < weapon.getLevelRequirement()){
                        System.out.println(hero.getName() + " does not require level to buy this item");
                    }else if (hero.getInventories().getWeapons().contains(weapon)){
                        System.out.println("Sorry, you already have the item in your backpack, you cannot have two of the same item at the same time");
                    }else{
                        System.out.println(hero.getName() + " spent " + weapon.getCost() + " money to buy " + weapon.getName());
                        hero.getInventories().getWeapons().add(weapon);
                        hero.setGold(hero.getGold() - cost);
                    }
                }else if(spell!=null){
                    int cost = spell.getCost();
                    if(cost > hero.getGold()){
                        System.out.println(hero.getName() + " does not have enough money to buy this item");
                    }else if(hero.getLevel() < spell.getLevelRequirement()){
                        System.out.println(hero.getName() + " does not require level to buy this item");
                    }else if(hero.getInventories().getSpells().contains(spell)){
                        System.out.println("Sorry, you already have the item in your backpack, you cannot have two of the same item at the same time");
                    }else{
                        System.out.println(hero.getName() + " spent " + spell.getCost() + " money to buy " + spell.getName());
                        hero.getInventories().getSpells().add(spell);
                        hero.setGold(hero.getGold() - cost);
                    }
                }else if(armor != null){
                    int cost = armor.getCost();
                    if(cost > hero.getGold()){
                        System.out.println(hero.getName() + " does not have enough money to buy this item");
                    }else if(hero.getLevel() < armor.getLevelRequirement()){
                        System.out.println(hero.getName() + " does not require level to buy this item");
                    }else if(hero.getInventories().getArmors().contains(armor)){
                        System.out.println("Sorry, you already have the item in your backpack, you cannot have two of the same item at the same time");
                    }else{
                        System.out.println(hero.getName() + " spent " + armor.getCost() + " money to buy " + armor.getName());
                        hero.getInventories().getArmors().add(armor);
                        hero.setGold(hero.getGold() - cost);
                    }
                }else{
                    int cost = potion.getCost();
                    if(cost > hero.getGold()){
                        System.out.println(hero.getName() + " does not have enough money to buy this item");
                    }else if(hero.getLevel() < potion.getLevelRequirement()){
                        System.out.println(hero.getName() + " does not require level to buy this item");
                    }else if(hero.getInventories().getPotions().contains(potion)){
                        System.out.println("Sorry, you already have the item in your backpack, you cannot have two of the same item at the same time");
                    }else{
                        System.out.println(hero.getName() + " spent " + potion.getCost() + " money to buy " + potion.getName());
                        hero.getInventories().getPotions().add(potion);
                        hero.setGold(hero.getGold() - cost);
                    }
                }
            }
        }
    }

    /*
     * @Author Jun Zhu
     * @Date  11/9/2022
     * @Param []
     * @return void
     * @Description hero sell item to market
     **/
    public void sellItem(){
        List<Weapon> weapons = hero.getInventories().getWeapons();
        List<Armor> armors = hero.getInventories().getArmors();
        List<Potion> potions = hero.getInventories().getPotions();
        List<Spell> spells = hero.getInventories().getSpells();
        if (weapons.size() == 0 && armors.size() == 0 && potions.size() == 0&& spells.size() == 0){
            System.out.println(hero.getName() + " does not have any inventory, can not sell any thing!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            hero.printInventories();
            System.out.println("Enter the inventory name to sell this item, or enter X to return to previous menu");
            String itemName = scanner.nextLine();
            if (itemName.equals("I")){
                hero.printHeroState();
                hero.printInventories();
            }else if (itemName.equals("H")){
                Database.printHelpMenu();
            }else if (itemName.equals("Q")){
                quitGame = true;
                return;
            }else if (itemName.equals("X")){
                return;
            }else {
                Weapon weapon = hero.searchWeaponByName(itemName);
                Spell spell = hero.searchSpellByName(itemName);
                Armor armor = hero.searchArmorByName(itemName);
                Potion potion = hero.searchPotionByName(itemName);
                if(weapon == null && spell == null && armor == null && potion == null){
                    System.out.println("Cant find this item");
                }else if(weapon!=null){
                    int cost = weapon.getCost()/2;
                    System.out.println(hero.getName() + " sell " + weapon.getName() + " get " + cost + " money");
                    hero.getInventories().getWeapons().remove(weapon);
                    hero.setGold(hero.getGold() + cost);
                }else if(spell!=null){
                    int cost = spell.getCost()/2;
                    System.out.println(hero.getName() + " sell " + spell.getName() + " get " + cost + " money");
                    hero.getInventories().getSpells().remove(spell);
                    hero.setGold(hero.getGold() + cost);
                }else if(armor != null){
                    int cost = armor.getCost()/2;
                    System.out.println(hero.getName() + " sell " + armor.getName() + " get " + cost + " money");
                    hero.getInventories().getArmors().remove(armor);
                    hero.setGold(hero.getGold() + cost);
                }else{
                    int cost = potion.getCost()/2;
                    System.out.println(hero.getName() + " sell " + potion.getName() + " get " + cost + " money");
                    hero.getInventories().getPotions().remove(potion);
                    hero.setGold(hero.getGold() + cost);
                }
            }
        }
    }
}
