package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Calculator2 extends JFrame implements ActionListener {

	private double num1, num2;
	Container c, n, n2;
	JButton c1, c2, c3, c4;
	Boolean adicao = false;	Boolean subtracao = false;
	Boolean divisao = false; Boolean multiplicacao = false;
	Boolean raiz = false; Boolean raizCubica = false;
	Boolean potencia = false;
	private String display = "";
	private JButton jbN1, jbN2, jbN3, jbN4, jbN5, jbN6, jbN7, jbN8, jbN9, jbN0;
	private JButton jjIgual, jjSoma, jjSub, jjMult, jjPi, jjDivide, jjClean, 
		jjRaiz, jjRaizCubica, jjPot, jjPonto;
	private JLabel jjResult;

	private final Color BG_ORANGE = new Color(229, 153, 20);

	public Calculator2() {

		super("Calculator");
		getContentPane().setForeground(Color.BLACK);
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);

		c = getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		c.setBackground(Color.BLACK);
		jjClean = new JButton("Clean");
		jjClean.setFont(new Font("Ubuntu", Font.BOLD, 20));
		jjClean.setBackground(Color.BLACK);
		jjClean.setForeground(Color.LIGHT_GRAY);

		jjResult = new JLabel(" ");
		jjResult.setBackground(Color.BLACK);
		jjResult.setHorizontalTextPosition(SwingConstants.RIGHT);
		jjResult.setHorizontalAlignment(SwingConstants.RIGHT);
		jjResult.setForeground(Color.WHITE);
		jjResult.setFont(new Font("Ubuntu Mono", Font.PLAIN, 45));

		n = new JPanel();
		n.setForeground(Color.LIGHT_GRAY);
		n.setLayout(new GridLayout(5, 4, 5, 5));
		n.setBackground(Color.BLACK);

		n2 = new JPanel();
		n2.setLayout(new GridLayout(1, 2, 5, 5));
		n2.setBackground(Color.BLACK);
		n2.add(jjResult);

		n.add(jjRaiz = new JButton("raiz"));
		jjRaiz.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjRaiz.setForeground(Color.LIGHT_GRAY);
		jjRaiz.setBackground(Color.BLACK);

		n.add(jjRaizCubica = new JButton("r cubic"));
		jjRaizCubica.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjRaizCubica.setForeground(Color.LIGHT_GRAY);
		jjRaizCubica.setBackground(Color.BLACK);

		n.add(jjPot = new JButton("Pot"));
		jjPot.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjPot.setForeground(Color.LIGHT_GRAY);
		jjPot.setBackground(Color.BLACK);

		n.add(jjPi = new JButton("Pi"));
		jjPi.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjPi.setForeground(Color.LIGHT_GRAY);
		jjPi.setBackground(Color.BLACK);

		n.add(jbN9 = new JButton("9"));
		jbN9.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN9.setForeground(Color.LIGHT_GRAY);
		jbN9.setBackground(Color.BLACK);

		n.add(jbN8 = new JButton("8"));
		jbN8.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN8.setForeground(Color.LIGHT_GRAY);
		jbN8.setBackground(Color.BLACK);

		n.add(jbN7 = new JButton("7"));
		jbN7.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN7.setForeground(Color.LIGHT_GRAY);
		jbN7.setBackground(Color.BLACK);

		n.add(jjDivide = new JButton("/"));
		jjDivide.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjDivide.setForeground(Color.WHITE);
		jjDivide.setBackground(BG_ORANGE);

		n.add(jbN4 = new JButton("4"));
		jbN4.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN4.setForeground(Color.LIGHT_GRAY);
		jbN4.setBackground(Color.BLACK);

		n.add(jbN5 = new JButton("5"));
		jbN5.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN5.setForeground(Color.LIGHT_GRAY);
		jbN5.setBackground(Color.BLACK);

		n.add(jbN6 = new JButton("6"));
		jbN6.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN6.setForeground(Color.LIGHT_GRAY);
		jbN6.setBackground(Color.BLACK);

		n.add(jjMult = new JButton("*"));
		jjMult.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjMult.setForeground(Color.WHITE);
		jjMult.setBackground(BG_ORANGE);

		n.add(jbN1 = new JButton("1"));
		jbN1.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN1.setForeground(Color.LIGHT_GRAY);
		jbN1.setBackground(Color.BLACK);

		n.add(jbN2 = new JButton("2"));
		jbN2.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN2.setForeground(Color.LIGHT_GRAY);
		jbN2.setBackground(Color.BLACK);

		n.add(jbN3 = new JButton("3"));
		jbN3.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN3.setForeground(Color.LIGHT_GRAY);
		jbN3.setBackground(Color.BLACK);

		n.add(jjSub = new JButton("-"));
		jjSub.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjSub.setForeground(Color.WHITE);
		jjSub.setBackground(BG_ORANGE);

		n.add(jjPonto = new JButton("."));
		jjPonto.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjPonto.setForeground(Color.LIGHT_GRAY);
		jjPonto.setBackground(Color.BLACK);

		n.add(jbN0 = new JButton("0"));
		jbN0.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jbN0.setForeground(Color.LIGHT_GRAY);
		jbN0.setBackground(Color.BLACK);

		n.add(jjIgual = new JButton("="));
		jjIgual.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjIgual.setForeground(Color.LIGHT_GRAY);
		jjIgual.setBackground(Color.BLACK);

		n.add(jjSoma = new JButton("+"));
		jjSoma.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		jjSoma.setForeground(Color.WHITE);
		jjSoma.setBackground(BG_ORANGE);

		c.add(BorderLayout.NORTH, n2);
		c.add(BorderLayout.CENTER, n);
		c.add(BorderLayout.SOUTH, jjClean);

		jbN1.addActionListener(new LerN1());
		jbN2.addActionListener(new LerN2());
		jbN3.addActionListener(new LerN3());
		jbN4.addActionListener(new LerN4());
		jbN5.addActionListener(new LerN5());
		jbN6.addActionListener(new LerN6());
		jbN7.addActionListener(new LerN7());
		jbN8.addActionListener(new LerN8());
		jbN9.addActionListener(new LerN9());
		jbN0.addActionListener(new LerN0());
		jjPonto.addActionListener(new addPonto());
		jjSub.addActionListener(new calcSub());
		jjRaiz.addActionListener(new calcRaiz());
		jjMult.addActionListener(new calcMult());
		jjSoma.addActionListener(new calcSoma());
		jjDivide.addActionListener(new calcDivisao());
		jjIgual.addActionListener(new calcResolve());
		jjClean.addActionListener(new LerLimpar());
		jjRaizCubica.addActionListener(new calcRaizCubica());
		jjPot.addActionListener(new calcPot());
		jjPi.addActionListener(new calcPi());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	class LerN1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			display = jjResult.getText();
			jjResult.setText(display + "1");
		}
	}

	class LerN2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			display = jjResult.getText();
			jjResult.setText(display + "2");
		}
	}

	class LerN3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "3");
		}
	}

	class LerN4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "4");
		}
	}

	class LerN5 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			display = jjResult.getText();
			jjResult.setText(display + "5");
		}
	}

	class LerN6 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "6");
		}
	}

	class LerN7 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "7");
		}
	}

	class LerN8 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			display = jjResult.getText();
			jjResult.setText(display + "8");
		}
	}

	class LerN9 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "9");
		}
	}

	class LerN0 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + "0");
		}
	}

	class addPonto implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(jjResult.getText() + ".");
		}
	}

	class calcSub implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				jjResult.setText(" ");
				subtracao = true;
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcMult implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				jjResult.setText(" ");
				multiplicacao = true;
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());

			}
		}
	}

	class calcDivisao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				jjResult.setText(" ");
				divisao = true;
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcSoma implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				jjResult.setText(" ");
				adicao = true;
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcRaiz implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				num2 = Math.sqrt(num1);
				jjResult.setText(String.format("%.2f", num2));
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcRaizCubica implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				num2 = Math.cbrt(num1);
				jjResult.setText(String.format("%.2f", num2));
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcPot implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num1 = Double.parseDouble(jjResult.getText());
				jjResult.setText(" ");
				num2 = Math.pow(num1, 2);
				jjResult.setText(String.format("%.2f", num2));
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class calcPi implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText("3.14159");
		}
	}

	class calcResolve implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num2 = Double.parseDouble(jjResult.getText());
				if (adicao == true) {
					num2 = num1 + num2;
				} else if (subtracao == true) {
					num2 = num1 - num2;
				} else if (multiplicacao == true) {
					num2 = num1 * num2;
				} else if (divisao == true) {
					num2 = num1 / num2;
				}

				jjResult.setText(Double.toString(num2));
				clean();
			} catch (NumberFormatException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	class LerLimpar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jjResult.setText(" ");
			clean();
		}
	}

	void clean() {
		num1 = 0;
		num2 = 0;
		raiz = false;
		adicao = false;
		subtracao = false;
		divisao = false;
		multiplicacao = false;
		raizCubica = false;
		potencia = false;
	}

	public static void main(String[] args) {
		new Calculator2();
	}
}