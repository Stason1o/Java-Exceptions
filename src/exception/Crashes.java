
package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crashes {
    
    public class date{//структура даты.
        int day;
        int month;
        int crashYear;
        
        public void setDay(int _day) throws CarExcp{
            if(_day < 0 || _day > 31)
                throw new CarExcp(_day,1);
            else day = _day;
        }
        public void setMonth(int _month) throws CarExcp{
            if(month < 0 || month > 12)
                throw new CarExcp(_month, 2);
            else month = _month;
        }
        public void setYear(int _year) throws CarExcp{
            if(_year < 1980 || _year > 2016)
                throw new CarExcp(_year, 3);
            else crashYear = _year;
        }
    }
    date crashDate  = new date();
    double price;//цена ремонта
//    boolean death;//есть ли смерть.
    byte drunk;//процент алкоголя в крови.
    Crashes()  {//конструктор по ум-ю, все поля вводятся с клавиатуры
        boolean flag = false;//для выхода из цикла
            do{
                flag = false;
                try{
                    System.out.println("Enter price for crash: ");
                    price = inInt();
                    if(price < 0)
                        throw new CarExcp(price);

                    System.out.println("Enter day of crash: ");
                    crashDate.setDay(inInt());
                    if(crashDate.day < 0 || crashDate.day > 31)
                        throw new CarExcp(crashDate.day,1);

                    System.out.print("Enter month of crash: ");
                    crashDate.month = inInt();
                    if(crashDate.month < 0 || crashDate.month > 12)
                        throw new CarExcp(crashDate.month,2);
                    
                    System.out.print("Enter year of crash: ");
                    crashDate.crashYear = inInt();
                    if(crashDate.crashYear < 1900 || crashDate.crashYear > 2017)
                        throw new CarExcp(crashDate.crashYear,3);

                    System.out.print("Enter value of drunkness (0 - 127): ");
                    drunk = inByte();
                    if(drunk < 0 || drunk > 128)
                        throw new CarExcp(drunk);
                }
                catch(CarExcp x){
                    x.analyze();
                    flag = true;
                }
            }while(flag);
    }
    //констркутор с параметрами для всех полей
    Crashes(double _price, byte _drunk, int _day, int _month, int _year) throws IOException {
        fill(_price, _drunk, _day, _month, _year);
    }
    
    private void fill(double _price, byte _drunk, int _day, int _month, int _year ){
        try{
            setCrashPrice(_price);
            setCrashDate(_day, _month, _year);
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
    public int getDay()             { return crashDate.day;       }
    public int getMonth()           { return crashDate.month;     }
    public int getYear()            { return crashDate.crashYear; }
    
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
    
    public void setCrashDate(int _day, int _month, int _year) throws CarExcp{
        if(_day < 0 || _day > 31)
            throw new CarExcp(_day,1);
        else crashDate.setDay(_day);
        if(_month < 0 || _month > 12)
            throw new CarExcp(_month,2);
        else crashDate.setMonth(_month);
        if(_year < 1900 || _year > 2017)    
            throw new CarExcp(_year,3);
        else crashDate.setYear(_year);   
    }

    //вывод данных об аварии
    public void printInfo(){
        System.out.println("price: " + price);
//        System.out.println("death: " + death);
        System.out.println("drunk: " + drunk);
        System.out.println("date:  " + crashDate.day + "/" + crashDate.month + "/" + crashDate.crashYear);
    }
    
    public static String inString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try{
            str = reader.readLine();
        } catch(IOException e){}
        return str;
    }
    
    public static int inInt() {
    	int result = 0;
    	boolean flag;
    	do {
    		flag = false;
	    	try {
                    try {
                        result = (Integer.valueOf(inString()).intValue());
                    } catch (NumberFormatException e) {
                        flag = true;
                        throw new CarExcp(e);
                    }
	    	} catch (CarExcp e) {
                    flag = true;
                    e.analyze();
	    	}
    	} while (flag);
        return result;
    }
    
    public static float inFloat() {
    	float result = 0.0f;
    	boolean flag;
    	do {
            flag = false;
            try {
                try {
                    result = (Float.valueOf(inString()).floatValue());
                } catch (NumberFormatException e) {
                    flag = true;
                    throw new CarExcp(e);
                }
            } catch (CarExcp e) {
                flag = true;
                e.analyze();
            }
    	} while (flag);
        return result;
    }
    
    public static short inShort() {
    	short result = 0;
    	boolean flag;
    	do {
            try {
                try {
                    result = (Short.valueOf(inString()).shortValue());
                } catch (NumberFormatException e) {
                    flag = true;
                    throw new CarExcp(e);
                }
            } catch (CarExcp e) {
                flag = true;
                e.analyze();
            }
            flag = false;
    	} while (flag);
        return result;
    }
    
    public static double inDouble() {
    	double result = 0.0;
    	boolean flag;
    	do {
            flag = false;
            try {
                try {
                    result = (Double.valueOf(inString()).doubleValue());
                } catch (NumberFormatException e) {
                    flag = true;
                    throw new CarExcp(e);
                }
            } catch (CarExcp e) {
                    flag = true;
                    e.analyze();
            }
    	} while (flag);
        return result;
    }

    public static byte inByte() {
    	byte result = (byte)0;
    	boolean flag;
    	do {
            flag = false;
            try {
                try {
                    result = (Byte.valueOf(inString()).byteValue());
                } catch (NumberFormatException e) {
                    flag = true;
                    throw new CarExcp(e);
                }
            } catch (CarExcp e) {
                flag = true;
                e.analyze();
            }
    	} while (flag);
        return result;
    }

//    static boolean inBool(){
//        return(Boolean.valueOf(inString()).booleanValue());
//    }
}
