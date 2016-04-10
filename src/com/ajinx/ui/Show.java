package com.ajinx.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class Show extends JFrame {
	private static final long serialVersionUID = 1L;

	public JPasswordField passwordField;
	public JButton btnVerify;
	public JTextPane txtpnPassword;
	public JTextPane txtpnSafefilter;
	public JTextPane txtpnEasyfilter;
	public JTextPane txtpnWordsalt;
	public JSpinner safeSpinner;
	public JSpinner easySpinner;
	public JSpinner saltSpinner;
	public JButton btnReset;
	public JOptionPane notification;

	public Show() {
		setTitle("598 Password Checker");
		getContentPane().setLayout(null);
		setBounds(100, 100, 400, 374);

		btnVerify = new JButton("Verify");
		btnVerify.setBounds(147, 238, 89, 23);
		getContentPane().add(btnVerify);

		txtpnSafefilter = new JTextPane();
		txtpnSafefilter.setEditable(false);
		txtpnSafefilter.setBackground(UIManager.getColor("Panel.background"));
		txtpnSafefilter.setText("Offensive Word Filter");
		txtpnSafefilter.setBounds(109, 95, 125, 20);
		getContentPane().add(txtpnSafefilter);

		txtpnEasyfilter = new JTextPane();
		txtpnEasyfilter.setEditable(false);
		txtpnEasyfilter.setBackground(UIManager.getColor("Panel.background"));
		txtpnEasyfilter.setText("Common Word Filter");
		txtpnEasyfilter.setBounds(109, 137, 125, 20);
		getContentPane().add(txtpnEasyfilter);

		txtpnWordsalt = new JTextPane();
		txtpnWordsalt.setEditable(false);
		txtpnWordsalt.setBackground(UIManager.getColor("Panel.background"));
		txtpnWordsalt.setText("Salting");
		txtpnWordsalt.setBounds(109, 178, 125, 20);
		getContentPane().add(txtpnWordsalt);

		safeSpinner = new JSpinner();
		safeSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		safeSpinner.setBounds(240, 95, 29, 20);
		getContentPane().add(safeSpinner);

		easySpinner = new JSpinner();
		easySpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		easySpinner.setBounds(240, 137, 29, 20);
		getContentPane().add(easySpinner);

		saltSpinner = new JSpinner();
		saltSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		saltSpinner.setBounds(240, 178, 29, 20);
		getContentPane().add(saltSpinner);

		btnReset = new JButton("Reset");
		btnReset.setBounds(147, 272, 89, 23);
		getContentPane().add(btnReset);

		txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("PASSWORD");
		txtpnPassword.setBackground(UIManager.getColor("Panel.background"));
		txtpnPassword.setBounds(156, 11, 71, 20);
		getContentPane().add(txtpnPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(114, 39, 155, 20);
		getContentPane().add(passwordField);
	}

	public void resetSpinners() {
		safeSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		easySpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		saltSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
	}

	public Integer[] getSpinnerValues() {
		final Integer[] options = new Integer[3];
		options[0] = (Integer) safeSpinner.getValue();
		options[1] = (Integer) easySpinner.getValue();
		options[2] = (Integer) saltSpinner.getValue();
		return options;
	}
}
