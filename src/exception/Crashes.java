
package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crashes {
    
//    public class date{//структура даты.
//        int day;
//        int month;
//        int crashYear;
//        
//        public void setDay(int _day){
//            if(_day > 0 && _day < 32)
//                crashDate.day = _day;
//        }
//        public void setMonth(int _month){
//            crashDate.month = _month;
//        }
//        public void setYear(int _year){
//            if(_year > 1980 && _year < 2017)
//                crashDate.crashYear = _year;
//        }
//    }
//    date crashDate  = new date();
    double price;//цена ремонта
//    boolean death;//есть ли смерть.
    byte drunk;//процент алкоголя в крови.
    Crashes()  {//конструктор по ум-ю, все поля вводятся с клавиатуры
        boolean flag = false;//для выхода из цикла
            do{
                flag = false;
                try{
                    do{
                        System.out.println("Enter price for crash: ");
                        price = inInt();
                        if(price < 0)
                            throw new CarExcp(price);
                    }while(price < 0 );
    //                System.out.print("Was death?(true - yes, false - no) : ");
    //                death = inBool();
                    do{
                        System.out.print("Enter value of drunkness (0 - 127): ");
                        try{
                            drunk = inByte();
                        }catch(NumberFormatException x){
                            throw new CarExcp(x);
                        }
                    }while(drunk < 0 || drunk > 128);
                    
                }
                catch(CarExcp x){
                    x.analyze();
                    flag = true;
                }
            }while(flag);
    }
    //констркутор с параметрами для всех полей
    Crashes(double _price, byte _drunk) throws IOException {
        fill(_price,_drunk);
    }
    
    private void fill(double _price, byte _drunk/*int _day, int _month, int _year, float _drunk,*/ ){
        try{
            setCrashPrice(_price);
//            setCrashDate(_day, _month, _year);
//            setDeath(_death);
            setDrunk(_drunk);
        } catch(CarExcp x){
            x.analyze();
        }
    }
    //set + get 
    public double getCrashPrice()   { return price; }
//    public boolean getDeath()       { return death; }
    public float getDrunk()         { return drunk; }
//    public int getDay()             { return crashDate.day;       }
//    public int getMonth()           { return crashDate.month;     }
//    public int getYear()            { return crashDate.crashYear; }
    
    public void setCrashPrice(double _price) throws CarExcp{
        if(_price < 0)
            throw new CarExcp(_price);
        else this.price = _price;
    }
//    public void setDeath(boolean _death) throws CarExcp{
//        if(_death != false || _death != true)
//            throw new CarExcp(_death);
//        this.death = _death;
//    }
    public void setDrunk(byte _drunk) throws CarExcp{
        if(_drunk < 0 && _drunk > 128)
            throw new CarExcp(_drunk);//если не подходит, выбрасывается эксепшн
        else this.drunk = _drunk;
    }
    
//    public void setCrashDate(int _day, int _month, int _year) throws CarExcp{
//        crashDate.setDay(_day);
//        crashDate.setMonth(_month);
//        crashDate.setYear(_year);
//    }
    
    //вывод данных об аварии
    public void printInfo(){
        System.out.println("price: " + price);
//        System.out.println("death: " + death);
        System.out.println("drunk: " + drunk);
//        System.out.println("date:  " + crashDate.day + "/" + crashDate.month + "/" + crashDate.crashYear);
    }
        static String inString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try{
            str = reader.readLine();
        } catch(IOException e){}
        return str;
    }
    
    static int inInt(){
        return (Integer.valueOf(inString()).intValue());
    }
    
    static float inFloat(){
        return (Float.valueOf(inString()).floatValue());
    }
    static boolean inBool(){
        return(Boolean.valueOf(inString()).booleanValue());
    }
    static byte inByte(){
        return(Byte.valueOf(inString()).byteValue());
    }
    static double inDouble(){
        return(Double.valueOf(inString()).doubleValue());
    }
}
