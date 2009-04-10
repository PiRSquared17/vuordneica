package lv.ante.vuordneica.util.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Class receives a property file template (usually English properties, such as
 * ApplicationResources.properties) It also receives properties, which partly
 * overlap with the keys found in template The task is to output property file,
 * which matches the original template (with all the ENglish comments) But
 * meanwhile it has the property values properly replaced and encoded.
 * 
 * @author kap
 * 
 */
public class FormatPropertyTemplate {
	
	private PropertyFileLineIterator iterator;
	private Properties props = new Properties();
	
	public Iterator<String> getPropFile() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileInputStream("src/main/resources/ApplicationResources_ltg.properties"));
		FileReaderToList it = new FileReaderToList("src/main/resources/ApplicationResources.properties");
		List<String> list = it.load();
		it.close();
		iterator = new PropertyFileLineIterator(props, list);
		return iterator;
	}
	
	public void printReport() {
		System.out.println("\n\nProperty size: " + props.size());
		System.out.println("Found: " + iterator.getFound());
		System.out.println("Not Found: " + iterator.getNotFound());
		System.out.println("Comment lines: " + iterator.getComments());
		System.out.println("Empty lines: " + iterator.getEmpty());
	}
}
