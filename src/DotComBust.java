import java.util.ArrayList;

/**
 * Created by kilo on 2017/1/17.
 */
class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        one.setName("eToys.com");
        DotCom three = new DotCom();
        one.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("your goal is to sink three dot coms");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number fo guesses");

        for(DotCom doComToset : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            doComToset.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (DotCom doComTotest : dotComsList) {
            result = doComTotest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(doComTotest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("all dot are dead");
    }

    public static void main(String[] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}


