package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 10:55 AM
 * @Description: enum for separate three different hero type
 */
public enum HeroType {
    Warrior(1, "Warrior"),
    Sorcerer(2, "Sorcerer"),
    Paladin(3, "Paladin");
    private int typeNum;
    private String typeName;

    HeroType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

    public static String getSymbolByIndex(int index){
        for(HeroType symbol : HeroType.values()){
            if(index == symbol.getTypeNum()){
                return symbol.getTypeName();
            }
        }
        return "";
    }

    public static int getTypeNumBySymbol(String typeName){
        for(HeroType type : HeroType.values()){
            if(type.getTypeName().equals(typeName)){
                return type.getTypeNum();
            }
        }
        return 99;
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
