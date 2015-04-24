package com.wvaviator.aviatorapi.File;

import java.io.File;
import java.io.FileNotFoundException;

import com.wvaviator.aviatorapi.AviatorAPI;

public class FileReference {
	
	private static File configurationDirectory = AviatorAPI.configurationDirectory;
	private static File serverDirectory = new File(configurationDirectory.getParent());
	private static File modsDirectory = new File(serverDirectory.getPath() + "/mods");

	/**The configuration directory is the folder labeled "config" in the server
	 * directory. It contains configuration .cfg files for this and other mods.
	 * @return The configuration directory file
	 */
	public static File getConfigDirectory() {
		return configurationDirectory;
	}
	
	/**The server directory is the primary directory which contains all files
	 * relating to the server, including within it the server jar, mods folder,
	 * server.properties file, and other files and directories.
	 * @return The server directory file
	 */
	public static File getServerDirectory() {
		return serverDirectory;
	}
	
	/**The mods directory is the directory folder which contains all the mods loaded
	 * by FML on the server, including this.
	 * @return The mods directory file
	 */
	public static File getModsDirectory() {
		return modsDirectory;
	}
	
	/**The world directory contains all of the region files and player information for a 
	 * specific world. World directory names can change based on the server, be wary if you
	 * are designing a mod for lots of different servers which may have worlds with different
	 * names or multiple world folders.
	 * @param worldName The name of the directory, usually the same as the world name
	 * @return The world directory file
	 * @throws DirectoryNotFoundException If the specified directory name does not exist
	 */
	public static File getWorldDirectory(String worldName) throws FileNotFoundException {
		File worldDirectory = new File(serverDirectory.getPath() + "/" + worldName);
		if (!worldDirectory.exists()) {
			String message = "Attempted to access world directory at path: " + worldDirectory.getPath() + "\n"
					+ "This directory does not appear to exist. Please ensure you've specified the correct "
					+ "world name and that the directory matches the world name.";
			throw new FileNotFoundException(message);
		}
		return worldDirectory;
	}
	
	/**The server.properties file containing basic server options in the main server directory
	 * @return The server.properties text file
	 */
	public static File getServerPropertiesFile() {
		File serverPropertiesFile = new File(serverDirectory.getPath() + "/server.properties");
		return serverPropertiesFile;
	}
	
	/**The logs directory located in the main server directory contains current log files and
	 * FML debugging logs.
	 * @return The logs directory file
	 */
	public static File getLogsDirectory() {
		File logsDirectory = new File(serverDirectory.getPath() + "/logs");
		return logsDirectory;
	}
	
	/**Check to see if a file exists. Great for avoiding NPEs
	 * @param file The string name of the file you wish to find exists (case sensitive)
	 * @param directory The directory the file should be in
	 * @return TRUE if the file exists, FALSE if it does not
	 */
	public static boolean doesFileExist(String file, File directory) {
		File exists = new File(directory.getPath() + "/" + file);
		if (exists.exists()) return true;
		return false;
	}
	
	/**Check to see if a directory exists inside the specified parent directory
	 * @param directoryName The name of the directory you want to check exists
	 * @param parentDirectory The parent directory to check inside of
	 * @return TRUE if the directory exists, FALSE if not
	 */
	public static boolean doesDirectoryExist(String directoryName, File parentDirectory) {
		File exists = new File(parentDirectory.getPath() + "/" + directoryName);
		if (exists.exists()) return true;
		return false;
	}
	
	/**Create a new directory with the name of your choice inside the parent directory
	 * of your choice. If the directory already exists, this does nothing.
	 * For example, to create a folder named "MyMod" inside the "config"
	 * folder, use createDirectory("MyMod", FileReference.getConfigDirectory);
	 * @param directoryName The name of the new directory you wish to create
	 * @param parentDirectory The directory your new directory should be contained within
	 */
	public static void createDirectory(String directoryName, File parentDirectory) {
		File directory = new File(parentDirectory.getPath() + directoryName);
		if (!directory.exists()) return;
		directory.mkdir();
	}
	
	/**Retrieve the specified file if it exists, otherwise return an exception.
	 * @param fileName The name of the file to retrieve
	 * @param parentDirectory The directory the file is within
	 * @return The requested file
	 * @throws FileNotFoundException If the file doesn't exist
	 */
	public static File getFile(String fileName, File parentDirectory) throws FileNotFoundException {
		File file = new File(parentDirectory.getPath() + "/" + fileName);
		if (!file.exists()) {
			String message = "Attempted to retrieve a file that doesn't exist!\n"
					+ "Tried to get file from directory: " + file.getPath();
			throw new FileNotFoundException(message);
		}
		return file;
	}
	
	/**Retrieve the specified directory if it exists, otherwise return an exception.
	 * @param fileName The name of the file to retrieve
	 * @param parentDirectory The directory the file is within
	 * @return The requested file
	 * @throws FileNotFoundException If the file doesn't exist
	 */
	public static File getDirectory(String directoryName, File parentDirectory) throws FileNotFoundException {
		File file = new File(parentDirectory.getPath() + "/" + directoryName);
		if (!file.exists()) {
			String message = "Attempted to retrieve a directory that doesn't exist!\n"
					+ "Tried to get file from directory: " + file.getPath();
			throw new FileNotFoundException(message);
		}
		return file;
	}
	
}
