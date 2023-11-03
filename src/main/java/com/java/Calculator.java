package com.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;
	private JTextField output;
	private JButton multiButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(10, 10, 800, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		num1 = new JTextField();
		num1.setBounds(136, 115, 162, 38);
		panel.add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setColumns(10);
		num2.setBounds(396, 115, 162, 38);
		panel.add(num2);
		
		output = new JTextField();
		output.setColumns(10);
		output.setBounds(136, 207, 422, 38);
		panel.add(output);
		
		JButton addButton = new JButton("Add");
		addButton.setBackground(UIManager.getColor("Button.highlight"));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n1=Integer.parseInt(num1.getText());
				int n2=Integer.parseInt(num1.getText());
				int result=n1+n2;
			output.setText("Addition Result="+result );
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(136, 295, 135, 47);
		panel.add(addButton);
		
		multiButton = new JButton("*");
		multiButton.setBackground(UIManager.getColor("Button.highlight"));
		multiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n1=Integer.parseInt(num1.getText());
				int n2=Integer.parseInt(num1.getText());
				int result=n1*n2;
			output.setText("Multiplication Result="+result );
				
			}
		});	
		multiButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		multiButton.setBounds(317, 293, 135, 49);
		panel.add(multiButton);
		
		JLabel lblNewLabel = new JLabel("Calculator");
		lblNewLabel.setBackground(new Color(255, 250, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 24, 404, 47);
		panel.add(lblNewLabel);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBackground(UIManager.getColor("Button.highlight"));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				output.setText("");
			}
		});
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		refreshButton.setBounds(483, 293, 120, 47);
		panel.add(refreshButton);
	}
}
