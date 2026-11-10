package com.ecommerce;

public abstract class OrderCheck {

    public abstract boolean check(String productId, String customerId, String address, double amount);

    protected boolean fail(String message) {
        System.out.println("[OrderCheck] Check failed: " + message);
        return false;
    }
}

class AmountCheck extends OrderCheck {

    @Override
    public boolean check(String productId, String customerId, String address, double amount) {
        if (amount <= 0) {
            return fail("invalid amount " + amount);
        }
        if (productId.isEmpty() || customerId.isEmpty() || address.isEmpty()) {
            return fail("order data is empty");
        }
        System.out.println("[OrderCheck] Check passed.");
        return true;
    }
}
