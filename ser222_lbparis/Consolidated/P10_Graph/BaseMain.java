import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Program for generating kanji component dependency order via topological sort.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class BaseMain {
    
    /**
     * Entry point for testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //TODO: implement this 
    	
        //Freebie: this is one way to load the UTF8 formated character data.
        try {
			BufferedReader indexReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("data-kanji.txt")), "UTF8"));
		} catch (UnsupportedEncodingException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	File file = new File(System.getProperty("user.dir") + "/" + "java/data-kanji.txt");
//    	try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) 
//    	{
//    	    int value = 0;
//    	    while ((value = br.read()) != -1) 
//    	    {
//    	        char c = (char) value;
//    	        System.out.println(c);
//    	    }
//    	} catch (FileNotFoundException e) 
//    	{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) 
//    	{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

    }
}