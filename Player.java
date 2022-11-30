import java.util.*;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:27 AM
 * @Description: contains a list of hero and current player position
 */
public class Player {
    private List<Hero> heroes;

    private Map map;
    public void checkHeroesState(){
        for (Hero hero:heroes){
            hero.printHeroState();
        }
        System.out.println();
    }
    public Player(List<Hero> heroes,Map map) {
        this.map = map;
        this.heroes = heroes;
        initiateHero();
    }

    public void initiateHero(){
        System.out.println();
        System.out.println("Please select your heroes!");
        Database.showDBHeroList();
        Scanner scanner = new Scanner(System.in);
        Set<String> checkDuplicate = new HashSet<>();
        for(int i = 1;i<=Database.HERO_SIZE;i++){
            boolean validInput =false;
            int heroNum = 0;
            while (!validInput){
                System.out.println("Enter the index of hero to pick this hero to your team, 0 - 17");
                System.out.println("Pick " + i + " hero");
                String userIndex = scanner.nextLine();
                if (userIndex.matches("[0-9]|(1[0-7])") && !checkDuplicate.contains(userIndex)){
                    checkDuplicate.add(userIndex);
                    heroNum = Integer.parseInt(userIndex);
                    validInput = true;
                }
            }
            this.heroes.add(Database.heroes.get(heroNum));
        }
        List<String> heroIndex = new ArrayList<>();
        System.out.println();
        System.out.println("Now, it is time to assign your heroes to different fronts!");
        for (int i=0;i<Database.HERO_SIZE;i++){
            System.out.println(i + " " + heroes.get(i).getName());
        }
        for (int i=0;i<Database.HERO_SIZE;i++){
            boolean validInput =false;
            int heroNum = 0;
            while(!validInput){
                System.out.println("Enter the hero number to assign hero to " + i + " line");
                String userIndex = scanner.nextLine();
                if (userIndex.matches("[0-2]")){
                    if(!heroIndex.contains(userIndex)){
                        heroIndex.add(userIndex);
                        heroNum = Integer.parseInt(userIndex);
                        Hero hero = heroes.get(heroNum);
                        hero.setPositionRow(7);
                        hero.setPositionCol(i*3);
                        this.map.getBoardArray()[hero.getPositionRow()][hero.getPositionCol()].setHero(hero);
                        hero.setHeroLine(i);
                        validInput = true;
                    }else{
                        System.out.println("You have assigned this hero, please select another hero index!");
                    }
                }
            }
        }
        System.out.println();
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void printHeroInventory(){
        System.out.println("Inventory list of your hero:");
        for(Hero hero : heroes){
            hero.printInventories();
        }
    }

    public Hero searchHeroByName(String name){
        for (Hero hero:heroes){
            if(hero.getName().equals(name)){
                return hero;
            }
        }
        return null;
    }

}
