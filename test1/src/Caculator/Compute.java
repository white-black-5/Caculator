package Caculator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Compute {
	char[] str;

	public Compute(String infix) {
		str = infix.toCharArray();// 将字符串类型转为字符数组
	}

	Queue<String> s_in = new LinkedList<String>();// 存放中缀表达式的队列
	Queue<String> s_out = new LinkedList<String>();// 存放后缀表达式的队列
	Stack<String> symbol = new Stack<String>();// 存放运算符的栈

	
	public String resultstr = "";

	public void init() {
		String temp = "";
		int m = 0;
		//遍历传进来的字符串
		
	
		// 当第一字符是负号时进行操作
		if (str[0] == '-' && str[1] >= '0' && str[1] <= '9') {
			temp = temp + String.valueOf(str[0]);
			m = 1;
			while (str[m] >= '0' && str[m] <= '9' || str[m] == '.') {
				temp = temp + String.valueOf(str[m]);
				m++;
			} // 将字符数组中首位的负号，数字0~9及小数点转为字符串存入临时对象temp
			s_in.add(temp);// 将首位的负号，数字0~9及小数点压入中缀表达式的队列
			temp = "";
		}

		for (int i = m; i < str.length; i++) {
			// 当首位为负数进行处理
			if (str[i] == '-' && (str[i - 1] == '+' || str[i - 1] == '-' || str[i - 1] == '*' || str[i - 1] == '/'
					|| str[i - 1] == '(' || str[i - 1] == ')')) {
				temp = temp + String.valueOf(str[i]);
				i++;

				while (str[i] >= '0' && str[i] <= '9' || str[i] == '.') {
					temp = temp + String.valueOf(str[i]);
					i++;
				}
				if (!temp.equals("")) {
					s_in.add(temp);// 将数字压入存放中缀表达式的队列
					temp = "";
				}

				// 负数后的符号进行处理
				if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/' || str[i] == '('
						|| str[i] == ')') {
					i--;
				}
			}
			
            //首位不为负号时
			else {
				if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/' || str[i] == '('
						|| str[i] == ')') {
					if (!temp.equals(" ")) {
						s_in.add(temp);
						temp = "";
					}
					s_in.add(String.valueOf(str[i]));// 将运算符压入存放中缀表达式的队列
				}

				else {
					temp = temp + String.valueOf(str[i]);// 将除运算符外的字符压入存放中缀表达式的队列
				}
			}
		}
		// 将最后一个字符串压入存放中缀表达式的队列
		if (!temp.equals("")) {
			s_in.add(temp);
			temp = "";
		}
	}

	// 中缀表达式转为后缀表达式
	public void convert() {
		init();
		Iterator<String> it = s_in.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			// 扫描到数字，将其加入后缀表达式队列
			if (!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("(")
					|| temp.equals(")"))) {
				s_out.add(temp);
			} else {

				// 扫描到运算符，运算符栈为空或者当前运算符优先级高于栈顶操作符的优先级时直接入栈
				if (symbol.isEmpty() || (priority(temp, symbol.peek()))) {
					symbol.push(temp);
				}

				// 其他运算符则和栈顶元素比较

				// 扫描到左括号，直接入栈
				else if (temp.equals("(")) {
					symbol.push(temp);
				}

				// 扫描到右括号，则将栈里的元素逐个出栈加入到后缀表达式队列中，直到找到与之配对的左括号。
				else if (temp.equals(")")) {
					while ((!symbol.isEmpty()) && (!symbol.peek().equals("("))) {
						s_out.add(symbol.pop());
					}
					if (!symbol.isEmpty()) {
						symbol.pop();
					}
				}

				else {
					// 当运算符栈不为空时且当前运算符小于或等于栈顶操作符的优先级时执行出栈操作，直到栈顶运算符优先级小于当前运算符为止。
					while ((!symbol.isEmpty()) && (!priority(temp, symbol.peek()))) {
						s_out.add(symbol.pop());
					}
					symbol.push(temp);
				}

			}
		}
		// 读取完所有字符后，将操作符栈中的所有元素弹出并加入到后缀表达式队列中
		while (!symbol.isEmpty()) {
			s_out.add(symbol.pop());
		}
	}
	
    //后缀表达式的求值计算
	public void calculate() {
		convert();
		String temp = "";
		double s1 = 0;
		double s2 = 0;
		double result = 0;
		char[] ch = new char[1];
		Stack<Double> number = new Stack<Double>();// 存放操作数的栈
		Iterator<String> out = s_out.iterator();
		while (out.hasNext()) {
			temp = out.next();
            //若为数字，直接压入操作数栈中
			if (!((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")))) {
				number.push(Double.valueOf(temp));
			} 
			//若为运算符，且操作数栈不为空则从操作数栈弹出两个数字进行操作后将结果压回栈内
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

	// 第一个参数是队列里的符号，第二个参数是栈里的符号
	// op1优先级高于op2，返回true，否则，返回false
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
