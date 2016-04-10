package com.ajinx.model;

import javax.swing.JOptionPane;

import com.ajinx.ui.Show;

public class WordResponseModel {
	public enum ResponseCode {
		BAD, COMMON, SALTED, CLEAN
	};

	private ResponseCode code;
	private String saltedString;

	public ResponseCode getCode() {
		return code;
	}

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public String getSaltedString() {
		return saltedString;
	}

	public void setSaltedString(String saltedString) {
		this.saltedString = saltedString;
	}

	public boolean validate(final Show view) {
		if (code == ResponseCode.BAD) {
			JOptionPane.showMessageDialog(view.getContentPane(), "Invalid password. Offensive word detected!",
					"Offensive Word Filter", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (code == ResponseCode.COMMON) {
			JOptionPane.showMessageDialog(view.getContentPane(), "Invalid password. Common word detected!",
					"Common Word Filter", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (code == ResponseCode.SALTED) {
			JOptionPane.showMessageDialog(view.getContentPane(), "Password salted: " + getSaltedString(), "Salt Filter",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	public void acceptPassword(final Show view) {
		JOptionPane.showMessageDialog(view.getContentPane(), "Password valid!", "Password Verification",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
