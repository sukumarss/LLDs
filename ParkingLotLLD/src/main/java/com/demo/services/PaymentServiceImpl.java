package com.demo.services;

import com.demo.interfaces.PaymentService;
import com.demo.paymentMethods.Cash;
import com.demo.paymentMethods.CreditCard;
import com.demo.paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public void acceptCash(int amount) {
        PaymentMethod cash = new Cash();
        cash.initiatePayment(amount);
    }

    @Override
    public void acceptCreditCard(String cardNumber, int cvv, int amount) {
        PaymentMethod creditCard = new CreditCard(cardNumber,cvv);
        creditCard.initiatePayment(amount);
    }
}
