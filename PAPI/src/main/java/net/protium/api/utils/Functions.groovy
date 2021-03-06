/*
 * Copyright (C) 2017 - Protium - Ussoltsev Dmitry, Jankurazov Ruslan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.api.utils

import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Matcher
import java.util.stream.Collectors

final class Functions {
	static String implode(String[] array, String glue) {
		StringBuilder builder = new StringBuilder()

		for (String current :
				array) {
			builder
					.append(current)
					.append(glue)
		}

		String result = builder.toString()

		if (result.length() < glue.length()) {
			return result
		}
		result.substring(0, result.length() - glue.length())
	}

	static String implode(List array, String glue) {
		StringBuilder builder = new StringBuilder()

		for (String current :
				array) {
			builder
					.append(current)
					.append(glue)
		}

		String result = builder.toString()

		if (result.length() < glue.length()) {
			return result
		}
		result.substring(0, result.length() - glue.length())
	}

	static String[] listFiles(String folder, String extension) {
		def result = Files.walk(Paths.get(folder))
				.filter({ p -> p.toString().endsWith(extension) })
				.collect(Collectors.toList())

		result as String[]
	}

	static String pathToFile(String[] folder, String fileName, String extension) {
		folder += fileName
		String path = implode(folder, File.separator) + extension

		if (Files.exists(Paths.get(path))) {
			path
		} else {
			throw new FileNotFoundException()
		}
	}

	static String pathToFile(String folder, String fileName, String extension) {
		def path = [folder, fileName] as String[]
		path = implode(path, File.separator) + extension

		if (Files.exists(Paths.get(path))) {
			path
		} else {
			throw new FileNotFoundException()
		}
	}

	static String createFile(String[] folder, String fileName, String extension) {
		folder += fileName
		String path = implode(folder, File.separator) + extension
		path
	}

	static String createFile(String folder, String fileName, String extension) {
		String[] path = [folder, fileName] as String[]
		implode(path, File.separator) + extension
	}

	static String getFileName(String filePath) {
		File target = new File(filePath)
		def arrPath = target.getName().split('\\.') as String[]
		arrPath = arrPath.length > 1 ? arrPath[0..-2] : [arrPath[0]]
		implode(arrPath as String[], ".")
	}

	static boolean matchRegex(String regex, String needle) {
		(needle =~ regex).matches()
	}

	static Matcher getMatcher(String regex, String needle) {
		(needle =~ regex)
	}

	static Integer min(Integer a, Integer b) {
		(a < b ? a : b)
	}

	@Deprecated
	static void debug(s) {
		println "========================="
		println s
		println "========================="
	}
}
