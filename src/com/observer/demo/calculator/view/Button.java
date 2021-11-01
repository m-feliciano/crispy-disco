package com.observer.demo.calculator.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements ActionListener {

	private final Color BG_CINZA = new Color(99, 99, 99);

	public Button(String text, Color bg) {
		setText(text);
		setBackground(bg);
		setForeground(Color.LIGHT_GRAY);
		comumColor();
	}

	public Button(String text) {
		setText(text);
		setBackground(BG_CINZA);
		setForeground(Color.LIGHT_GRAY);
		comumColor();

	}

	public Button(String texto, Color cor, Color font) {
		setText(texto);
		setBackground(cor);
		setForeground(font);
		comumColor();

	}

	void comumColor() {
		setOpaque(true);
		setFont(new Font("courier", Font.BOLD, 20));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
