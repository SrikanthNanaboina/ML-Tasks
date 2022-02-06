package com.bhavna.textfileprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessor {
	private static Map<String, List<LoginRecord>> infoMap = new HashMap<>();
	private static Map<String, List<String>> failMap = new HashMap<>();
	
	public static void processFile(String path) {
		File file = new File(path);
		 
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str;
			while ((str = br.readLine()) != null) {
				try {
					parseLine(str);
				}
				catch(LogFormatException e) {
					if(!failMap.containsKey(e.getMessage()))
						failMap.put(e.getMessage(), new ArrayList<String>());
						
					failMap.get(e.getMessage()).add(str);
		        }
				
			}
		}
        catch(FileNotFoundException e) {
        	System.err.println("File not found");
        }
        catch(IOException e) {
        	System.out.println("Error while reading file");
        }
        finally {
			System.out.println("=== Success Map ===");
			infoMap.forEach((k,v)-> {
										System.out.println("User: "+ k +", No. of Logins: "+v.size());
										v.forEach(log-> System.out.println(log.getTime()+" "+log.getDate()));
										System.out.println();
									});
			
			System.out.println("=== Fail Map ===");
			failMap.forEach((k,v)-> {
										System.out.println("Error: "+k);
										v.forEach(line-> System.out.println(line));
										System.out.println();
									});
		}
        
		
	}
	
	public static void parseLine(String line) throws LogFormatException{
			
		String[] arr = line.trim().split("\\s+");
		
		if(arr.length!=4)
			throw new LogFormatException("Invalid Format");
		
		if(!arr[0].matches("[a-zA-z]+"))
			throw new LogFormatException("Invalid Name Format");
		
		if(!arr[1].matches(	  "(0?2\\/(0?[1-9]|[12][0-9])|"
							+ "(0?[469]|11)\\/(0?[1-9]|[12][0-9]|30)|"
							+ "(0?[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))"))
			throw new LogFormatException("Invalid Day Format");
		
		if(!(arr[2]+" "+arr[3]).matches("(0?[1-9]|1[012]):[0-5][0-9]\\s[AaPp][mM]$"))
			throw new LogFormatException("Invalid Time Format");
		
		if(!infoMap.containsKey(arr[0]))
			infoMap.put(arr[0], new ArrayList<LoginRecord>());
			
		infoMap.get(arr[0]).add(new LoginRecord(arr[0], arr[1], (arr[2]+" "+arr[3])) );		

	}

}
