package com.cacl.pojo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

/**
 * MyButton�࣬�̳�JButton
 */
public class MyButton extends JButton {
	
	public MyButton(String text, int a, int b, int c, int d) {
		super(text);// ���ð�ť�ı�
		this.setActionCommand(this.getText());// ���ð�ť�����
		this.setForeground(Color.blue);
		this.setBounds(a, b, c, d);// ���ð�ť��λ�ü���С
		this.setFocusPainted(false);// ���ð�ť���ʱ����ʾ�����
		this.setMargin(new Insets(0, 0, 0, 0));// ���ð�ť�����־�����ߵľ���Ϊ0
		this.setFont(new Font("����",Font.PLAIN,15));
	}
}
