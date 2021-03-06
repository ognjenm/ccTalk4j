package com.github.pierrebeucher.cctalk4j.device.bill;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BillTest {

	private Bill bill = new Bill((byte) 1, "XO", "0010", "A", BigDecimal.valueOf(1000));
	private Bill john = new Bill((byte) 1, "XO", "0010", "A", BigDecimal.valueOf(1000));
	private Bill claire = new Bill((byte) 5, "XO", "0020", "D", BigDecimal.valueOf(2000));
	
	@Test
	public void toByteArray(){
		//1 X O 0 0 1 0 A
		byte[] expected = new byte[]{0x01, 0x58, 0x4f, 0x30, 0x30, 0x31, 0x30, 0x41};
		Assert.assertEquals(bill.toByteArray(), expected);
	}
	
	@Test
	public void billType() {
		Assert.assertEquals(bill.billType(), 1);
	}

	@Test
	public void countryCode() {
		Assert.assertEquals(bill.countryCode(), "XO");
	}

	@Test
	public void issueCode() {
		Assert.assertEquals(bill.issueCode(), "A");
	}

	@Test
	public void rawIdentification() {
		Assert.assertEquals(bill.rawIdentification(), "XO0010A");
	}

	@Test
	public void valueCode() {
		Assert.assertEquals(bill.valueCode(), "0010");
	}
	
	@Test
	public void getCurrencyValue(){
		Assert.assertEquals(bill.getCurrencyValue(), BigDecimal.valueOf(1000));
	}
	
	@Test
	public void equals_true() {
		Assert.assertTrue(bill.equals(john));
	}
	
	@Test
	public void equals_false() {
		Assert.assertFalse(bill.equals(claire));
	}
}
