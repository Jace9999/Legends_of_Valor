package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 11/7/2022 1:18 PM
 * @Description: enum for separate three different monster type
 */
public enum MonsterType {
    Exoskeletons(1, "Exoskeletons"),
    Dragons(2, "Dragons"),
    Spirits(3, "Spirits");
    private int typeNum;
    private String typeName;

    MonsterType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

    public static String getNameByNum(int index){
        for(MonsterType symbol : MonsterType.values()){
            if(index == symbol.getTypeNum()){
                return symbol.getTypeName();
            }
        }
        return "";
    }

    public static int getTypeNumByName(String typeName){
        for(MonsterType type : MonsterType.values()){
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
