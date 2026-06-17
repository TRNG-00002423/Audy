package vehicle;

public class ElectricCar extends Vehicle implements AutonomousCapable {
    // TODO fields: e.g. kWhPer100Km, pricePerKWh
    private final double kWhPer100Km;
    private final double pricePerKWh;
    private final boolean selfDriveCapable;

    

    public ElectricCar(String make, int modelYear, double kWhPer100Km, double pricePerKWh, boolean selfDriveCapable) {
        super(make, modelYear);
        this.kWhPer100Km = kWhPer100Km;
        this.pricePerKWh = pricePerKWh;
        this.selfDriveCapable = selfDriveCapable;
    }
    


    public double getkWhPer100Km() {
        return kWhPer100Km;
    }



    public double getPricePerKWh() {
        return pricePerKWh;
    }



    @Override
    public double fuelCostPer100Km() {
        return kWhPer100Km * pricePerKWh;
    }

    @Override
    public boolean supportsSelfDrive() {
        return selfDriveCapable;
    }

}
