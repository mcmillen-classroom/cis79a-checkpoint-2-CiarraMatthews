package admin.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView manotherTextView;
    private TextView mTextView;


    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private Button mHintButton;

    private Question[] mQuestions;
    private int mIndex;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPreviousButton = (ImageButton) findViewById(R.id.previous_question);
        mHintButton = (Button) findViewById(R.id.hint_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);

        manotherTextView = (TextView) findViewById(R.id.text_view);
        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[5];
        mIndex = 0;
        //Initialize each slot in the array.
        mQuestions[0] = new Question(R.string.question_1, true, R.string.hint_1);
        mQuestions[1] = new Question(R.string.question_2,true, R.string.hint_2);
        mQuestions[2] = new Question(R.string.question_3,false, R.string.hint_3);
        mQuestions[3] = new Question(R.string.question_4,false, R.string.hint_4);
        mQuestions[4] = new Question(R.string.question_5,true, R.string.hint_5);
        mTextView.setText(((mQuestions) [mIndex]).getmTextResId());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
        }
        else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
        }
        else if (view.getId() == R.id.next_button) {
            mIndex++;
            if (mIndex >= mQuestions.length) {
                mIndex = 0;
                //mTextView.setText(mQuestions[0].getmTextResId());
            }
            mTextView.setText(mQuestions[mIndex].getmTextResId());
        }
        else if (view.getId() == R.id.previous_question) {
            mIndex--;
            if (mIndex < 0) {
                mIndex = 4;
            }
            mTextView.setText(mQuestions[mIndex].getmTextResId());
        }
        else if (view.getId() == R.id.hint_button) {
            Toast myToast = Toast.makeText(this,(mQuestions[mIndex].getHmTextResId()), Toast.LENGTH_SHORT);
            myToast.show();
            //mTextView.setText(mQuestions[mIndex].getHmTextResId());
        }
    }

    public boolean checkAnswer (boolean userInput)
    {
        if (mQuestions[mIndex].getAnswer() == userInput)
        {
            manotherTextView.setText("Score:" + score);
            score++;
            Toast myToast = Toast.makeText(this, "You are correct! ", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
        else
        {
            manotherTextView.setText("Score:" + score);
            score--;
            Toast myToast = Toast.makeText(this, "You are incorrect... ", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
}
