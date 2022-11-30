package Enums;

/**
 * @Author: Jun Zhu
 * @Date: 11/6/2022 12:26 PM
 * @Description: Enum for store player movement type
 */
public enum ForwardType {
    North(0,"W"),
    West(1,"S"),
    South(2,"A"),
    East(3,"D"),

    None(99,"");
    int forwardType;
    String keyboard;

    ForwardType(int forwardType, String keyboard) {
        this.forwardType = forwardType;
        this.keyboard = keyboard;
    }

    public static String getKeyboardByForwardType(int index){
        for(ForwardType type : ForwardType.values()){
            if(index == type.getForwardType()){
                return type.getKeyboard();
            }
        }
        return None.getKeyboard();
    }

    public static int getForwardTypeByKeyboard(String keyboard){
        for(ForwardType type : ForwardType.values()){
            if(type.getKeyboard().equals(keyboard)){
                return type.getForwardType();
            }
        }
        return None.getForwardType();
    }

    public int getForwardType() {
        return forwardType;
    }

    public void setForwardType(int forwardType) {
        this.forwardType = forwardType;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
