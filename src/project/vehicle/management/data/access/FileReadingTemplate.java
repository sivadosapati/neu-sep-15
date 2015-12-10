package project.vehicle.management.data.access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class FileReadingTemplate {
	private boolean skipFirstLine = false;
	public void setSkipFirstLine(boolean b){
		this.skipFirstLine = b;
	}
	public void parseFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		if( skipFirstLine == true){
			br.readLine();
		}
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			processLine(line);
		}
		try {
			br.close();
		} catch (Exception e) {

		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
	

	public abstract void processLine(String line);
}
