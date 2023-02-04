/**
 * @Author Muhammad Saimon
 * @since Dec 12/26/21 10:06 PM
 */

public class Tuple<X, Y> { // // This is Multiple Type Parameterize.
    private X xObj;
    private Y yObj;

    public Tuple(X xObj, Y yObj) {
        this.xObj = xObj;
        this.yObj = yObj;
    }

    public X getxObj() {
        return xObj;
    }

    public Y getyObj() {
        return yObj;
    }

    public void showType() {
        String xType = xObj.getClass().getName();
        String yType = yObj.getClass().getName();

        System.out.println("Type of xObj is: " + xType + " and Value is: " + xObj);
        System.out.println("Type of yObj is: " + yType + " and Value is: " + yObj);
    }
}
