package com.stress.salsii1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class recommandation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommandation);

//        button to navigate from recommendation to the map activity
        Button mybtn = findViewById(R.id.bottomButton);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recommandation.this, AllocateLocation.class);
                startActivity(intent);
            }
        });

    }
}