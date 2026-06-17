package vehicle;

/**
 * TODO: abstract Vehicle — encapsulate fields, declare abstract cost method.
 */
public abstract class Vehicle {
    // TODO private fields + ctor + getters
    private final String make;
    private final int modelYear;

    
    protected Vehicle(String make, int modelYear) {
        this.make = make;
        this.modelYear = modelYear;
    }

    
    public String getMake() {
        return make;
    }




    public int getModelYear() {
        return modelYear;
    }


    public abstract double fuelCostPer100Km();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + make + ", " + modelYear + "]";
    }

}
