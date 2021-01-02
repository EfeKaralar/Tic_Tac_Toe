package com.example.xox;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void x_attack(View v){
        //marks the clicked button with an X and disables it.
        Button b = (Button) v;
        b.setTextColor(Color.RED);
        b.setText("X");
    }
    public void o_attack(View v) {
        //marks the clicked button with an O and disables it.
        Button b = (Button) v;
        b.setTextColor(Color.BLUE);
        b.setText("O");
    }
    //int id11 = R.id.one1; int id12 = R.id.one2; int id13 = R.id.one3;    int id21 = R.id.two1; int id22 = R.id.two2; int id23 = R.id.two3;    int id31 = R.id.three1; int id32 = R.id.three2; int id33 = R.id.three3;
    int board [][] = new int[3][3]; //the empty matrix representing the board. gets filled with 1(X)'s amd -1(O)'S as game is played.
    int boardIds [][] = {
            {R.id.one1, R.id.one2, R.id.one3},
            {R.id.two1, R.id.two2, R.id.two3},
            {R.id.three1, R.id.three2, R.id.three3}}; // a matrix representing the board. is filled with id's of the buttons.
    public void Fill_Board(int [][] Board,int id, int move){
        //fills the matrix "board" when a button is pressed.
        outer: for (int i = 0; i<=2; i++){
            for (int j =0; j<=2; j++){
                if (boardIds[i][j] == id){
                    Board[i][j]=move;
                    break outer;
                }
            }
        }
    }
    public String Check_Winner(int[][]Board,int MC){
        //Since all X's are represented by 1's and all O's by -1's, if the sum of a row, or a column, or a cross is either 3 or -3, a player has won the game.

        //int checkArray [] = {firstRow, secondRow, thirdRow, firstColumn, secondColumn, thirdColumn, firstCross, secondCross};
        int checkArray [] = {Board[0][0]+Board[0][1]+Board[0][2], Board[1][0]+Board[1][1]+Board[1][2], Board[2][0]+Board[2][1]+Board[2][2], Board[0][0]+Board[1][0]+Board[2][0], Board[0][1]+Board[1][1]+Board[2][1], Board[0][2]+Board[1][2]+Board[2][2], Board[0][0]+Board[1][1]+Board[2][2], Board[0][2]+Board[1][1]+Board[2][0]};
        for (int i=0;i<8;i++){
            //x wins
            if (checkArray[i] == 3){
                return ("X"+String.valueOf(i));
            }
            //o wins
            if (checkArray[i]==-3){
                return "O"+String.valueOf(i);
            }
        }
        //it's a tie
        if (MC==9){
            return "TIE";
        }
        //game continues
        return "";
    }
    public void Determine_Winner(String w){
        if (w.length()!=0) {
            if (w.length() == 2) {
                TextView title = (TextView) findViewById(R.id.turnOfTitle);
                TextView winnerTitle = (TextView) findViewById(R.id.turnOf);
                title.setText("Winner:");
                winnerTitle.setText(w.charAt(0)+ "!!!");
                winnerTitle.setTextColor(Color.parseColor("#800080"));
            } else if (w.length() == 3) {
                //it's a tie
                TextView title = (TextView) findViewById(R.id.turnOfTitle);
                TextView winnerTitle = (TextView) findViewById(R.id.turnOf);
                title.setText("");
                winnerTitle.setText(w);
                winnerTitle.setTextColor(Color.parseColor("#800080"));
            }
            //disable and make grey all the buttons
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    findViewById(boardIds[i][j]).setEnabled(false);
                    findViewById(boardIds[i][j]).setBackgroundColor(Color.parseColor("#C0C0C0"));
                }
            }
            //enable play again button
            Button PA = (Button) findViewById(R.id.playAgain);
            PA.setVisibility(View.VISIBLE);
            PA.setEnabled(true);
        }
    }
    public void HighLightWinner(String w){
        if (w.length()==2){
            int i = Integer.valueOf(Character.toString(w.charAt(1)));
            if (Character.toString(w.charAt(0)).equals("X")){
                switch (i){
                    case 0:
                        View a0 = findViewById(R.id.one1);
                        View b0 = findViewById(R.id.one2);
                        View c0 = findViewById(R.id.one3);
                        a0.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b0.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c0.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 1:
                        View a1 = findViewById(R.id.two1);
                        View b1 = findViewById(R.id.two2);
                        View c1 = findViewById(R.id.two3);
                        a1.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b1.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c1.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 2:
                        View a2 = findViewById(R.id.three1);
                        View b2 = findViewById(R.id.three2);
                        View c2 = findViewById(R.id.three3);
                        a2.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b2.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c2.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 3:
                        View a3 = findViewById(R.id.one1);
                        View b3 = findViewById(R.id.two1);
                        View c3 = findViewById(R.id.three1);
                        a3.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b3.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c3.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 4:
                        View a4 = findViewById(R.id.one2);
                        View b4 = findViewById(R.id.two2);
                        View c4 = findViewById(R.id.three2);
                        a4.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b4.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c4.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 5:
                        View a5 = findViewById(R.id.one3);
                        View b5 = findViewById(R.id.two3);
                        View c5 = findViewById(R.id.three3);
                        a5.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b5.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c5.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 6:
                        View a6 = findViewById(R.id.one1);
                        View b6 = findViewById(R.id.two2);
                        View c6 = findViewById(R.id.three3);
                        a6.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b6.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c6.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                    case 7:
                        View a7 = findViewById(R.id.one3);
                        View b7 = findViewById(R.id.two2);
                        View c7 = findViewById(R.id.three1);
                        a7.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        b7.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        c7.setBackgroundColor(Color.parseColor("#FFCBCE"));
                        break;
                }
            }
            if (Character.toString(w.charAt(0)).equals("O")){
                //THIS FUNCTION BREAKS THE APP
                switch (i){
                    case 0:
                        View a0 = findViewById(R.id.one1);
                        View b0 = findViewById(R.id.one2);
                        View c0 = findViewById(R.id.one3);
                        a0.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b0.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c0.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 1:
                        View a1 = findViewById(R.id.two1);
                        View b1 = findViewById(R.id.two2);
                        View c1 = findViewById(R.id.two3);
                        a1.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b1.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c1.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 2:
                        View a2 = findViewById(R.id.three1);
                        View b2 = findViewById(R.id.three2);
                        View c2 = findViewById(R.id.three3);
                        a2.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b2.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c2.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 3:
                        View a3 = findViewById(R.id.one1);
                        View b3 = findViewById(R.id.two1);
                        View c3 = findViewById(R.id.three1);
                        a3.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b3.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c3.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 4:
                        View a4 = findViewById(R.id.one2);
                        View b4 = findViewById(R.id.two2);
                        View c4 = findViewById(R.id.three2);
                        a4.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b4.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c4.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 5:
                        View a5 = findViewById(R.id.one3);
                        View b5 = findViewById(R.id.two3);
                        View c5 = findViewById(R.id.three3);
                        a5.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b5.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c5.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 6:
                        View a6 = findViewById(R.id.one1);
                        View b6 = findViewById(R.id.two2);
                        View c6 = findViewById(R.id.three3);
                        a6.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b6.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c6.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 7:
                        View a7 = findViewById(R.id.one3);
                        View b7 = findViewById(R.id.two2);
                        View c7 = findViewById(R.id.three1);
                        a7.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        b7.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        c7.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                }
            }
        }
    }
    public int CountMove(){
        TextView t = (TextView) findViewById(R.id.moveCount);
        String s = (String) t.getText();
        int i = Integer.valueOf(s);
        String s2 = String.valueOf(i+1);
        CharSequence c = (CharSequence) s2;
        t.setText(c);
        return i+1;
    }
    public void PlayAgain(View v){
        //resets everything
        //resets titles
        TextView title = (TextView) findViewById(R.id.turnOfTitle);
        TextView winnerTitle = (TextView) findViewById(R.id.turnOf);
        title.setText("Turn:");
        winnerTitle.setText("X");
        winnerTitle.setTextColor(Color.parseColor("#FF0000"));
        //resets buttons
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                findViewById(boardIds[i][j]).setEnabled(true);
                findViewById(boardIds[i][j]).setBackgroundColor(Color.parseColor("#FF3F51B5"));
                TextView t = (TextView) findViewById(boardIds[i][j]);
                t.setText("");
            }
        }
        //resets values of buttons
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                board[i][j]=0;
            }
        }
        //resets play again button
        Button b = (Button) v;
        b.setEnabled(false);
        b.setVisibility(View.INVISIBLE);
        //resets move count
        TextView t = (TextView) findViewById(R.id.moveCount);
        t.setText("0");
    }
    public void CheckMove(View v){
        //determines if it is the move of X or O. the main function of buttons.
        v.setEnabled(false);
        TextView a = (TextView) findViewById(R.id.turnOf);
        String A = (String) a.getText();
        //checking the turn and applying applying either x_attack or o_attack
        if (A.equals("X")){
            x_attack(v);
            a.setText("O");
            a.setTextColor(Color.BLUE);
            Fill_Board(board, v.getId(), 1 );
        }
        else if (A.equals("O")){
            o_attack(v);
            a.setText("X");
            a.setTextColor(Color.RED);
            Fill_Board(board, v.getId(), -1 );
        }
        v.setBackgroundColor(Color.parseColor("#C0C0C0"));
        int move_count = CountMove();
        String winner = Check_Winner(board, move_count);
        Determine_Winner(winner);
        HighLightWinner(winner);
    }
}