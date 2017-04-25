package com.example.bkmiecik.android4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Zakladki extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar bar;
    FragmentTransaction transakcja;
    Fragment11 f11;
    Fragment12 f12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakladki);

        bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab o1 = bar.newTab();
        ActionBar.Tab o2 = bar.newTab();

        o1.setText("Opcja 1");
        o2.setText("Opcja 2");

        o1.setTabListener(this);
        o2.setTabListener(this);

        bar.addTab(o1,false);
        bar.addTab(o2,false);

        f11 = new Fragment11();
        f12 = new Fragment12();

        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);

        transakcja.attach(f11);

        transakcja.commit();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        FragmentTransaction transakcja =
                getSupportFragmentManager().beginTransaction();
        transakcja.detach(f11);
        transakcja.detach(f12);


        switch (tab.getPosition()){
            case 0:
                transakcja.attach(f11);
                break;
            case 1:
                transakcja.attach(f12);
                break;
        }
        transakcja.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
