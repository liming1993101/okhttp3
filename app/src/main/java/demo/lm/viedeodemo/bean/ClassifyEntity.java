package demo.lm.viedeodemo.bean;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ClassifyEntity{
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private String name;
    private int type;
}
