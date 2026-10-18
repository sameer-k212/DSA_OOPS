

class Myclass
{
    private int x;
    public Myclass() {
        x = 5;
    }
    public void setX(int value) {
        x = value;
    }
    public int getX() {
        return x;
    }
    public void incrementX() {
        x++;
    }
    public void printX() {
        System.out.println("The value of x is: " + x);
    }
}
public class OutPutQuestions
    {
        int x = 10;
        void modifyValue(int val) {
            x = val * 2;
        }
        int getValue() {
            return x;
        }
        public static void main(String[] args) {
            OutPutQuestions obj1 = new OutPutQuestions();
            OutPutQuestions obj2 = obj1;
            OutPutQuestions obj3 = new OutPutQuestions();
            obj2.modifyValue(5);
            obj3.modifyValue(7);
            System.out.println("obj1 value: " + obj1.getValue());
            System.out.println("obj2 value: " + obj2.getValue());
            System.out.println("obj3 value: " + obj3.getValue());

            Myclass obj5 = new Myclass();
            Myclass obj4= new Myclass();
            obj5.setX(10);
            obj4.incrementX();
            obj5.printX();
            obj4.printX();
        }
    }

