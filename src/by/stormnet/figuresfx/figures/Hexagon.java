package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Hexagon extends Figure {
    private double storona;

    public Hexagon(double cx, double cy, double lineWidth, Color color, double storona) {
        super(Figure.FIGURE_TYPE_HEXAGON, cx, cy, lineWidth, color);
        this.storona = storona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hexagon hexagon = (Hexagon) o;
        return Double.compare(hexagon.storona, storona) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storona);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                        cx,
                        cx + storona * Math.sqrt(3) / 2,
                        cx + storona * Math.sqrt(3) / 2,
                        cx,
                        cx - storona * Math.sqrt(3) / 2,
                        cx - storona * Math.sqrt(3) / 2},
                new double[]{
                        cy - storona,
                        cy - storona / 2,
                        cy + storona / 2,
                        cy + storona,
                        cy + storona / 2,
                        cy - storona / 2
                },
                6
        );
    }
}
