package com.observer.demo.calculator.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.observer.demo.calculator.model.Cache;
import com.observer.demo.calculator.model.CacheObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements CacheObserver {

	private final JLabel label;
	private String strDisplay;

	public Display() {
		Cache.getInstancia().addObserver(this);

		label = new JLabel(Cache.getInstancia().getTextMain());
		setBackground(new Color(46, 49, 50));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 40));

		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));

		add(label);
	}

	/**
	 * @return the strDisplay
	 */
	public String getStrDisplay() {
		return strDisplay;
	}

	/**
	 * @param strDisplay the strDisplay to set
	 */
	public void setStrDisplay(String strDisplay) {
		this.strDisplay = strDisplay;
	}

	@Override
	public void value(String newString) {
		label.setText(newString);
	}

}
