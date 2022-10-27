package mainclass2;

import java.awt.BorderLayout;
import java.io.IOException;
import static java.lang.Math.floor;

public class Hesaplama {
    private PeopleSportFood psf;
    private WriteTxt writeT;
    private int i = -1;
    private int[] personID = new int[100];
    private int[] sportCalori = new int[100];
    private int[] calorie = new int[100];
    public Hesaplama() throws IOException{
        psf = new PeopleSportFood();
        writeT = new WriteTxt();
    }
    //istenen şekilde write değişkenine atama ve txt yazmak için writetxt classına gonderme işlemi
    public void Yazdir(int persnID,int foodID,int sportID,int numberOfPortion) throws IOException{
        String write= null;
        if(i != -1)
            writeT.saveData("***************");
        i++;
        if(foodID != 0 && sportID == 0){
            AddNamePerson(persnID,foodID,numberOfPortion);
            int index = findFoodIndex(foodID);
            /*istenen yazma şekli
             *11234	has	taken	261kcal	from	elma*/
            write = persnID+"\thas\ttaken\t"
                    +(psf.getFoodCalorieCount(index)*numberOfPortion)
                    +"kcal\tfrom\t"+psf.getNameOfFood(index);
        }
        else if(foodID == 0 && sportID != 0){
            AddNameSport(persnID,sportID,numberOfPortion);
            int index = findSportIndex(sportID);
            /*istenen yazma şekli
             *11235	has	burned	476kcal	thanks	to	basketball*/
            write = persnID+"\thas\tburnded\t"
                    +(psf.getCalorieBurned(index)*(numberOfPortion/60))
                    +"kcal\tthanks\tto\t"+psf.getNameOfSport(index);
        }
        
        writeT.saveData(write);
    }
    
    //eğer komut print(id) ise gelen id yi genel toplam verilerini write içerisine at
    //ardından writetxt classına gonder
    public void printYazdir(int persnID){
        String write;
        int toplamKalori = 0;
        int toplamYakilanKalorie = 0;
        int index = findPersonIndex(persnID);
        int dailyCN = getDailyCalorieNeeds(persnID);
        for(int j = 0;personID[j] != 0;j++){
            if(personID[j] == persnID){
                toplamYakilanKalorie += sportCalori[j];
                toplamKalori += calorie[j];
            }
        }
        //murat	35	1776kcal	1225kcal	0kcal	-551kcal
        write = "***************\n"+psf.getName(index)+"\t"
                +psf.getBirtYear(index)+"\t"
                +dailyCN+"kcal\t"
                +toplamKalori+"kcal\t"
                +toplamYakilanKalorie+"kcal\t"
                +(toplamKalori-dailyCN)+"kcal";
        writeT.saveData(write);
    }
    
    //eğer komut printList ilkin yazdırlanlar hepsi genel toplam verilerini write içerisine at
    //ardından writetxt classına gönder
    public void printListYazdir(){
        String write;
        
        writeT.saveData("***************");
        int toplamKalori = 0;
        int k,j,x=0;
        int toplamYakilanKalorie = 0;
        int dailyCN;
        int[] uniqID = new int[10];
        for(j = 0;personID[j] != 0;j++){
            for(k = 0;k < 10;k++){
                if(uniqID[k] == personID[j])
                {
                    break;
                }
            }
            if(k == 10){
                uniqID[x] = personID[j];x++;
            }
        }
        for(k = 0;uniqID[k] != 0;k++)
        {
            for(j = 0;personID[j]!=0;j++)
            {
                if(uniqID[k] == personID[j])
                {
                    toplamKalori += calorie[j];
                    toplamYakilanKalorie += sportCalori[j];
                }
            }
            dailyCN = getDailyCalorieNeeds(uniqID[k]);
            int genelToplam = toplamKalori-dailyCN-toplamYakilanKalorie;
        //murat	35	1776kcal	1225kcal	0kcal	-551kcal
            write = psf.getName(findPersonIndex(uniqID[k]))+"\t"
                +psf.getBirtYear(findPersonIndex(uniqID[k]))+"\t"
                +dailyCN+"kcal\t"
                +toplamKalori+"kcal\t"
                +toplamYakilanKalorie+"kcal\t"
                +(genelToplam>0?"+":"")+genelToplam+"kcal";
            writeT.saveData(write);
            toplamKalori = 0;toplamYakilanKalorie = 0;
        }
    }
    //Gunlük alması gereken kalorinin üstüne cıkan kişi yazdırma
    public void printWarnYazdir(){
        String write;
        
        writeT.saveData("***************");
        int toplamKalori = 0;
        int k,j,x=0;
        int kontrol = 0;
        int toplamYakilanKalorie = 0;
        int dailyCN;
        int[] uniqID = new int[10];
        for(j = 0;personID[j] != 0;j++){
            for(k = 0;k < 10;k++){
                if(uniqID[k] == personID[j])
                {
                    break;
                }
            }
            if(k == 10){
                uniqID[x] = personID[j];x++;
            }
        }
        for(k = 0;uniqID[k] != 0;k++)
        {
            for(j = 0;personID[j]!=0;j++)
            {
                if(uniqID[k] == personID[j])
                {
                    toplamKalori += calorie[j];
                    toplamYakilanKalorie += sportCalori[j];
                }
            }
            dailyCN = getDailyCalorieNeeds(uniqID[k]);
        //murat	35	1776kcal	1225kcal	0kcal	-551kcal
            int genelToplam = toplamKalori-dailyCN-toplamYakilanKalorie;
            if(genelToplam>0){
                write = psf.getName(findPersonIndex(uniqID[k]))+"\t"
                    +psf.getBirtYear(findPersonIndex(uniqID[k]))+"\t"
                    +dailyCN+"kcal\t"
                    +toplamKalori+"kcal\t"
                    +toplamYakilanKalorie+"kcal\t+"
                    +genelToplam+"kcal";
                writeT.saveData(write);kontrol++;
            }
            toplamKalori = 0;toplamYakilanKalorie = 0;
        }
        if(kontrol==0){
            writeT.saveData("there\tis\tno\tsuch\tperson");
        }
    }
    //Gelen komuttaki kişiyi diziye ekleyecektir
    private void AddNamePerson(int pId,int fId,int portion){
        personID[i] = pId;
        calorie[i] = psf.getFoodCalorieCount(findFoodIndex(fId))*portion;
        sportCalori[i] = 0;
    }
    //Gelen komuttaki spor kalorisini diziye ekleyecektir
    private void AddNameSport(int pId,int sId,int portion){
        personID[i] = pId;
        calorie[i] = 0;
        sportCalori[i] = psf.getCalorieBurned(findSportIndex(sId))*(portion/60);
    }
    //gunluk alması gereken kalori mıktarını donecektir
    private int getDailyCalorieNeeds(int ID){
        int index = findPersonIndex(ID);
        //male yada female olmasına gore gunluk alması gereken kalori mıktari
        if("male".equals(psf.getGender(index)))
        {
            //66+(13.75*agırlık)+(5*boy)-(6.8*yas)
            return (int) Math.round(66+(13.75*psf.getWeight(index))+(5*psf.getHeight(index))-(6.8*psf.getBirtYear(index)));
        }
        else{
            //65+(9.6*agırlık)+(1.7*boy)-(4.7*yas)
            return (int) Math.round(665+(9.6*psf.getWeight(index))+(1.7*psf.getHeight(index))-(4.7*psf.getBirtYear(index)));
        }
    }
    //idleri gonderip kacıncı indexte oldugunu bulan ve bu indexleri donen metodlar 
    private int findPersonIndex(int ID){
        int index;
        int[] array = psf.getPersonID();
        for(index = 0;array[index] != 0;index++)
        {
            if(array[index] == ID)
                break;
        }
        return index;
    }
    private int findFoodIndex(int ID){
        int index;
        int[] array = psf.getFoodID();
        for(index = 0;array[index] != 0;index++)
        {
            if(array[index] == ID)
                break;
        }
        return index;
    }
    private int findSportIndex(int ID){
        int index;
        int[] array = psf.getSportID();
        for(index = 0;array[index] != 0;index++)
        {
            if(array[index] == ID)
                break;
        }
        return index;
    }
}
