package com.springEmp.springBoot.GlobalLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobLog {

	public static Logger getLogger(Class className) {
		return LoggerFactory.getLogger(className);
	}
}