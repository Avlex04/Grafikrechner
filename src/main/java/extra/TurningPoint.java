package extra;

public class TurningPoint extends SpecialPoint {

    boolean isGlobal;
    double xValue;
    double yValue;

    public TurningPoint( double xValue, double yValue, boolean isGlobal) {
        super(xValue, yValue);
        this.isGlobal = isGlobal;
    }
}