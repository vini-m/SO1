package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {
	public void callProcess(String path){
		try{
			Runtime.getRuntime().exec(path);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println("Couldn\'t start process - " + msg);
		}
	}
	
	public void readProcess(String path){
		try {
			Process proc = Runtime.getRuntime().exec(path);
			InputStream stream = proc.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(streamReader);
			String line = buffer.readLine();
			while(line != null){
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void killProcessWindows(String proc){
		String cmdPID = "TASKKILL /PID ";
		String cmdName = "TASKKILL /IM ";
		StringBuffer cmdBuffer = new StringBuffer();
		
		int pid = 0;
		try{
			pid = Integer.parseInt(proc);
			cmdBuffer.append(cmdPID);
		} catch (NumberFormatException e) {
			cmdBuffer.append(cmdName);
		} finally {
			cmdBuffer.append(proc);
		}
		
		this.callProcess(cmdBuffer.toString());
	}
	
	public void killProcessNIX(String proc){
		String cmdPID = "kill ";
		String cmdName = "killall ";
		StringBuffer cmdBuffer = new StringBuffer();
		
		int pid = 0;
		try{
			pid = Integer.parseInt(proc);
			cmdBuffer.append(cmdPID);
		} catch (NumberFormatException e) {
			cmdBuffer.append(cmdName);
		} finally {
			cmdBuffer.append(proc);
		}
		
		this.callProcess(cmdBuffer.toString());
	}
}
