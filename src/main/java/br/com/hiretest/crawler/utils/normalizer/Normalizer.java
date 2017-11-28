package br.com.hiretest.crawler.utils.normalizer;

import org.apache.commons.text.StringEscapeUtils;

import br.com.hiretest.crawler.utils.regex.PatternConstants;

public class Normalizer {
	
	/**
	 * Remove tabs, non breaking spaces(&nbsp;) and breaking lines
	 */
	public static String normalizeHtml(String content) {
		return StringEscapeUtils.unescapeHtml4(content.replaceAll(PatternConstants.REPLACE_NORMALIZE_HTML, "").trim());
	}

}
