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
				frame.setTitle("������");// ���ñ���
				frame.setVisible(true);// ����ͼ�ν���ɼ�

			}
		});
	}

	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 350, 500);// ���ô�����Ϊ350���߶�Ϊ500,��ʹ����ʾ�ھ���Ļ���Ϸ����꣨600,200����λ�ô�
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// ���ñ߿�����Ϊ5
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 0));// ��������8�в��ֵ�����
		contentPane.setBackground(Color.LIGHT_GRAY);// ���ñ�����ɫ

		JPanel panel = new JPanel();// ������ʷ��¼������
		contentPane.add(panel);// ����׺���ʽ�����ӽ�
		panel.setLayout(new BorderLayout(0, 0));
		JLabel label = new JLabel(" ��ʷ��¼");
		panel.add(label, BorderLayout.WEST);

		textField = new JTextField();
		textField.setEditable(false);// ����ʷ��¼�ı�������Ϊ���ɱ༭
		panel.add(textField, BorderLayout.CENTER);// ����ʷ��¼�������ı�����
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();// ��������������
		contentPane.add(panel_1);// �����������ӽ�contentPane
		panel_1.setLayout(new BorderLayout(0, 0));// �����������Ϊ�߿򲼾�
		JLabel lblNewLabel = new JLabel("��ǰ����:");
		panel_1.add(lblNewLabel, BorderLayout.WEST);// �����������ı�ǩ������

		textField_1 = new JTextField();
		textField_1.setEditable(false);// �������ı�������Ϊ���ɱ༭
		panel_1.add(textField_1, BorderLayout.CENTER);// �������������ı�����
		textField_1.setColumns(10);// �����ı��ֶ�����

		JPanel panel_2 = new JPanel();// ����������������
		contentPane.add(panel_2);// �������������ӽ�contentPane
		panel_2.setLayout(new BorderLayout(0, 0));
		JLabel label_1 = new JLabel("������:");
		panel_2.add(label_1, BorderLayout.WEST);

		textField_2 = new JTextField();
		textField_2.setEditable(false);// ���������ı�������Ϊ���ɱ༭
		panel_2.add(textField_2, BorderLayout.CENTER);// ���������������ı�����
		textField_2.setColumns(10);

		JPanel panel_3 = new JPanel();// �����ؼ�������
		contentPane.add(panel_3);// ���ؼ������ӽ�contentPane
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));// ��������1�в��ֵ�����

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

		// ������
		JButton button = new JButton("(");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button.getText();
				textField_1.setText(expression);
			}
		});
		panel_3.add(button);

		// ������
		JButton button_1 = new JButton(")");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_1.getText();
				textField_1.setText(expression);
			}
		});
		panel_3.add(button_1);

		// ���
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

		// �ӷ�
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_2.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_2);

		// ����7
		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_3.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_3);

		// ����8
		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_4.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_4);

		// ����9
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_5.getText();
				textField_1.setText(expression);
			}
		});
		panel_4.add(button_5);

		// ����
		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_6.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_6);

		// ����4
		JButton button_7 = new JButton("4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_7.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_7);

		// ����5
		JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_8.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_8);

		// ����6
		JButton button_9 = new JButton("6");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_9.getText();
				textField_1.setText(expression);
			}
		});
		panel_5.add(button_9);

		// �˷�
		JButton button_10 = new JButton("*");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_10.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_10);

		// ����1
		JButton button_11 = new JButton("1");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_11.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_11);

		// ����2
		JButton button_12 = new JButton("2");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_12.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_12);

		// ����3
		JButton button_13 = new JButton("3");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_13.getText();
				textField_1.setText(expression);
			}
		});
		panel_6.add(button_13);

		// ����
		JButton button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_14.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_14);

		// С����
		JButton button_15 = new JButton(".");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_15.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_15);

		// ����0
		JButton button_16 = new JButton("0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression += button_16.getText();
				textField_1.setText(expression);
			}
		});
		panel_7.add(button_16);

		// �Ⱥ�
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
