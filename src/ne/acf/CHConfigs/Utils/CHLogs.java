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
		
		if (salvar)
		salvarLog();
	}
	
	 private void salvarLog() {
		    try {
		      File saveTo = new File("CHLog.log");
		      if (!saveTo.exists()) {
		        saveTo.createNewFile();
		      }
		      long tamanho = saveTo.length();
		      long limite = 1000000;
		      if (tamanho >= limite)
		      {
		    	  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			      Date date = new Date();
		    	  File limit = new File("CHLog - " + dateFormat.format(date) + ".log");
		    	  if(saveTo.renameTo(limit)){
		    	        System.out.println("Nova fila criada com exito");
		    	        saveTo.createNewFile();
		    	  }
		    	  else
		    	  {
		  	        System.out.println("Ocoreu um erro ao tentar criar uma nova fila"); 
		    	  }
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
