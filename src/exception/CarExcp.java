
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
    class Date{//структура даты аварий
        int day   = 1;
        int month = 1;
        int year  = 2000;
    }
    Date date = new Date();
    double price = 1000;
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
    
    CarExcp(int dOrMOrY, int oneOf){
        switch (oneOf) {
            case 1:
                date.day = dOrMOrY;
                break;
            case 2:
                date.month = dOrMOrY;
                break;
            case 3:
                date.year = dOrMOrY;
                break;
            default:
                break;
        }
    }
    void analyze(){//обработка exception'ов
        if(list ==  null)//если число аварий 
            System.err.println("NOT_INITIALIZED_LIST");
        if(yearC < 1900 || yearC > 2017)
            System.err.println("OUT_OF_RANGE_YEAR_EXCEPTION");
        if(maxSpeedC < 0)
            System.err.println("NEGATIVE_SPEED_EXCEPTION");
        if(maxSpeedC > 1227.996)
            System.err.println("MAXIMUM_SPEED_LIMIT_EXCEPTION");
        if(price < 0)
            System.err.println("NEGATIVE_PRICE_EXCEPTION");
        if(date.day < 0 || date.day > 31)
            System.err.println("OUT_OF_RANGE_DAY_EXCEPTION");
        if(date.month < 0 || date.month > 12)
            System.err.println("OUT_OF_RANGE_MONTH_EXCEPTION");
        if(date.year < 1900 || date.year > 2017)
            System.err.println("OUT_OF_RANGE_YEAR_EXCEPTION");
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
/*5430.0
80
15
11
2004
3333.0
65
17
09
2007

