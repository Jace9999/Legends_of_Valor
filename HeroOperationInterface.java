import java.util.HashMap;
import java.util.List;

/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 9:24 PM
 * @Description: Contains basic hero operation methods
 */
public interface HeroOperationInterface {
    HashMap usePotion();
    HashMap movement(Map map);
    boolean recall(Map map);
    void useManaPotion(Potion potion);
    HashMap attack(Map map);
    boolean enterMarket();
    HashMap caseSpell(Map map);
    HashMap changeEquipment();
}
