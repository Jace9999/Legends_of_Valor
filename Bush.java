import Enums.UnitType;

/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 7:52 PM
 * @Description: bush grid on the map, extended from SpecialArea.Has ability bonus within the grid.
 */
public class Bush extends SpecialArea{
    public Bush(int positionRow, int positionCol, UnitType unitType) {
        super(positionRow, positionCol, unitType);
    }
}
