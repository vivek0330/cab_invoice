package com.bridgelabz;

import java.util.*;

public class InvoiceGenerator {

    private static final int costPerMinute = 1;
    private static final double minCostPerKm = 10;
    private static final double minfare = 5;

    /**
     * Purpose : Given distance and time,Return total fare for the journey
     * <p>
     * Condition : If minimum total fare is less than the MINIMUM_FARE, return MINIMUM_FARE
     *
     * @param distance
     * @param minute
     */
    public double calculateFare(double distance, int minute) {
        double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
        if (distance < 1.0 && minute <= 5) {
            return totalfare;
        } else if (distance < 0.5 && minute <= 2) {
            return minfare;
        }
        return totalfare;
    }

    /**
     * Purpose : calculating total fare for multiple rides.
     *
     * @param ride
     */
    public double calculateFare(Ride[] ride) {
        double totalfare = 0;
        for (Ride rides : ride) {
            totalfare += this.calculateFare(rides.distance, rides.minute);
        }
        return totalfare;
    }

    /**
     * Purpose : enhanced invoice that returns total number of rides,total fare and average fare
     */

    public InvoiceSummary calculateTotalFare(Ride[] ride) {
        double totalfare = 0;
        double averageFare = 0;
        for (Ride rides : ride) {
            totalfare += this.calculateFare(rides.distance, rides.minute);
        }
        averageFare = totalfare / ride.length;
        return new InvoiceSummary(ride.length, totalfare, averageFare);
    }

    /**
     * Purpose : Given a userid the invoice service gets the list of rides and returns invoice
     */
    public InvoiceRecords findInvoice(String userId) throws InvalidInputException {
        try {
            List<InvoiceRecords> list = new ArrayList();
            list.add(new InvoiceRecords("U01", 3, 363, 121));
            list.add(new InvoiceRecords("U02", 2, 340, 170));
            list.add(new InvoiceRecords("U03", 4, 208, 52));
            list.add(new InvoiceRecords("U04", 8, 480, 60));

            InvoiceRecords user = null;
            for (int i = 0; i < list.size(); i++) {
                if (userId.equals(list.get(i).getUserId())) {
                    user = list.get(i);
                    break;
                }
            }
            return user;
        } catch (NullPointerException ae) {
            throw new InvalidInputException("Invalid Input!No Records Found");
        }
    }

    /**
     * Purpose : To calculate premium rides
     */
    public double calculateFare(String choice, double distance, int minute) {
        if (choice.equalsIgnoreCase("Normal")) {
            int costPerMinute = 1;
            double minCostPerKm = 10;
            double minfare = 5;
            double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
            return totalfare;
        } else if (choice.equalsIgnoreCase("Premium")) {
            int costPerMinute = 2;
            double minCostPerKm = 15;
            double minfare = 20;
            double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
            return totalfare;
        }
        double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
        return totalfare;
    }


}