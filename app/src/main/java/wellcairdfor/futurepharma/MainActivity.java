package wellcairdfor.futurepharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gogogo();
    }


    public void gogogo()
    {
        Intent intent = new Intent(this, FiveQuestions.class);
        startActivity(intent);

    }
}
