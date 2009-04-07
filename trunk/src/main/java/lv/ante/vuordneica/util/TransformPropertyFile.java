package lv.ante.vuordneica.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Changes ApplicationResources_lv.properties into Unicode-escaped property file
 * 
 * @author kap
 */
public class TransformPropertyFile {
	public static String transform(String arg) {
		arg = arg.replaceAll("Ā", "\\\\u0100");
		arg = arg.replaceAll("ā", "\\\\u0101");
		arg = arg.replaceAll("Ē", "\\\\u0112");
		arg = arg.replaceAll("ē", "\\\\u0113");
		arg = arg.replaceAll("Ī", "\\\\u012a");
		arg = arg.replaceAll("ī", "\\\\u012b");
		arg = arg.replaceAll("Ō", "\\\\u014c");
		arg = arg.replaceAll("ō", "\\\\u014d");
		arg = arg.replaceAll("Ū", "\\\\u016a");
		arg = arg.replaceAll("ū", "\\\\u016b");
		
		arg = arg.replaceAll("Č", "\\\\u010c");
		arg = arg.replaceAll("č", "\\\\u010d");
		arg = arg.replaceAll("Ģ", "\\\\u0122");
		arg = arg.replaceAll("ģ", "\\\\u0123");
		arg = arg.replaceAll("Ķ", "\\\\u0136");
		arg = arg.replaceAll("ķ", "\\\\u0137");
		arg = arg.replaceAll("Ļ", "\\\\u013b");
		arg = arg.replaceAll("ļ", "\\\\u013c");
		arg = arg.replaceAll("Ņ", "\\\\u0145");
		arg = arg.replaceAll("ņ", "\\\\u0146");
		arg = arg.replaceAll("Ŗ", "\\\\u0156");
		arg = arg.replaceAll("ŗ", "\\\\u0157");
		arg = arg.replaceAll("Š", "\\\\u0160");
		arg = arg.replaceAll("š", "\\\\u0161");
		arg = arg.replaceAll("Ž", "\\\\u017d");
		arg = arg.replaceAll("ž", "\\\\u017e");
		
		return arg; 
	}
	
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("src/main/resources/ApplicationResources_ltg.properties");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fos = new FileOutputStream("src/main/resources/ApplicationResources_lv.properties");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		String line = null;
		while((line = br.readLine()) != null) {
			bw.write(transform(line));
			bw.newLine();
		}
		
		bw.close();
		osw.close();
		fos.close();
		
		br.close();
		isr.close();
		fis.close();
	}
}
