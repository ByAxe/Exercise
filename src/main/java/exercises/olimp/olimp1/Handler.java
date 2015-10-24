package exercises.olimp.olimp1;

public class Handler {

    private int num = 0;
    private int counter = 0;
    private int sum = 0;

    public Handler(int num) {
        this.num = num;
    }

    public void runLoop(){
        int currentSum;
        do{
            digitsNumberCounter();
            currentSum = numbersSum(num);
            output();
            num = currentSum;
        }while(currentSum != 153);
    }

    public int digitsNumberCounter() {
        int tempNum = num;
        while (tempNum != 0) {
            counter++;
            tempNum /= 10;
        }
        return counter;
    }

    public int numbersSum(int num) {
        int denominator;
        int currentFigure;
        sum = 0;
        do {
            denominator = (int) Math.pow(10, --counter);
            currentFigure = (num / denominator);
            num%=denominator;
            sum += (int) Math.pow(currentFigure, 3);
        } while (counter > 0);

        return sum;
    }

    public void output(){
        System.out.println(sum);
    }

}
