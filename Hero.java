import Enums.ForwardType;
import Enums.HeroType;
import Enums.SpellType;
import Enums.UnitType;

import java.util.*;

import static Enums.UnitType.*;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 10:45 AM
 * @Description: hero type
 */
public class Hero extends Creature implements HeroOperationInterface {

    private int experience;
    private int experienceToUpLevel;
    private int maxHp;
    private int currentMp;
    private int maxMp;
    private int dexterity;
    private int gold;
    private Inventories inventories;
    private String heroType;

    private Weapon currentWearWeapon;

    private Armor currentWearArmor;

    private int strengthIncreaseInBattle;

    private int agilityIncreaseInBattle;

    private int dexterityIncreaseInBattle;

    private int defenseIncreaseInBattle;

    private boolean dyingState;

    private int heroLine;

    public Hero(String name, int level, int experience, int experienceToUpLevel, int currentHp, int maxHp, int currentMp, int maxMp, int strength, int defense, int agility,
                int dexterity, int gold, String heroType, Inventories inventories, Weapon currentWearWeapon, Armor currentWearArmor,
                int strengthIncreaseInBattle, int agilityIncreaseInBattle, int dexterityIncreaseInBattle, int defenseIncreaseInBattle, boolean dyingState, int heroLine) {
        super(name, level, strength, defense, agility, currentHp, 0, 0);
        this.experience = experience;
        this.experienceToUpLevel = experienceToUpLevel;
        this.maxHp = maxHp;
        this.currentMp = currentMp;
        this.maxMp = maxMp;
        this.dexterity = dexterity;
        this.gold = gold;
        this.inventories = inventories;
        this.heroType = heroType;
        this.currentWearWeapon = currentWearWeapon;
        this.currentWearArmor = currentWearArmor;
        this.strengthIncreaseInBattle = strengthIncreaseInBattle;
        this.agilityIncreaseInBattle = agilityIncreaseInBattle;
        this.dexterityIncreaseInBattle = dexterityIncreaseInBattle;
        this.defenseIncreaseInBattle = defenseIncreaseInBattle;
        this.dyingState = dyingState;
        this.heroLine = heroLine;
    }

    public int getHeroLine() {
        return heroLine;
    }

    public void setHeroLine(int heroLine) {
        this.heroLine = heroLine;
    }

    public boolean isDyingState() {
        return dyingState;
    }

    public void setDyingState(boolean dyingState) {
        this.dyingState = dyingState;
    }

    public int getStrengthIncreaseInBattle() {
        return strengthIncreaseInBattle;
    }

    public void setStrengthIncreaseInBattle(int strengthIncreaseInBattle) {
        this.strengthIncreaseInBattle = strengthIncreaseInBattle;
    }

    public int getAgilityIncreaseInBattle() {
        return agilityIncreaseInBattle;
    }

    public void setAgilityIncreaseInBattle(int agilityIncreaseInBattle) {
        this.agilityIncreaseInBattle = agilityIncreaseInBattle;
    }

    public int getDexterityIncreaseInBattle() {
        return dexterityIncreaseInBattle;
    }

    public void setDexterityIncreaseInBattle(int dexterityIncreaseInBattle) {
        this.dexterityIncreaseInBattle = dexterityIncreaseInBattle;
    }

    public int getDefenseIncreaseInBattle() {
        return defenseIncreaseInBattle;
    }

    public void setDefenseIncreaseInBattle(int defenseIncreaseInBattle) {
        this.defenseIncreaseInBattle = defenseIncreaseInBattle;
    }

    public Weapon getCurrentWearWeapon() {
        return currentWearWeapon;
    }

    public void setCurrentWearWeapon(Weapon currentWearWeapon) {
        this.currentWearWeapon = currentWearWeapon;
    }

    public Armor getCurrentWearArmor() {
        return currentWearArmor;
    }

    public void setCurrentWearArmor(Armor currentWearArmor) {
        this.currentWearArmor = currentWearArmor;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperienceToUpLevel() {
        return experienceToUpLevel;
    }

    public void setExperienceToUpLevel(int experienceToUpLevel) {
        this.experienceToUpLevel = experienceToUpLevel;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventories getInventories() {
        return inventories;
    }

    public void setInventories(Inventories inventories) {
        this.inventories = inventories;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public void printInventories() {
        List<Weapon> weapons = this.inventories.getWeapons();
        List<Armor> armors = this.inventories.getArmors();
        List<Potion> potions = this.inventories.getPotions();
        List<Spell> spells = this.inventories.getSpells();
        System.out.println("Inventory list of " + getName());
        if (weapons.size() == 0) {
            System.out.println(getName() + " does not have any weapon");
        } else {
            System.out.println("Weapon:");
            inventories.printWeapon();
        }
        if (armors.size() == 0) {
            System.out.println(getName() + " does not have any armor");
        } else {
            System.out.println("Armor:");
            inventories.printArmor();
        }
        if (potions.size() == 0) {
            System.out.println(getName() + " does not have any potion");
        } else {
            System.out.println("Potion:");
            inventories.printPotion();
        }
        if (spells.size() == 0) {
            System.out.println(getName() + " does not have any spell");
        } else {
            System.out.println("Spell:");
            inventories.printSpell();
        }
    }

    public void printHeroState() {
        System.out.println(getName() + "   (" + getHeroType() + ")" + "   " + "Level: " + getLevel() + "   " + "Coins: " + getGold()
                + "   " + "Strength: " + getStrength());
        System.out.println("      " + "Defense: " + getDefense() + "   " + "Dexterity: " + getDexterity()
                + "   " + "Agility: " + getAgility() + "   " + "Health: " + getCurrentHp() + "/" + getMaxHp() + "   " + "Mana: " + getCurrentMp() + "/" + getMaxMp()
                + "   " + "Exp: " + getExperience() + "/" + getExperienceToUpLevel());
        System.out.println("Strength increase by weapon or potion: " + getStrengthIncreaseInBattle() + "   "
                + "Defense increase by weapon or potion: " + getDefenseIncreaseInBattle() + "   " +
                "Agility increase by weapon or potion: " + getAgilityIncreaseInBattle() + "   "
                + "Dexterity increase by weapon or potion: " + getDexterityIncreaseInBattle());

        if (getCurrentWearWeapon()!=null){
            System.out.println(getName() + " current equips weapon " + getCurrentWearWeapon().getName());
        }
        if (getCurrentWearArmor()!=null){
            System.out.println(getName() + " current equips armor " + getCurrentWearArmor().getName());
        }
        System.out.println();
    }

    public Weapon searchWeaponByName(String name) {
        for (Weapon weapon : inventories.getWeapons()) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }

    public Armor searchArmorByName(String name) {
        for (Armor armor : inventories.getArmors()) {
            if (armor.getName().equals(name)) {
                return armor;
            }
        }
        return null;
    }

    public Potion searchPotionByName(String name) {
        for (Potion potion : inventories.getPotions()) {
            if (potion.getName().equals(name)) {
                return potion;
            }
        }
        return null;
    }

    public Spell searchSpellByName(String name) {
        for (Spell spell : inventories.getSpells()) {
            if (spell.getName().equals(name)) {
                return spell;
            }
        }
        return null;
    }

    public void useHealthPotion(Potion potion) {
        int hp = this.getCurrentHp() + potion.getIncreaseAmount();
        System.out.println(this.getName() + " uses potion " + potion.getName() + " to recover hp");
        if (hp > this.getMaxHp()) {
            this.setCurrentHp(this.getMaxHp());
        } else {
            this.setCurrentHp(hp);
        }
        System.out.println(this.getName() + " current hp is " + this.getCurrentHp());
    }

    public void useManaPotion(Potion potion) {
        int mana = this.getCurrentMp() + potion.getIncreaseAmount();
        System.out.println(this.getName() + " uses potion " + potion.getName() + " to recover mana");
        if (mana > this.getMaxMp()) {
            this.setCurrentMp(this.getMaxMp());
        } else {
            this.setCurrentMp(mana);
        }
        System.out.println(this.getName() + " current mana is " + this.getCurrentMp());
    }

    public HashMap<String,Boolean> usePotion() {
        HashMap<String,Boolean> result = new HashMap<>();
        List<Potion> potions = this.getInventories().getPotions();
        if (potions.size() == 0) {
            System.out.println(this.getName() + "does not have any potion");
            result.put(Database.EMPTY_ITEM,true);
            return result;
        }
        Scanner scanner = new Scanner(System.in);
        this.getInventories().printPotion();
        while (true) {
            System.out.println("Please enter the name of potion");
            String inputName = scanner.nextLine();
            if (inputName.equals("Q")){
                result.put(Database.GAME_OVER,true);
                return result;
            }else if(inputName.equals("I")){
                printHeroState();
                printInventories();
            }
            Potion potion = this.searchPotionByName(inputName);
            if (potion != null) {
                String increaseType = potion.getIncreaseType();
                this.getInventories().getPotions().remove(potion);
                switch (increaseType) {
                    case "Health":
                        useHealthPotion(potion);
                        break;
                    case "Strength":
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase strength");
                        this.setStrengthIncreaseInBattle(this.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                        break;
                    case "Mana":
                        useManaPotion(potion);
                        break;
                    case "Agility":
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase agility");
                        this.setAgilityIncreaseInBattle(this.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                        break;
                    case "Health/Mana/Strength/Agility":
                        useHealthPotion(potion);
                        useManaPotion(potion);
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase strength");
                        this.setStrengthIncreaseInBattle(this.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase agility");
                        this.setAgilityIncreaseInBattle(this.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                        break;
                    default:
                        useHealthPotion(potion);
                        useManaPotion(potion);
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase strength");
                        this.setStrengthIncreaseInBattle(this.getStrengthIncreaseInBattle() + potion.getIncreaseAmount());
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase agility");
                        this.setAgilityIncreaseInBattle(this.getAgilityIncreaseInBattle() + potion.getIncreaseAmount());
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase dexterity");
                        this.setDexterityIncreaseInBattle(this.getDexterityIncreaseInBattle() + potion.getIncreaseAmount());
                        System.out.println(this.getName() + " uses potion " + potion.getName() + " to increase defense");
                        this.setDefenseIncreaseInBattle(this.getDefenseIncreaseInBattle() + potion.getIncreaseAmount());
                        break;
                }
                return result;
            } else {
                System.out.println("Can not find this potion, please re-enter the potion name!");
            }
        }
    }

    public List<Monster> printNearMonster(Map map) {
        List<Monster> monsterList = new ArrayList<>();
        int heroCol = this.getPositionCol();
        int heroRow = this.getPositionRow();
        Cell[][] boardArray = map.getBoardArray();
        // check whether exists monster near the hero
        // Check current position
        if (boardArray[heroRow][heroCol].getMonster() != null) {
            monsterList.add(boardArray[heroRow][heroCol].getMonster());
        }
        // check forward position
        if (boardArray[heroRow - 1][heroCol].getMonster() != null) {
            monsterList.add(boardArray[heroRow - 1][heroCol].getMonster());
        }
        // check left position
        if ((heroCol - 1 >= 0 && boardArray[heroRow][heroCol - 1].getMonster() != null)) {
            monsterList.add(boardArray[heroRow][heroCol - 1].getMonster());
        }
        // check right position
        if ((heroCol + 1 <= 7 && boardArray[heroRow][heroCol + 1].getMonster() != null)) {
            monsterList.add(boardArray[heroRow][heroCol + 1].getMonster());
        }
        // check forward left position
        if (heroCol - 1 >= 0 && boardArray[heroRow - 1][heroCol - 1].getMonster() != null) {
            monsterList.add(boardArray[heroRow - 1][heroCol - 1].getMonster());
        }
        // check forward right position
        if (heroCol + 1 <= 7 && boardArray[heroRow - 1][heroCol + 1].getMonster() != null) {
            monsterList.add(boardArray[heroRow - 1][heroCol + 1].getMonster());
        }
        return monsterList;
    }

    public HashMap<String,Boolean> attack(Map map) {
        HashMap<String,Boolean> result = new HashMap<>();
        List<Monster> monster = printNearMonster(map);
        boolean validInput = false;
        while (!validInput) {
            for (int i = 0; i < monster.size(); i++) {
                System.out.println(i +" " + monster.get(i).getName());
            }
            System.out.println("Enter the monster index to attack corresponding monster:");
            Scanner scanner = new Scanner(System.in);
            String indexInput = scanner.nextLine();
            if (indexInput.equals("Q")){
                result.put(Database.GAME_OVER,true);
                return result;
            }else if(indexInput.equals("I")){
                printHeroState();
                printInventories();
            }else if (indexInput.equals("MI")){

            }else if (!indexInput.matches("[0-9]")) {
                System.out.println("Invalid input");
            } else {
                int index = Integer.parseInt(indexInput);
                if (index >= monster.size()) {
                    System.out.println("Invalid input");
                } else {
                    Monster attackMonster = monster.get(index);
                    int dodgeChance = (int) ((attackMonster.getAgility() + this.getAgilityIncreaseInBattle()) * Database.DODGE_RATE);
                    Random random = new Random();
                    int randomVal = random.nextInt(100);
                    System.out.println(this.getName() + " attack " + attackMonster.getName());
                    if (randomVal <= dodgeChance) {
                        System.out.println(this.getName() + " attack was MISSING!");
                    } else {
                        int attackDamage = (int) (((this.getStrength() + this.getStrengthIncreaseInBattle()) - attackMonster.getDefense()) * Database.ATTACK_RATE);
                        System.out.println(this.getName() + " attack was EFFECTIVE! " + attackMonster.getName() + " has taken " + attackDamage);
                        if (attackMonster.getCurrentHp() - attackDamage <= 0) {
                            // if monster die
                            System.out.println(attackMonster.getName() + " dead!");
                            map.getBoardArray()[attackMonster.getPositionRow()][attackMonster.getPositionCol()].setMonster(null);
                            attackMonster.setCurrentHp(0);
                            attackMonster.setDead(true);
                            afterKillMonster(attackMonster.getLevel());
                        } else {
                            attackMonster.setCurrentHp(attackMonster.getCurrentHp() - attackDamage);
                        }
                    }
                    validInput = true;
                }
            }
        }
        return result;
    }

    public void afterKillMonster(int monsterLevel) {
        int getGold = monsterLevel * 500;
        this.setGold(this.getGold() + getGold);
        System.out.println(this.getName() + " get " + getGold + " gold");
        int getExperience = 3 * monsterLevel;
        this.setExperience(this.getExperience() + getExperience);
        System.out.println(this.getName() + " get " + getExperience + " experience");
        if (this.getExperience() >= this.getExperienceToUpLevel()) {
            // Level up
            this.setLevel(this.getLevel() + 1);
            System.out.println(this.getName() + " level up! current level is " + this.getLevel());
            this.setExperience(this.getExperience() - this.getExperienceToUpLevel());
            this.setExperienceToUpLevel(this.getLevel() * 10);
            this.setMaxHp((int) (this.getMaxHp() * 1.3));
            this.setMaxMp((int) (this.getMaxMp() * 1.3));
            this.setCurrentHp(this.getMaxHp());
            this.setCurrentMp(this.getMaxMp());
            if (this.getHeroType().equals(HeroType.Warrior.getTypeName())) {
                this.setStrength((int) (this.getStrength() * Database.FAVORED_INCREASE_RATE));
                this.setDexterity((int) (this.getDexterity() * Database.BASE_INCREASE_RATE));
                this.setAgility((int) (this.getAgility() * Database.FAVORED_INCREASE_RATE));
            } else if (this.getHeroType().equals(HeroType.Sorcerer.getTypeName())) {
                this.setStrength((int) (this.getStrength() * Database.BASE_INCREASE_RATE));
                this.setDexterity((int) (this.getDexterity() * Database.FAVORED_INCREASE_RATE));
                this.setAgility((int) (this.getAgility() * Database.FAVORED_INCREASE_RATE));
            } else {
                this.setStrength((int) (this.getStrength() * Database.FAVORED_INCREASE_RATE));
                this.setDexterity((int) (this.getDexterity() * Database.FAVORED_INCREASE_RATE));
                this.setAgility((int) (this.getAgility() * Database.BASE_INCREASE_RATE));
            }
            this.setDefense(this.getDefense() + 50);
        }
    }

    public boolean enterMarket() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to market!");
            System.out.println("Your hero can buy item and sell item in here, or enter X to exit market");
            Transaction transaction = new Transaction(this, Database.GLOBAL_MARKET);
            boolean exitGame = transaction.processTransaction();
            if (exitGame) {
                return false;
            }
            return true;
        }
    }

    public boolean checkNearMonster(Map map) {
        int heroCol = this.getPositionCol();
        int heroRow = this.getPositionRow();
        Cell[][] boardArray = map.getBoardArray();
        // check whether exists monster near the hero
        if (boardArray[heroRow][heroCol].getMonster() != null || boardArray[heroRow - 1][heroCol].getMonster() != null || (heroCol - 1 >= 0 && boardArray[heroRow][heroCol - 1].getMonster() != null)
                || (heroCol + 1 <= 7 && boardArray[heroRow][heroCol + 1].getMonster() != null)
                || (heroCol - 1 >= 0 && boardArray[heroRow - 1][heroCol - 1].getMonster() != null)
                || (heroCol + 1 <= 7 && boardArray[heroRow - 1][heroCol + 1].getMonster() != null)) {
            return true;
        }
        return false;
    }

    public HashMap<String,Boolean> movement(Map map) {
        HashMap<String,Boolean> result = new HashMap<>();
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter W,A,S,D to move");
            Scanner scanner = new Scanner(System.in);
            String moveInput = scanner.nextLine();
            if (moveInput.equals("Q")){
                result.put(Database.GAME_OVER,true);
                return result;
            }else if(moveInput.equals("I")){
                printHeroState();
                printInventories();
            }else{
                int forwardTypeByKeyboard = ForwardType.getForwardTypeByKeyboard(moveInput);
                if (forwardTypeByKeyboard == ForwardType.None.getForwardType()) {
                    System.out.println("Invalid key input!");
                    System.out.println();
                    continue;
                }
                Cell[][] boardArray = map.getBoardArray();
                int positionRow = this.getPositionRow();
                int positionCol = this.getPositionCol();
                int newPositionRow = positionRow + Database.direction[forwardTypeByKeyboard][0];
                int newPositionCol = positionCol + Database.direction[forwardTypeByKeyboard][1];
                if (newPositionCol < 0 || newPositionCol == map.getBoardSize() || newPositionRow < 0 || newPositionRow == map.getBoardSize() ||
                        boardArray[newPositionRow][newPositionCol].getUnitType().equals(Inaccessible_Type)) {
                    System.out.println("Invalid movement position!");
                    continue;
                }
                if (boardArray[newPositionRow][newPositionCol].getHero() != null) {
                    System.out.println("This is an hero in this position, you can not move to there!");
                    continue;
                }
                // check near monster
                if (((positionCol - 1 > 0 && boardArray[positionRow][positionCol - 1].getMonster() != null) ||
                        (positionCol + 1 < Database.BOARD_SIZE && boardArray[positionRow][positionCol + 1].getMonster() != null) ||
                        (boardArray[positionRow][positionCol].getMonster() != null)) && forwardTypeByKeyboard==ForwardType.North.getForwardType()) {
                    System.out.println("You can not move to the back of monster!");
                    continue;
                }
                // if hero's current position is a buffer position, we need remove the buffer when hero move to next position
                if (!boardArray[positionRow][positionCol].getUnitType().equals(Common_Type) && !boardArray[positionRow][positionCol].getUnitType().equals(Hero_Nexus)){
                    UnitType unitType = boardArray[positionRow][positionCol].getUnitType();
                    switch (unitType){
                        case Bush_Type:
                            System.out.println(getName() + " leave Bush area, dexterity increment buffer is removed!");
                            setDexterity((int) (getDexterity() / Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                        case Cave_Type:
                            System.out.println(getName() + " leave Cave area, agility increment buffer is removed!");
                            setAgility((int) (getAgility() / Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                        case Koulou_Type:
                            System.out.println(getName() + " leave Koulou area, strength increment buffer is removed!");
                            setStrength((int) (getStrength() / Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                    }
                }
                boardArray[positionRow][positionCol].setHero(null);
                this.setPositionRow(newPositionRow);
                this.setPositionCol(newPositionCol);
                boardArray[newPositionRow][newPositionCol].setHero(this);
                // if hero's move position is a buffer position, we need to add buffer to the hero
                if (!boardArray[newPositionRow][newPositionCol].getUnitType().equals(Common_Type) && !boardArray[newPositionRow][newPositionCol].getUnitType().equals(Hero_Nexus)){
                    UnitType unitType = boardArray[newPositionRow][newPositionCol].getUnitType();
                    switch (unitType){
                        case Bush_Type:
                            System.out.println(getName() + " enter Bush area, get dexterity increment!");
                            setDexterity((int) (getDexterity() * Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                        case Cave_Type:
                            System.out.println(getName() + " enter Cave area, get agility increment!");
                            setAgility((int) (getAgility() * Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                        case Koulou_Type:
                            System.out.println(getName() + " enter Koulou area, get strength increment!");
                            setStrength((int) (getStrength() * Database.SPECIAL_AREA_INCREMENT_RATE));
                            break;
                    }
                }
                if (this.getPositionRow() == 0) {
                    result.put(Database.GAME_OVER,true);
                    result.put(Database.PLAYER_WIN,true);
                    return result;
                }
                validInput = true;
            }
        }
        return result;
    }

    public boolean recall(Map map) {
        if(map.getBoardArray()[7][heroLine * 3].getHero()!=null){
            System.out.println("Your nexus's recall position has been occupied by hero, you can not recall!");
            return false;
        }
        map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(null);
        this.setPositionCol(heroLine * 3);
        this.setPositionRow(7);
        map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
        return true;
    }

    public HashMap<String,Boolean> teleport(Map map, List<Hero> heroes) {
        HashMap<String,Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < heroes.size(); i++) {
            if (!heroes.get(i).equals(this)) {
                System.out.println(i + " " + heroes.get(i).getName() + " with position " + heroes.get(i).getPositionRow()+ " , " + heroes.get(i).getPositionCol());
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the hero index that you wanna teleport to");
            String heroIndex = scanner.nextLine();
            if (heroIndex.equals("Q")){
                hashMap.put(Database.GAME_OVER,true);
                return hashMap;
            }else if(heroIndex.equals("I")){
                printHeroState();
                printInventories();
            }else if (heroIndex.matches("[0-2]")) {
                int index = Integer.parseInt(heroIndex);
                if (heroes.get(index).equals(this)) {
                    System.out.println("You can not pick current hero!");
                } else {
                    Hero hero = heroes.get(index);
                    // if target hero is at nexus, move to target hero's left or right position
                    if (hero.getPositionRow() == 7) {
                        if (hero.getPositionCol() - 1 < 0 ||
                                map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol() - 1].getUnitType().equals(Inaccessible_Type)) {
                            if (map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol() + 1].getHero()!=null){
                                System.out.println("Target hero is at nexus, you cant teleport to the target hero since there is a hero nearby");
                                hashMap.put(Database.INVALID_MOVEMENT,true);
                                return hashMap;
                            }
                            map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(null);
                            this.setPositionRow(hero.getPositionRow());
                            this.setPositionCol(hero.getPositionCol() + 1);
                            map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
                            return hashMap;
                        } else {
                            if (map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol() - 1].getHero()!=null){
                                System.out.println("Target hero is at nexus, you cant teleport to the target hero since there is a hero nearby");
                                hashMap.put(Database.INVALID_MOVEMENT,true);
                                return hashMap;
                            }
                            map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(null);
                            this.setPositionRow(hero.getPositionRow());
                            this.setPositionCol(hero.getPositionCol() - 1);
                            map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
                            return hashMap;
                        }
                    } else {
                        map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(null);
                        // if target hero is not at nexus, move to target hero's back
                        if (map.getBoardArray()[hero.getPositionRow() + 1][hero.getPositionCol()].getHero() != null) {
                            if (hero.getPositionCol() - 1 < 0 ||
                                    map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol() - 1].getUnitType().equals(Inaccessible_Type)) {
                                this.setPositionRow(hero.getPositionRow() + 1);
                                this.setPositionCol(hero.getPositionCol() + 1);
                                map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
                                return hashMap;
                            } else {
                                this.setPositionRow(hero.getPositionRow() + 1);
                                this.setPositionCol(hero.getPositionCol() - 1);
                                map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
                                return hashMap;
                            }
                        } else {
                            this.setPositionRow(hero.getPositionRow() + 1);
                            this.setPositionCol(hero.getPositionCol());
                            map.getBoardArray()[getPositionRow()][getPositionCol()].setHero(this);
                            return hashMap;
                        }
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public HashMap<String ,Boolean> caseSpell(Map map) {
        HashMap<String ,Boolean> hashMap = new HashMap<>();
        List<Spell> spells = this.getInventories().getSpells();
        if (spells.size() == 0) {
            System.out.println(this.getName() + "does not have any spell");
            hashMap.put(Database.EMPTY_ITEM,true);
            return hashMap;
        }
        Scanner scanner = new Scanner(System.in);
        this.getInventories().printSpell();
        while (true) {
            System.out.println("Please enter the name of spell");
            String inputName = scanner.nextLine();
            if (inputName.equals("Q")){
                hashMap.put(Database.GAME_OVER,true);
                return hashMap;
            }else if(inputName.equals("I")){
                printHeroState();
                printInventories();
            }else if (inputName.equals("MI")){

            }else {
                Spell spell = this.searchSpellByName(inputName);
                if (spell != null) {
                    if (this.getCurrentMp() < spell.getManaCost()) {
                        System.out.println(this.getName() + " does not have enough mana to cast this spell");
                        hashMap.put(Database.EMPTY_ITEM,true);
                        return hashMap;
                    } else {
                        boolean validMonsterName = false;
                        this.setCurrentMp(this.getCurrentMp() - spell.getManaCost());
                        List<Monster> monsterList = printNearMonster(map);
                        for (int i = 0; i < monsterList.size(); i++) {
                            System.out.println(i + " " + monsterList.get(i).getName());
                        }
                        while (!validMonsterName) {
                            System.out.println("Enter the monster index which you wanna cast spell at");
                            String monsterIndex = scanner.nextLine();
                            if (!monsterIndex.matches("[0-9]")) {
                                System.out.println("Invalid Input!");
                            } else {
                                int index = Integer.parseInt(monsterIndex);
                                if (monsterList.get(index) == null) {
                                    System.out.println("Can not find this index!");
                                } else {
                                    Monster monster = monsterList.get(index);
                                    if (monster.isDead()) {
                                        System.out.println(monster.getName() + " is dead, cant attack!");
                                    } else {
                                        int damage = (int) ((this.getDexterity() + this.getDexterityIncreaseInBattle()) * Database.SPELL_RATE * spell.getDamage());
                                        System.out.println(this.getName() + "use spell " + spell.getName() + " to deal " + damage + " damage to monster " + monster.getName());
                                        if (spell.getSpellType().equals(SpellType.Ice.getTypeName())) {
                                            System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's strength");
                                            monster.setStrength((int) (monster.getStrength() * 0.8));
                                        } else if (spell.getSpellType().equals(SpellType.Fire.getTypeName())) {
                                            System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's defense");
                                            monster.setDefense((int) (monster.getDefense() * 0.8));
                                        } else {
                                            System.out.println(spell.getName() + " type is " + spell.getSpellType() + ", also reduce 20% target monster's agility");
                                            monster.setAgility((int) (monster.getAgility() * 0.8));
                                        }
                                        if (monster.getCurrentHp() <= damage) {
                                            // if monster die
                                            System.out.println(monster.getName() + " dead!");
                                            map.getBoardArray()[monster.getPositionRow()][monster.getPositionCol()].setMonster(null);
                                            monster.setCurrentHp(0);
                                            monster.setDead(true);
                                            afterKillMonster(monster.getLevel());
                                        } else {
                                            monster.setCurrentHp(monster.getCurrentHp() - damage);
                                        }
                                        return hashMap;
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public HashMap<String,Boolean> changeEquipment() {
        HashMap<String,Boolean> hashMap = new HashMap<>();
        if (this.getCurrentWearArmor() != null) {
            System.out.println(this.getName() + " currently equip armor " + this.getCurrentWearArmor().getName());
        }
        if (this.getCurrentWearWeapon() != null) {
            System.out.println(this.getName() + " currently equip weapon " + this.getCurrentWearWeapon().getName());
        }
        List<Weapon> weapons = this.getInventories().getWeapons();
        List<Armor> armors = this.getInventories().getArmors();
        if (weapons.size() == 0 && armors.size() == 0) {
            System.out.println(this.getName() + "does not have any weapon and armor in the inventory list");
            hashMap.put(Database.EMPTY_ITEM,true);
            return hashMap;
        } else {
            Scanner scanner = new Scanner(System.in);
            this.getInventories().printWeapon();
            this.getInventories().printArmor();
            while (true) {
                System.out.println("Please enter the name of weapon or armor to equip");
                System.out.println("If you select a weapon while you currently have a weapon equipped, it will be swapped");
                String inventoryName = scanner.nextLine();
                if (inventoryName.equals("I")) {
                    this.printHeroState();
                    printInventories();
                } else if (inventoryName.equals("Q")) {
                    hashMap.put(Database.GAME_OVER,true);
                    return hashMap;
                } else {
                    Armor armor = this.searchArmorByName(inventoryName);
                    Weapon weapon = this.searchWeaponByName(inventoryName);
                    if (armor != null) {
                        this.getInventories().getArmors().remove(armor);
                        Armor currentWearArmor = this.getCurrentWearArmor();
                        if (this.getCurrentWearArmor() != null) {
                            this.getInventories().getArmors().add(currentWearArmor);
                            this.setDefenseIncreaseInBattle(this.getDefenseIncreaseInBattle() - currentWearArmor.getDamageReduction());
                            System.out.println(this.getName() + " swap current armor " + currentWearArmor.getName() + " to new armor " + armor.getName());
                        }
                        this.getInventories().getArmors().remove(armor);
                        this.setCurrentWearArmor(armor);
                        this.setDefenseIncreaseInBattle(this.getDefenseIncreaseInBattle() + armor.getDamageReduction());
                        System.out.println(this.getName() + " equip armor " + armor.getName() + ", defense increase " + armor.getDamageReduction());
                        return hashMap;
                    } else if (weapon != null) {
                        this.getInventories().getWeapons().remove(weapon);
                        Weapon currentWearWeapon = this.getCurrentWearWeapon();
                        if (this.getCurrentWearWeapon() != null) {
                            this.getInventories().getWeapons().add(this.getCurrentWearWeapon());
                            this.setStrengthIncreaseInBattle(this.getStrengthIncreaseInBattle() - currentWearWeapon.getDamage());
                        }
                        this.getInventories().getWeapons().remove(weapon);
                        this.setCurrentWearWeapon(weapon);
                        this.setStrengthIncreaseInBattle(this.getStrengthIncreaseInBattle() + weapon.getDamage());
                        System.out.println(this.getName() + " equip weapon " + weapon.getName() + ", strength increase " + weapon.getDamage());
                        return hashMap;
                    } else {
                        System.out.println("Can not find this name in your weapon list or armor list");
                    }
                }
            }
        }
    }
}
