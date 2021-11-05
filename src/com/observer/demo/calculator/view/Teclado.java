package com.observer.demo.calculator.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.observer.demo.calculator.model.Cache;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private final Color BG_ORANGE = new Color(242, 163, 60);
	private final Color BG_GREEN = new Color(0, 100, 0);
	private final Color BG_CINZA_ESCURO = new Color(68, 68, 68);

	public Teclado() {
		setLayout(new GridLayout(5, 4));

		/* First line */
		addButton("AC", BG_CINZA_ESCURO);
		addButton("raiz", BG_CINZA_ESCURO);
		addButton("%", BG_CINZA_ESCURO);
		addButton("+/-", BG_CINZA_ESCURO);

		/* Second line */
		addButton("9");
		addButton("8");
		addButton("7");
		addButton("/", BG_ORANGE, Color.WHITE);

		/* Third line */
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("X", BG_ORANGE, Color.WHITE);

		/* Fourth line */
		addButton("1");
		addButton("2");
		addButton("3");
		addButton("-", BG_ORANGE, Color.WHITE);

		/* Fifth line */
		addButton(",");
		addButton("0");
		addButton("=", BG_GREEN, Color.WHITE);
		addButton("+", BG_ORANGE, Color.WHITE);

		setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

	public void addButton(String texto) {
		Button botao = new Button(texto);
		botao.addActionListener(this);
		add(botao);
	}

	public void addButton(String texto, Color bg) {
		Button botao = new Button(texto, bg);
		botao.addActionListener(this);
		add(botao);
	}

	public void addButton(String texto, Color bg, Color fg) {
		Button botao = new Button(texto, bg, fg);
		botao.addActionListener(this);
		add(botao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton jb = (JButton) e.getSource();
			Cache.getInstancia().doCommand(jb.getText());
		}

	}
}