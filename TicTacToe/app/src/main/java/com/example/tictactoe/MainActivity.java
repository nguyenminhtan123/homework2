package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{

    String player = "X";
    int [][] gameData=new int[4][4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void check(View view){
        String btnId=((Button)view).getResources().getResourceEntryName(((Button)view).getId());

        int j=Integer.parseInt((btnId.substring(btnId.length() - 1)));
        int i=Integer.parseInt((btnId.substring(btnId.length() - 2,btnId.length()-1)));

        if (player.equals("X")){
            ((Button)view).setText("O");
            player="O";
            gameData[i][j]=2;
        }else {
            ((Button)view).setText("X");
            player="X";
            gameData[i][j]=1;
        }
        if (checkWinner(gameData) == 1) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Player 1 is winner");
            builder1.setCancelable(true);
            AlertDialog alert11 = builder1.create();
            alert11.show();

        }else if (checkWinner(gameData) == 2) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Player 2 is winner");
            builder1.setCancelable(true);
            AlertDialog alert11 = builder1.create();
            alert11.show();

        }

    }

    public int checkWinner(int [][] gameData){
        int result = 0;
        for (int count = 1; count < 4; count++) {
            if(gameData[count][1] == gameData[count][2] && gameData[count][2] == gameData[count][3] &&  gameData[count][3] !=0){
                result =gameData[count][1];

            }
        }
        for (int count = 1; count < 4; count++) {
            if(gameData[1][count] == gameData[2][count] && gameData[2][count] == gameData[3][count] &&  gameData[3][count] !=0){
                result =gameData[1][count];

            }
        }
        if(gameData[1][1] == gameData[2][2] && gameData[1][1] == gameData[3][3] && gameData[1][1] != 0){
            result = gameData[1][1];

        }
        if(gameData[1][3] == gameData[2][2] && gameData[1][3] == gameData[3][1] && gameData[3][1] != 0){
            result = gameData[1][3];

        }

        return result;

    }


}

