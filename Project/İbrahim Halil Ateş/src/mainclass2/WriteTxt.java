
package mainclass2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {
    private File file;
    static private String[] metinler = new String[50];
    private int i = -1;
    public WriteTxt()
    {
        
    }
    public void saveData(String metin){
        i++;
        metinler[i] = metin+"\n";
    }
    public void writeTxt() throws IOException{
        file = new File("outputFiles/monitoring.txt");
        if(!file.exists()){
            file.createNewFile();
        } 
        FileWriter writer = new FileWriter(file);
        try (BufferedWriter bw = new BufferedWriter(writer)) {
            for(int j = 0;metinler[j]!= null;j++){
                bw.write(metinler[j]);
            }
            System.out.println("monitoring.txt Write Successful");
        }
    }
    
}
