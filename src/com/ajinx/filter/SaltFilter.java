package com.ajinx.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.ajinx.model.PasswordModel;
import com.ajinx.model.WordResponseModel;
import com.ajinx.model.WordResponseModel.ResponseCode;

public class SaltFilter implements Filter {

	public static final String RESOURCE = "resources/SALT.txt";

	public WordResponseModel execute(final PasswordModel password) {
		try {
			final FileReader reader = new FileReader(RESOURCE);
			final BufferedReader br = new BufferedReader(reader);

			final WordResponseModel response = new WordResponseModel();
			response.setCode(ResponseCode.CLEAN);

			final StringBuffer word = new StringBuffer(password.getWord());
			String item = br.readLine();
			response.setSaltedString(word.append(item).toString());
			response.setCode(ResponseCode.SALTED);
			reader.close();
			return response;
		} catch (FileNotFoundException e) {
			// TODO error handling
		} catch (IOException e) {
			// TODO error handling
		}
		return null;
	}

}
