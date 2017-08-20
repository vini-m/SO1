package Controller;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String ip(String osName) {
		String adapterInfo;
		StringBuffer cmd = new StringBuffer();
		if (osName.contains("win")) cmd.append("ipconfig");
		else cmd.append("ifconfig");
		
		return adapterInfo;
	}
}
