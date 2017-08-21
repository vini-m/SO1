package View;

import java.util.Scanner;

import Controller.ProcessController;

public class Main {
	public static void main(String[] args) {
		ProcessController proc = new ProcessController();
		String osName = System.getProperty("os.name");
		
		if (osName.contains("Win"))
			proc.readProcess("tasklist.exe /fo table");
		else
			proc.readProcess("ps a");
		
		System.out.println("Type the process you want to kill: ");
		Scanner sc = new Scanner(System.in);
		String pidOrName = sc.nextLine();
		if (osName.contains("Win"))
			proc.killProcessWindows(pidOrName);
		else
			proc.killProcessNIX(pidOrName);;
		
	}
}
