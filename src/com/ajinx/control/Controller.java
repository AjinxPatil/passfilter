package com.ajinx.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ajinx.filter.Filter;
import com.ajinx.filter.FilterChain;
import com.ajinx.model.PasswordModel;
import com.ajinx.model.WordResponseModel;
import com.ajinx.ui.Show;

public class Controller {
	private PasswordModel password;
	private Show window;

	@SuppressWarnings("unused")
	private Controller() {

	}

	public Controller(PasswordModel model, Show view) {
		this.password = model;
		this.window = view;
	}

	public void control() {
		window.setVisible(true);

		ActionListener spinResetter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.resetSpinners();
			}
		};
		window.btnReset.addActionListener(spinResetter);

		ActionListener verifier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!password.validate(window)) {
					return;
				}
				WordResponseModel response = null;
				final FilterChain chain = new FilterChain();
				final Integer[] options = window.getSpinnerValues();
				chain.make(options);
				final Filter[] filters = chain.getFilters();
				if (filters.length == 0) {
					new WordResponseModel().acceptPassword(window);
					return;
				}
				int i = 0;
				while (i < filters.length) {
					if (filters[i] == null) {
						i++;
						continue;
					}
					response = filters[i].execute(password);
					if (!response.validate(window)) {
						break;
					}
					i++;
				}
				if (i == filters.length) {
					response.acceptPassword(window);
				}
			}
		};
		window.btnVerify.addActionListener(verifier);
	}
}
