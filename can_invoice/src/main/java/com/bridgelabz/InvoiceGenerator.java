package com.bridgelabz;

public class InvoiceGenerator {

    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    public static void main(String[] args) {
        System.out.println("WELCOME TO CAB INVOICE GENERATOR");
    }

    public double getTotalFare(double distance, int time) {
        double totalFare = (COST_PER_KILOMETER * distance) + (COST_PER_MINUTE * time);
        totalFare = Math.max(totalFare, MINIMUM_FARE);
        return totalFare;
    }

    public double getTotalFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += ride.distance * COST_PER_KILOMETER + ride.time * COST_PER_MINUTE;
        }
        totalFare = Math.max(totalFare, MINIMUM_FARE);
        return totalFare;
    }

    public InvoiceSummary getInvoiceSummary(Rides[] rides) {
        double totalFare = getTotalFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
}
