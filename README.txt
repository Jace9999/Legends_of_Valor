# CS611-<Assignment 4>
## <legends of Valor>
---------------------------------------------------------------------------
Name: <Jun Zhu>, <Tianxin Zhou>
BU email: <zhujun99@bu.edu>, <txzhou@bu.edu>
BUID: <U78975626>, <U00104753>

## How to compile and run
---------------------------------------------------------------------------
javac -d bin *.java
java -cp bin Main

## Files
---------------------------------------------------------------------------
Main.java
@Description: contains main function for entering game

GameAbstract.java
@Description: abstract game class, contains basic processes for a game. 

Game.java
@Description: Concrete game where the processes of Legends of Valor were implemented. control the processing of game, initiate map and database first, then start the game.

Entity.java
@Description: each entity has a common attribute which is name

Equipment.java
@Description: parent class for all inventory type, each inventory type has cost and level levelRequirement attribute

Creature.java
@Description: parent class for Hero and Monster, since every creature in this game has some common value

Player.java
@Description: contains a list of hero and current player position. 

Map.java
@Description: map class, contains the size of map which is able to scalable and a 2D unit array. In Legends of Valor, map is fixed to an 8x8 board.

Cell.java
@Description: represent a cell on the map

SpecialArea.java
@Description: Special grids on the map, heroes gain ability bonus when entering SpecialArea and lose bonus when exiting SpecialArea.

Bush.java
@Description: bush grid on the map, extended from SpecialArea.Has ability bonus within the grid.

Cave.java
@Description: cave grid on the map, extended from SpecialArea.Has ability bonus within the grid.

Koulou.java
@Description: Koulou grid on the map, extended from SpecialArea. Has ability bonus within the grid.

Transaction.java
@Description: using to process a transaction between hero and market

Database.java
@Description: contains all hardcode data from txt

Inventories.java
@Description: contains four list to store hero's weapon, armor, potion and spell

Market.java
@Description: market class, each market contains 4 different list to store weapon, armor, potion and spell

Armor.java
@Description: Armor type extends from Equipment

Weapon.java
@Description: Weapon type extends from Equipment

Spell.java
@Description: using to represent spell

Potion.java
@Description: using to store potion

Hero.java
@Description: hero type. How a hero takes actions, changing status and personal belongings are defined. Extended from Creature.

Monster.java
@Description: Monster type, how a monster changes its status is defined. Extended from Creature.

ForwardType.java
@Description: Enum for store player movement type

HeroType.java
@Description: enum for separate three different hero type

MonsterType.java
@Description: enum for separate three different monster type

PotionIncreaseType.java
@Description: enum for separate different potion increase type

SpellType.java
@Description: enum for separate different spell type

UnitType.java
@Description: enum for separate different unit type

HeroOperationInterface.java
@Description: Contains basic hero operation methods

TransactionOperationInterface.java
@Description: Contains basic market operation methods
## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa1" after unzipping the files
2. Run the following instructions:
javac -d bin src/*.java
java -cp bin Main

## Notes
---------------------------------------------------------------------------
Map in the game is colored to indicate various types of grids, copied map in the example input/output section is not able to fully support that display. Please check the map by running the program.

The specific implementation of my game follows the instructions pdf given by the professor and all functions are well implemented.
In this game, monsters have the same strength, defense, and agility attributes as heroes, 
which are shared with heroes in the formula for calculating them in battle. 
The hero can buy items in the store, potions are consumable only in the battle and can only be used once.
Weapons, armor, and spells are not consumable. 
However, when the hero defeats an enemy, the weapons and armor equipped by the hero in the battle are automatically returned to the hero's Inventory collection, 
and the next battle will require a new turn to equip the weapon or armor.
In addition, when a hero upgrades, their Strength, Dexterity, and Agility attributes increment rate is affected by the hero's type.
At the same time, spells will not only cause damage to the enemy, and different types of spells will cause different negative effects on the enemy

## Input/Output Example
---------------------------------------------------------------------------
<Check Status>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: I

Output:
Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 1354   Strength: 700
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase by weapon or potion: 0   Defense increase by weapon or potion: 0   Agility increase by weapon or potion: 0   Dexterity increase by weapon or potion: 0

Inventory list of Gaerdal_Ironhand
Gaerdal_Ironhand does not have any weapon
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Gaerdal_Ironhand does not have any spell

<Buy Items In The Market>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: E

Output:
Welcome to market!
Your hero can buy item and sell item in here, or enter X to exit market

Press S to sell, B to Buy or X to switch hero to transact or exit market

Input:B

Output:
Sell list of current market:
Weapon:
Sword   Cost: 500   Level Require: 1   Damage: 800   
Bow   Cost: 300   Level Require: 2   Damage: 500   
Scythe   Cost: 1000   Level Require: 6   Damage: 1100   
Axe   Cost: 550   Level Require: 5   Damage: 850   
TSwords   Cost: 1400   Level Require: 8   Damage: 1600   
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Armor:
Platinum_Shield   Cost: 150   Level Require: 1   Damage Reduction: 200
Breastplate   Cost: 350   Level Require: 3   Damage Reduction: 600
Full_Body_Armor   Cost: 1000   Level Require: 8   Damage Reduction: 1100
Wizard_Shield   Cost: 1200   Level Require: 10   Damage Reduction: 1500
Guardian_Angel   Cost: 1000   Level Require: 10   Damage Reduction: 1000
Potion:
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Strength_Potion   Cost: 200   Level Require: 1   Increase Type: Strength   Increase Amount: 75
Magic_Potion   Cost: 350   Level Require: 2   Increase Type: Mana   Increase Amount: 100
Luck_Elixir   Cost: 500   Level Require: 4   Increase Type: Agility   Increase Amount: 65
Mermaid_Tears   Cost: 850   Level Require: 5   Increase Type: Health/Mana/Strength/Agility   Increase Amount: 100
Ambrosia   Cost: 1000   Level Require: 8   Increase Type: All   Increase Amount: 150
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Thunder_Blast   Cost: 750   Level Require: 4   Mana Cost: 400   Spell Type: Lighting   Damage: 950
Electric_Arrows   Cost: 550   Level Require: 5   Mana Cost: 200   Spell Type: Lighting   Damage: 650
Spark_Needles   Cost: 500   Level Require: 2   Mana Cost: 200   Spell Type: Lighting   Damage: 600
Snow_Cannon   Cost: 500   Level Require: 2   Mana Cost: 250   Spell Type: Ice   Damage: 650
Ice_Blade   Cost: 250   Level Require: 1   Mana Cost: 100   Spell Type: Ice   Damage: 450
Frost_Blizzard   Cost: 750   Level Require: 5   Mana Cost: 350   Spell Type: Ice   Damage: 850
Arctic_Storm   Cost: 700   Level Require: 6   Mana Cost: 300   Spell Type: Ice   Damage: 800
Flame_Tornado   Cost: 700   Level Require: 4   Mana Cost: 300   Spell Type: Fire   Damage: 850
Breath_of_Fire   Cost: 350   Level Require: 1   Mana Cost: 100   Spell Type: Fire   Damage: 450
Heat_Wave   Cost: 450   Level Require: 2   Mana Cost: 150   Spell Type: Fire   Damage: 600
Lava_Comet   Cost: 800   Level Require: 7   Mana Cost: 550   Spell Type: Fire   Damage: 1000
Hell_Storm   Cost: 600   Level Require: 3   Mana Cost: 600   Spell Type: Fire   Damage: 950

Enter the inventory name to buy this item, or enter X to return to the previous menu

Input: Dagger

Output:
Gaerdal_Ironhand spent 200 money to buy Dagger
Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: Magic_Potion
Output: 
Gaerdal_Ironhand does not require level to buy this item
Enter the inventory name to buy this item, or enter X to return to the previous menu
Input: some_dagger
Output:
Cant find this item
Enter the inventory name to buy this item, or enter X to return to the previous menu

Input:X

Output:
Press S to sell, B to Buy or X to switch hero to transact or exit market
Input:S
Output:
Inventory list of Gaerdal_Ironhand
Weapon:
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Enter the inventory name to sell this item, or enter X to return to previous menu

Input:Dagger

Output:
Gaerdal_Ironhand sell Dagger get 100 money
Inventory list of Gaerdal_Ironhand
Gaerdal_Ironhand does not have any weapon
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Enter the inventory name to sell this item, or enter X to return to previous menu



<Move>
Output:
                
M     M     M   
                
                
                
                
                
H     H     H             
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input:M

Output:
Enter W,A,S,D to move

Input: W

Output:
                
M     M     M   
                
                
                
                
H               
      H     H   
Sehanine_Monnbow enter Bush area, get dexterity increment!

Input: A
Output:
Invalid movement position!
Enter W,A,S,D to move

Or <try to move to the back of monster>
Output:
                
                
                
M H   M H   M H 
                
                
                
                
It is Sehanine_Monnbow Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: M

Output:
Enter W,A,S,D to move

Input:W

Output:
You can not move to the back of monster!

<Recall>
Output:
                
                
M     M     M   
                
                
                
H           H   
H               
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: R
Output:
                
                
                
M     M     M   
                
                
H               
H           H   


<Change Weapon or Armor>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: C

Output:
Dagger   Cost: 200   Level Require: 1   Damage: 250   
Please enter the name of weapon or armor to equip
If you select a weapon while you currently have a weapon equipped, it will be swapped

Input:
Dagger

Output:
Gaerdal_Ironhand equip weapon Dagger, strength increase 250

<Teleport>
Output:
                
                
M     M     M   
                
                
                
H     H     H   
                

It is Sehanine_Monnbow Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: T

Output:
0 Gaerdal_Ironhand with position 6 , 0
2 Muamman_Duathall with position 6 , 6
Please enter the hero index that you wanna teleport to

Input:0

Output:
                
                
M     M     M   
                
                
                
H           H   
H               

<Display hero information>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input:I

Output:
Gaerdal_Ironhand   (Warrior)   Level: 1   Coins: 654   Strength: 770
      Defense: 0   Dexterity: 600   Agility: 500   Health: 100/100   Mana: 100/100   Exp: 7/10
Strength increase by weapon or potion: 250   Defense increase by weapon or potion: 0   Agility increase by weapon or potion: 0   Dexterity increase by weapon or potion: 0
Gaerdal_Ironhand current equips weapon Dagger

Inventory list of Gaerdal_Ironhand
Gaerdal_Ironhand does not have any weapon
Gaerdal_Ironhand does not have any armor
Gaerdal_Ironhand does not have any potion
Spell:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500


It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

<Display Monster Info>
Output:
It is Sehanine_Monnbow Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input:MI

Output:
BigBad-Wolf-2   (Exoskeletons)   Level: 1
      Strength: 150   Defense: 250   Health: 78/100
Casper   (Spirits)   Level: 1
      Strength: 100   Defense: 100   Health: 100/100
Blinky-1   (Spirits)   Level: 1
      Strength: 450   Defense: 350   Health: 100/100

<Cast Spell>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: S

Output:
Lightning_Dagger   Cost: 400   Level Require: 1   Mana Cost: 150   Spell Type: Lighting   Damage: 500
Please enter the name of spell

Input: Lightning_dagger

Or

Output:
Enter the monster index which you wanna cast spell at

Input: 0

Output:
Muamman_Duathalluse spell Ice_Blade to deal 33 damage to monster BigBad-Wolf-1
Ice_Blade type is Ice, also reduce 20% target monster's strength


Output:
Gaerdal_Ironhand does not have enough mana to cast this spell


<Hero Attack>
Output:
It is Gaerdal_Ironhand Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input:A

output:
0 BigBad-Wolf
Enter the monster index to attack corresponding monster:

Input: 0

Or

Output:
No monster in hero attack range


Output:
Gaerdal_Ironhand attack BigBad-Wolf
Gaerdal_Ironhand attack was MISSING!

<Use Potion>
Output:
It is Sehanine_Monnbow Round!
I:Check Hero State, P:Use A Potion, A:Attack
S:Cast A Spell, M:Move, T:Teleport, R:Recall
C: Change Weapon Or Armor, E: Enter Market While Hero In The Nexus
MI:Check Monsters State, Q: Exit game

Input: P

Output:
Healing_Potion   Cost: 250   Level Require: 1   Increase Type: Health   Increase Amount: 100
Please enter the name of potion

Input: Healing_Potion

Output:
Sehanine_Monnbow uses potion Healing_Potion to recover hp
Sehanine_Monnbow current hp is 100

<Hero Kills a Monster>
Output:
Gaerdal_Ironhand attack BigBad-Wolf
Gaerdal_Ironhand attack was EFFECTIVE! BigBad-Wolf has taken 38
BigBad-Wolf dead!
Gaerdal_Ironhand get 500 gold
Gaerdal_Ironhand get 2 experience

<Monsters' Round>
Output:
It is BigBad-Wolf round!
Monster BigBad-Wolf attack Hero Gaerdal_Ironhand
BigBad-Wolf attack was EFFECTIVE! Gaerdal_Ironhand has taken 7
There is not hero in Natsunomeryu attack range, Natsunomeryu move forward!
There is not hero in BigBad-Wolf-1 attack range, BigBad-Wolf-1 move forward!

<Hero Wins>
Output:
Congratulation! You have won the game!
Game Over! Good Bye!


