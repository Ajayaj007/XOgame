package com.beast.tictactoe.xo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class onepHardGame extends AppCompatActivity implements View.OnClickListener {
    ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9, back;
        int b1c = 0, b2c = 0, b3c = 0, b4c = 0, b5c = 0, b6c = 0, b7c = 0, b8c = 0, b9c = 0;
        LinearLayout llayout;
        int dataentry[][] = new int[3][3], x = 0, y = 0, c, gameover, ctrlvar;
        int xp, yp;
        TextView xs, ys, dispTurn, winner;
        Button playAgain, reset;
        Boolean backActivity = false;
        Move compMove = new Move();
        int firstPlayer, nextPlayer;
        String displayTurn1, displayTurn2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.normal);
            ctrlvar = 0;
            for (int i = 0; i <= 2; i++)
                for (int j = 0; j <= 2; j++) {
                    dataentry[i][j] = 0;
                }
            xs = (TextView) findViewById(R.id.xscore);
            ys = (TextView) findViewById(R.id.yscore);
            dispTurn = (TextView) findViewById(R.id.dispTurn);
            winner = (TextView) findViewById(R.id.winner);
/*        SpannableString spantext = new SpannableString("X's Turn");
        spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
        dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);*/
            playAgain = (Button) findViewById(R.id.pagain);
            reset = (Button) findViewById(R.id.reset);
            playAgain.setVisibility(View.INVISIBLE);
            playAgain.setClickable(false);
            llayout = (LinearLayout) findViewById(R.id.llayout);
            b1 = (ImageView) findViewById(R.id.b1);
            b2 = (ImageView) findViewById(R.id.b2);
            b3 = (ImageView) findViewById(R.id.b3);
            b4 = (ImageView) findViewById(R.id.b4);
            b5 = (ImageView) findViewById(R.id.b5);
            b6 = (ImageView) findViewById(R.id.b6);
            b7 = (ImageView) findViewById(R.id.b7);
            b8 = (ImageView) findViewById(R.id.b8);
            b9 = (ImageView) findViewById(R.id.b9);
            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);
            b4.setOnClickListener(this);
            b5.setOnClickListener(this);
            b6.setOnClickListener(this);
            b7.setOnClickListener(this);
            b8.setOnClickListener(this);
            b9.setOnClickListener(this);
            back = (ImageView) findViewById(R.id.back);
            back.setOnClickListener(this);
            clickable(false);
        }

        @Override
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            if (hasFocus) {
                decidePlayer();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (firstPlayer == 1)
                            firstPlay();
                        clickable(true);
                    }
                }, 500);
            }
        }

    public void decidePlayer() {
        Random rand = new Random();
        int a = rand.nextInt(20);
        if ((a % 2) == 0) {
            firstPlayer = 1;
            nextPlayer = 0;
            xp = 1;
            yp = 10;
            displayTurn1 = "Computer's Turn";
            displayTurn2 = "Your Turn";
            SpannableString spantext = new SpannableString("Computer takes X");
            spantext.setSpan(new RelativeSizeSpan(1.5f), 14, 16, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
            clickable(false);
        } else {
            firstPlayer = 0;
            nextPlayer = 1;
            xp = 10;
            yp = 1;
            displayTurn1 = "Your Turn";
            displayTurn2 = "Computer's Turn";
            SpannableString spantext = new SpannableString("You are X");
            spantext.setSpan(new RelativeSizeSpan(1.5f), 7, 9, 0);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
            clickable(true);
        }
    }

    public void firstPlay() {
        Random rand = new Random();
        int a, place;
        place = rand.nextInt(3);
        a = rand.nextInt(3);
        if (a == 0 && place == 0) {
            displayTurn(b1, 0, 0, firstPlayer);
            b1c = 1;
        } else if (a == 0 && place == 1) {
            displayTurn(b2, 0, 1, firstPlayer);
            b2c = 1;
        } else if (a == 0 && place == 2) {
            displayTurn(b3, 0, 2, firstPlayer);
            b3c = 1;
        } else if (a == 1 && place == 0) {
            displayTurn(b4, 1, 0, firstPlayer);
            b4c = 1;
        } else if (a == 1 && place == 1) {
            displayTurn(b5, 1, 1, firstPlayer);
            b5c = 1;
        } else if (a == 1 && place == 2) {
            displayTurn(b6, 1, 2, firstPlayer);
            b6c = 1;
        } else if (a == 2 && place == 0) {
            displayTurn(b7, 2, 0, firstPlayer);
            b7c = 1;
        } else if (a == 2 && place == 1) {
            displayTurn(b8, 2, 1, firstPlayer);
            b8c = 1;
        } else if (a == 2 && place == 2) {
            displayTurn(b9, 2, 2, firstPlayer);
            b9c = 1;
        }
    }

/*    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }*/

    public void clickable(Boolean val) {
        if (b1c == 0)
            b1.setClickable(val);
        if (b2c == 0)
            b2.setClickable(val);
        if (b3c == 0)
            b3.setClickable(val);
        if (b4c == 0)
            b4.setClickable(val);
        if (b5c == 0)
            b5.setClickable(val);
        if (b6c == 0)
            b6.setClickable(val);
        if (b7c == 0)
            b7.setClickable(val);
        if (b8c == 0)
            b8.setClickable(val);
        if (b9c == 0)
            b9.setClickable(val);
    }

    public void clear() {
        String v = x + " ";
        xs.setText(v);
        v = y + " ";
        ys.setText(v);
        clickable(false);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setClickable(true);
        dispTurn.setText(" ");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x != 0 || y != 0) {
                    xs.setText("0");
                    ys.setText("0");
                    x = 0;
                    y = 0;
                    newGame();
                }
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                newGame();
            }
        });

    }

    public void newGame() {
        SpannableString spantext = new SpannableString("X's Turn");
        spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
        dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        winner.setText(" ");
        playAgain.setClickable(false);
        playAgain.setVisibility(View.INVISIBLE);
        ctrlvar = 0;
        c = 0;
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j <= 2; j++) {
                dataentry[i][j] = 0;
            }
        b1.setBackgroundResource(R.drawable.empty);
        b2.setBackgroundResource(R.drawable.empty);
        b3.setBackgroundResource(R.drawable.empty);
        b4.setBackgroundResource(R.drawable.empty);
        b5.setBackgroundResource(R.drawable.empty);
        b6.setBackgroundResource(R.drawable.empty);
        b7.setBackgroundResource(R.drawable.empty);
        b8.setBackgroundResource(R.drawable.empty);
        b9.setBackgroundResource(R.drawable.empty);
        b1c = 0;
        b2c = 0;
        b3c = 0;
        b4c = 0;
        b5c = 0;
        b6c = 0;
        b7c = 0;
        b8c = 0;
        b9c = 0;
        clickable(true);
        decidePlayer();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstPlayer == 1) {
                    firstPlay();
                    clickable(true);
                }
            }
        }, 500);
    }

    public void declare(ImageView bb1, ImageView bb2, ImageView bb3, int check) {
        if (check == 1) {
            SpannableString spantext = new SpannableString("X wins!");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            bb1.setBackgroundResource(R.drawable.xwin);
            bb2.setBackgroundResource(R.drawable.xwin);
            bb3.setBackgroundResource(R.drawable.xwin);
            gameover = 1;
            x++;
            clear();
        } else if (check == 0) {
            SpannableString spantext = new SpannableString("O wins!");
            spantext.setSpan(new RelativeSizeSpan(1.7f), 0, 1, 0);
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            bb1.setBackgroundResource(R.drawable.owin);
            bb2.setBackgroundResource(R.drawable.owin);
            bb3.setBackgroundResource(R.drawable.owin);
            gameover = 1;
            y++;
            clear();
        }
    }

    public void check() {
        c = (dataentry[0][0] + dataentry[0][1] + dataentry[0][2]);
        gameover = 0;
        if (c == 3) {
            declare(b1, b2, b3, 1);
        } else if (c == 30) {
            declare(b1, b2, b3, 0);
        }
        c = (dataentry[1][0] + dataentry[1][1] + dataentry[1][2]);
        if (c == 3) {
            declare(b4, b5, b6, 1);
        } else if (c == 30) {
            declare(b4, b5, b6, 0);
        }
        c = (dataentry[2][0] + dataentry[2][1] + dataentry[2][2]);
        if (c == 3) {
            declare(b7, b8, b9, 1);
        } else if (c == 30) {
            declare(b7, b8, b9, 0);
        }
        c = (dataentry[0][0] + dataentry[1][0] + dataentry[2][0]);
        if (c == 3) {
            declare(b1, b4, b7, 1);
        } else if (c == 30) {
            declare(b1, b4, b7, 0);
        }
        c = (dataentry[0][1] + dataentry[1][1] + dataentry[2][1]);
        if (c == 3) {
            declare(b2, b5, b8, 1);
        } else if (c == 30) {
            declare(b2, b5, b8, 0);
        }
        c = (dataentry[0][2] + dataentry[1][2] + dataentry[2][2]);
        if (c == 3) {
            declare(b3, b6, b9, 1);
        } else if (c == 30) {
            declare(b3, b6, b9, 0);
        }
        c = (dataentry[0][0] + dataentry[1][1] + dataentry[2][2]);
        if (c == 3) {
            declare(b1, b5, b9, 1);
        } else if (c == 30) {
            declare(b1, b5, b9, 0);
        }
        c = (dataentry[0][2] + dataentry[1][1] + dataentry[2][0]);
        if (c == 3) {
            declare(b3, b5, b7, 1);
        } else if (c == 30) {
            declare(b3, b5, b7, 0);
        }
        if (ctrlvar == 9 && gameover == 0) {
            SpannableString spantext = new SpannableString("DRAW!");
            winner.setText(spantext, TextView.BufferType.SPANNABLE);
            clear();
        }
    }

    public void displayTurn(ImageView bb1, int a, int b, int check) {
        if (check == 1) {
            bb1.setBackgroundResource(R.drawable.x);
            bb1.setClickable(false);
            ctrlvar++;
            dataentry[a][b] = 1;
            SpannableString spantext = new SpannableString(displayTurn2);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        } else if (check == 0) {
            bb1.setBackgroundResource(R.drawable.o);
            bb1.setClickable(false);
            ctrlvar++;
            dataentry[a][b] = 10;
            SpannableString spantext = new SpannableString(displayTurn1);
            dispTurn.setText(spantext, TextView.BufferType.SPANNABLE);
        }
    }

    public void compTurn() {
        compMove = findBestMove();
        int a = compMove.row;
        int place = compMove.col;
        if (a == 0 && place == 0) {
            displayTurn(b1, 0, 0, firstPlayer);
            b1c = 1;
        } else if (a == 0 && place == 1) {
            displayTurn(b2, 0, 1, firstPlayer);
            b2c = 1;
        } else if (a == 0 && place == 2) {
            displayTurn(b3, 0, 2, firstPlayer);
            b3c = 1;
        } else if (a == 1 && place == 0) {
            displayTurn(b4, 1, 0, firstPlayer);
            b4c = 1;
        } else if (a == 1 && place == 1) {
            displayTurn(b5, 1, 1, firstPlayer);
            b5c = 1;
        } else if (a == 1 && place == 2) {
            displayTurn(b6, 1, 2, firstPlayer);
            b6c = 1;
        } else if (a == 2 && place == 0) {
            displayTurn(b7, 2, 0, firstPlayer);
            b7c = 1;
        } else if (a == 2 && place == 1) {
            displayTurn(b8, 2, 1, firstPlayer);
            b8c = 1;
        } else if (a == 2 && place == 2) {
            displayTurn(b9, 2, 2, firstPlayer);
            b9c = 1;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                displayTurn(b1, 0, 0, nextPlayer);
                b1c = 1;
                break;
            case R.id.b2:
                displayTurn(b2, 0, 1, nextPlayer);
                b2c = 1;
                break;
            case R.id.b3:
                displayTurn(b3, 0, 2, nextPlayer);
                b3c = 1;
                break;
            case R.id.b4:
                displayTurn(b4, 1, 0, nextPlayer);
                b4c = 1;
                break;
            case R.id.b5:
                displayTurn(b5, 1, 1, nextPlayer);
                b5c = 1;
                break;
            case R.id.b6:
                displayTurn(b6, 1, 2, nextPlayer);
                b6c = 1;
                break;
            case R.id.b7:
                displayTurn(b7, 2, 0, nextPlayer);
                b7c = 1;
                break;
            case R.id.b8:
                displayTurn(b8, 2, 1, nextPlayer);
                b8c = 1;
                break;
            case R.id.b9:
                displayTurn(b9, 2, 2, nextPlayer);
                b9c = 1;
                break;
            case R.id.back:
                onepHardGame.this.finish();
                backActivity = true;
        }
        clickable(false);
        if (!backActivity)
            check();
        if (gameover != 1 && ctrlvar != 9 && !backActivity) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    compTurn();
                    clickable(true);
                    check();
                }
            }, 500);
        }
    }

    public class Move {
        int row, col;
    }

    Move findBestMove() {
        int bestVal = -1000;
        compMove.row = -1;
        compMove.col = -1;

        // Traverse all cells, evalutae minimax function for all empty cells. And return the cell with optimal value.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if celll is empty
                if (dataentry[i][j] == 0) {
                    // Make the move
                    dataentry[i][j] = xp;

                    // compute evaluation function for this move.
                    int moveVal = minimax(0, false);

                    // Undo the move
                    dataentry[i][j] = 0;

                    // If the value of the current move is more than the best value, then update best/
                    if (moveVal > bestVal) {
                        compMove.row = i;
                        compMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return compMove;
    }

    int minimax(int depth, boolean isMax) {
        int score = evaluate();

        // If Maximizer has won the game return his/her evaluated score
        if (score == 10)
            return score - depth;

        // If Minimizer has won the game return his/her evaluated score
        if (score == -10)
            return score + depth;

        // If there are no more moves and no winner then it is a tie
        if (!isMovesLeft())
            return 0;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (dataentry[i][j] == 0) {
                        // Make the move
                        dataentry[i][j] = xp;

                        // Call minimax recursively and choose the maximum value
                        best = max(best, minimax(depth + 1, !isMax));

                        // Undo the move
                        dataentry[i][j] = 0;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (dataentry[i][j] == 0) {
                        // Make the move
                        dataentry[i][j] = yp;

                        // Call minimax recursively and choose the minimum value
                        best = min(best,
                                minimax(depth + 1, !isMax));

                        // Undo the move
                        dataentry[i][j] = 0;
                    }
                }
            }
            return best;
        }
    }

    boolean isMovesLeft() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (dataentry[i][j] == 0)
                    return true;
        return false;
    }

    // This is the evaluation function as discussed in the previous article ( http://goo.gl/sJgv68 )
    int evaluate() {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (dataentry[row][0] == dataentry[row][1] &&
                    dataentry[row][1] == dataentry[row][2]) {
                if (dataentry[row][0] == xp)
                    return +10;
                else if (dataentry[row][0] == yp)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (dataentry[0][col] == dataentry[1][col] &&
                    dataentry[1][col] == dataentry[2][col]) {
                if (dataentry[0][col] == xp)
                    return +10;

                else if (dataentry[0][col] == yp)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (dataentry[0][0] == dataentry[1][1] && dataentry[1][1] == dataentry[2][2]) {
            if (dataentry[0][0] == xp)
                return +10;
            else if (dataentry[0][0] == yp)
                return -10;
        }

        if (dataentry[0][2] == dataentry[1][1] && dataentry[1][1] == dataentry[2][0]) {
            if (dataentry[0][2] == xp)
                return +10;
            else if (dataentry[0][2] == yp)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

}
