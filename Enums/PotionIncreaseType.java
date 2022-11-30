package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 11/5/2022 11:47 AM
 * @Description: enum for separate different potion increase type
 */
public enum PotionIncreaseType {

    Health(1, "Health"),
    Strength(2, "Strength"),
    Mana(3, "Mana"),
    Agility(4, "Agility"),
    Health_Mana_Strength_Agility(5, "Health/Mana/Strength/Agility"),
    All(9, "All");
    private int typeNum;
    private String typeName;

    public static String getSymbolByIndex(int index){
        for(PotionIncreaseType increaseType : PotionIncreaseType.values()){
            if(index == increaseType.getTypeNum()){
                return increaseType.getTypeName();
            }
        }
        return "";
    }

    public static int getTypeNumBySymbol(String symbol){
        for(PotionIncreaseType type : PotionIncreaseType.values()){
            if(type.getTypeName().equals(symbol)){
                return type.getTypeNum();
            }
        }
        return 99;
    }


    PotionIncreaseType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

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
}
