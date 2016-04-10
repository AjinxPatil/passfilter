package com.ajinx.core;

import java.awt.EventQueue;

import com.ajinx.control.Controller;
import com.ajinx.model.PasswordModel;
import com.ajinx.ui.Show;

public class WordChecker {
	public static void main(String[] args) {
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						final PasswordModel model = new PasswordModel();
						final Show view = new Show();
						final Controller controller = new Controller(model, view);
						controller.control();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
