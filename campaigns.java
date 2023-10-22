package com.example.gram_panchayat;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class campaigns extends AppCompatActivity {
    TextView dt1, dt2, dt3, dt4, dt5;
    LinearLayout layout1, layout2, layout3, layout4, layout5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaigns);

        dt1 = findViewById(R.id.details);
        dt2 = findViewById(R.id.details2);
        dt3 = findViewById(R.id.details3);
        dt4 = findViewById(R.id.details4);
        dt5 = findViewById(R.id.details5);

        layout1 = findViewById(R.id.layout);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);

        setupExpandableCard(layout1, dt1);
        setupExpandableCard(layout2, dt2);
        setupExpandableCard(layout3, dt3);
        setupExpandableCard(layout4, dt4);
        setupExpandableCard(layout5, dt5);
    }

    public void expand(View view) {
        LinearLayout layout = null;
        TextView dt = null;

        switch (view.getId()) {
            case R.id.layout:
                layout = layout1;
                dt = dt1;
                break;
            case R.id.layout2:
                layout = layout2;
                dt = dt2;
                break;
            case R.id.layout3:
                layout = layout3;
                dt = dt3;
                break;
            case R.id.layout4:
                layout = layout4;
                dt = dt4;
                break;
            case R.id.layout5:
                layout = layout5;
                dt = dt5;
                break;
        }

        if (layout != null && dt != null) {
            int visibility = (dt.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout, new AutoTransition());
            dt.setVisibility(visibility);
        }
    }

    private void setupExpandableCard(LinearLayout layout, TextView details) {
        layout.setOnClickListener(this::expand);
        details.setVisibility(View.GONE);
    }
}
