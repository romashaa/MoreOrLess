package MoreOrLess;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int minLimit;
    private int maxLimit;

    private int secretValue;

    private List<Integer> history = new ArrayList<Integer>();

    public void setSecretValue(){
        secretValue = (int)Math.ceil(Math.random()* (maxLimit - minLimit - 1) + minLimit);
    }

    public boolean checkValue (int value){
        history.add(value);
        if (value == secretValue){
            return false;
        } else if (value > secretValue){
            maxLimit = value;
        } else {
            minLimit = value;
        }
        return true;
    }

    public void setLimits(int minLimit, int maxLimit){
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public int getSecretValue() {
        return secretValue;
    }
    public int getMinLimit() {
        return minLimit;
    }
    public int getMaxLimit() {
        return maxLimit;
    }
    public List<Integer> getHistory() {
        return history;
    }

}
