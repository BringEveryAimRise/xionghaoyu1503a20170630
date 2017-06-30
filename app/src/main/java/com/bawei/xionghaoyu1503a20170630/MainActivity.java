package com.bawei.xionghaoyu1503a20170630;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        View left = toolbar.findViewById(R.id.toolbar_left);
        left.setOnClickListener(this);
        View righ = toolbar.findViewById(R.id.toolbar_righ);
        righ.setOnClickListener(this);
        View icon = toolbar.findViewById(R.id.toolbar_icon);
        icon.setOnClickListener(this);
        right= (ImageView) toolbar.findViewById(R.id.main_iv_right);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


        initFragment();

    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_panter,new LeftFragment()).commit();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_left:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_panter,new LeftFragment()).commit();
                break;
            case R.id.toolbar_righ:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_panter,new RighFragment()).commit();
                break;
        }
    }
}
