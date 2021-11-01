package com.observer.demo.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Cache {

	private enum CommandType {
		CLEAR, NUMBER, DIV, MULT, SUB, SUM, IQUAL, DOC, SINAL, PERCENT, RAIZ;
	}

	private static final Cache instancia = new Cache();

	private String textMain = "";
	private String textBuffer = "";
	private boolean replace = false;
	private CommandType lastCommand = null;

	private List<CacheObserver> observers = new ArrayList<>();

	private Cache() {

	}

	public static Cache getInstancia() {
		return instancia;
	}

	public void addObserver(CacheObserver observer) {
		observers.add(observer);
	}

	public String getTextMain() {
		return textMain.isEmpty() ? "0" : textMain;
	}

	public void doCommand(String text) {

		CommandType cdType = getCommandType(text);

		if (cdType == null) {
			return;
		} else if (cdType == CommandType.CLEAR) {
			textMain = "";
			textBuffer = "";
			replace = false;
			lastCommand = null;

		} else if (cdType == CommandType.SINAL) {
			textMain = "-" + textMain;
		} else if (cdType == CommandType.PERCENT) {
			if (!textMain.isEmpty()) {
				Double vl = Double.parseDouble(textMain.replace(",", ".")) / 100;
				textMain = vl.toString().replace(".", ",");
			}
		} else if (cdType == CommandType.RAIZ) {
			if (!textMain.isEmpty()) {
				Double vl = Math.sqrt(Double.parseDouble(textMain.replace(",", ".")));
				textMain = vl.toString().substring(0, 8).replace(".", ",");
			}
		} else if (cdType == CommandType.NUMBER || cdType == CommandType.DOC) {
			textMain = replace ? text : textMain + text;
			replace = false;
		} else {
			replace = true;
			textMain = getResultCommand();
			textBuffer = textMain;
			lastCommand = cdType;
		}
		System.out.println(cdType);
		observers.stream().forEach(o -> o.value(getTextMain()));
	}

	private String getResultCommand() {
		if (lastCommand == null || lastCommand == CommandType.IQUAL) {
			return textMain;
		}
		double numBuffer = Double.parseDouble(textBuffer.replace(",", "."));
		double numMain = Double.parseDouble(textMain.replace(",", "."));

		Double result = 0.0;

		if (lastCommand == CommandType.SUM) {
			result = numBuffer + numMain;
		} else if (lastCommand == CommandType.SUB) {
			result = numBuffer - numMain;
		} else if (lastCommand == CommandType.MULT) {
			result = numBuffer * numMain;
		} else if (lastCommand == CommandType.DIV) {
			result = numBuffer / numMain;
		}
		String str = Double.toString(result).replace(".", ",");
		boolean integer = str.endsWith(",0");
		return integer ? str.replace(",0", "") : str;
	}

	private CommandType getCommandType(String text) {

		if (textMain.isEmpty() && text == "0") {
			return null;
		}

		try {
			Integer.parseInt(text);
			return CommandType.NUMBER;
		} catch (NumberFormatException e) { // When it's not a number...
			if ("AC".equals(text)) {
				return CommandType.CLEAR;
			} else if ("/".equals(text)) {
				return CommandType.DIV;
			} else if ("+".equals(text)) {
				return CommandType.SUM;
			} else if ("X".equals(text)) {
				return CommandType.MULT;
			} else if ("-".equals(text)) {
				return CommandType.SUB;
			} else if (",".equals(text) && !textMain.contains(",")) {
				return CommandType.DOC;
			} else if ("=".equals(text)) {
				return CommandType.IQUAL;
			} else if ("+/-".equals(text) && !textMain.contains("-")) {
				return CommandType.SINAL;
			} else if ("%".equals(text)) {
				return CommandType.PERCENT;
			} else if ("raiz".equals(text)) {
				return CommandType.RAIZ;
			}

		}
		return null;
	}

}
