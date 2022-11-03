import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

  
public class some{

    AddressType add = new AddressType();

    public AddressType getAdd() {
        return add;
    }

    public void setAdd(AddressType add) {
        this.add = add;
    }

    static String parseString(String temp){
       temp = temp.replace("\", \"", "" );
        temp = temp.replace("\"", "");
        temp = temp.replace(",", "");
        temp = temp.replace("city:", "");
        temp = temp.replace("\s", "");
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

    static String find(String data){
        String[] dataType = {"\"city\":", "\"state\":", "\"zip\":", "\"county\":"};
        String newData;
        AddressType add = extracted();

        
        for (int j = 0; j < 4; j++){
            String find = dataType[j];
            int i = data.indexOf(find);
        if(i>0){
            newData = (data.substring(i));
            String parsedData = stop(newData);
            newData = parseString(parsedData);
            // System.out.println(newData);

            switch (j){
                case 0:
                    add.City = newData;
                    System.out.println(add.City + " " + j);  
                case 1:
                    add.State = newData;
                    System.out.println(add.State + " " + j);  

                case 2:
                    add.ZipCode = newData; 
                    System.out.println(add.ZipCode + " " + j);  

                case 3:
                    add.County = newData; 
                    System.out.println(add.County + " " + j);  
            }

            // System.out.println(add);
            
        }
        else {
            System.out.println("not found");
        }

        
    }
        return data;
    }

    private static AddressType extracted() {
        return new AddressType();
    }

    public static void main(String[] args) throws Exception 
    {

        AddressType add = extracted();
        
        String data = "";
        try {
            File ReadJsonFile = new File("jsonListedHelena.json");
            Scanner JsonFile = new Scanner(ReadJsonFile);

            while (JsonFile.hasNextLine()){
                String line = JsonFile.nextLine();
                data += line;
                // System.out.println(data);
            }

            data = find(data);
            // System.out.println(add.County);
            JsonFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("no good");
            e.printStackTrace();
        }
    
    }
}