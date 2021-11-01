package com.simple.calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField value1;
	private JTextField value2;

	public Calculator() {
		setBackground(Color.WHITE);
		setFont(new Font("Ubuntu", Font.PLAIN, 16));
		setForeground(Color.WHITE);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 265);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 1, 1));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel LbValor1 = new JLabel("First value: ");
		LbValor1.setBackground(Color.WHITE);
		LbValor1.setFont(new Font("Ubuntu", Font.BOLD, 16));
		LbValor1.setForeground(Color.ORANGE);
		LbValor1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(LbValor1);

		value1 = new JTextField();
		value1.setBackground(Color.WHITE);
		value1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		value1.setForeground(Color.BLACK);
		value1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(value1);
		value1.setColumns(10);

		JLabel LbValor2 = new JLabel("Second value: ");
		LbValor2.setBackground(Color.WHITE);
		LbValor2.setFont(new Font("Ubuntu", Font.BOLD, 16));
		LbValor2.setForeground(Color.ORANGE);
		LbValor2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(LbValor2);

		value2 = new JTextField();
		value2.setBackground(Color.WHITE);
		value2.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		value2.setForeground(Color.BLACK);
		value2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(value2);
		value2.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel LbResultado = new JLabel("Result: ");
		LbResultado.setFont(new Font("Ubuntu Mono", Font.BOLD, 14));
		LbResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		LbResultado.setForeground(Color.GRAY);
		panel_3.add(LbResultado);

		JLabel Resultado = new JLabel(" ");
		Resultado.setFont(new Font("Ubuntu Mono", Font.BOLD, 22));
		Resultado.setBackground(Color.WHITE);
		Resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		Resultado.setForeground(Color.LIGHT_GRAY);
		panel_3.add(Resultado);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 4, 5, 5));

		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(e -> {
			double x = Double.parseDouble(value1.getText());
			double y = Double.parseDouble(value2.getText());
			Resultado.setText(String.format("%.2f", x + y));

		});
		btnNewButton_4.setFont(new Font("Ubuntu", Font.BOLD, 13));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setForeground(Color.BLACK);
		panel.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.addActionListener(e -> {
			double x = Double.parseDouble(value1.getText());
			double y = Double.parseDouble(value2.getText());
			Resultado.setText(String.format("%.2f", x - y));
		});
		btnNewButton_3.setFont(new Font("Ubuntu", Font.BOLD, 13));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(Color.BLACK);
		panel.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("x");
		btnNewButton_2.addActionListener(e -> {
			double x = Double.parseDouble(value1.getText());
			double y = Double.parseDouble(value2.getText());
			Resultado.setText(String.format("%.2f", x * y));
		});

		btnNewButton_2.setFont(new Font("Ubuntu", Font.BOLD, 13));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.BLACK);
		panel.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("/");
		btnNewButton_1.addActionListener(e -> {
			double x = Double.parseDouble(value1.getText());
			double y = Double.parseDouble(value2.getText());
			if (x == 0 || y == 0)
				Resultado.setText("Undefined");
			else
				Resultado.setText(String.format("%.2f", x / y));
		});
		btnNewButton_1.setFont(new Font("Ubuntu", Font.BOLD, 13));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		panel.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 5, 5));

		JButton btnNewButton = new JButton("CLEAN");
		btnNewButton.setFont(new Font("Ubuntu", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(e -> {
			value1.setText("");
			value2.setText("");
			Resultado.setText("");
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
