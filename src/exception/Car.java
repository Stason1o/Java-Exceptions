package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Car {
    ArrayList<Crashes> crashes = new ArrayList<Crashes>();//arraylist который будет содержать объекты типа Crashes
    int year;//год авто
    String carName;//имя авто
    float maxSpeed;//макс скорость авто
    public static int nrCars;//переменная, считающаякол-во созд. объектов

    Car(String filename){
        File rFile = new File(filename);
        Scanner sc;
        try {
            try{
                sc = new Scanner(rFile);
                carName = sc.next();
                maxSpeed = sc.nextFloat();
                year = sc.nextInt();
                while(sc.hasNext())
                    crashes.add(new Crashes(sc.nextDouble(),sc.nextByte()));
                nrCars++;
            }
            catch(IOException | NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException | InputMismatchException x){
                throw new CarExcp(x);
            }
        } 
        catch (CarExcp ex) {
            ex.analyze();
        }
    }
    
    Car() {//конструктор по-умолчанию        
        boolean flag = false;
        do{
            flag = false;
            try{
                do{
                    System.out.println("Enter name of car: ");
                    carName = inString();//ввод с кл.
                    if(carName.equals(""))
                        throw new CarExcp(carName);
                }while(carName.equals(""));
                
                int numOfCrashes;
                do{
                    System.out.println("Enter number of crashes: ");
                    numOfCrashes = inInt();
                }while(numOfCrashes < 0 || numOfCrashes > 10);
                System.out.println("Enter repair prices for " + numOfCrashes + " crashes");
                for (int i = 0; i < numOfCrashes; i++)//кол-во записей arrayList'a зависит от лок-го поля numOfCrashes
                    crashes.add(new Crashes());//добавление записей
                do{
                    System.out.println("Enter car's year: ");
                    year = inInt();
                    if(year < 1806 && year > 2017)//если условие не выполняется выкидывает ошибку
                        throw new CarExcp(year);
                    //System.out.println("The year of car is wrong! Reenter year.");
                }while((year < 1806) && (year > 2017));
                do{ 
                    System.out.println("Enter car's max speed: ");
                    maxSpeed = inFloat();
                    if(!(maxSpeed > 0 && maxSpeed < 1227.996))
                        throw new CarExcp(maxSpeed);
                }while(maxSpeed < 0 && maxSpeed > 1227.996);
            }
            catch(CarExcp error){
                flag = true;
                error.analyze();
            }
//            catch(IOException ioe){
//                
//            }
        } while(flag);
        nrCars++;
        
    }
    //конструктор с одним параметром
    Car(int newCrashes) {
        System.out.println("Enter quantity of crashes: ");
        
        boolean flag = false;
        do{
            flag = false;
            try{
                System.out.println("Enter name of car: ");
                carName = inString();
                if(carName.equals(""))
                    throw new CarExcp(carName);
//                int numOfCrashes;
//                do{
//                    numOfCrashes = inInt();
//                }while(numOfCrashes < 0 || numOfCrashes > 10);
                
                System.out.println("Enter repair prices for " + newCrashes + " crashes");
                for (int i = 0; i < newCrashes; i++)//кол-во записей arrayList'a зависит от лок-го поля numOfCrashes
                    crashes.add(new Crashes());//добавление записей
                
                do{
                    System.out.println("Enter car's year: ");
                    year = inInt();
                    if(year < 1806 && year > 2017)
                        throw new CarExcp(year);
                    //System.out.println("The year of car is wrong! Reenter year.");
                }while((year < 1806) && (year > 2017));
                do{ 
                    System.out.println("Enter car's max speed: ");
                    maxSpeed = inFloat();
                    if(!(maxSpeed > 0 && maxSpeed < 1227.996))
                        throw new CarExcp(maxSpeed);
                }while(maxSpeed < 0 && maxSpeed > 1227.996);
            }
            catch(CarExcp error){
                error.analyze();
                flag = true;
            }
        } while(flag);
        nrCars++;
    }
    
    //конструктор с 3-мя параметрами
    Car(String newName,int newYear,int newSpeed){
        System.out.println("Enter quantity of crashes: ");
        boolean flag = false;
            do{
                flag = false;
                    carName = newName;
                    int numOfCrashes;
                    do{
                        numOfCrashes = inInt();
                    }while(numOfCrashes < 0 || numOfCrashes > 10);

                        System.out.println("Enter repair prices for " + numOfCrashes + " crashes");
                        for (int i = 0; i < numOfCrashes; i++)//кол-во записей arrayList'a зависит от лок-го поля numOfCrashes
                            crashes.add(new Crashes());//добавление записей
                        year = newYear;
                        //System.out.println("The year of car is wrong! Reenter year.");
                        maxSpeed = newSpeed;
            } while(flag);
        nrCars++;
    }
	
    Car(String newName,int newYear,int newSpeed, double _price, byte _drunk) throws IOException{
        System.out.println("Enter quantity of numOfCrashes: ");
        int numOfCrashes = inInt();
        System.out.println("Enter repair price for each crash: ");
        for (int i = 0; i < numOfCrashes; i++)
            crashes.add(new Crashes(_price, _drunk));
        carName = newName;
        year = newYear;
        maxSpeed = newSpeed;
        nrCars++;
    }
    
    Car(Car oldCar){ 
        crashes = oldCar.crashes;
        carName = oldCar.carName;
        year = oldCar.year;
        maxSpeed = oldCar.maxSpeed;
        nrCars++;
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
        return (Float.valueOf(inString()).intValue());
    } 
      //метод записи в файл
    @SuppressWarnings("ConvertToTryWithResources")
    public void writeInFile(String filename) throws IOException{
        File outF = new File(filename + ".txt");
        FileWriter fWrite = new FileWriter(outF);
        PrintWriter  pWrite = new PrintWriter(fWrite);
          
        pWrite.println(carName + "\t");
        pWrite.println("РљРѕР»РёС‡РµСЃС‚РІРѕ Р°РІР°СЂРёР№: " + crashes.size());
        for (Crashes x:crashes)
            pWrite.println(x.price);
        pWrite.println(maxSpeed);
        pWrite.println(year);
        System.out.println("Characteristics were saved in " + filename + ".txt");
        pWrite.close();
    }
      
//    public void setCrashes(byte newCrashes) {
//        try{
//            if((newCrashes < 0) || (newCrashes < crashes))
//                throw new CarExcp(newCrashes);
//            int tmp[] = new int[crashes];
//            for(int i = 0; i < crashes; i++)
//                tmp[i] = crashPrice[i];
//            int minCrashPrice = (crashes < newCrashes) ? crashes : newCrashes;
//                crashPrice = new int[newCrashes];
//            for (int i = 0; i < minCrashPrice; i++)
//                crashPrice[i] = tmp[i];
//            crashes = newCrashes;
//        }
//        catch(CarExcp error){
//            error.analyze();
//        }
//    }
// методы изменения полей класса
    public void setName(String newName) throws CarExcp{
        if(newName.equals(""))
            throw new CarExcp(newName);
        else 
            carName = newName;
    }
    public void setYear(int newYear) throws CarExcp{
        if((newYear < 1806) || (newYear > 2017))
            throw new CarExcp(newYear);
        else 
            year = newYear;  
    }
    public void setSpeed(float newSpeed) throws CarExcp{

        if((newSpeed < 0) || (newSpeed > 1227.966))
            throw new CarExcp(newSpeed);
        else
            maxSpeed = newSpeed;

    }
    
//    public void setCrashPrice(int pos, int price, ArrayList<Crashes> list){
//        try{
//            if((pos < 0) || (pos >= crashes.size()))
//                throw new CarExcp(price, pos);
//            list.get(pos).setCrashPrice(price);
//        }
//        catch(CarExcp error){
//            error.analyze();
//        }
//    }
    //мутоды доступа к полям класса
    public ArrayList<Crashes> getCrashes(){
        return crashes;
    }
    public String getName(){
        return carName;
    }
    public int getYear(){
        return year;
    }
    public float getSpeed(){
        return maxSpeed;
    }
    public double getCrashPrice(int pos,ArrayList<Crashes> list){
        return list.get(pos).getCrashPrice();
    }
      
    void printCar(){//печать данных 
        System.out.println("Name of car: " + carName);
        System.out.println("Year of car: " + year);
        System.out.println("Car's max speed: " + maxSpeed);
        System.out.println("Quantity of numOfCrashes: " + crashes.size());
        System.out.println("Information about crashes: ");
        for (Crashes x: crashes){
            x.printInfo();
        }
    }
    public void compareTwoCars(Car sCar){//сравнение 2-х автомоблей
          if(crashes.size() < sCar.crashes.size())//если кол-во аварий меньше....
              System.out.println(carName + " has more numOfCrashes than second car");
          System.out.println(sCar.carName + " has more numOfCrashes than first car");
      }
    public int calcRepairSum(){//подсче суммы ремонтов
          int sum = 0;
          for (Crashes x: crashes)
              sum += x.getCrashPrice();
          return sum;
      }
      
    public static int calcRepairSumOfTwoCars(Car car1,Car car2){//подсчет суммы ремонтов 2-х автомобилей
          int sum = 0;
          for (Crashes x: car1.crashes)
              sum += x.getCrashPrice();
          for(Crashes y: car2.crashes)
              sum += y.getCrashPrice();
          return sum;
      }
      
    public static void main(String[] args) throws IOException {
        System.out.println("ВВЕДИТЕ ДАННЫЕ ВСЕХ АВТОМОБИЛЕЙ:");
        Car Lamborgini = new Car("file.txt");
        Lamborgini.printCar();
        Lamborgini.calcRepairSum();
        System.out.println("-------------------------------");
        
        Car Ferrari = new Car();
        Ferrari.printCar();
        Ferrari.calcRepairSum();
        
        
        
//        System.out.println("--------------------------------");
//        CarList Lambo = new CarList(Ferrari);
//        Lambo.printCar();
//        Lambo.calcRepairSum();

//        
//        System.out.println("--------------------------------");
//        CarList Lada = new CarList(5);
//        Lada.printCar();
//        Lada.calcRepairSum();

//        
//        System.out.println("--------------------------------");
//        CarList Audi = new CarList("Audi R8",2014,300, 1111,10,"january", 2005, false, 0.4f);
//        Audi.printCar();
//        Audi.calcRepairSum();

            
//Создание и инициализация динамического массива автомобилей
        System.out.println("--------------------------------");
        ArrayList<Car> vector= new ArrayList<Car>();
     //   vector.add(new CarList());
//        vector.add(Lambo);
        vector.add(new Car("Audi R8",2014,300,1234,(byte)50));
//        vector.add(new CarList(5));
//        vector.add(Audi);
//        vector.add(Lada);
        vector.add(Ferrari);
        
//Вывод информации об элементах в массиве
        for(Car x: vector)
            x.printCar();
       
        try{
            Ferrari.writeInFile(Ferrari.getName());
//          Lambo.writeInFile("Lambo");
//          Lada.writeInFile(Lada.getName());
//          Audi.writeInFile(Audi.getName());
        }catch(IOException x){
            System.err.println("Can't write i file");
        }
//        System.out.println("-------------Сравнение пар атомобилей-------------------");
//        Ferrari.compareTwoCars(Audi);
//        System.out.println("--------------------------------");
//        Lambo.compareTwoCars(Lada);
//        System.out.println("--------------------------------");
        //Подсчет полной стоимость всех ремонтов автомобилей
        int sum = 0;
        for (Car x: vector)
            sum += x.calcRepairSum();
//        for (Crashes x: Lambo.crashes)
//            sum += x.getCrashPrice();
//        for (Crashes x: Ferrari.crashes)
//            sum += x.getCrashPrice();
//        for (Crashes x: Lada.crashes)
//            sum += x.getCrashPrice();
//        for (Crashes x: Audi.crashes)
//            sum += x.getCrashPrice();
        System.out.println("Общая стоимость ремонтов всех созданных автомобилей: " + sum);
        System.out.println("количество созданных автомобилей: " + nrCars);
    }
    
}
