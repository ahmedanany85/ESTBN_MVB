package com.example.estbn_mvb.Onboarding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estbn_mvb.R;
import com.xcode.onboarding.OnBoarder;
import com.xcode.onboarding.OnBoardingPage;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main)  ---> Remove this line

        List<OnBoardingPage> pages = new ArrayList<>();
        pages.add(new OnBoardingPage(R.drawable.ic_pre_screen_p1,"أظهار الموقع","لوريم إيبسوم طريقة لكتابة النصوص في النشر والتصميم الجرافيكي تستخدم بشكل شائع لتوضيح الشكل المرئي للمستند أو الخط"));
        pages.add(new OnBoardingPage(R.drawable.ic_pre_screen_p1,"أظهار الموقع","لوريم إيبسوم طريقة لكتابة النصوص في النشر والتصميم الجرافيكي تستخدم بشكل شائع لتوضيح الشكل المرئي للمستند أو الخط"));
        pages.add(new OnBoardingPage(R.drawable.ic_pre_screen_p1,"أظهار الموقع","لوريم إيبسوم طريقة لكتابة النصوص في النشر والتصميم الجرافيكي تستخدم بشكل شائع لتوضيح الشكل المرئي للمستند أو الخط"));

        OnBoarder.startOnBoarding(this, pages,null);


    }
}
