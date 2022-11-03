import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

/**
 * use this to get all of the property_id numbers 
 * happy birthday
 */


public class getProID {


    static String parseString(String temp){
        temp = temp.replace("\", \"", "" );
         temp = temp.replace("\"", "");
         temp = temp.replace(",", "");
        //  temp = temp.replace("property_id:", "");
        //  temp = temp.replace("\s", "");
         return temp;
     }

    static String stop(String words){
        String temp = "";
        for (int i = 0; i < words.length(); i++){
            temp += words.charAt(i);
            if (words.charAt(i) == ','){
                break;
            }
        }
        return temp;
    }

    /**
     * @param data
     * @return
     */
    static String find(String data){
        


        try{
        String find = "\"property_id\":";
        int i = data.indexOf(find);
        
        if(i>0){

            String newData = (data.substring(data.indexOf(find)));
            // System.out.println(i);
            String parsedData = stop(newData);
            data = parseString(parsedData);
            System.out.println(data);
              
        }
        else {
            // System.out.println("not found");
        }
    } 
    catch(Exception e){
        System.out.print("SOL");
    }

        return data;
    }
    
    public static void main(String[] args) throws Exception 
    {
        // AddressType add = new AddressType();
       String data = "";
        try {
            File ReadJsonFile = new File("jsonListedHelena.json");
            Scanner JsonFile = new Scanner(ReadJsonFile);

            while (JsonFile.hasNextLine()){
                String line = JsonFile.nextLine();
                String newLine = find(line);
                data += line;
                // System.out.println(newLine);
            }
            // data = find(data);
            // add.City = data;
            // System.out.println(data);
            JsonFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("no good");
            e.printStackTrace();
        }
    
    }

}
