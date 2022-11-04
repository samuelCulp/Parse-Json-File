import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class getProID2  {

    public static String ParseStringQualifications(String text) {
        // text = StringUtility.ParseID(text);
        var tmp = text.replace("\",\"", "|");
        tmp = tmp.replace("\"", "");
        tmp = tmp.replace(",", "");
        tmp = tmp.replace("property_id:", "");
        tmp = tmp.replace(" ", "");
        return tmp;
    }
    
    static void findStringQualifications(String data){

        try{
            String find = "\"property_id\":";
            int i = data.indexOf(find);

            if(i>0){
                String newData = (data.substring(i));
                newData = ParseStringQualifications(newData);
                System.out.println(newData);
            }
            
        } catch(Exception e){
            System.out.println("not found");
        }
       
    }
    

    public static void main(String[] args) throws Exception{
        File ReadJsonFile = new File("jsonListedHelena.json");
        Scanner JsonFile = new Scanner(ReadJsonFile);

        while(JsonFile.hasNextLine()){
            String line = JsonFile.nextLine();
            findStringQualifications(line);
        }
        JsonFile.close();
    }
}
