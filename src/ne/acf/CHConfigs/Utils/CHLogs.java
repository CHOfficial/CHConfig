package ne.acf.CHConfigs.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CHLogs {

	public String msg;
	public boolean save;
	
	public CHLogs (String log, boolean salvar)
	{
		msg = log;
		save = salvar; 
		
		Anunciar();
		if (salvar)
		salvarLog();
	}
	
	private void Anunciar()
	{
		System.out.print(msg);
	}
	
	 private void salvarLog() {
		    try {
		      File saveTo = new File("CHLog.log");
		      if (!saveTo.exists()) {
		        saveTo.createNewFile();
		      }
		      FileWriter fw = new FileWriter(saveTo, true);
		      PrintWriter pw = new PrintWriter(fw);
		      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		      Date date = new Date();
		      pw.println(dateFormat.format(date) + " - " + 
		        msg);
		      pw.flush();
		      pw.close();
		    } catch (IOException e) {
		    	
		      e.printStackTrace();
		      
		    }
		    
		  }
}
