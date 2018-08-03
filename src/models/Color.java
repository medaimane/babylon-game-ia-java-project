package models;

import java.io.Serializable;

/**
 *
 * @author medaimane
 */
public class Color implements Serializable {

    private static final long serialVersionUID = 9177103522343277451L;
    private String name;
    private Integer num;

    public Color() {
    }

    public Color(String name) {
        int number;
        switch (name) {
            case "BLANK":
                number = 0;
                break;
            case "RED":
                number = -1;
                break;
            case "BLUE":
                number = -2;
                break;
            case "YELLOW":
                number = -3;
                break;
            case "GREEN":
                number = -4;
                break;
            default:
                number = 0;
                break;
        }
        this.num = number;
        this.name = name;
    }

    public Color(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        int number;
        switch (name) {
            case "BLANK":
                number = 0;
                break;
            case "RED":
                number = -1;
                break;
            case "BLUE":
                number = -2;
                break;
            case "YELLOW":
                number = -3;
                break;
            case "GREEN":
                number = -4;
                break;
            default:
                number = 0;
                break;
        }
        this.num = number;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Color{" + "name=" + name + ", num=" + num + '}';
    }

}
