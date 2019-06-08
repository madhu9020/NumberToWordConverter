package com.converter.wordConverter.service;

import com.converter.wordConverter.exception.NumberNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToWordConverterServiceTest {
	
	@Test
	public void getSingleDigitWordTest() throws NumberNotFoundException {
		
		assertEquals("one", NumberToWordConverterService.getSingleDigitWord(1));
		
		assertEquals("nine", NumberToWordConverterService.getSingleDigitWord(9));
		
	}

	@Test
	public void getTwoDigitWordTest() throws NumberNotFoundException {
		
		assertEquals("twenty", NumberToWordConverterService.getTwoDigitWord(20));
		
		assertEquals("twenty one", NumberToWordConverterService.getTwoDigitWord(21));

		assertEquals("thirty three", NumberToWordConverterService.getTwoDigitWord(33));
		
	}

	@Test(expected = NumberNotFoundException.class)
	public void testNumberNotFoundException(){
		NumberToWordConverterService.getSingleDigitWord(22);
	}

}
