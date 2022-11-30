import Enums.UnitType;

/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 7:53 PM
 * @Description: cave grid on the map, extended from SpecialArea.Has ability bonus within the grid.
 */
public class Cave extends SpecialArea{
    public Cave(int positionRow, int positionCol, UnitType unitType) {
        super(positionRow, positionCol, unitType);
    }
}
