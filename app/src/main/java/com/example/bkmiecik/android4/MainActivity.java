package com.example.bkmiecik.android4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnWyborOpcjiListener {

    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);
        transakcja.commit();
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transakcja =
                getSupportFragmentManager().beginTransaction();
        transakcja.detach(f11);
        transakcja.detach(f12);

        switch (opcja){
            case 1:
                transakcja.attach(f11);
                break;
            case 2:
                transakcja.attach(f12);
                break;
        }
        transakcja.commit();
    }
}
