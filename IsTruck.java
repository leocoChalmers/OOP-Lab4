public interface IsTruck {
    int getBedAngle();
    void setBedAngle(int angle);
    double getCurrentSpeed();
    void gas(double amount);

    default void changeBedAngle(int amount) {
        if (getCurrentSpeed() == 0.0) {
            int newAngle = getBedAngle() + amount;
            if (newAngle >= 0 && newAngle <= 70) {
                setBedAngle(newAngle);
            } else {
                throw new IllegalArgumentException("Angle can't be below 0 or over 70 degrees");
            }
        } else {
            throw new IllegalArgumentException("Can't move while changing bed angle");
        }
    }

    default void raiseBedAngle() {
        changeBedAngle(7);  // Math.abs(7) är onödigt då 7 redan är positivt
    }

    default void lowerBedAngle() {
        changeBedAngle(-7);
    }

}