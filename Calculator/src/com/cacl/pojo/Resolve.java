package com.cacl.pojo;

import com.cacl.dao.impl.MyQueue;
import com.cacl.dao.impl.MyStack;

public class Resolve {

	/**
	 * �滻��׺���ʽ�еĸ���
	 * 
	 * @param string
	 * @return
	 */
	public static String ReplaceMinusString(String string) {

		StringBuffer str = new StringBuffer(string);

		// �������ַ�Ϊ-,����Ϊ���ֵ�ƥ��
		if (string.startsWith("-")) {
			str.replace(str.indexOf("-"), str.indexOf("-") + 1, "@");
		}

		// �����ԣ�-��ʼ����Ϊ���ֵ�ƥ��
		while (str.toString().contains("(-")) {
			str.replace(str.indexOf("(-") + 1, str.indexOf("(-") + 2, "@");
		}
		return str.toString();
	}

	/**
	 * ���������������@���ظ��� ��ʶ����ַ�
	 * 
	 * @param str
	 * @return
	 */
	public static Double ReplaceBackMinusAndPi(String str) {
		if (str.contains("@")) {
			String s1 = str.replaceAll("@", "-");
			if (s1.equals("��")) {
				return Math.PI;
			} else if (s1.equals("-��")) {
				return -Math.PI;
			} else {
				return Double.parseDouble(s1);
			}
		} else if (str.equals("��")) {
			return Math.PI;
		} else if (str.equals("-��")) {
			return -Math.PI;
		} else {
			return Double.parseDouble(str);
		}

	}

	/**
	 * ��׺���ʽת��׺���ʽ
	 * 
	 * @param IFX
	 * @return
	 */
	public static MyQueue<String> TransIntoSuffix(String Infix)// IFXΪ��׺���ʽ
	{
		MyQueue<String> Suffix = new MyQueue<String>();
		StringBuffer numBuffer = new StringBuffer();// ��������һ������
		MyStack<String> operater = new MyStack<String>();// �Ų�����
		String a;
		operater.push("=");// ��һ��Ϊ�Ⱥ�
		int i = 0;
		char ch;
		for (i = 0; i < Infix.length();) {
			ch = Infix.charAt(i);
			switch (ch) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '@':
				while (Character.isDigit(ch) || ch == '.' || ch == '@'
						|| ch == '��')// ƴ��
				{
					numBuffer.append(ch); // ׷���ַ�
					ch = Infix.charAt(++i);
				}
				Suffix.add(numBuffer.toString());// break;
				numBuffer = new StringBuffer(); // ����ѻ�ȡ����������
				continue; // ����Ҫ����ѭ������Ϊi�Ѿ����ӹ���
			case '��':
				Suffix.add("��");
				break;
			case '(': // ������ֱ����ջ
				operater.push("(");
				break;
			case ')': // �����ţ���������֮ǰ�Ĳ�����ȡ��
				while (operater.peek() != "(")
					Suffix.add(operater.pop());
				operater.pop();
				break;
			case '+':
			case '-':
				while ((operater.size() > 1 && operater.peek() != "("))
					Suffix.add(operater.pop());
				a = String.valueOf(ch);
				operater.push(a);
				break;
			case '*':
			case '/':
				while (operater.size() > 1
						&& (operater.peek() == "*" || operater.peek() == "/"
								|| operater.peek() == "s"
								|| operater.peek() == "c"
								|| operater.peek() == "t"
								|| operater.peek() == "S"
								|| operater.peek() == "C"
								|| operater.peek() == "T"
								|| operater.peek() == "l"
								|| operater.peek() == "g"
								|| operater.peek() == "^" || operater.peek() == "��"))
					// ���ȼ��Ƚϣ���ջ���Ƚϣ�
					Suffix.add(operater.pop());// ��ǰ���������ȼ����ڵ���ջ���ĵ���ջ��
				a = String.valueOf(ch);
				operater.push(a);
				break;
			case 's':
			case 'c':
			case 't':// ���Ǻ���
			case 'o':
			case 'i':
			case 'a':// �����Ǻ���
			case 'S':
			case 'T':
			case 'C':// ˫������
			case 'l':// ��Ȼ����
			case 'g':// 10Ϊ�׶�������
				while (operater.size() > 1
						&& (operater.peek() == "s" || operater.peek() == "c"
								|| operater.peek() == "t"
								|| operater.peek() == "S"
								|| operater.peek() == "C"
								|| operater.peek() == "T"
								|| operater.peek() == "o"
								|| operater.peek() == "i"
								|| operater.peek() == "a"
								|| operater.peek() == "l"
								|| operater.peek() == "g"
								|| operater.peek() == "^" || operater.peek() == "��"))
					// ���ȼ��Ƚϣ���ջ�������ڵ��ڵĵ���
					Suffix.add(operater.pop());
				a = String.valueOf(ch);
				operater.push(a);
				break;
			case '^':// ��
			case '��':// ����
				while (operater.size() > 1
						&& (operater.peek() == "^" || operater.peek() == "��"))
					Suffix.add(operater.pop());
				a = String.valueOf(ch);
				operater.push(a);
				break;
			}

			i++;
		}
		while (operater.size() > 0)
			Suffix.add(operater.pop());

		return Suffix;
	}

	/**
	 * ��׺���ʽ��ֵ �Ƕ�����
	 * 
	 * @param Suffix
	 * @return
	 */
	public static Double AngleFigure(MyQueue<String> Suffix) {
		Double x1, x2, n;
		String str;
		MyStack<String> s = new MyStack<String>();
		while (Suffix.element() != "=") {
			str = Suffix.remove();
			switch (str.charAt(0)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '@':
			case '��':
				s.push(str);
				break;
			case '+':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 + x1;
				//����10λС��
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '-':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 - x1;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '*':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x1 * x2;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '/':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 / x1;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 's':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.sin(x1 * Math.PI / 180);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'c':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.cos(x1 * Math.PI / 180);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 't':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.tan(x1 * Math.PI / 180);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'i':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.asin(x1) * 180 / Math.PI;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'o':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.acos(x1) * 180 / Math.PI;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'a':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.atan(x1) * 180 / Math.PI;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'S':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.sinh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'C':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.cosh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'T':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.tanh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'l':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.log(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'g':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.log10(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '��':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.sqrt(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;// ����
			case '^':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = Math.pow(x2, x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			}
		}
		return ReplaceBackMinusAndPi(s.pop());
	}

	/**
	 * ��׺���ʽ��ֵ ��������
	 * 
	 * @param Suffix
	 * @return
	 */
	public static Double RadFigure(MyQueue<String> Suffix) {
		Double x1, x2, n;
		String str;
		MyStack<String> s = new MyStack<String>();
		while (Suffix.element() != "=") {
			str = Suffix.remove();
			switch (str.charAt(0)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '@':
			case '��':
				s.push(str);
				break;
			case '+':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 + x1;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '-':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 - x1;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '*':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x1 * x2;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '/':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = x2 / x1;
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 's':
				x1 = ReplaceBackMinusAndPi(s.pop());
				if (x1 != Math.PI || x1 != -Math.PI) {
					n = Math.sin(x1);
				} else if (x1 == Math.PI) {
					n = Math.sin(Math.PI);
				} else {
					n = Math.sin(-Math.PI);
				}
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'c':
				x1 = ReplaceBackMinusAndPi(s.pop());
				if (x1 != Math.PI || x1 != -Math.PI) {
					n = Math.cos(x1);
				} else if (x1 == Math.PI) {
					n = Math.cos(Math.PI);
				} else {
					n = Math.cos(-Math.PI);
				}
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 't':
				x1 = ReplaceBackMinusAndPi(s.pop());
				if (x1 != Math.PI || x1 != -Math.PI) {
					n = Math.tan(x1);
				} else if (x1 == Math.PI) {
					n = Math.tan(Math.PI);
				} else {
					n = Math.tan(-Math.PI);
				}
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'i':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.asin(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'o':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.acos(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'a':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.atan(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'S':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.sinh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'C':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.cosh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'T':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.tanh(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'l':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.log(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case 'g':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.log10(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			case '��':
				x1 = ReplaceBackMinusAndPi(s.pop());
				n = Math.sqrt(x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;// ����
			case '^':
				x1 = ReplaceBackMinusAndPi(s.pop());
				x2 = ReplaceBackMinusAndPi(s.pop());
				n = Math.pow(x2, x1);
				s.push(String.valueOf(String.format("%.10f", n)));
				break;
			}
		}
		return ReplaceBackMinusAndPi(s.pop());
	}
}
