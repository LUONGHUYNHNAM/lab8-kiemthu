package com.poly.test_subject.lab4Test;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import com.poly.test_subject.lab4.VatCalculator;

public class TestVatCal {
 
    VatCalculator vat = new VatCalculator();

    @Test
    public void testGetVatAmount() {    
        double expect = 10;
        Assert.assertEquals(expect, vat.getVatOnMount(100));
        Assert.assertNotEquals(expect, vat.getVatOnMount(120));
    }

}
