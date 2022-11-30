import Enums.UnitType;

/**
 * @Author: Jun Zhu
 * @Date: 11/29/2022 8:32 PM
 * @Description: TODO
 */
public class SpecialArea {
    private int positionRow;
    private int positionCol;
    private UnitType unitType;

    public SpecialArea(int positionRow, int positionCol, UnitType unitType) {
        this.positionRow = positionRow;
        this.positionCol = positionCol;
        this.unitType = unitType;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}
