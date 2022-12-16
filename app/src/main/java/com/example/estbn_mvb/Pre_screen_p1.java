package com.example.estbn_mvb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estbn_mvb.Onboarding.OnBoardingActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Pre_screen_p1 extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button mStart;
    Animation animation;
    int currentPos;
    ImageButton next_btn;
    Button skp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_screen_p1);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        mStart = findViewById(R.id.startBtn);
        next_btn = findViewById(R.id.next_btn);
        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        skp_btn = findViewById(R.id.skp_btn);

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTypeSheet();
            }
        });


    }

    private void userTypeSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.AppBottomSheetDialogTheme);
        Button carOwner;
        Button provider;

        bottomSheetDialog.setContentView(R.layout.pre_user_type);
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);

        BottomSheetBehavior.from(bottomSheet)
                .setState(BottomSheetBehavior.STATE_EXPANDED);

        carOwner = bottomSheetDialog.findViewById(R.id.carOwner);
        provider = bottomSheetDialog.findViewById(R.id.provider);

        carOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pre_screen_p1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        bottomSheetDialog.show();
    }


    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }

    public void lastPage(View view) {
        viewPager.setCurrentItem(3);

    }

    private void addDots(int position) {

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.primaryDark));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;

            if (position == 0) {
                dotsLayout.setVisibility(View.VISIBLE);
                next_btn.setVisibility(View.VISIBLE);
                mStart.setVisibility(View.GONE);
                skp_btn.setVisibility(View.VISIBLE);

                mStart.setVisibility(View.INVISIBLE);

            } else if (position == 1) {

                dotsLayout.setVisibility(View.VISIBLE);
                next_btn.setVisibility(View.VISIBLE);
                mStart.setVisibility(View.GONE);
                skp_btn.setVisibility(View.VISIBLE);

                mStart.setVisibility(View.INVISIBLE);

            }  else {
                animation = AnimationUtils.loadAnimation(Pre_screen_p1.this, R.anim.header_ainme);
                mStart.setAnimation(animation);
                dotsLayout.setVisibility(View.GONE);
                next_btn.setVisibility(View.GONE);
                skp_btn.setVisibility(View.GONE);
                mStart.setVisibility(View.VISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}