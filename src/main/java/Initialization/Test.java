package Initialization;

class MyExc1 extends Exception{}
class MyExc2 extends Exception{}
class MyExc3 extends Exception{}

public class Test {
    public static void main(String[] args) throws Exception {
        try {
            System.out.print(1);
            p();
        }catch (MyExc2 e){
        }
        finally {
           // throw new MyExc3();
            System.out.print(2);
        }
    }
    public static void p() throws Exception {
        try {
            throw new MyExc1();
        } catch (MyExc1 myExc1) {
            throw new MyExc2();
        }finally {
            System.out.println(3);
        }
    }
}