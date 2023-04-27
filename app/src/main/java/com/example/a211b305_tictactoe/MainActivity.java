package com.example.a211b305_tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int box_clicked=-1;
    int player=1;
    int [][]winning_state={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []game_state={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        box_clicked=game_state[tag];
        if(isWinner==false && box_clicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross_tic);
                game_state[tag] = player;
                Toast.makeText(this, tag + "" + " Cross", Toast.LENGTH_SHORT).show();
                player = 2;
            } else {
                v.setImageResource(R.drawable.zero_tic);
                game_state[tag] = player;
                Toast.makeText(this, tag + "" + " Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }

            for (int i = 0; i < winning_state.length; i++) {
                if (game_state[winning_state[i][0]] == game_state[winning_state[i][1]] && game_state[winning_state[i][1]] == game_state[winning_state[i][2]] && game_state[winning_state[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 2 ? 1 : 2), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }

            }
        }
    }

    public void reset(View view)
    {
        GridLayout grid_layout;
        grid_layout = findViewById(R.id.grid_layout);
        int total_images=grid_layout.getChildCount();
        for(int i=0;i<total_images;i++)
        {
            ImageView v=(ImageView) grid_layout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        box_clicked=-1;
        for (int i=0;i<game_state.length;i++)
            game_state[i]=-1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}