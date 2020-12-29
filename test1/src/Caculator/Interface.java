package Caculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class Interface extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	String expression = " ";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Interface frame = new Interface();
				frame.setTitle("计算器");// 设置标题
				frame.setVisible(true);// 设置图形界面可见

			}
		});
	}

	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 350, 500);// 设置窗体宽度为350，高度为500,并使其显示在距屏幕左上方坐标（600,200）的位置处
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置边框，像素为5
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 0));// 创建具有8行布局的网格
		contentPane.setBackground(Color.LIGHT_GRAY);// 设置背景颜色

		JPanel panel = new JPanel();// 创建历史记录面板对象
		contentPane.add(panel);// 将后缀表达式面板添加进
		panel.setLayout(new BorderLayout(0, 0));
		JLabel label = new JLabel(" 历史记录");
		panel.add(label, BorderLayout.WEST);

		textField = new JTextField();
		textField.setEditable(false);// 将历史记录文本区域设为不可编辑
		panel.add(textField, BorderLayout.CENTER);// 给历史记录面板添加文本内容
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();// 创建输入面板对象
		contentPane.add(panel_1);// 将输入面板添加进contentPane
		panel_1.setLayout(new BorderLayout(0, 0));// 设置输入面板为边框布局
		JLabel lblNewLabel = new JLabel("当前输入:");
		panel_1.add(lblNewLabel, BorderLayout.WEST);// 设置输入面板的标签，靠左

		textField_1 = new JTextField();
		textField_1.setEditable(false);// 将输入文本区域设为不可编辑
		panel_1.add(textField_1, BorderLayout.CENTER);// 给输入面板添加文本内容
		textField_1.setColumns(10);// 设置文本字段列数

		JPanel panel_2 = new JPanel();// 创建计算结果面板对象
		contentPane.add(panel_2);// 将计算结果面板添加进contentPane
		panel_2.setLayout(new BorderLayout(0, 0));
		JLabel label_1 = new JLabel("计算结果:");
		panel_2.add(label_1, BorderLayout.WEST);

		textField_2 = new JTextField();
		textField_2.setEditable(false);// 将计算结果文本区域设为不可编辑
		panel_2.add(textField_2, BorderLayout.CENTER);// 给计算结果面板添加文本内容
		textField_2.setColumns(10);

		JPanel panel_3 = new JPanel();// 创建控件面板对象
		contentPane.add(panel_3);// 将控件面板添加进contentPane
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));// 创建具有1行布局的网格

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		// 左括号
		JButton button = new JButton("(");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button.getText();
				textField_1.setText(expression);
			}
		});
		panel_3.add(button);

		// 右括号
		JButton button_1 = new JButton(")");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_1.getText();
				textField_1.setText(expression);
			}
		});
		panel_3.add(button_1);

		// 清除
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = "";
				textField_1.setText(expression);
				// textField_1.setText("");
				textField_2.setText("");
			}
		});
		panel_3.add(btnC);

		// 加法
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_2.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_2);

		// 数字7
		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_3.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_3);

		// 数字8
		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_4.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_4);

		// 数字9
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_5.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_5);

		// 减法
		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_6.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_6);

		// 数字4
		JButton button_7 = new JButton("4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_7.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_7);

		// 数字5
		JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_8.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_8);

		// 数字6
		JButton button_9 = new JButton("6");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_9.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_9);

		// 乘法
		JButton button_10 = new JButton("*");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_10.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_10);

		// 数字1
		JButton button_11 = new JButton("1");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_11.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_11);

		// 数字2
		JButton button_12 = new JButton("2");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_12.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_12);

		// 数字3
		JButton button_13 = new JButton("3");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_13.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_13);

		// 除法
		JButton button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_14.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_14);

		// 小数点
		JButton button_15 = new JButton(".");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_15.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_15);

		// 数字0
		JButton button_16 = new JButton("0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_16.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_16);

		// 等号
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compute cv = new Compute(expression);

				cv.calculate();

				textField_1.setText(expression);
				textField_2.setText(cv.resultstr);
				textField.setText(expression + "=" + cv.resultstr);
			}
		});
		panel_7.add(btnNewButton);
	}

}
