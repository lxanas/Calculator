package com.cacl;

import javax.swing.JOptionPane;

import com.cacl.pojo.CalcFrame;

/**
 * ������
 * 
 * @author Gavin
 * 
 */
public class TestMyCalc {
	public static void main(String[] args) {
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��۳�ʼ��ʧ��");
		}
		new CalcFrame();
	}
}
