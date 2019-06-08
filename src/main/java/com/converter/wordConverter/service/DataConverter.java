package com.converter.wordConverter.service;

import com.converter.wordConverter.exception.NumberNotFoundException;

public class DataConverter {
	
	public static String getConvertedWordForNumber(Integer number) throws NumberNotFoundException {
		
		String convertedWord;
		
		String numberStr = String.valueOf(number);
		
		int numberLength = numberStr.length();
		
		NumberToWordConverterService numberToWordConverterService = new NumberToWordConverterService();
		
		switch(numberLength) {
			case 1 :
				convertedWord = numberToWordConverterService.getSingleDigitWord(number);
				break;
			case 2 :
				convertedWord = numberToWordConverterService.getTwoDigitWord(number);
				break;
			case 3 :
				String unitDenominator = numberToWordConverterService.getSingleDigitWord(Integer.parseInt(String.valueOf(numberStr.charAt(0))));
				Integer numberSubStr = Integer.parseInt(String.valueOf(numberStr.substring(1, 3)));
				if(!numberStr.substring(1, 3).equals("00")) {
					if(String.valueOf(numberSubStr).length() == 1 && !String.valueOf(numberSubStr).equals("0")) {
						String tensDenominator = numberToWordConverterService.getSingleDigitWord(numberSubStr);
						convertedWord = unitDenominator+" hundred and "+tensDenominator;
					}else {
						String tensDenominator = numberToWordConverterService.getTwoDigitWord(Integer.parseInt(String.valueOf(numberStr.substring(1, 3))));
						convertedWord = unitDenominator+" hundred and "+tensDenominator;
					}
				} else {
					convertedWord = unitDenominator + " hundred";
				}
				break;
			case 4 :
				unitDenominator = numberToWordConverterService.getSingleDigitWord(Integer.parseInt(String.valueOf(numberStr.charAt(0))));
				if(!numberStr.substring(1, 4).equals("000")) {
					convertedWord = unitDenominator + " thousand " +getConvertedWordForNumber(Integer.parseInt(numberStr.substring(1, 4)));
				} else {
					convertedWord = unitDenominator + " thousand";
				}
				break;
			default:
				throw new NumberNotFoundException("Length more than 5 not supported");
		
		}
		
		return convertedWord;
	}

}
