package com.bridgelabz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = null;

    /**
     * Purpose : To create object before any test case is called so that it improves Redundancy of code
     */
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    /**
     * Step 1.1
     * Purpose : Given distance and time,
     * return total fare
     */
    @Test
    public void givenDistanceAndMinute_shouldReturn_totalFare() {

        double distance = 20.0;
        int minute = 15;
        double fare = invoiceGenerator.calculateFare(distance, minute);
        assertEquals(215, fare, 0.0);
    }

    /**
     * Step 1.2
     * Purpose: Given distance and time,
     * return minimum fare as 5
     */
    @Test
    public void givenDistanceAndMinute_shouldReturn_minFare() {
        double distance = 0.3;
        int minute = 2;
        double fare = invoiceGenerator.calculateFare(distance, minute);
        assertEquals(5, fare, 0.0);
    }

    /**
     * Step 2.1
     * Purpose: Given distance and time for multiple rides,
     * return total fare.
     */
    @Test
    public void givenDistanceAndMinute_shouldReturn_totalFare_forMultipleRides() {
        Ride[] ride = {
                new Ride(20.0, 15),
                new Ride(0.3, 2),
                new Ride(5.0, 3)
        };
        double fare = invoiceGenerator.calculateFare(ride);
        assertEquals(273, fare, 0.0);
    }

    @Test
    public void givenDistanceAndMinute_shouldReturntotalFare_forMultipleRides() {
        Ride[] ride = {
                new Ride(2.0, 15),
                new Ride(0.5, 1),
                new Ride(50.0, 30)
        };
        double fare = invoiceGenerator.calculateFare(ride);
        assertEquals(571, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturn_invoiceSummary() {
        Ride[] ride = {
                new Ride(20.0, 15),
                new Ride(0.3, 2),
                new Ride(5.0, 3)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateTotalFare(ride);
        InvoiceSummary expected = new InvoiceSummary(3, 273, 91);
        assertEquals(expected, invoiceSummary);
    }

    @Test
    public void givenMultipleRides_shouldReturn_InvoiceSummary() {
        Ride[] ride = {
                new Ride(2.0, 14),
                new Ride(0.5, 1),
                new Ride(50.0, 30)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateTotalFare(ride);
        InvoiceSummary expected = new InvoiceSummary(3, 570, 190);
        assertEquals(expected, invoiceSummary);
    }

    @Test
    public void givenUserId_shouldReturn_InvoiceSummary() throws InvalidInputException {
        String user = "U01";
        InvoiceRecords invoicerecords = invoiceGenerator.findInvoice(user);
        InvoiceRecords expected = new InvoiceRecords("U01", 3, 363, 121);
        assertEquals(expected, invoicerecords);
    }

    @Test
    public void givenUserId_shouldreturn_InvoiceSummary() throws InvalidInputException {
        String user = "U04";
        InvoiceRecords invoicerecords = invoiceGenerator.findInvoice(user);
        InvoiceRecords expected = new InvoiceRecords("U04", 8, 480, 60);
        assertEquals(expected, invoicerecords);
    }

    @Test
    public void givenUserId_shouldReturn_InvalidInputException() throws InvalidInputException {
        String user = " ";
        InvoiceRecords invoicerecords = invoiceGenerator.findInvoice(user);
        assertEquals(null, invoicerecords);
    }

    @Test
    public void givenChoice_shouldReturn_TotalFare() {
        String choice = "Normal";
        double distance = 20.0;
        int minute = 15;
        double fare = invoiceGenerator.calculateFare(choice, distance, minute);
        assertEquals(215, fare, 0.0);

    }


    @Test
    public void givenChoice_shouldReturn_TotalFareforGivenChoice() {
        String choice = "Premium";
        double distance = 10.0;
        int minute = 5;
        double fare = invoiceGenerator.calculateFare(choice, distance, minute);
        assertEquals(160, fare, 0.0);

    }
}