package entities;

import java.awt.*;
import view.global;
public class Food {
    Point foodPoint = new Point();
    Color color = global.FOOD_COLOR;

    public Food() {
        super();
    }

    public Point getFoodPoint() {
        return foodPoint;
    }

    public void setFoodPoint(Point foodPoint) {
        this.foodPoint = foodPoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
