package org.example.enums;

public enum TransactionType {
    CASH_WITHDRAW,
    BALANCE_CHECK;
    public static void showAllStates(){
        for(TransactionType type : TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
