package com.demo.paymentMethods;

public class Cash extends PaymentMethod{
    @Override
    public boolean initiatePayment(int amount){
        System.out.println("Making by caash of Rs. "+amount);
        return true;
    }
}
