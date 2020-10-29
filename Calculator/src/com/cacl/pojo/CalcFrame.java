package com.cacl.pojo;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.naming.NameAlreadyBoundException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.cacl.dao.impl.MyQueue;

public class CalcFrame extends JFrame {
	private Double M = 0d;// �洢��
	private Double copy = null;
	// ���3
	private JTextField text1;// �ı���1�����ڽ����û�����
	private JTextField text2;// �ı���2��������ʾ����ʽ����
	// ���2
	private JButton btnleftKuo;
	private JButton btnrightKuo;
	private JButton btnMod;
	private JButton btnSin;
	private JButton btnAsin;
	private JButton btnCos;
	private JButton btnAcos;
	private JButton btnTan;
	private JButton btnAtan;
	private JButton btnLn;
	private JButton btnN;
	private JButton btnSinh;
	private JButton btnCosh;
	private JButton btnTanh;
	private JButton btnLog;
	private JButton btnPi;
	private JRadioButton rbtnAngle;
	private JRadioButton rbtnRad;
	// ���1
	private JButton btn1;// ��ť1
	private JButton btn2;// ��ť2
	private JButton btn3;// ��ť3
	private JButton btn4;// ��ť4
	private JButton btn5;// ��ť5
	private JButton btn6;// ��ť6
	private JButton btn7;// ��ť7
	private JButton btn8;// ��ť8
	private JButton btn9;// ��ť9
	private JButton btn0;// ��ť0
	private JButton btnPoint;// С���㰴ť
	private JButton btnAdd;// �ӺŰ�ť
	private JButton btnPlus;// ���Ű�ť
	private JButton btnMul;// �˺Ű�ť
	private JButton btnDiv;// ���Ű�ť
	private JButton btnPow;// �������㰴ť
	private JButton btnOk;// �ȺŰ�ť
	private JButton btnSign;// ѡ�������Ű�ť
	private JButton btnFlush;// �����Ļ��ť
	private JButton btnSqrt;// ����
	private JButton btnDao;// ����
	private JButton btnBackSpace;// �˸�
	private JButton btnMC;// ���
	private JButton btnMR;// ����
	private JButton btnMS;// �洢
	private JButton btnMadd;// ��
	private JButton btnMplus;// ��

	// �˵���
	private JMenuBar menubar;
	private JMenu menu_look;
	private JRadioButtonMenuItem look_basement;
	private JRadioButtonMenuItem look_science;
	private ButtonGroup buttonGroup;
	private JMenu menu_edit;
	private JMenuItem edit_copy;
	private JMenuItem edit_paste;
	private JMenu menu_help;
	private JMenuItem help_help;
	private JMenuItem help_about;

	// ���
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel;

	/**
	 * ���췽��
	 */
	public CalcFrame() {
		super("�ҵļ�����");// title
		this.setResizable(false);// ���ò��ɸı��С
		this.setIconImage(new ImageIcon("images\\calc.png").getImage());// ������С��ͼƬ
		this.setSize(220, 335);// ���ô�С
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		initPanel1();
		initPanel2();
		initPanel3();
		initBar(); // ���ó�ʼ������
		initListener();// ����ע�����������
		this.setLocationRelativeTo(null);// ����Ĭ����ʾΪ��������
		this.setVisible(true);// ���ÿɼ�
	}

	/**
	 * ��ʼ���˵���
	 */
	public void initBar() {
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);// ע������
		menu_look = new JMenu("�鿴(V)");
		menu_look.setMnemonic('V');
		menubar.add(menu_look);
		look_basement = new JRadioButtonMenuItem("������");
		look_basement.setAccelerator(KeyStroke
				.getKeyStroke('1', Event.ALT_MASK));
		look_science = new JRadioButtonMenuItem("��ѧ��");
		look_science
				.setAccelerator(KeyStroke.getKeyStroke('2', Event.ALT_MASK));
		buttonGroup = new ButtonGroup();
		buttonGroup.add(look_basement);
		buttonGroup.add(look_science);
		menu_look.add(look_basement);
		menu_look.add(look_science);
		look_basement.setSelected(true);

		menu_edit = new JMenu("�༭(E)");
		menu_edit.setMnemonic('E');
		menubar.add(menu_edit);
		edit_copy = new JMenuItem("����");
		edit_copy.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
		menu_edit.add(edit_copy);
		edit_paste = new JMenuItem("ճ��");
		edit_paste.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));
		menu_edit.add(edit_paste);
		menu_edit.addSeparator();

		menu_help = new JMenu("����(H)");
		menu_help.setMnemonic('H');
		menubar.add(menu_help);
		help_help = new JMenuItem("�鿴����");
		help_help.setAccelerator(KeyStroke.getKeyStroke('F',Event.ALT_MASK));
		menu_help.add(help_help);
		help_about = new JMenuItem("���ڼ�����");
		menu_help.add(help_about);
		this.add(panel3);
		this.add(panel1);
	}

	/**
	 * ��ʼ�����1
	 */
	public void initPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);
		btnMC = new MyButton("MC", 10, 65, 35, 30);
		panel1.add(btnMC);
		btnMR = new MyButton("MR", 50, 65, 35, 30);
		panel1.add(btnMR);
		btnMS = new MyButton("MS", 90, 65, 35, 30);
		panel1.add(btnMS);
		btnMadd = new MyButton("M+", 130, 65, 35, 30);
		panel1.add(btnMadd);
		btnMplus = new MyButton("M-", 170, 65, 35, 30);
		panel1.add(btnMplus);
		btn1 = new MyButton("1", 10, 205, 35, 30);
		panel1.add(btn1);
		btn2 = new MyButton("2", 50, 205, 35, 30);
		panel1.add(btn2);
		btn3 = new MyButton("3", 90, 205, 35, 30);
		panel1.add(btn3);
		btn4 = new MyButton("4", 10, 170, 35, 30);
		panel1.add(btn4);
		btn5 = new MyButton("5", 50, 170, 35, 30);
		panel1.add(btn5);
		btn6 = new MyButton("6", 90, 170, 35, 30);
		panel1.add(btn6);
		btn7 = new MyButton("7", 10, 135, 35, 30);
		panel1.add(btn7);
		btn8 = new MyButton("8", 50, 135, 35, 30);
		panel1.add(btn8);
		btn9 = new MyButton("9", 90, 135, 35, 30);
		panel1.add(btn9);
		btn0 = new MyButton("0", 10, 240, 75, 30);
		panel1.add(btn0);
		btnPoint = new MyButton(".", 90, 240, 35, 30);
		panel1.add(btnPoint);
		btnAdd = new MyButton("+", 130, 240, 35, 30);
		panel1.add(btnAdd);
		btnPlus = new MyButton("-", 130, 205, 35, 30);
		panel1.add(btnPlus);
		btnMul = new MyButton("*", 130, 170, 35, 30);
		panel1.add(btnMul);
		btnDiv = new MyButton("/", 130, 135, 35, 30);
		panel1.add(btnDiv);
		btnOk = new MyButton("=", 170, 205, 35, 65);
		panel1.add(btnOk);
		btnSign = new MyButton("��", 130, 100, 35, 30);
		panel1.add(btnSign);
		btnPow = new MyButton("^", 170, 170, 35, 30);
		btnPow.setActionCommand("^");
		panel1.add(btnPow);
		btnFlush = new MyButton("C", 90, 100, 35, 30);
		panel1.add(btnFlush);
		btnSqrt = new MyButton("��", 170, 100, 35, 30);
		panel1.add(btnSqrt);
		btnDao = new MyButton("1/x", 170, 135, 35, 30);
		panel1.add(btnDao);
		btnBackSpace = new MyButton("<----", 10, 100, 75, 30);
		btnBackSpace.setFont(new Font("����", Font.BOLD, 16));
		panel1.add(btnBackSpace);
	}

	/**
	 * ��ʼ�����2
	 */
	public void initPanel2() {
		panel2 = new JPanel();
		panel2.setLayout(null);
		btnleftKuo = new MyButton("(", 110, 100, 35, 30);
		btnrightKuo = new MyButton(")", 150, 100, 35, 30);
		rbtnAngle = new JRadioButton("�Ƕ�");// �Ƕ�
		rbtnRad = new JRadioButton("����");// ����
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbtnAngle);
		btnGroup.add(rbtnRad);
		rbtnAngle.setBounds(10, 65, 80, 30);
		rbtnAngle.setForeground(Color.blue);
		rbtnAngle.setSelected(true);
		rbtnRad.setBounds(90, 65, 80, 30);
		rbtnRad.setForeground(Color.blue);
		btnMod = new MyButton("Mod", 70, 100, 35, 30);
		btnSin = new MyButton("sin", 70, 135, 55, 30);
		btnAsin = new MyButton("asin", 130, 135, 55, 30);
		btnCos = new MyButton("cos", 70, 170, 55, 30);
		btnAcos = new MyButton("acos", 130, 170, 55, 30);
		btnTan = new MyButton("tan", 70, 205, 55, 30);
		btnAtan = new MyButton("atan", 130, 205, 55, 30);
		btnLn = new MyButton("ln", 70, 240, 55, 30);
		btnN = new MyButton("n!", 130, 240, 55, 30);
		btnSinh = new MyButton("sinh", 10, 135, 55, 30);
		btnCosh = new MyButton("cosh", 10, 170, 55, 30);
		btnTanh = new MyButton("tanh", 10, 205, 55, 30);
		btnLog = new MyButton("log", 10, 240, 55, 30);
		btnPi = new MyButton("��", 10, 100, 55, 30);
		panel2.add(btnleftKuo);
		panel2.add(btnrightKuo);
		panel2.add(rbtnAngle);
		panel2.add(rbtnRad);
		panel2.add(btnLn);
		panel2.add(btnSin);
		panel2.add(btnCos);
		panel2.add(btnTan);
		panel2.add(btnAsin);
		panel2.add(btnAcos);
		panel2.add(btnAtan);
		panel2.add(btnMod);
		panel2.add(btnN);
		panel2.add(btnSinh);
		panel2.add(btnCosh);
		panel2.add(btnTanh);
		panel2.add(btnLog);
		panel2.add(btnPi);
	}

	/**
	 * ��ʼ�����3
	 */
	public void initPanel3() {
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setSize(205, 60);
		text1 = new JTextField();// ʵ����һ���ı���
		text1.setBounds(10, 35, 195, 25);// �����ı����С �Լ� λ��
		text1.setFont(new Font("����", Font.PLAIN, 18));
		text1.setHorizontalAlignment(JTextField.RIGHT);// �����Ҷ���
		text1.setBackground(new Color(255, 192, 203));// ���ñ���ɫ
		text1.setBorder(null);// ����û�б߿�
		panel3.add(text1);

		text2 = new JTextField();
		text2.setBounds(10, 10, 195, 25);
		text2.setHorizontalAlignment(JTextField.RIGHT);
		text2.setBackground(new Color(255, 192, 203));
		text2.setBorder(null);
		panel3.add(text2);
	}

	/**
	 * Ϊÿ����ťע�����
	 */
	public void initListener() {
		btn1.addActionListener(new ButtonAction());
		btn2.addActionListener(new ButtonAction());
		btn3.addActionListener(new ButtonAction());
		btn4.addActionListener(new ButtonAction());
		btn5.addActionListener(new ButtonAction());
		btn6.addActionListener(new ButtonAction());
		btn7.addActionListener(new ButtonAction());
		btn8.addActionListener(new ButtonAction());
		btn9.addActionListener(new ButtonAction());
		btn0.addActionListener(new ButtonAction());
		btnPoint.addActionListener(new ButtonAction());
		btnAdd.addActionListener(new ButtonAction());
		btnPlus.addActionListener(new ButtonAction());
		btnMul.addActionListener(new ButtonAction());
		btnDiv.addActionListener(new ButtonAction());
		btnPow.addActionListener(new ButtonAction());
		btnOk.addActionListener(new ButtonAction());
		btnSqrt.addActionListener(new ButtonAction());
		btnSin.addActionListener(new ButtonAction());
		btnCos.addActionListener(new ButtonAction());
		btnTan.addActionListener(new ButtonAction());
		btnAcos.addActionListener(new ButtonAction());
		btnAsin.addActionListener(new ButtonAction());
		btnAtan.addActionListener(new ButtonAction());
		btnSinh.addActionListener(new ButtonAction());
		btnCosh.addActionListener(new ButtonAction());
		btnTanh.addActionListener(new ButtonAction());
		btnLog.addActionListener(new ButtonAction());
		btnLn.addActionListener(new ButtonAction());
		btnleftKuo.addActionListener(new ButtonAction());
		btnrightKuo.addActionListener(new ButtonAction());
		btnPi.addActionListener(new ButtonAction());

		look_science.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scienceType();
			}
		});

		look_basement.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				basementType();
			}
		});

		// Ϊ������ѡ��ťע�������--->����������ķ�ʽʵ��
		btnSign.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (look_basement.isSelected()) {
					if (text1.getText().startsWith("-")) {
						text1.setText(text1.getText().replace("-", ""));
					} else {
						text1.setText("-" + text1.getText());
					}
				} else if (look_science.isSelected()) {
					text2.setText(text2.getText() + "-");
				}
			}
		});

		btnMS.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M = Double.parseDouble(text1.getText());
			}
		});

		btnMadd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M += Double.parseDouble(text1.getText());
			}
		});

		btnMplus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M -= Double.parseDouble(text1.getText());
			}
		});

		btnMC.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				M = 0d;
			}
		});

		btnMR.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				text1.setText(M.toString());
			}
		});

		// Ϊ�����Ļ��ťע�������--->ͬ������������ʵ��
		btnFlush.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				text1.setText(null);
				text2.setText(null);
			}
		});

		btnBackSpace.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (look_basement.isSelected()) {
					if (!text1.getText().equals("")) {
						text1.setText(text1.getText().substring(0,
								text1.getText().length() - 1));
					}
				} else if (look_science.isSelected()) {
					if (!text2.getText().equals("")) {
						text2.setText(text2.getText().substring(0,
								text2.getText().length() - 1));
					}
				}
			}
		});

		btnDao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (!text1.getText().equals("")) {
						text2.setText("1 / " + text1.getText() + " =");
						Double x = 1 / Double.parseDouble(text1.getText());
						text1.setText(x.toString());
					} else if (text1.getText().equals("")
							&& !text2.getText().equals("")) {
						Double x = 1 / Double.parseDouble(text2.getText());
						text2.setText("1/" + text2.getText() + "=");
						text1.setText(x.toString());
					}
				} catch (Exception e1) {
					text1.setText(null);
					text2.setText("Error! Please Check!");
				}

			}
		});

		btnMod.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!text1.getText().equals("")) {
					text2.setText(text1.getText() + "Mod");
					text1.setText(null);
				} else if (text1.getText().equals("")) {
					text2.setText(text2.getText() + "Mod");
				}
			}
		});

		btnN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (!text1.getText().equals("")) {
						int n;
						text2.setText(text1.getText() + "!=");
						int m = (int) Double.parseDouble(text2.getText()
								.substring(0, text2.getText().indexOf("!"))
								.trim());
						if (isBigDecimal(m)) {
							n = (int) m;
							if(n<0){
								text1.setText(null);
								text2.setText("Error! Please Check!");
								return;
							}
						} else {
							text1.setText(null);
							text2.setText("Error! Please Check!");
							return;
						}
						int s = fact(m);
						text1.setText(String.valueOf(s));
					} else if (text1.getText().equals("")
							&& !text2.getText().equals("")) {
						int n = 0;
						text2.setText(text2.getText() + " ! =");
						double m = Double.parseDouble(text2.getText()
								.substring(0, text2.getText().indexOf("!"))
								.trim());
						if (isBigDecimal(m)) {
							n = (int) m;
							if(n<0){
								text1.setText(null);
								text2.setText("Error! Please Check!");
								return;
							}
						} else {
							text1.setText(null);
							text2.setText("Error! Please Check!");
							return;
						}
						int s = fact(n);
						text1.setText(String.valueOf(s));
					}
				} catch (Exception e1) {
					text1.setText(null);
					text2.setText("Error! Please Check!");
				}
			}
		});

		help_about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								CalcFrame.this,
								" �ҵļ���������\n          ������ͬ����ʤ����~\n"
										+ "                �κ����ʣ�����ϵ����\n"
										+ "                                     By Gavin",
								"����", JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon("images/calc.png"));
			}
		});

		edit_copy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (text1.getText().equals(""))
					return;
				copy = Double.parseDouble(text1.getText());
			}
		});

		edit_paste.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (copy == null)
					return;
				if (look_basement.isSelected()) {
						text1.setText(text1.getText() + String.valueOf(copy));
						text2.setText(null);
				} else if (look_science.isSelected()) {
					if(!text2.getText().endsWith("=")){
						text1.setText(null);
						text2.setText(text2.getText() + String.valueOf(copy));
					}else if(text2.getText().endsWith("=")){
						text1.setText(null);
						text2.setText(String.valueOf(copy));
					}
				}

			}
		});

		help_help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ʹ�øü�����"
						+ "\n      �������л������ͼ�����" + "\n          Ҳ�����л�����ѧ������"
						+ "\n       �����ʹ�ù����У�" + "\n            �����κ����ʻ���"
						+ "\n      �뼰ʱ��ϵ����~", "����",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
								"images/help.gif"));
			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int n = JOptionPane.showConfirmDialog(CalcFrame.this, "ȷ���˳���",
						"��ʾ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (n == JOptionPane.OK_OPTION) {// ������ȷ�ϰ�ť��������˳�
					System.exit(0);
				}
			}
		});
		
	}

	/**
	 * �л��������ͼ�����
	 */
	public void basementType() {

		try {
			CalcFrame.this.setSize(220, 335);
			panel3.setSize(205, 60);
			text1.setBounds(10, 35, 195, 25);
			text2.setBounds(10, 10, 195, 25);
			text2.setHorizontalAlignment(JTextField.RIGHT);
			CalcFrame.this.remove(panel);
			CalcFrame.this.remove(panel2);
			CalcFrame.this.add(panel3);
			CalcFrame.this.add(panel1);
		} catch (Exception e) {

		}
	}

	/**
	 * �л�����ѧ������
	 */
	public void scienceType() {
		if (CalcFrame.this.getSize().getWidth() == 220) {
			CalcFrame.this.setSize(432, 335);
			panel3.setSize(420, 60);
			text1.setBounds(10, 35, 408, 25);
			text2.setBounds(10, 10, 408, 25);
			text2.setHorizontalAlignment(JTextField.LEFT);
			text2.setFont(new Font("����", Font.PLAIN, 18));
			CalcFrame.this.add(panel3);
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 2, 0, 0));
			panel.add(panel2);
			panel.add(panel1);
			CalcFrame.this.add(panel);
		}
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isBigDecimal(double n) {
		String s = String.valueOf(n);
		String st = s.substring(s.indexOf(".") + 1);
		int i = Integer.parseInt(st);
		if (i == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * ת������ʽ��sin-->s cos-->c tan-->t asin-->i acos-->o atan-->a sinh-->S
	 * cosh-->C tanh-->T log-->g ln-->l
	 * 
	 * @param string
	 */
	public String transform(String string) {
		StringBuffer stringbuffer = new StringBuffer(string);
		while (stringbuffer.toString().contains("asin")) {
			stringbuffer.replace(stringbuffer.indexOf("asin"),
					stringbuffer.indexOf("asin") + 3, "i");
		}
		while (stringbuffer.toString().contains("acos")) {
			stringbuffer.replace(stringbuffer.indexOf("acos"),
					stringbuffer.indexOf("acos") + 3, "o");
		}
		while (stringbuffer.toString().contains("atan")) {
			stringbuffer.replace(stringbuffer.indexOf("atan"),
					stringbuffer.indexOf("atan") + 3, "a");
		}
		while (stringbuffer.toString().contains("sinh")) {
			stringbuffer.replace(stringbuffer.indexOf("sinh"),
					stringbuffer.indexOf("sinh") + 3, "S");
		}
		while (stringbuffer.toString().contains("cosh")) {
			stringbuffer.replace(stringbuffer.indexOf("cosh"),
					stringbuffer.indexOf("cosh") + 3, "C");
		}
		while (stringbuffer.toString().contains("tanh")) {
			stringbuffer.replace(stringbuffer.indexOf("tanh"),
					stringbuffer.indexOf("tanh") + 3, "T");
		}
		while (stringbuffer.toString().contains("sin")) {
			stringbuffer.replace(stringbuffer.indexOf("sin"),
					stringbuffer.indexOf("sin") + 3, "s");
		}
		while (stringbuffer.toString().contains("cos")) {
			stringbuffer.replace(stringbuffer.indexOf("cos"),
					stringbuffer.indexOf("cos") + 3, "c");
		}
		while (stringbuffer.toString().contains("tan")) {
			stringbuffer.replace(stringbuffer.indexOf("tan"),
					stringbuffer.indexOf("tan") + 3, "t");
		}
		while (stringbuffer.toString().contains("ln")) {
			stringbuffer.replace(stringbuffer.indexOf("ln"),
					stringbuffer.indexOf("ln") + 2, "l");
		}
		while (stringbuffer.toString().contains("log")) {
			stringbuffer.replace(stringbuffer.indexOf("log"),
					stringbuffer.indexOf("log") + 3, "g");
		}
		return stringbuffer.toString();
	}

	/**
	 * �׳˷���
	 * 
	 * @param n
	 * @return
	 */
	public int fact(int n) {
		//����6000�����ݿ�����ջ������쳣��
		if(n>6000){
			try {
				throw new Exception();
			} catch (Exception e) {
				text2.setText("������Ч��");
			}
			return 0;
		}
		
		if (n == 1 || n == 0) {
			return 1;
		}
		//�������
		if(n*fact(n-1)<=0){
			try {
				throw new Exception();
			} catch (Exception e) {
				text2.setText("���");
			}
			return 0;
		}
		
		return n * fact(n - 1);
	}

	// ������--->�ڲ���ʵ��
	class ButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (look_basement.isSelected()) {
				if (e.getActionCommand().equals("0")
						|| e.getActionCommand().equals("1")
						|| e.getActionCommand().equals("2")
						|| e.getActionCommand().equals("3")
						|| e.getActionCommand().equals("4")
						|| e.getActionCommand().equals("5")
						|| e.getActionCommand().equals("6")
						|| e.getActionCommand().equals("7")
						|| e.getActionCommand().equals("8")
						|| e.getActionCommand().equals("9")
						|| e.getActionCommand().equals(".")) {
					text1.setText(text1.getText() + e.getActionCommand());
				} else if (!e.getActionCommand().equals("=")
						&& !e.getActionCommand().equals("0")
						&& !e.getActionCommand().equals("1")
						&& !e.getActionCommand().equals("2")
						&& !e.getActionCommand().equals("3")
						&& !e.getActionCommand().equals("4")
						&& !e.getActionCommand().equals("5")
						&& !e.getActionCommand().equals("6")
						&& !e.getActionCommand().equals("7")
						&& !e.getActionCommand().equals("8")
						&& !e.getActionCommand().equals("9")
						&& !e.getActionCommand().equals(".")) {
					text2.setText(text1.getText() + " " + e.getActionCommand());
					text1.setText("");
				} else if (e.getActionCommand() == "=") {
					try {
						text2.setText(text2.getText() + " "
								+ text1.getText().trim() + "=");
						String s1 = text2.getText();
						String s = Resolve.ReplaceMinusString(s1);
						MyQueue<String> PFX = Resolve.TransIntoSuffix(s);
						Double result = Resolve.AngleFigure(PFX);
						text1.setText(result.toString());
					} catch (Exception e1) {
						text1.setText(null);
						text2.setText("Error! Please Check!");
					}
				}
			} else if (look_science.isSelected()) {
				if ((e.getActionCommand().equals("sin")
						|| e.getActionCommand().equals("cos")
						|| e.getActionCommand().equals("tan")
						|| e.getActionCommand().equals("sinh")
						|| e.getActionCommand().equals("cosh")
						|| e.getActionCommand().equals("tanh")
						|| e.getActionCommand().equals("asin")
						|| e.getActionCommand().equals("acos")
						|| e.getActionCommand().equals("atan")
						|| e.getActionCommand().equals("log") || e
						.getActionCommand().equals("ln"))) {
					if (text2.getText().endsWith("*")
							|| text2.getText().endsWith("/")
							|| text2.getText().endsWith("+")
							|| text2.getText().endsWith("-")
							|| text2.getText().endsWith("^")) {
						text2.setText(text2.getText() + e.getActionCommand());
						text1.setText("");
					} else {
						text2.setText(e.getActionCommand());
						text1.setText("");
					}
				} else if ((text2.getText().endsWith("=")
						|| text2.getText().endsWith("0")
						|| text2.getText().endsWith("1")
						|| text2.getText().endsWith("2")
						|| text2.getText().endsWith("3")
						|| text2.getText().endsWith("4")
						|| text2.getText().endsWith("5")
						|| text2.getText().endsWith("6")
						|| text2.getText().endsWith("7")
						|| text2.getText().endsWith("8") || text2.getText()
						.endsWith("9")) && e.getActionCommand().equals("(")) {
					text2.setText(e.getActionCommand());
					text1.setText(null);
				} else if (!e.getActionCommand().equals("=")
						&& text1.getText().equals("")
						&& !text2.getText().equals("Error! Please Check!")) {
					text2.setText(text2.getText() + e.getActionCommand());
				} else if (!e.getActionCommand().equals("=")
						&& text1.getText().equals("")
						&& text2.getText().equals("Error! Please Check!")) {
					text2.setText(e.getActionCommand());
				} else if (!e.getActionCommand().equals("=")
						&& !text1.getText().equals("")) {
					text2.setText(text1.getText() + e.getActionCommand());
					text1.setText("");
				} else if (e.getActionCommand().equals("=")) {
					if (rbtnRad.isSelected()) {
						try {
							text2.setText(text2.getText() + "=");
							if (text2.getText().contains("Mod")) {
								String string = text2.getText();
								double m1 = Double.parseDouble(string
										.substring(0, string.indexOf("Mod"))
										.trim());
								double m2 = Double.parseDouble(string
										.substring(string.indexOf("Mod") + 3,
												string.length() - 1).trim());
								if (isBigDecimal(m2) && isBigDecimal(m1)) {
									text1.setText(String.valueOf(m1 % m2));
								} else {
									text1.setText(null);
									text2.setText("Error! Please Check!");
								}
							} else {
								String s1 = transform(text2.getText());
								String s = Resolve.ReplaceMinusString(s1);
								MyQueue<String> PFX = Resolve.TransIntoSuffix(s);
								Double result = Resolve.RadFigure(PFX);
								text1.setText(result.toString());
							}

						} catch (Exception e1) {
							text1.setText(null);
							text2.setText("Error! Please Check!");
							e1.printStackTrace();
						}
					} else if (rbtnAngle.isSelected()) {
						try {
							text2.setText(text2.getText() + "=");
							if (text2.getText().contains("Mod")) {
								String string = text2.getText();
								double m1 = Double.parseDouble(string
										.substring(0, string.indexOf("Mod"))
										.trim());
								double m2 = Double.parseDouble(string
										.substring(string.indexOf("Mod") + 3,
												string.length() - 1).trim());
								if (isBigDecimal(m2) && isBigDecimal(m1)) {
									text1.setText(String.valueOf(m1 % m2));
								} else {
									text1.setText(null);
									text2.setText("Error! Please Check!");
								}
							} else {
								String s1 = transform(text2.getText());
								String s = Resolve.ReplaceMinusString(s1);
								MyQueue<String> PFX = Resolve.TransIntoSuffix(s);
								Double result = Resolve.AngleFigure(PFX);
								text1.setText(result.toString());
							}
						} catch (Exception e1) {
							text1.setText(null);
							text2.setText("Error! Please Check!");
						}
					}

				}
			}
		}
	}
}
