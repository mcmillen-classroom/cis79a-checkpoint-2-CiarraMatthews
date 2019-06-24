package admin.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nTrueButton;
    private Button nFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nTrueButton = (Button) findViewById(R.id.true_button);
        nFalseButton = (Button) findViewById(R.id.false_button);

        nTrueButton.setOnClickListener(this);
        nFalseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView myTextView = (TextView) view;
        Toast myToast = Toast.makeText(this, "You just clicked " + myTextView.getText(), Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.TOP|Gravity.CENTER_VERTICAL,0,0);
        myToast.show();
    }
}
