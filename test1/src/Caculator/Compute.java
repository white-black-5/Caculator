package Caculator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Compute {
	char[] str;

	public Compute(String infix) {
		str = infix.toCharArray();// ���ַ�������תΪ�ַ�����
	}

	Queue<String> s_in = new LinkedList<String>();// �����׺���ʽ�Ķ���
	Queue<String> s_out = new LinkedList<String>();// ��ź�׺���ʽ�Ķ���
	Stack<String> symbol = new Stack<String>();// ����������ջ

	
	public String resultstr = "";

	public void init() {
		String temp = "";
		int m = 0;
		//�������������ַ���
		
	
		// ����һ�ַ��Ǹ���ʱ���в���
		if (str[0] == '-' && str[1] >= '0' && str[1] <= '9') {
			temp = temp + String.valueOf(str[0]);
			m = 1;
			while (str[m] >= '0' && str[m] <= '9' || str[m] == '.') {
				temp = temp + String.valueOf(str[m]);
				m++;
			} // ���ַ���������λ�ĸ��ţ�����0~9��С����תΪ�ַ���������ʱ����temp
			s_in.add(temp);// ����λ�ĸ��ţ�����0~9��С����ѹ����׺���ʽ�Ķ���
			temp = "";
		}

		for (int i = m; i < str.length; i++) {
			// ����λΪ�������д���
			if (str[i] == '-' && (str[i - 1] == '+' || str[i - 1] == '-' || str[i - 1] == '*' || str[i - 1] == '/'
					|| str[i - 1] == '(' || str[i - 1] == ')')) {
				temp = temp + String.valueOf(str[i]);
				i++;

				while (str[i] >= '0' && str[i] <= '9' || str[i] == '.') {
					temp = temp + String.valueOf(str[i]);
					i++;
				}
				if (!temp.equals("")) {
					s_in.add(temp);// ������ѹ������׺���ʽ�Ķ���
					temp = "";
				}

				// ������ķ��Ž��д���
				if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/' || str[i] == '('
						|| str[i] == ')') {
					i--;
				}
			}
			
            //��λ��Ϊ����ʱ
			else {
				if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/' || str[i] == '('
						|| str[i] == ')') {
					if (!temp.equals(" ")) {
						s_in.add(temp);
						temp = "";
					}
					s_in.add(String.valueOf(str[i]));// �������ѹ������׺���ʽ�Ķ���
				}

				else {
					temp = temp + String.valueOf(str[i]);// �������������ַ�ѹ������׺���ʽ�Ķ���
				}
			}
		}
		// �����һ���ַ���ѹ������׺���ʽ�Ķ���
		if (!temp.equals("")) {
			s_in.add(temp);
			temp = "";
		}
	}

	// ��׺���ʽתΪ��׺���ʽ
	public void convert() {
		init();
		Iterator<String> it = s_in.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			// ɨ�赽���֣���������׺���ʽ����
			if (!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("(")
					|| temp.equals(")"))) {
				s_out.add(temp);
			} else {

				// ɨ�赽������������ջΪ�ջ��ߵ�ǰ��������ȼ�����ջ�������������ȼ�ʱֱ����ջ
				if (symbol.isEmpty() || (priority(temp, symbol.peek()))) {
					symbol.push(temp);
				}

				// ������������ջ��Ԫ�رȽ�

				// ɨ�赽�����ţ�ֱ����ջ
				else if (temp.equals("(")) {
					symbol.push(temp);
				}

				// ɨ�赽�����ţ���ջ���Ԫ�������ջ���뵽��׺���ʽ�����У�ֱ���ҵ���֮��Ե������š�
				else if (temp.equals(")")) {
					while ((!symbol.isEmpty()) && (!symbol.peek().equals("("))) {
						s_out.add(symbol.pop());
					}
					if (!symbol.isEmpty()) {
						symbol.pop();
					}
				}

				else {
					// �������ջ��Ϊ��ʱ�ҵ�ǰ�����С�ڻ����ջ�������������ȼ�ʱִ�г�ջ������ֱ��ջ����������ȼ�С�ڵ�ǰ�����Ϊֹ��
					while ((!symbol.isEmpty()) && (!priority(temp, symbol.peek()))) {
						s_out.add(symbol.pop());
					}
					symbol.push(temp);
				}

			}
		}
		// ��ȡ�������ַ��󣬽�������ջ�е�����Ԫ�ص��������뵽��׺���ʽ������
		while (!symbol.isEmpty()) {
			s_out.add(symbol.pop());
		}
	}
	
    //��׺���ʽ����ֵ����
	public void calculate() {
		convert();
		String temp = "";
		double s1 = 0;
		double s2 = 0;
		double result = 0;
		char[] ch = new char[1];
		Stack<Double> number = new Stack<Double>();// ��Ų�������ջ
		Iterator<String> out = s_out.iterator();
		while (out.hasNext()) {
			temp = out.next();
            //��Ϊ���֣�ֱ��ѹ�������ջ��
			if (!((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")))) {
				number.push(Double.valueOf(temp));
			} 
			//��Ϊ��������Ҳ�����ջ��Ϊ����Ӳ�����ջ�����������ֽ��в����󽫽��ѹ��ջ��
			else {
				if (!number.isEmpty()) {
					s2 = number.pop();
				}
				if (!number.isEmpty()) {
					s1 = number.pop();
				}
				ch = temp.toCharArray();
				switch (ch[0]) {
				case '+':
					result = s1 + s2;
					number.add(result);
					break;
				case '-':
					result = s1 - s2;
					number.add(result);
					break;
				case '*':
					result = s1 * s2;
					number.add(result);
					break;
				case '/':
					result = s1 / s2;
					number.add(result);
					break;
				default:
					break;
				}
			}
		}
		resultstr = String.valueOf(result);
	}

	// ��һ�������Ƕ�����ķ��ţ��ڶ���������ջ��ķ���
	// op1���ȼ�����op2������true�����򣬷���false
	public Boolean priority(String op1, String op2) {
		if (op2.equals("(")) {
			return true;
		}
		if (op1.equals("+")) {
			return false;
		}
		if (op1.equals("-")) {
			return false;
		}
		if (op1.equals("*")) {
			if (op2.equals("+") || op2.equals("-")) {
				return true;
			}
			if (op2.equals("*") || op2.equals("/")) {
				return false;
			}
		}
		if (op1.equals("/")) {
			if (op2.equals("+") || op2.equals("-")) {
				return true;
			}
			if (op2.equals("*") || op2.equals("/")) {
				return false;
			}
		}
		return null;
	}
}
