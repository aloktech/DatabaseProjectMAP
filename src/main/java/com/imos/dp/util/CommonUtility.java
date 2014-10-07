/**
 * 
 */
package com.imos.dp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pintu
 *
 */
public class CommonUtility {

	public static List<String> extractPackageNameFromFilePath(String filePath, String startPhrase, String fileExt) {
		List<String> paths = new ArrayList<>();
		if (filePath.contains(",")) {
			for (String p : filePath.split(",")) {
				File dir = new File(p);
				checkForDirectory(startPhrase, fileExt, paths, dir);
			}
		} else {
			File dir = new File(filePath);
			checkForDirectory(startPhrase, fileExt, paths, dir);
		}

		return paths;
	}

	private static void checkForDirectory(String startPhrase, String fileExt, List<String> paths, File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isFile() && file.getName().endsWith(fileExt)) {
					String path = file.getPath();
					path = path.substring(path.indexOf(startPhrase) + startPhrase.length() + 1,
							path.lastIndexOf(fileExt) - 1);
					path = path.replaceAll("\\\\", ".");
					paths.add(path); 
				}
			}
		}
	}
}
