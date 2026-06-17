package vehicle;

public class GasCar extends Vehicle {
    // TODO fields: e.g. litersPer100Km, pricePerLiter
    private final double litersPer100Km;
    private final double pricePerLiter;
    
    public GasCar(String make, int modelYear, double litersPer100Km, double pricePerLiter) {
        super(make, modelYear);
        this.litersPer100Km = litersPer100Km;
        this.pricePerLiter = pricePerLiter;
    }

    public double getLitersPer100Km() {
        return litersPer100Km;
    }



    public double getPricePerLiter() {
        return pricePerLiter;
    }



    @Override
    public double fuelCostPer100Km() {
        return litersPer100Km * pricePerLiter;
    }
}
