package exercises.olimp.olimp6;

public class Handler {
    private final Long[] NumArray = new Long[61];
    private int weight;

    public Handler(int weight){
        this.weight = weight;

        ArrayFilling();
//        output();
    }

    private void ArrayFilling(){
        for (int i = 0; i < NumArray.length; i++) {
            NumArray[i] = (long) Math.pow(2,i);
        }
    }

    /*public void output(){
        for (Long i : NumArray){
            System.out.println(i);
        }
    }*/
}
