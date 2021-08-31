package MoreOrLess;

import java.util.Scanner;

public class Controller {
    int PRIMARY_MIN_LIMIT = 0;
    int PRIMARY_MAX_LIMIT = 100;

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setLimits(PRIMARY_MIN_LIMIT, PRIMARY_MAX_LIMIT);

        model.setSecretValue();
        System.out.println(model.getSecretValue());

        while (model.checkValue(inputIntValueWithScanner(sc)));

        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(View.HISTORY + String.valueOf(model.getHistory()));
    }

    private int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
                sc.next();
            }
            // check value into diapason
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
                View.INPUT_INT_DATA+ "from "+ model.getMinLimit() + " to "+ model.getMaxLimit();
    }
}

