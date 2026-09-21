package com.example.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private ImageView image;
    private RadioButton answ1;
    private RadioButton answ2;
    private RadioButton answ3;
    private Button btn;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<String> questions = new ArrayList<>();

        questions.add("Które to schronisko?");
        questions.add("Zwierzę na zdjęciu to");
        questions.add("W oddali są widoczne");


        image = findViewById(R.id.img);
        question = findViewById(R.id.question);

        answ1 = findViewById(R.id.answ1);
        answ2 = findViewById(R.id.answ2);
        answ3 = findViewById(R.id.answ3);

        btn = findViewById(R.id.btn);

        question.setText(questions.get(0));

        btn.setOnClickListener(v ->
        {
            CheckAnswears();

            if(question.getText().toString().equals(questions.get(0)))
            {
                image.setImageResource(R.drawable.zad2);
                SetQuestions(questions.get(1),"owczarek.","wilk.","kozica.");
            }
            else if (question.getText().toString().equals(questions.get(1)))
            {
                image.setImageResource(R.drawable.zad3);
                SetQuestions(questions.get(2),"Himalaje.","Alpy.","Tatry.");
            }
            else if (question.getText().toString().equals(questions.get(2)))
            {
                image.setImageResource(R.drawable.zad1);
                SetQuestions(questions.get(0),"Na Rysiance.","Na Wielkiej Raczy.","Na Wielkiej Raczy.");
            }
        });
    }
    private void CheckAnswears()
    {
        if(answ2.isChecked() && answ2.getText().toString().equals("Na Wielkiej Raczy."))
        {
            points++;
        }
        else if (answ1.isChecked() && answ2.getText().toString().equals("owczarek."))
        {
            points++;
        }
        else if(answ3.isChecked() && answ3.getText().toString().equals("Tatry."))
        {
            points++;
        }
        answ1.setChecked(false);
        answ2.setChecked(false);
        answ3.setChecked(false);
    }

    private void SetQuestions(String q, String ans1, String ans2, String ans3)
    {

        question.setText(q);

        answ1.setText(ans1);
        answ2.setText(ans2);
        answ3.setText(ans3);
    }

}