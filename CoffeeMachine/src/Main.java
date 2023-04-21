package machine;

import java.util.Scanner;

 class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waterMachine = 400;
        int milkMachine = 540;
        int coffeeMachine = 120;
        int cups = 9;
        int money = 550;

        String enoughResources = null;
        boolean answerBoolean = true;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String buyFillTake = scanner.next();


            switch (buyFillTake) {
                case "fill":
                    System.out.println("\n" + "Write how many ml of water you want to add:");
                    waterMachine += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milkMachine += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffeeMachine += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    cups += scanner.nextInt();
                    Task.remaining(waterMachine, milkMachine, coffeeMachine, cups, money, enoughResources + "\n");
                    break;
                case "remaining":
                    System.out.println("\n" + Task.remaining(waterMachine, milkMachine, coffeeMachine, cups, money, enoughResources));
                    break;
                case "buy":
                    System.out.println("\n" + "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String decision = scanner.next();
                    enoughResources = Task.decisionForCoffee(decision, waterMachine, milkMachine, coffeeMachine, cups);
                    if (decision.equals("back")) {
                        break;
                    } else if (decision.equals("1") && waterMachine >= 250 && coffeeMachine >= 20) {
                        money += 4;
                        cups -= 1;
                        coffeeMachine -= 16;
                        waterMachine -= 250;
                    } else if (decision.equals("2") && waterMachine >= 350 && milkMachine >= 75 && coffeeMachine >= 20) {
                        money += 7;
                        waterMachine -= 350;
                        milkMachine -= 75;
                        coffeeMachine -= 20;
                        cups -= 1;
                    } else if (decision.equals("3") && waterMachine >= 200 && milkMachine >= 100 && coffeeMachine >= 12) {
                        money += 6;
                        waterMachine -= 200;
                        milkMachine -= 100;
                        coffeeMachine -= 12;
                        cups -= 1;
                    }
                    System.out.println(enoughResources);
                    break;
                case "take":
                    System.out.println("\n" + "I gave you $" + money + "\n");
                    money -= money;

                    break;
                case "exit":
                    answerBoolean = false;
                    break;
            }

        } while (answerBoolean);


    }
}


class Task {
    public static String decisionForCoffee(String decision, int waterMachine, int milkMachine, int coffeeMachine,
                                           int cups) {
        String answer = null;
        if (decision.equals("1")) {
            if (waterMachine < 250) {
                answer = "Sorry, not enough water!" + "\n";
            } else if (coffeeMachine < 16) {
                answer = "Sorry, not enough coffee beans!" + "\n";
            } else if (cups < 1) {
                answer = "Sorry, not enough cups" + "\n";
            } else {
                answer = "I have enough resources, making you a coffee!" + "\n";
            }
            return answer;
        } else if (decision.equals("2")) {
            if (waterMachine < 350) {
                answer = "Sorry, not enough water!" + "\n";
            } else if (milkMachine < 75) {
                answer = "Sorry, not enough water!" + "\n";
            } else if (coffeeMachine < 20) {
                answer = "Sorry, not enough coffee beans!" + "\n";
            } else if (cups < 1) {
                answer = "Sorry, not enough cups" + "\n";
            } else {
                answer = "I have enough resources, making you a coffee!" + "\n";
            }

        } else if (decision.equals("3")) {
            if (waterMachine < 200) {
                answer = "Sorry, not enough water!" + "\n";
            } else if (milkMachine < 100) {
                answer = "Sorry, not enough water!" + "\n";
            } else if (coffeeMachine < 12) {
                answer = "Sorry, not enough coffee beans!" + "\n";
            } else if (cups < 1) {
                answer = "Sorry, not enough cups" + "\n";
            } else {
                answer = "I have enough resources, making you a coffee!" + "\n";
            }
        }
        return answer;
    }


    public static String remaining(int waterMachine, int milkMachine, int coffeeMachine, int cups, int money, String enoughResources) {
        enoughResources = "The coffee machine has:" + "\n" + waterMachine + " ml of water" + "\n" + milkMachine + " ml of milk" + "\n" + coffeeMachine +
                " g of coffee beans" + "\n" + cups + " disposable cups" + "\n" + "$" + money + " of money" + "\n";
        return enoughResources;
    }
}