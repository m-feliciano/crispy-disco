package com.observer.demo.calculator;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import com.observer.demo.calculator.view.Display;
import com.observer.demo.calculator.view.Teclado;

@SuppressWarnings("serial")
public class Calculator2 extends JFrame {

	public Calculator2() {

		super("Calculator");

		setCustomLayout();
		
		setSize(265, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setCustomLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new DimensionUIResource(233, 65));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		
		new Calculator2();
	}
}