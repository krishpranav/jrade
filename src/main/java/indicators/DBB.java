package indicators;

import java.util.List;

public class DBB {
    private double closingPrice;
    private double standardDeviation;
    private final int period;
    private double upperBand;
    private double upperMidBand;
    private double middleBand;
    private double lowerMidBand;
    private double lowerBand;
    private String explanation;
    private SMA sma;

    public DBB(List<Double> closingPrice, int period) {
        this.period = period;
        this.sma = new SMA(closingPrice, period);
        init(closingPrice);
    }

    @Override
    public double get() {
        if ((upperBand - lowerBand) / middleBand < 0.05)
            return 0;
        if (upperMidBand < closingPrice && closingPrice <= upperBand)
            return 1;
        if (lowerBand < closingPrice && closingPrice <= lowerMidBand)
            return -1;
        else
            return 0;
    }

    @Override
    public double getTemp(double newPrice) {
        return 0;
    }

    @Override 
    public void init(List<Double> closingPrice) {
    }

    @Override
    public int check(double newPrice) {
        if (getTemp(newPrice) == 1) {
            explanation = "Price in DBB buy zone";
        }
        if (getTemp(newPrice) == -1) {
            explanation = "Price in DBB self zone";
            return -1;
        }

        explanation = "";
        return 0;
    }

    @Override
    public String getExplanation() {
        return explanation;
    }
}
