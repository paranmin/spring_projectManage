package com.dgit.util;

public class PagingUtil {
	private static PagingUtil instance = new PagingUtil();

	public static PagingUtil getInstance() {
		return instance;
	}

	private PagingUtil() {
	}

	public String makePaging(int cnt, int page, int width, int row, String url) {
		if (cnt <= 0) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<p class=\"paging\">");
		String prev = "";
		if (page <= 1) {
			prev = String.format("%s?page=%s", url, 1);
		} else if (page >= cnt) {
			prev = String.format("%s?page=%s", url, cnt);
		} else {
			prev = String.format("%s?page=%s", url, page - 1);
		}
		sb.append(String.format("<a href=\"%s\">이전</a> ", prev));

		for (int i = 0; i < cnt; i++) {
			int cur = i + 1;
			if (cur == page) {
				sb.append(String.format("<a href=\"#\">%2$s</a> ", url, cur));
			} else {
				sb.append(String.format("<a href=\"%s?page=%2$s\">%2$s</a> ", url, cur));
			}
		}
		String next = "";
		if (page >= cnt) {
			next = String.format("%s?page=%s", url, cnt);
		} else {
			next = String.format("%s?page=%s", url, page + 1);
		}
		sb.append(String.format("<a href=\"%s\">다음</a>", next));
		sb.append("</p>");
		return sb.toString();
	}

}
