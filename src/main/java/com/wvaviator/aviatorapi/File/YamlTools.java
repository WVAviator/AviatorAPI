package com.wvaviator.aviatorapi.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlTools {
	
	/**This method returns a Map object from a YML file. The Map will contain other Maps and Lists
	 * by retrieving data from the .yml file. 
	 * @param yamlFile The .yml file to retrieve the data from
	 * @return A Map containing all information in the .yml file
	 * @throws FileNotFoundException if the file is not found
	 */
	public static Map getYamlMap(File yamlFile) throws FileNotFoundException {
		
		InputStream input = new FileInputStream(yamlFile);
		Yaml yaml = new Yaml();
		Object data = yaml.load(input);
		Map map = (Map) data;
		return map;
		
	}

}
