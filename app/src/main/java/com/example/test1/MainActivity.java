package com.example.test1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button but1, but2, but3, but4, but5, butRez;
    TextView text1, text2, text3, text4, text5, text6;
    View view1;
    final int alpha_id = 1;
    final int scale_id = 2;
    final int translate_id = 3;
    final int rotate_id = 4;
    final int combo_id = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);
        but5 = findViewById(R.id.but5);
        butRez = findViewById(R.id.butRez);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text3);
        text3 = findViewById(R.id.text4);
        text4 = findViewById(R.id.text5);
        text5 = findViewById(R.id.text6);
        text6 = findViewById(R.id.text7);
        view1 = findViewById(R.id.view1);

        registerForContextMenu(text1);  // привязываем к тексту выпадающее контекстное меню


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.but1:
                        text2.setText(R.string.text2);
                        but1.setFocusableInTouchMode(true);
                        butRez.setText(R.string.But1);
                        butRez.setBackgroundResource(R.drawable.but1); break;
                    case R.id.but2:
                        text3.setText(R.string.text3);
                        butRez.setText(R.string.But2);
                        butRez.setBackgroundResource(R.drawable.but2); break;
                    case R.id.but3:
                        text4.setText(R.string.text4);
                        butRez.setText(R.string.But3);
                        butRez.setBackgroundResource(R.drawable.but3); break;
                    case R.id.but4:
                        text5.setText(R.string.text5);
                        butRez.setText(R.string.But4);
                        butRez.setBackgroundResource(R.drawable.but4); break;
                    case R.id.but5:
                        text6.setText(R.string.text6);
                        butRez.setText(R.string.But5);
                        butRez.setBackgroundResource(R.drawable.but5); break;
                }
            }
        };

        but1.setOnClickListener(onClickListener);           // назначение кнопкам слушателя
        but2.setOnClickListener(onClickListener);
        but3.setOnClickListener(onClickListener);
        but4.setOnClickListener(onClickListener);
        but5.setOnClickListener(onClickListener);

        text1.setOnClickListener(new View.OnClickListener() {   // создание слушателя для текстовой кнопки
            @Override
            public void onClick (View view) {
                but5.setVisibility(View.VISIBLE);
                view1.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override       //метод, который создаёт пункты в меню
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.text1:
                menu.add(0, alpha_id, 0, "alpha");
                menu.add(0, scale_id, 0, "scale");
                menu.add(0, translate_id, 0, "translate");
                menu.add(0, rotate_id, 0, "rotate");
                menu.add(0, combo_id, 0, "combo");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override   //метод, который запускает анимацию, в зависимости от выбранного пункта меню
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()) {
            case alpha_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            case scale_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case translate_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.trans);
                break;
            case rotate_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case combo_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.combo);
                break;
        }
        text1.startAnimation(anim);
        return super.onContextItemSelected(item);
    }

}