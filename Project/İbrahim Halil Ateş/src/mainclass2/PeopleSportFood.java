
package mainclass2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PeopleSportFood {
    //People için değişkenler

    private int personID[] = new int[100];
    private String name[] = new String[100];
    private String gender[] = new String[100];
    private int weight[] = new int[100];
    private int height[] = new int[100];;
    private int birtYear[] = new int[100];
    //Food için değişkenler
    private int foodID[] = new int[100];
    private String nameOfFood[] = new String[100];
    private int foodCalorieCount[] = new int[100];
    //Sport için değişkenler
    private int sportID[] = new int[100];
    private String nameOfSport[] = new String[100];
    private int calorieBurned[] = new int[100];
    
    public PeopleSportFood() throws IOException{
        personDoldur();
        foodDoldur();
        sportDoldur();
    }
    //people.txt Okuması ve Diziye Kaydetmesi
    private void personDoldur() throws FileNotFoundException, IOException{
        int i = 0;
        String line;
        String fileNamePeople = "inputFiles/people.txt";
        BufferedReader br;
        br = new BufferedReader(new FileReader(fileNamePeople));   
        
        while ((line = br.readLine()) != null) {
            String[] temp = line.split("\t");
            personID[i] = Integer.parseInt(temp[0]);
            name[i] = temp[1];
            gender[i] = temp[2];
            weight[i] = Integer.parseInt(temp[3]);
            height[i] = Integer.parseInt(temp[4]);
            birtYear[i] = Integer.parseInt(temp[5]);
            i++;
        }
        br.close();
    }
    //food.txt Okuması ve Dİziye Ataması
    private void foodDoldur() throws FileNotFoundException, IOException{
        int i = 0;
        String line;
        String fileNameFood = "inputFiles/food.txt";
        BufferedReader br;
        br = new BufferedReader(new FileReader(fileNameFood));
        while ((line = br.readLine()) != null) {
            String[] temp = line.split("\t");
            foodID[i] = Integer.parseInt(temp[0]);
            nameOfFood[i] = temp[1];
            foodCalorieCount[i] = Integer.parseInt(temp[2]);
            i++;
        }
        br.close();
    }
    //Sport.txt Okumasi ve Diziye Ataması
    private void sportDoldur() throws FileNotFoundException, IOException{
        int i = 0;
        String line;
        String fileNameSport = "inputFiles/sport.txt";
        BufferedReader br;
        br = new BufferedReader(new FileReader(fileNameSport));
        while ((line = br.readLine()) != null) {
            String[] temp = line.split("\t");
            sportID[i] = Integer.parseInt(temp[0]);
            nameOfSport[i] = temp[1];
            calorieBurned[i] = Integer.parseInt(temp[2]);
            i++;
        }
        br.close();
    }
    //Kişilerin idlerini doner
    public int[] getPersonID() {
        return personID;
    }
    //Yemeklerin idlerini doner
    public int[] getFoodID() {
        return foodID;
    }
    //Sporlarin idlerini doner
    public int[] getSportID() {
        return sportID;
    }
    //her gelen index için kişi ismini doner
    public String getName(int index) {
        return name[index];
    }
    //her gelen index için cinsiyet doner
    public String getGender(int index) {
        return gender[index];
    }
    //her gelen index için kilo doner
    public int getWeight(int index) {
        return weight[index];
    }
    //Her gelen index için boy doner
    public int getHeight(int index) {
        return height[index];
    }
    //her gelen index için yaş doner
    public int getBirtYear(int index) {
        return 2022-birtYear[index];
    }
    //her gelen index için yemek ismi doner
    public String getNameOfFood(int index) {
        return nameOfFood[index];
    }
    //her gelen index için yemek calori miktarini doner
    public int getFoodCalorieCount(int index) {
        return foodCalorieCount[index];
    }
    //her gelen index için spor ismini doner
    public String getNameOfSport(int index) {
        return nameOfSport[index];
    }
    //her gelen index için sporun 60dk yaktıgı kalori mıktarını doner
    public int getCalorieBurned(int index) {
        return calorieBurned[index];
    }
}
