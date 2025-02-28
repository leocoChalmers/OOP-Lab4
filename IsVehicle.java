/*
public interface IsVehicle {
    default void move(){
        switch (direction){
            case 0:
                position[1] += currentSpeed;
                break;
            case 1:
                position[0] += currentSpeed;
                break;
            case 2:
                position[1] -= currentSpeed;
                break;
            case 3:
                position[0] -= currentSpeed;
                break;
        }
    }
    private int changeDirection(int i){return (4 + IsVehicle.direction + i) % 4;}
    default void turnLeft(){
        direction = changeDirection(-1);
    }
    default void turnRight(){
        direction = changeDirection(1);
    }

        default double[] getPosition(){
            return position;
        }

        default void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }

        default void decrementSpeed(double amount){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }
        default double speedFactor(){
            return enginePower * 0.01;
        }

        default int getNrDoors(){
            return nrDoors;
        }
        default double getEnginePower(){
            return enginePower;
        }

        default double getCurrentSpeed(){
            return currentSpeed;
        }

        default Color getColor(){
            return color;
        }

        default void setColor(Color clr){color = clr;}

        default void startEngine(){
            currentSpeed = 0.1;
            engineOn = true;
        }

        default void stopEngine(){
            currentSpeed = 0;
            engineOn = false;
        }

        default String getModelName(){return modelName;}

        default void gas(double amount){
            if(amount <= 1 && amount>0 && engineOn){
                incrementSpeed(amount);
            } else {
                throw new IllegalArgumentException("Too much gas");
            }
        }

        default void brake(double amount){
            if (amount <= 1 && amount >0){
                decrementSpeed(amount);
            }else{
                throw new IllegalArgumentException("Too much brake");
            }
        }
    }

}*/
