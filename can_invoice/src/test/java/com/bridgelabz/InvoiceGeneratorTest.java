package com.bridgelabz;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime_WhenCalculated_ReturnTotalFare()
    {
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(5.0, 5);
        Assert.assertEquals(55.0, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFareGetCalculated_ThenReturnMinimumFare()
    {
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(0.132, 1);
        Assert.assertEquals(5, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculated_ReturnTotalFare()
    {
        Rides[] rides = {new Rides(26.05, 29), new Rides(12.39, 25)};
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
        Assert.assertEquals(438.4, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculated_ReturnInvoiceSummery()
    {
        Rides[] rides = {new Rides(25.12, 40), new Rides(12.39, 25)};
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary summary = new InvoiceSummary(2, 440.1);
        Assert.assertEquals(summary, invoiceSummary);
    }
}