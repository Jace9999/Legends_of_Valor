import Enums.UnitType;

/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 7:53 PM
 * @Description: Koulou grid on the map, extended from SpecialArea. Has ability bonus within the grid.
 */
public class Koulou extends SpecialArea{
    public Koulou(int positionRow, int positionCol, UnitType unitType) {
        super(positionRow, positionCol, unitType);
    }
}
