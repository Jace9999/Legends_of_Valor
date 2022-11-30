import Enums.MonsterType;
import Enums.PotionIncreaseType;
import Enums.SpellType;

import java.util.ArrayList;
import java.util.List;

import static Enums.HeroType.*;
import static Enums.HeroType.Paladin;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 8:28 PM
 * @Description: contains all hardcode data from txt
 */
public class Database {
    public static List<Weapon> weapons;
    public static List<Armor> armors;

    public static List<Potion> potions;

    public static List<Spell> spells;

    public static List<Hero> heroes;

    public static List<Monster> monsters;

    public static final int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public final static int HERO_SIZE = 3;
    public final static int BOARD_SIZE = 8;
    public static final double BASE_INCREASE_RATE = 1.2;

    public static final double FAVORED_INCREASE_RATE = 1.5;

    public static final double DODGE_RATE = 0.02;

    public static final double ATTACK_RATE = 0.05;

    public static final double SPELL_RATE = 0.0001;

    public static final double HERO_ROUND_RECOVER_RATE = 1.1;
    public static final double SPECIAL_AREA_INCREMENT_RATE = 1.1;

    public static final String GAME_OVER = "GameOver";

    public static final String PLAYER_WIN = "PlayerWin";

    public static final String EMPTY_ITEM = "EmptyItem";

    public static final String INVALID_MOVEMENT = "InvalidMovement";

    public static Market GLOBAL_MARKET;


    public Database(){
        weapons= new ArrayList<>();
        armors= new ArrayList<>();
        potions= new ArrayList<>();
        spells= new ArrayList<>();
        heroes= new ArrayList<>();
        monsters= new ArrayList<>();
        initiateWeaponDB();
        initiateArmorDB();
        initiatePotionDB();
        initiateSpellDB();
        initiateHeroDB();
        initiateMonsterDB();
        GLOBAL_MARKET= new Market();
    }

    public static void initiateWeaponDB(){
        weapons.add(new Weapon("Sword",500,1,100));
        weapons.add(new Weapon("Bow",300,2,200));
        weapons.add(new Weapon("Scythe",1000,6,350));
        weapons.add(new Weapon("Axe",550,5,250));
        weapons.add(new Weapon("TSwords",1400,8,500));
        weapons.add(new Weapon("Dagger",200,1,50));
    }

    public static void initiateArmorDB(){
        armors.add(new Armor("Platinum_Shield",150,1,100));
        armors.add(new Armor("Breastplate",350,3,300));
        armors.add(new Armor("Full_Body_Armor",1000,8,500));
        armors.add(new Armor("Wizard_Shield",1200,10,850));
        armors.add(new Armor("Guardian_Angel",1000,10,800));
    }

    public static void initiatePotionDB(){
        potions.add(new Potion("Healing_Potion",250,1, PotionIncreaseType.Health.getTypeName(),100));
        potions.add(new Potion("Strength_Potion",200,1,PotionIncreaseType.Strength.getTypeName(),75));
        potions.add(new Potion("Magic_Potion",350,2,PotionIncreaseType.Mana.getTypeName(),100));
        potions.add(new Potion("Luck_Elixir",500,4,PotionIncreaseType.Agility.getTypeName(),65));
        potions.add(new Potion("Mermaid_Tears",850,5,PotionIncreaseType.Health_Mana_Strength_Agility.getTypeName(),100));
        potions.add(new Potion("Ambrosia",1000,8,PotionIncreaseType.All.getTypeName(),150));
    }

    public static void initiateSpellDB(){
        spells.add(new Spell("Lightning_Dagger",400,1,150, SpellType.Lighting.getTypeName(), 500));
        spells.add(new Spell("Thunder_Blast",750,4,400,SpellType.Lighting.getTypeName(),950));
        spells.add(new Spell("Electric_Arrows",550,5,200,SpellType.Lighting.getTypeName(),650));
        spells.add(new Spell("Spark_Needles",500,2,200,SpellType.Lighting.getTypeName(),600));
        spells.add(new Spell("Snow_Cannon",500,2,250,SpellType.Ice.getTypeName(), 650));
        spells.add(new Spell("Ice_Blade",250,1,100,SpellType.Ice.getTypeName(),450));
        spells.add(new Spell("Frost_Blizzard",750,5,350,SpellType.Ice.getTypeName(),850));
        spells.add(new Spell("Arctic_Storm",700,6,300,SpellType.Ice.getTypeName(), 800));
        spells.add(new Spell("Flame_Tornado",700,4,300,SpellType.Fire.getTypeName(),850));
        spells.add(new Spell("Breath_of_Fire",350,1,100,SpellType.Fire.getTypeName(),450));
        spells.add(new Spell("Heat_Wave",450,2,150,SpellType.Fire.getTypeName(),600));
        spells.add(new Spell("Lava_Comet",800,7,550,SpellType.Fire.getTypeName(),1000));
        spells.add(new Spell("Hell_Storm",600,3,600,SpellType.Fire.getTypeName(),950));
    }
    public static void initiateHeroDB(){
        heroes.add(new Hero("Gaerdal_Ironhand",1,7,10,100,100,100,100,700,0,500,600,1354,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Sehanine_Monnbow",1,8,10,100,100,600,600,700,0,800,500,2500,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Muamman_Duathall",1,6,10,100,100,300,300,900,0,500,750,2546,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Flandal_Steelskin",1,7,10,100,100,200,200,750,0,650,700,2500,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Undefeated_Yoj",1,7,10,100,100,400,400,800,0,400,700,2500,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Eunoia_Cyn",1,6,10,100,100,400,400,700,0,800,600,2500,
                Warrior.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Rillifane_Rallathil",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Segojan_Earthcaller",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Reign_Havoc",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Reverie_Ashels",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Kalabar",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Skye_Soar",1,7,10,100,100,100,100,700,0,500,600,1354,
                Sorcerer.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Parzival",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Sehanine_Moonbow",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Skoraeus_Stonebones",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Garl_Glittergold",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Amaryllis_Astra",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
        heroes.add(new Hero("Caliber_Heist",1,7,10,100,100,100,100,700,0,500,600,1354,
                Paladin.getTypeName(),new Inventories(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),null,null,0,0,0,0,false,0));
    }

    public static void initiateMonsterDB(){
        monsters.add(new Monster("Brandobaris",100,3,350,450,300,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("BigBad-Wolf",100,1,150,250,150,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("BigBad-Wolf-1",100,1,150,250,150,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("BigBad-Wolf-2",100,1,150,250,150,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("WickedWitch",100,2,250,350,250,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("WickedWitch-1",100,2,250,350,250,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("WickedWitch-2",100,2,250,350,250,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Andrealphus",100,2,150,500,400,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Andrealphus-2",100,2,150,500,400,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Andrealphus-1",100,2,150,500,400,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Blinky",100,1,450,350,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Blinky-1",100,1,450,350,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Blinky-2",100,1,450,350,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Andromalius",100,3,550,450,250,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Casper",100,1,100,100,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Desghidorrah",100,3,300,400,350, MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Desghidorrah-1",100,3,300,400,350, MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Desghidorrah-2",100,3,300,400,350, MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Desghidorrah-3",100,3,300,400,350, MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Desghidorrah-4",100,3,300,400,350, MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Chrysophylax",100,2,200,500,200,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Natsunomeryu",100,1,100,200,100,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Cyrrollalee",100,7,700,800,750,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Kiaransalee",100,8,850,950,850,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Merrshaullk",100,10,1000,900,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Yeenoghu",100,9,950,850,900,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Exodia",100,10,1000,1000,500,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("TheScaleless",100,7,700,600,750,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Alexstraszan",100,10,1000,900,550,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("D-Maleficent",100,9,900,950,850,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("TheWeatherbe",100,8,800,900,800,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("BlueEyesWhite",100,9,900,600,750,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Melchiresas",100,7,350,150,750,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Melchiresas-1",100,7,350,150,750,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Melchiresas-2",100,7,350,150,750,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Melchiresas-3",100,7,350,150,750,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Melchiresas-4",100,7,350,150,750,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Jormunngand",100,8,600,900,200,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Jormunngand-1",100,8,600,900,200,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Jormunngand-2",100,8,600,900,200,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Jormunngand-3",100,8,600,900,200,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Jormunngand-4",100,8,600,900,200,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Rakkshasass",100,9,550,600,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Rakkshasass-1",100,9,550,600,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Rakkshasass-2",100,9,550,600,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Rakkshasass-3",100,9,550,600,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Rakkshasass-4",100,9,550,600,350,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Taltecuhtli",100,10,300,200,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Taltecuhtli-1",100,10,300,200,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Taltecuhtli-2",100,10,300,200,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Taltecuhtli-3",100,10,300,200,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Taltecuhtli-4",100,10,300,200,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("BunsenBurner",100,4,400,500,450,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("BunsenBurner-1",100,4,400,500,450,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("BunsenBurner-2",100,4,400,500,450,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("BunsenBurner-3",100,4,400,500,450,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("BunsenBurner-4",100,4,400,500,450,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Aasterinian",100,4,400,500,450,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Chronepsish",100,6,650,750,600,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Shargaas",100,5,550,650,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Shargaas-1",100,5,550,650,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Shargaas-2",100,5,550,650,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Shargaas-3",100,5,550,650,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("St-Shargaas-4",100,5,550,650,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("DocOck",100,6,600,600,550,MonsterType.Exoskeletons.getTypeName(),false));
        monsters.add(new Monster("Igneel",100,6,600,400,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Igneel-1",100,6,600,400,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Igneel-2",100,6,600,400,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Igneel-3",100,6,600,400,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Igneel-4",100,6,600,400,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Phaarthurnax",100,6,600,700,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Kas-Ethelinh",100,5,600,500,600,MonsterType.Dragons.getTypeName(),false));
        monsters.add(new Monster("Chiang-shih",100,4,700,600,400,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("FallenAngel",100,5,800,700,500,MonsterType.Spirits.getTypeName(),false));
        monsters.add(new Monster("Ereshkigall",100,6,950,450,350,MonsterType.Spirits.getTypeName(),false));
    }

    public static void printHelpMenu(){
        System.out.println("Here are your controls:");
        System.out.println("      To move around the map, use your W,A,S,D keys!");
        System.out.println("W -> North, A -> West, S -> South, D -> East");
        System.out.println("H is the current position of your hero in the map, M represents a monster position and X represents a position that inaccessible");
        System.out.println("After select your heroes, enter Q at any time to exit game. However, let's not get try sneaky and use it to escape battle.");
        System.out.println("After select your heroes, enter I at any time to check hero's state.");
        System.out.println("After select your heroes, enter H at any time to view this instruction.");
        System.out.println("Think that should be all! Make sure you read and understand the command thoroughly. Have fun!");
        System.out.println();
    }

    public static void showDBHeroList(){
        System.out.println("------------------------------------");
        for(int i=0;i<heroes.size();i++){
            System.out.print(i + ": ");
            heroes.get(i).printHeroState();
        }
        System.out.println("------------------------------------");
        System.out.println();
    }
}
