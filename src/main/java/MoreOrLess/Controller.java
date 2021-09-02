package MoreOrLess;

import java.util.Scanner;

public class Controller {
    private final int PRIMARY_MIN_LIMIT=0;
    private final int PRIMARY_MAX_LIMIT=100;
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        model.setMaxLimit(PRIMARY_MAX_LIMIT);
        model.setMinLimit(PRIMARY_MIN_LIMIT);
        model.setSecretNum();
        while(model.check(InputValueWithScanner(sc)));
        view.printMessage(View.CONGRATULATION + model.getSecretNum());
        view.printMessage(View.ATTEMPTS + String.valueOf(model.getAttempts()));
    }
    private int InputValueWithScanner(Scanner sc){
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
                sc.next();
            }
            if ((res = sc.nextInt()) <= model.getMinLimit() ||
                    res >= model.getMaxLimit()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
                continue;
            }
            break;
        }
        return res;

    }
    private String getInputIntMessage() {
        return
                View.INPUT_INT_DATA + " from "+
               model.getMinLimit()+" to "+ model.getMaxLimit();
    }

}

