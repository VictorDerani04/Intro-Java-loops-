import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();

    }
    public static void problem1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----- Dice Game -----");
        System.out.println("Hello Player!\n Let's play 'Dice Roll'!\n You start with $100.\n " +
                "The player may bet a minimum of $5.\n The player rolls the dice.\n " +
                "If they get doubles (for example, two sixes), they get 8× their bet returned plus\n" +
                "their original bet (if they have $10 and bet it all, they now have $80+$10 = $90 after the win). If they do\n" +
                "not roll the same number, they lose the money that they bet.\n If you want to leave at anytime, you should put a negative bet" );
        int money = 100;
        while(money>0){
            System.out.print("Your bet:");
            int bet = scan.nextInt();
            int dice1 =(int) (Math.random()*6)+1;
            int dice2 =(int) (Math.random()*6)+1;
            if(dice1 != dice2 && bet<=money && bet>=5){
                money = money - bet;
                System.out.println("You lost this round!\n You rolled (" + dice1 + ", " + dice2 + ")\n Now you have: " + money);
            }
            else if(dice1==dice1 && bet<=money && bet>=5){
                money = money + (bet * 8 + bet);
                System.out.println("You rolled (" + dice1 + ", " + dice2 + ")\n Now you have: " + money);
            }
            else if(bet<0)
                break;
            else
                System.out.println("You cannot bet more than your money or lower than $5");
        }
        System.out.println("Your final money is $" + money);
    }
    public static void problem2(){
        System.out.println("----- Grade Calculator -----");
        Scanner scan = new Scanner(System.in);

        int hw = 0;
        int i = 0;
        double sum = 0;
        double convHW = 0;
        double min = 100;
        do{
            System.out.print("Please enter in a HW score (enter -1 with you are done): ");
            hw = scan.nextInt();
            if(hw>=0 && hw<=10){
                i++;
                convHW = hw*10;
                if(hw<min)
                    min = hw*10;
                sum = sum + convHW;
            }
            else if(hw>10){
                System.out.println("This value is invalid... try again");
            }
        }while(hw>=0);

        double examSum = 0;
        for(int x= 1; x<3; x++){
            System.out.print("Enter your exam " + x + " grade: ");
            int exam = scan.nextInt();
            if(exam>=0 && exam<=100)
                examSum = examSum + exam;
            else {
                System.out.println("This value is invalid... try again");
                x--;
            }
        }

        double quizSum = 0;
        double convQuiz = 0;
        for(int y= 1; y<5; y++){
            System.out.print("Enter your quiz " + y + " grade: ");
            int quiz = scan.nextInt();
            if(quiz>=0 && quiz<=20) {
                convQuiz = quiz*5;
                quizSum = quizSum + convQuiz;
            }
            else{
                System.out.println("This values is invalid... try again");
                y--;
            }
        }

        double examAvg = examSum/2;
        double quizAvg = quizSum/4;
        double hwAvg = (sum-min)/(i-1);
        double finalAvg = hwAvg*0.25 + examAvg*0.5 + quizAvg*0.25;
        System.out.println("Your grade is: " + finalAvg);
    }
    public static void problem3(){
        System.out.println("----- Permutations -----");
        for(int i=0; i<Math.pow(5,5); i++){
            int a1 = 1 +(i/(int) Math.pow(5,4)%5);
            int a2 = 1 +(i/(int) Math.pow(5,3)%5);
            int a3 = 1 +(i/(int) Math.pow(5,2)%5);
            int a4 = 1 +(i/(int) Math.pow(5,1)%5);
            int a5 = 1 +(i/(int) Math.pow(5,0)%5);
            if(a1!=a2 && a1!=a3 && a1!=a4 && a1!=a5 && a2!=a3 && a2!=a4 && a2!=a5 && a3!=a4 && a3!=a5 && a4!=a5){
                System.out.println("(" + a1 + ", " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ")");
            }

        }
    }
    public static void problem4() {
        Scanner scan =  new Scanner(System.in);
        System.out.println("----- Capital Sigma -----");
        int sigmaSize = 0;
        int sigmaSizeIn = 0;
        do{
            System.out.print("Enter an odd size number for the capital sigma: ");
            sigmaSizeIn = scan.nextInt();
            System.out.println("Wrong number... this is not an odd number... try again");
        } while(sigmaSizeIn%2==0);

        if(sigmaSizeIn%2==1){
            for(int i=0; i<sigmaSizeIn; i++){
                System.out.println();
                for(double x=0; x<sigmaSizeIn; x++){
                    if(x>sigmaSizeIn/2)
                        System.out.print(" ");
                    else if(x==i)
                        System.out.print("~");
                    else if((x+i)==sigmaSizeIn-1)
                        System.out.print("^");
                    else if(i==0 || i==sigmaSizeIn-1)
                        System.out.print("###");
                    else
                        System.out.print(" ");
                }
            }
        }
    }
}