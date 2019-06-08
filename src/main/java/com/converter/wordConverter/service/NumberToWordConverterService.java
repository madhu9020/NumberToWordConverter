package com.converter.wordConverter.service;

import java.util.Map;

import com.converter.wordConverter.exception.NumberNotFoundException;
import com.converter.wordConverter.util.DataUtil;

public class NumberToWordConverterService {
	
	public static String getSingleDigitWord(Integer number) {

		if (number != null) {
			Map<Integer, String> numberWordMap = DataUtil.getSingleDigitMap();

			if (numberWordMap.containsKey(number)) {
				return numberWordMap.get(number);
			} else {
				throw new NumberNotFoundException("Number not found");
			}
		}

		return null;
	}
	
	public static String getTwoDigitWord(Integer number) {
		String word = null;

		String inputNumberStr = String.valueOf(number);

		if (number != null) {

			Map<Integer, String> singleDigitNumberWordMap = DataUtil.getSingleDigitMap();
			Map<Integer, String> twoDigitNumberWordMap = DataUtil.getTwoDigitMap();

			if (twoDigitNumberWordMap.containsKey(number)) {
				word = twoDigitNumberWordMap.get(number);
			} else {
				String twoDigitWord = twoDigitNumberWordMap.get(Integer.parseInt(inputNumberStr.charAt(0) + "0"));
				String oneDigitWord = singleDigitNumberWordMap.get(Integer.parseInt(String.valueOf(inputNumberStr.charAt(1))));
				word = twoDigitWord + " " + oneDigitWord;
			}

			if (word == null)
				throw new NumberNotFoundException("Number not found");

		}

		return word;
	}

}
