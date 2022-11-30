package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 10/30/2022 11:02 AM
 * @Description: enum for separate different unit type
 */
public enum UnitType {
    Inaccessible_Type(41),
    Common_Type(45),
    Bush_Type(42),
    Cave_Type(43),
    Koulou_Type(44),
    Hero_Nexus(47),
    Monster_Nexus(46);
    private int typeNum;
    UnitType(int typeNum) {
        this.typeNum = typeNum;
    }

//    public static String getSymbolByIndex(int index){
//        for(UnitType symbol : UnitType.values()){
//            if(index == symbol.getTypeNum()){
//                return symbol.getSymbol();
//            }
//        }
//        return "";
//    }
//
//
//
//    public static int getTypeNumBySymbol(String symbol){
//        for(UnitType type : UnitType.values()){
//            if(type.getSymbol().equals(symbol)){
//                return type.getTypeNum();
//            }
//        }
//        return 99;
//    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }
}
