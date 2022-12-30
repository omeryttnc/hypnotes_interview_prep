package com.hypnotes.stepDefinitions.UIStepDef;

import org.junit.Assert;
import org.junit.Test;

public class deneme {
    @Test
    public void name() {
        String amount = "15.00";
        String subTotal = "15.00";
        String saleTotal = "3.00";
        int amountD =15;






        Assert.assertEquals(amountD, Double.parseDouble(amount), 0.0);
        Assert.assertEquals(Double.parseDouble(subTotal)*0.2,Double.parseDouble(saleTotal),0);
    }
}
