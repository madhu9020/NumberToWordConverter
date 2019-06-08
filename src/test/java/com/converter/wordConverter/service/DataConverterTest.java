package com.converter.wordConverter.service;

import com.converter.wordConverter.exception.NumberNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataConverterTest{

    @Test
	public void getConvertedWordForNumberTest() throws NumberNotFoundException {
		
		assertEquals("one", DataConverter.getConvertedWordForNumber(1));
		
		assertEquals("eleven", DataConverter.getConvertedWordForNumber(11));
		
		assertEquals("twenty", DataConverter.getConvertedWordForNumber(20));
		
		assertEquals("one hundred and one", DataConverter.getConvertedWordForNumber(101));

		assertEquals("two hundred", DataConverter.getConvertedWordForNumber(200));

		assertEquals("two hundred and fifty", DataConverter.getConvertedWordForNumber(250));

		assertEquals("nine hundred and ninety nine", DataConverter.getConvertedWordForNumber(999));

		assertEquals("three thousand five hundred and thirty", DataConverter.getConvertedWordForNumber(3530));

		assertEquals("nine thousand", DataConverter.getConvertedWordForNumber(9000));
		
	}

}
