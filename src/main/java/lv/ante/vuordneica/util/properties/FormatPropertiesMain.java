package lv.ante.vuordneica.util.properties;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class FormatPropertiesMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FormatPropertyTemplate fpt = new FormatPropertyTemplate();
		Iterator<String> it = fpt.getPropFile();
		FileOutputStream fos = new FileOutputStream("ApplicationResources_ltg.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		while (it.hasNext()) {
			bw.write(it.next());
			bw.newLine();
		}
		fpt.printReport();
		bw.close();
		osw.close();
		fos.close();
	}

}
