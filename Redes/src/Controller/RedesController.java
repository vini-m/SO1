package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String ip(String osName) {
		// TODO awk script
		StringBuffer adapterInfo = new StringBuffer();
		StringBuffer cmd = new StringBuffer();
		if (osName.contains("Win")) cmd.append("ipconfig");
		else cmd.append("ifconfig");
		
		try {
			Process proc = Runtime.getRuntime().exec(cmd.toString());
			InputStream stream = proc.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(streamReader);
			
			String line;
			do {
				line = buffer.readLine();
				if (line.contains("flags")) 
					adapterInfo.append();
			} while(line != null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return adapterInfo.toString();
	}
}
