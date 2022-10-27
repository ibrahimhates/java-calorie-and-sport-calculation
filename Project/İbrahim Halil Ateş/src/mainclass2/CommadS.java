
package mainclass2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CommadS {
    private int i = -1;
    private final BufferedReader br;
    private final Hesaplama hesap;
    public CommadS() throws FileNotFoundException, IOException{
        String fileNameCommad = "inputFiles/command.txt";
        br = new BufferedReader(new FileReader(fileNameCommad));
        hesap = new Hesaplama();
    }
    public void commadReadProcess() throws IOException{
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split("\t");
            String tmp = temp[0];
            if(tmp.charAt(tmp.length()-1)==')'){
                //Print(id)ile karşılaştığında ekrana o id yaz
                int id = 0;
                int a = 0;
                //Parantez içerisindeki id bul
                for(int j = 6;')' != tmp.charAt(j);j++){
                    a=Character.getNumericValue(tmp.charAt(j));
                    id += a*Math.pow(10,10-j);
                }
                hesap.printYazdir(id);
            }
            else if(tmp.charAt(tmp.length()-1) == 'n'){
                hesap.printWarnYazdir();
            }
            else if(tmp.charAt(tmp.length()-1) == 't'){
                hesap.printListYazdir();
            }
            else if(temp[1].charAt(0) == '2'){
                hesap.Yazdir(Integer.parseInt(temp[0]), 0,Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
               
            }
            else {
                hesap.Yazdir(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),0, Integer.parseInt(temp[2]));
              
            }
        }
        br.close();
    }
    
}
