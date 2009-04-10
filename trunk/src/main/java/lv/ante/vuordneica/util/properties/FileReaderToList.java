package lv.ante.vuordneica.util.properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderToList {
	
	FileInputStream fis;
	InputStreamReader isr; 
	BufferedReader br;	
	
	public FileReaderToList(String fileName) {
		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);		
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}		
	}

	public List<String> load() {
		List<String> lines = new ArrayList<String>();
		String line = null;
		try {
			while ((line = br.readLine())!=null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public void close() {
		try {
			br.close();
			isr.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
