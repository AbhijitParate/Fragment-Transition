package com.github.abhijitpparate.fragmenttransition;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.addA)
    Button addA;

    @BindView(R.id.addB)
    Button addB;

    @BindView(R.id.removeA)
    Button removeA;

    @BindView(R.id.removeB)
    Button removeB;

    @BindView(R.id.replace_a_b)
    Button replaceAb;

    @BindView(R.id.replace_b_a)
    Button replaceBa;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        manager = getFragmentManager();
    }

    @OnClick(R.id.addA)
    public void onAddA(View view){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.animator.enter_slide_from_left, R.animator.exit_slide_to_right,R.animator.enter_slide_from_left, R.animator.exit_slide_to_right);
        ft.replace(R.id.fragment_container, fragmentA, "A");
        ft.addToBackStack("A");
        ft.commit();
    }

    @OnClick(R.id.removeA)
    public void onRemoveA(View view){
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("A");
        if (fragmentA != null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.animator.enter_slide_from_left, R.animator.exit_slide_to_right,R.animator.enter_slide_from_left, R.animator.exit_slide_to_right);
            ft.remove(fragmentA);
            ft.commit();
        }
    }

    @OnClick(R.id.addB)
    public void onAddB(View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom,R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom);
        ft.replace(R.id.fragment_container, fragmentB, "B");
        ft.addToBackStack("B");
        ft.commit();
    }

    @OnClick(R.id.removeB)
    public void onRemoveB(View view){
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("B");
        if (fragmentB != null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom,R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom);
            ft.remove(fragmentB);
            ft.commit();
        }
    }

    @OnClick(R.id.replace_a_b)
    public void onReplaceAb(View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.animator.enter_slide_from_left, R.animator.exit_slide_to_right,R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom);
        ft.replace(R.id.fragment_container, fragmentB, "B");
        ft.addToBackStack("B");
        ft.commit();
    }

    @OnClick(R.id.replace_b_a)
    public void onReplaceBa(View view){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.animator.enter_slide_from_top, R.animator.exit_slide_to_bottom,R.animator.enter_slide_from_left, R.animator.exit_slide_to_right);
        ft.replace(R.id.fragment_container, fragmentA, "A");
        ft.addToBackStack("A");
        ft.commit();
    }
}
