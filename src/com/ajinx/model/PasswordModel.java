package com.ajinx.model;

import javax.swing.JOptionPane;

import com.ajinx.ui.Show;

public class PasswordModel {
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean validate(final Show view) {
		this.word = String.valueOf(view.passwordField.getPassword());
		if (this.word.length() == 0) {
			JOptionPane.showMessageDialog(view.getContentPane(), "Enter something to verify!", "Empty",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		final Integer safeOption = (Integer) view.safeSpinner.getValue();
		final Integer easyOption = (Integer) view.easySpinner.getValue();
		final Integer saltOption = (Integer) view.saltSpinner.getValue();

		if (safeOption == easyOption && (safeOption != 0 || easyOption != 0)) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Offensive Word Filter & Common Word Filter have same priorities!", "Selection Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (safeOption == saltOption && (safeOption != 0 || saltOption != 0)) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Offensive Word Filter & Salting have same priorities!", "Selection Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (saltOption == easyOption && (saltOption != 0 || easyOption != 0)) {
			JOptionPane.showMessageDialog(view.getContentPane(), "Common Word Filter & Salting have same priorities!",
					"Selection Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
