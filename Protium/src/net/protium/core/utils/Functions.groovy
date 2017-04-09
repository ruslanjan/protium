/*
 * Copyright (C) 2017 Ruslan Jankurazov, Dmitry Ussoltsev - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.core.utils

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class Functions {

	static String implode(String[] array, String glue) {
		StringBuilder builder = new StringBuilder()

		for (String current :
			array) {
			builder
				.append(current)
				.append(glue)
		}

		String result = builder.toString()

		return result.substring(0, result.length() - glue.length())
	}

	@SuppressWarnings("GroovyUnusedDeclaration")
	static String[] listFiles(String folder, String extension) {
		def result = Files.walk(Paths.get(folder))
			.filter({ p ->  p.toString().endsWith(extension) })
			.collect(Collectors.toList())

		result as String[]
	}

	static String pathToFile(String[] folder, String fileName, String extension)
	{
		implode(folder + [fileName], File.separator) + extension
	}
}
