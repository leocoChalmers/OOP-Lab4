public interface Loadable<T extends IsCar> {
    void loadVehicle(T vehicle);
    void unloadVehicle();
}
