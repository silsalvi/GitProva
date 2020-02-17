package lib;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		ArrayList<libro> lib = new ArrayList<libro>();
		
		int i,p;
		String t,d;
		InputStreamReader input = new InputStreamReader(System.in);
	    BufferedReader buffer = new BufferedReader(input);
	    Scanner scanner =new Scanner(input);
		for(i=0;i<1;i++)
		{

			System.out.print("Titolo: ");
			t=buffer.readLine();
			System.out.print("Descrizione: ");
			d=buffer.readLine();
			System.out.print("Prezzo: ");
			p= scanner.nextInt();
			lib.add(new libro(i,p,d,t));

			
		}
		scanner.close();
		
		JSONObject sampleObject = new JSONObject();
		for(i=0;i<1;i++) 
		{

		    sampleObject.put("titolo", lib.get(i).GetTitolo());
		    sampleObject.put("descrizione", lib.get(i).GetDescrizione());
		    sampleObject.put("prezzo", lib.get(i).GetPrezzo());
		    sampleObject.put("ID", lib.get(i).GetID());

		}


	    

	    try 
	    {
	    	
			Files.write(Paths.get("file.json"), sampleObject.toString().getBytes());
		} 
	    catch (IOException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	    
	    ArrayList<libro> list = new ArrayList<libro>(); 
	    
	    JSONParser parser = new JSONParser();

        try 
        { 
	        Reader reader = new FileReader("file.json") ;
	
	        JSONObject jsonObject = new JSONObject();
			try 
			{
				jsonObject = (JSONObject) parser.parse(reader);
			} catch (ParseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            list.add(
            			new libro
            					(
            					    Integer.parseInt(String.valueOf(jsonObject.get("ID"))),
            						Integer.parseInt(String.valueOf(jsonObject.get("prezzo"))),
	            					String.valueOf(jsonObject.get("descrizione")),
	            					String.valueOf(jsonObject.get("titolo"))
	            				)
            					
            		);

            



        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        

        }
	} 
}
