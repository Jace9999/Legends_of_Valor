package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:02 AM
 * @Description: enum for separate different spell type
 */
public enum SpellType {
    Ice(1, "Ice"),
    Fire(2, "Fire"),
    Lighting(3, "Lighting");
    private int typeNum;
    private String typeName;

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    SpellType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }
}
