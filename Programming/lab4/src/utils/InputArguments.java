package assemblyline.utils;

import java.util.Hashtable;

import assemblyline.vehicles.*;

public class InputArguments {
        /**
     * Asks user to input all the required arguments for creating a new instance of a vehicle class.
     * @param isRequired is it required that all parameters are inputted?
     * @param skip should name, vehicle type and fuel type be skipped?
     * @return a hashlist where key is a name of the variable and value is a corresponding object
     */
    public static Hashtable<String, Object> inputArguments(boolean isRequired, boolean skip) {
        Hashtable<String, Object> toReturn = new Hashtable<String, Object>();
        boolean correct = skip;
        String raw;

        //This code sucks, but I don't care enough to make it look good.
        //I know that nextInt, nextLong and nextDouble exist, but using them 
        //leads to a bunch of problems with nextLine.

        //21.02.2022 UPDATE: Wow, now it's even worse now.

        // =============== Argument input section ===============
        while (!correct) {
            IO.print("Name> ");
            raw = IO.nextLine();
            //if you inputted anything, we might as well check if it's correct
            if (shouldCheck(isRequired, raw)) {
                correct = Vehicle.isNameCorrect(raw);
                if (correct) {
                    toReturn.put("name", raw);
                } else {
                    IO.print(ErrorMessages.NAME_EMPTY);
                }
            } else {
                correct = true;
            }
        }

        // =============== Coordinates input section ===============
        correct = false;
        double x;
        while (!correct) {
            IO.print("X position (Double)> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    x = Double.parseDouble(raw);
                    correct = Coordinates.isXCorrect(x);
                    if (!correct) {
                        IO.print(ErrorMessages.X_OUT_OF_RANGE);
                    } else {
                        toReturn.put("x", x);
                    }
                } catch(Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }
        
        correct = false;
        long y;
        while (!correct) {
            IO.print("Y position (Long)> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    y = Long.parseLong(raw);
                    correct = Coordinates.isYCorrect(y);
                    if (!correct) {
                        IO.print(ErrorMessages.Y_OUT_OF_RANGE);
                    } else {
                        toReturn.put("y", y);
                    }
                } catch(Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }
        // =============== Coordinates input section END ===============

        correct = false;
        while (!correct) {
            IO.print("Engine power (Integer)> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    int enginePower = Integer.parseInt(raw);
                    correct = Vehicle.isEnginePowerCorrect(enginePower);

                    if (correct) {
                        toReturn.put("enginePower", enginePower);
                    } else {
                        IO.print(ErrorMessages.ENGINE_POWER_OUT_OF_RANGE);
                    }
                } catch (Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }

        correct = false;
        while (!correct) {
            IO.print("Number of wheels (Integer)> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    int numberOfWheels = Integer.parseInt(raw);
                    correct = Vehicle.isNumberOfWheelsCorrect(numberOfWheels);
                    if (correct) {
                        toReturn.put("numberOfWheels", numberOfWheels);
                    } else {
                        IO.print(ErrorMessages.NUMBER_OF_WHEELS_OUT_OF_RANGE);
                    }
                } catch(Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }  

        // =============== Vehicle type input ===============
        if (!skip) {
            IO.print("%nVehicle types:%n");
            for (int i = 0; i < VehicleType.values().length; i++) {
                IO.print("%s%n", VehicleType.values()[i]);
            }
        }

        correct = skip;
        while (!correct) {
            IO.print("Vehicle type> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    VehicleType vehicleType = VehicleType.valueOf(raw.toUpperCase().trim());
                    toReturn.put("vehicleType", vehicleType);
                    //There's actually no reason to check if VehicleType is correct, because
                    //valueOf can't return null
                    correct = true;
                } catch(Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }

        // =============== Fuel type input ===============
        if (!skip) {
            IO.print("%nFuel types:%n");
            for (int i = 0; i < FuelType.values().length; i++) {
                IO.print("%s%n", FuelType.values()[i]);
            }
        }

        correct = skip;
        while (!correct) {
            IO.print("Fuel Type> ");
            raw = IO.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    FuelType fuelType = FuelType.valueOf(raw.toUpperCase().trim());
                    toReturn.put("fuelType", fuelType);
                    correct = true;
                    //There's actually no reason to check if VehicleType is correct, because
                    //valueOf can't return null
                } catch(Exception e) {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }
        // =============== Argument input section END ===============

        return toReturn;
    }

    /**
     * Asks user to input all the required arguments for creating a new instance of a vehicle class.
     * @param isRequired is it required that all parameters are inputted?
     * @return a hashlist where key is a name of the variable and value is a corresponding object
     */
    public static Hashtable<String, Object> inputArguments(boolean isRequired) {
        return inputArguments(isRequired, false);
    }

    /**
     * Returns whether you should or should check value correctness.
     * If it's not required, but something was inputted, value should still be checked.
     * @param isRequired
     * @param string
     * @return whether you should or should check value correctness
     */
    public static boolean shouldCheck(boolean isRequired, String string) {
        return isRequired || !string.trim().equals("");
    }
}
