package Project;
import java.util.*;
public class plantRecycling {


    public static void main(String[] args) {
        System.err.println("---------------Recycling Service---------------");
        Factory factory = new Factory();
        factory.output();
        Price price = new Price(3.80, 1.9, 6.20, 120, 100);
        price.printPrice();
        EnergySaving energy = new EnergySaving(3.5, 0.42, 5.8, 64);
        energy.printEnergy();
    }
}

class TankCountCalculator {
    private int employees = 1, dailyCapacity = 1, waste = 1, hours = 1, days = 1;
    Scanner keyboard = new Scanner(System.in);
    protected static int tankCount = 0;

    public void getInputs() {
        boolean validEmployees = true, validDailyCapacity = true, validWaste = true, validHours = true, validDays = true;
        while (validEmployees) {
            try {
                System.out.println("Enter the number of employees (1-1000):");
                employees = keyboard.nextInt();
                if (employees < 1 || employees > 1000) {
                    throw new ArithmeticException();
                } else {
                    validEmployees = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                validEmployees = true;
                keyboard.next();
            } catch (ArithmeticException e) {
                System.out.println("Invalid value! Please enter a number between 1 and 1000.");
                validEmployees = true;
            }
        }
        while (validDailyCapacity) {
            try {
                System.out.println("Enter the daily capacity in percentage (1-100):");
                dailyCapacity = keyboard.nextInt();
                if (dailyCapacity < 1 || dailyCapacity > 100) {
                    throw new ArithmeticException();
                } else {
                    validDailyCapacity = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                validDailyCapacity = true;
                keyboard.next();
            } catch (ArithmeticException e) {
                System.out.println("Invalid value! Please enter a number between 1 and 100.");
                validDailyCapacity = true;
            }
        }
        while (validWaste) {
            try {
                System.out.println("Enter the monthly waste amount in tons (1-100):");
                waste = keyboard.nextInt();
                if (waste < 1 || waste > 100) {
                    throw new ArithmeticException();
                } else {
                    validWaste = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                validWaste = true;
                keyboard.next();
            } catch (ArithmeticException e) {
                System.out.println("Invalid value! Please enter a number between 1 and 100.");
                validWaste = true;
            }
        }
        while (validHours) {
            try {
                System.out.println("Enter the monthly working hours (1-744):");
                hours = keyboard.nextInt();
                if (hours < 1 || hours > 744) {
                    throw new ArithmeticException();
                } else {
                    validHours = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                validHours = true;
                keyboard.next();
            } catch (ArithmeticException e) {
                System.out.println("Invalid value! Please enter a number between 1 and 744.");
                validHours = true;
            }
        }
        while (validDays) {
            try {
                System.out.println("Enter the number of working days per month (1-31):");
                days = keyboard.nextInt();
                if (days < 1 || days > 31) {
                    throw new ArithmeticException();
                } else {
                    validDays = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                validDays = true;
                keyboard.next();
            } catch (ArithmeticException e) {
                System.out.println("Invalid value! Please enter a number between 1 and 31.");
                validDays = true;
            }
        }
    }

    public void calculateTankCount() {
        tankCount = (int) Math.ceil(waste * 1000 / (employees * dailyCapacity * hours * days));
        System.out.println("The number of tanks needed for recycling: " + tankCount);
    }
}

class Factory {
    public void output() {
        TankCountCalculator calculator = new TankCountCalculator();
        calculator.getInputs();
        calculator.calculateTankCount();
    }
}

class Price {
    private double paperPrice, glassPrice, plasticPrice;
    private int paperWeight, glassWeight;

    public Price(double paperPrice, double glassPrice, double plasticPrice, int paperWeight, int glassWeight) {
        this.paperPrice = paperPrice;
        this.glassPrice = glassPrice;
        this.plasticPrice = plasticPrice;
        this.paperWeight = paperWeight;
        this.glassWeight = glassWeight;
    }

    public void printPrice() {
        System.out.println("Price List:");
        System.out.println("Paper: $" + paperPrice + " per kg, weight per unit: " + paperWeight + " kg");
        System.out.println("Glass: $" + glassPrice + " per kg, weight per unit: " + glassWeight + " kg");
        System.out.println("Plastic: $" + plasticPrice + " per kg");
    }
}

class EnergySaving {
    private double paperSaving, glassSaving, plasticSaving;
    private int recyclingRate;

    public EnergySaving(double paperSaving, double glassSaving, double plasticSaving, int recyclingRate) {
        this.paperSaving = paperSaving;
        this.glassSaving = glassSaving;
        this.plasticSaving = plasticSaving;
        this.recyclingRate = recyclingRate;
    }

    public void printEnergy() {
        System.out.println("Energy Saving:");
        System.out.println("Paper: " + paperSaving + " kg CO2 saving per kg recycling, recycling rate: " + recyclingRate + "%");
        System.out.println("Glass: " + glassSaving + " kg CO2 saving per kg recycling, recycling rate: " + recyclingRate + "%");
        System.out.println("Plastic: " + plasticSaving + " kg CO2 saving per kg recycling, recycling rate: " + recyclingRate + "%");
    }
}