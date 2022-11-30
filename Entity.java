/**
 * @Author: Jun Zhu
 * @Date: 11/7/2022 1:19 PM
 * @Description: each entity has a common attribute which is name
 */
public class Entity {
    private String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
