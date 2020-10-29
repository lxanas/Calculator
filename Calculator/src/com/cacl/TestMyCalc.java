package com.cacl;

import javax.swing.JOptionPane;

import com.cacl.pojo.CalcFrame;

/**
 * 测试类
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
			JOptionPane.showMessageDialog(null, "外观初始化失败");
		}
		new CalcFrame();
	}
}
