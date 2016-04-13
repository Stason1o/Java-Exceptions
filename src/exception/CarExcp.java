
package exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CarExcp extends Exception{
    ArrayList<Crashes> list = new ArrayList<>();//данные об авариях
    int     yearC       = 2000;
    String  carNameC    = "Car";
    float   maxSpeedC   = 200.0f;
    Object  error       = null;
//    class Date{
//        int day;
//        int month;
//        int year;
//    }
//    Date date = new Date();
    double price = 1000;
//    boolean death = false;
    byte drunk = (byte)60;
    
    CarExcp(double _price){// конструктор с параметром double
        price = _price;
    }
    
    CarExcp(byte _drunk){// конструктор с параметром byte
        drunk = _drunk;
    }
    
    CarExcp(ArrayList<Crashes> _crashes){// конструктор с параметром arraylist
        list = _crashes;
    }

    CarExcp(String _name){// конструктор с параметром string
        carNameC = _name;
    }

    CarExcp(int _year){// конструктор с параметром int
        yearC = _year;
    }

    CarExcp(float _speed){// конструктор с параметром float
        maxSpeedC = _speed;
    }
    
    CarExcp(Object x){// конструктор с параметром Object
        error = x;
    }
    
    void analyze(){//обработка exception'ов
        if(list ==  null)//если число аварий 
            System.err.println("NOT_INITIALIZED_LIST");
        if(yearC < 1806)//
            System.err.println("OUT_OF_RANGE_YEAR_EXCEPTION");
        if(yearC > 2017)
            System.err.println("OUT_OF_RANGE_YEAR_EXCEPTION");
        if(maxSpeedC < 0)
            System.err.println("OUT_OF_RANGE_SPEED_EXCEPTION");
        if(maxSpeedC > 1227.996)
            System.err.println("OUT_OF_RANGE_SPEED_EXCEPTION");
        if(price < 0)
            System.err.println("NEGATIVE_PRICE_EXCEPTION");
        if(drunk < 0)
            System.err.println("NEGATIVE_DRUNKNESS_EXCEPTION");
        if(drunk > 128)
            System.err.println("OUT_OF_RANGE_EXCEPTION");
        if(error instanceof IOException)
            System.err.println("IO_EXCEPTION");
        if(error instanceof FileNotFoundException)
            System.err.println("FILE_NOT_FOUND_EXCEPTION");
        if(error instanceof NullPointerException)
            System.err.println("NULL_POINTER_EXCEPTION");
        if(error instanceof NumberFormatException)//
            System.err.println("NUMBER_FORMAT_EXCEPTION");
        if(error instanceof ArrayIndexOutOfBoundsException)//выход за пределы массива
            System.err.println("ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION");
        if(error instanceof InputMismatchException)//неподходящий тип данных
            System.err.println("INPUT_MISMATCH_EXCEPTION");
    }
}
