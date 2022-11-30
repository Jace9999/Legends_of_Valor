import Enums.UnitType;

import java.util.*;

import static Enums.UnitType.Common_Type;
import static Enums.UnitType.Hero_Nexus;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 12:22 PM
 * @Description: control the processing of game, initiate map and database first, then start the game.
 */
public class Game extends GameAbstract{
    private Player player;
    private Map map;

    private boolean gameOver;

    private boolean playerWin;

    private List<Hero> heroes;

    private List<Monster> monsters;

    public Game() {
        System.out.println("Welcome to Legends of Valor!");
        System.out.println();
        new Database();
        Database.printHelpMenu();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Ready for the game ? Enter Y to start the game!");
            String input = scanner.nextLine();
            if (input.equals("Y")){
                break;
            }else if (input.equals("Q")){
                return;
            }
        }
        initiate();
    }

    public void initiate() {
        // initiate database, in order to ensure program is able to read data from it
        monsters = new ArrayList<>();
        gameOver = false;
        playerWin = false;

        this.map = new Map(new Cell[Database.BOARD_SIZE][Database.BOARD_SIZE], Database.BOARD_SIZE);
        this.player = new Player(new ArrayList<>(), map);
        this.heroes = player.getHeroes();
        initiateMonster();
        playGame();
    }

    public void playGame() {
        int round = 1;
        while (true) {
            if (round % 8 == 0) {
                Iterator<Monster> iterator = monsters.iterator();
                while (iterator.hasNext()){
                    if (iterator.next().isDead()){
                        iterator.remove();
                    }
                }
                initiateMonster();

            }
            round++;
            heroesRound();
            if (gameOver) {
                if (playerWin) {
                    System.out.println("Congratulation! You have won the game!");
                }
                System.out.println("Game Over! Good Bye!");
                return;
            }
            monstersRound();
            if (gameOver) {
                if (playerWin) {
                    System.out.println("Congratulation! You have won the game!");
                }
                System.out.println("Game Over! Good Bye!");
                return;
            }
            for (Hero hero : heroes){
                if (hero.isDyingState()){
                    //reset dead hero
                    if (!map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].getUnitType().equals(Common_Type) && !map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].getUnitType().equals(Hero_Nexus)){
                        UnitType unitType = map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].getUnitType();
                        switch (unitType){
                            case Bush_Type:
                                hero.setDexterity((int) (hero.getDexterity() / Database.SPECIAL_AREA_INCREMENT_RATE));
                                break;
                            case Cave_Type:
                                hero.setAgility((int) (hero.getAgility() / Database.SPECIAL_AREA_INCREMENT_RATE));
                                break;
                            case Koulou_Type:
                                hero.setStrength((int) (hero.getStrength() / Database.SPECIAL_AREA_INCREMENT_RATE));
                                break;
                        }
                    }
                    map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].setHero(null);
                    hero.setPositionCol(hero.getHeroLine() * 3);
                    hero.setPositionRow(7);
                    map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].setHero(hero);

                    Armor currentWearArmor = hero.getCurrentWearArmor();
                    Weapon currentWearWeapon = hero.getCurrentWearWeapon();
                    if (currentWearWeapon != null) {
                        hero.getInventories().getWeapons().add(currentWearWeapon);
                    }
                    if (currentWearArmor != null) {
                        hero.getInventories().getArmors().add(currentWearArmor);
                    }
                    //reset the gain buff form battle
                    hero.setCurrentWearArmor(null);
                    hero.setDyingState(false);
                    hero.setCurrentWearWeapon(null);
                    hero.setStrengthIncreaseInBattle(0);
                    hero.setDefenseIncreaseInBattle(0);
                    hero.setDexterityIncreaseInBattle(0);
                    hero.setAgilityIncreaseInBattle(0);
                    hero.setCurrentHp(hero.getMaxHp());
                    hero.setCurrentMp(hero.getMaxMp());
                }else{
                    // recover for not dead hero
                    if (hero.getCurrentHp()*Database.HERO_ROUND_RECOVER_RATE > hero.getMaxHp()){
                        hero.setCurrentHp(hero.getMaxHp());
                    }else{
                        hero.setCurrentHp((int) (hero.getCurrentHp()*Database.HERO_ROUND_RECOVER_RATE));
                    }
                    if (hero.getCurrentMp()*Database.HERO_ROUND_RECOVER_RATE > hero.getMaxMp()){
                        hero.setCurrentMp(hero.getMaxMp());
                    }else{
                        hero.setCurrentMp((int) (hero.getCurrentMp()*Database.HERO_ROUND_RECOVER_RATE));
                    }
                }
            }
        }
    }

    public void heroesRound() {
        for (Hero hero : heroes) {
            map.printMap();
            boolean endRound = false;
            while (!endRound) {
                System.out.println();
                System.out.println("It is " + hero.getName() + " Round!");
                System.out.println("I:Check Hero State, P:Use A Potion, A:Attack");
                System.out.println("S:Cast A Spell, M:Move, T:Teleport, R:Recall");
                System.out.println("C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus");
                System.out.println("MI:Check Monsters State, Q: Exit game");
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "I":
                        hero.printHeroState();
                        hero.printInventories();
                        break;
                    case "Q":
                        gameOver =true;
                        return;
                    case "H":
                        Database.printHelpMenu();
                        break;
                    case "M":
                        HashMap<String, Boolean> result = hero.movement(this.map);
                        endRound = true;
                        if (result.containsKey(Database.GAME_OVER)){
                            gameOver = result.get(Database.GAME_OVER);
                            if (result.containsKey(Database.PLAYER_WIN)){
                                playerWin = result.get(Database.PLAYER_WIN);
                            }
                            return;
                        }
                        break;
                    case "P":
                        HashMap<String, Boolean> usePotionResult = hero.usePotion();
                        if (usePotionResult.containsKey(Database.GAME_OVER)){
                            gameOver = usePotionResult.get(Database.GAME_OVER);
                            return;
                        }
                        if (!usePotionResult.containsKey(Database.EMPTY_ITEM)){
                            endRound = true;
                        }
                        break;
                    case "A":
                        if (hero.checkNearMonster(map)) {
                            endRound = true;
                            HashMap<String, Boolean> attackResult = hero.attack(this.map);
                            if (attackResult.containsKey(Database.GAME_OVER)){
                                gameOver = attackResult.get(Database.GAME_OVER);
                                return;
                            }
                        } else {
                            System.out.println("No monster in hero attack range");
                        }
                        break;
                    case "S":
                        if (hero.checkNearMonster(map)) {
                            HashMap<String, Boolean> hashMap = hero.caseSpell(map);
                            if (hashMap.containsKey(Database.GAME_OVER)){
                                gameOver = hashMap.get(Database.GAME_OVER);
                                return;
                            }
                            if (!hashMap.containsKey(Database.EMPTY_ITEM)){
                                endRound = true;
                            }
                        } else {
                            System.out.println("No monster in hero attack range");
                        }
                        break;
                    case "T":
                        HashMap<String, Boolean> teleport = hero.teleport(map, heroes);
                        if (teleport.containsKey(Database.GAME_OVER)){
                            gameOver = teleport.get(Database.GAME_OVER);
                            return;
                        }
                        if (!teleport.containsKey(Database.INVALID_MOVEMENT)){
                            endRound = true;
                        }
                        break;
                    case "R":
                        if (hero.recall(map)){
                            endRound = true;
                        }
                        break;
                    case "E":
                        if (hero.getPositionRow() != 7) {
                            System.out.println(hero.getName() + " is not in the Nexus! You can not enter market!");
                        } else {
                            hero.enterMarket();
                            endRound = true;
                        }
                        break;
                    case "C":
                        HashMap<String, Boolean> changeEquipmentR = hero.changeEquipment();
                        if (changeEquipmentR.containsKey(Database.GAME_OVER)){
                            gameOver = changeEquipmentR.get(Database.GAME_OVER);
                            return;
                        }
                        if (!changeEquipmentR.containsKey(Database.EMPTY_ITEM)){
                            endRound = true;
                        }
                        break;
                    case "MI":
                        checkMonsterState();
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }

    public void monstersRound() {
        for (Monster monster : monsters) {
            if (monster.isDead()) {
                continue;
            }
            Hero hero = getNearHero(monster);
            if (hero == null) {
                System.out.println("There is not hero in " + monster.getName() + " attack range, " + monster.getName() + " move forward!");
                int positionRow = monster.getPositionRow();
                int positionCol = monster.getPositionCol();
                map.getBoardArray()[positionRow][positionCol].setMonster(null);
                monster.setPositionRow(positionRow + 1);
                map.getBoardArray()[monster.getPositionRow()][monster.getPositionCol()].setMonster(monster);
                if (monster.getPositionRow() == Database.BOARD_SIZE - 1) {
                    gameOver = true;
                    return;
                }
            } else {
                int dodgeChance = (int) (hero.getAgility() * Database.DODGE_RATE);
                Random random = new Random();
                int randomVal = random.nextInt(100);
                System.out.println("It is " + monster.getName() + " round!");
                System.out.println("Monster " + monster.getName() + " attack Hero " + hero.getName());
                if (randomVal <= dodgeChance) {
                    System.out.println(monster.getName() + " attack was MISSING!");
                } else {
                    int attackDamage = (int) ((monster.getStrength() - (hero.getDefense() + hero.getDefenseIncreaseInBattle())) * Database.ATTACK_RATE);
                    if (attackDamage > 0) {
                        System.out.println(monster.getName() + " attack was EFFECTIVE! " + hero.getName() + " has taken " + attackDamage);
                        // when hero die
                        if (hero.getCurrentHp() - attackDamage <= 0) {
                            System.out.println(hero.getName() + " die! he will rebirth in next round!");
                            hero.setDyingState(true);
                        } else {
                            hero.setCurrentHp(hero.getCurrentHp() - attackDamage);
                        }
                    } else {
                        System.out.println(monster.getName() + " attack was EFFECTIVE! " + ", but " + hero.getName() + " has a higher defense than monster strength, " + hero.getName() + " has taken 0 damage");
                    }
                }
            }
        }
    }

    public void initiateMonster() {
        // get the highest hero level, then create same level monster
        int currentHighestHeroLevel = 0;
        for (Hero hero:player.getHeroes()){
            currentHighestHeroLevel = Math.max(currentHighestHeroLevel,hero.getLevel());
        }
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            // create new monster while monster refresh location has not been occupied by old monster
            if (map.getBoardArray()[0][i*3].getMonster()==null) {
                // iterate the monster database until get monster which has same level with currentHighestHeroLevel
                while (true) {
                    int monsterIndex = random.nextInt(Database.monsters.size());
                    Monster monster = Database.monsters.get(monsterIndex);
                    if (monster.getLevel() == currentHighestHeroLevel && !monsters.contains(monster)){
                        map.getBoardArray()[0][i * 3].setMonster(monster);
                        monster.setCurrentHp(100);
                        monster.setDead(false);
                        monster.setPositionRow(0);
                        monster.setPositionCol(i * 3);
                        monsters.add(monster);
                        break;
                    }
                }
            }
        }
    }

    public Hero getNearHero(Monster monster) {
        int positionCol = monster.getPositionCol();
        int positionRow = monster.getPositionRow();
        Cell[][] boardArray = this.map.getBoardArray();
        // detect whether exists hero in current position
        if (boardArray[positionRow][positionCol].getHero() != null) {
            return boardArray[positionRow][positionCol].getHero();
        }
        // detect whether exists hero in right position
        if (boardArray[positionRow][positionCol + 1].getHero() != null) {
            return boardArray[positionRow][positionCol + 1].getHero();
        }
        // detect whether exists hero in forward position
        if (boardArray[positionRow + 1][positionCol].getHero() != null) {
            return boardArray[positionRow + 1][positionCol].getHero();
        }
        // detect whether exists hero in forward right position
        if (boardArray[positionRow + 1][positionCol + 1].getHero() != null) {
            return boardArray[positionRow + 1][positionCol + 1].getHero();
        }
        return null;
    }

    public void checkMonsterState(){
        for (Monster monster:monsters){
            if (!monster.isDead()){
                monster.printMonsterInfo();
            }
        }
    }
}
