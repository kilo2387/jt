
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by kilo on 2017/1/21.
 */

class GameHelper {
    private static final String alphabet = "ab";
    private int gridLength =2;
    private int gridSize = 4;
    private int[] grid = new int[gridSize];
    private int comCount = 0;


    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0){
                return null;
            }
        }catch (IOException e){
            System.out.println("IOException : " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attemps = 0;
        boolean success = false;
        int location = 0;
        comCount ++ ;
        int incr = 1;
        if((comCount % 2) == 1){
            incr = gridLength;
        }
        while (!success & attemps++ < 200){
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < comSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize){
                        success = false;
                    }
                    if(x > 0 && (location % gridLength ==0)){
                        success = false;
                    }
                }else{
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int colnum = 0;
        while (x < comSize){
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            colnum = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(colnum));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x ++ ;
            System.out.print( "coord " + x +" = "+ alphaCells.get(x-1)) ;
        }
        return alphaCells;
    }
}
