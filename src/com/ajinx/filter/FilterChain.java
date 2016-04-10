package com.ajinx.filter;

public class FilterChain {
	private Filter[] filters;

	public void make(final Integer[] prio) {
		filters = new Filter[3];
		if (prio[0] != 0) {
			filters[prio[0] - 1] = new SafeWordFilter();
		}
		if (prio[1] != 0) {
			filters[prio[1] - 1] = new CommonWordFilter();
		}
		if (prio[2] != 0) {
			filters[prio[2] - 1] = new SaltFilter();
		}
		if (prio[0] == prio[1] && prio[1] == prio[2] && prio[0] == 0) {
			filters = new Filter[0];
		}
	}

	public Filter[] getFilters() {
		return filters;
	}

}
