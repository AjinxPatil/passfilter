package com.ajinx.filter;

import com.ajinx.model.PasswordModel;
import com.ajinx.model.WordResponseModel;

public interface Filter {
	public static final String RESOURCE = "/resources/file";

	public WordResponseModel execute(final PasswordModel password);
}
