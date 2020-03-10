package com.anningtex.practicepens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.anningtex.practicepens.view.PenType;
import com.anningtex.practicepens.view.StrokesView;

/**
 * @author Administrator
 * desc: 钢笔字 毛笔字 书写
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    StrokesView strokesView;
    private Button reDo;
    private Button unDo;
    private Button recover;
    private RadioGroup pen_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        strokesView = findViewById(R.id.view);
        recover = findViewById(R.id.recover);
        unDo = findViewById(R.id.undo);
        reDo = findViewById(R.id.redo);
        pen_type = findViewById(R.id.pen_type);

        recover.setOnClickListener(this);
        unDo.setOnClickListener(this);
        reDo.setOnClickListener(this);

        pen_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.pen:
                        strokesView.setPenType(PenType.PEN);
                        break;
                    case R.id.brush_pen:
                        strokesView.setPenType(PenType.BRUSH);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.undo:
                strokesView.unDo();
                break;
            case R.id.recover:
                strokesView.recover();
                break;
            case R.id.redo:
                strokesView.reDo();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        strokesView.onDestroy();
    }
}
