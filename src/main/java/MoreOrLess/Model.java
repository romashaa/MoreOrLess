package MoreOrLess;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int maxLimit;
    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }
    public int getMaxLimit() {
        return maxLimit;
    }

    private int minLimit;
    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    private int secretNum;

    private List<Integer> attempts = new ArrayList<>();
    public List<Integer> getAttempts() {
        return attempts;
    }

    public int rand(){
        return  (int)Math.ceil(Math.random()*(maxLimit - minLimit - 1) + minLimit);
    }

    public void setSecretNum(){
        this.secretNum=rand();
    }

    public int getSecretNum(){
        return secretNum;
    }

    public boolean check(int val){
        attempts.add(val);
        if(val==secretNum){
            return false;
        }
        if(val>secretNum){
            maxLimit=val;
        }
        else{
            minLimit=val;
        }
        return true;
    }
}
