package com.ray.test.testingcolorpicker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    Context context;
    private Button btnColorPicker;
    private TextView tvText;
    private ImageView img;

    private ColorPickerDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * 初始化UI
     */
    private void initViews() {
        btnColorPicker = (Button) findViewById(R.id.btn);
        btnColorPicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog = new ColorPickerDialog(context, tvText.getTextColors().getDefaultColor(),
                        "Color Picker Test",//getResources().getString(R.string.btn),
                        new ColorPickerDialog.OnColorChangedListener() {

                            @Override
                            public void colorChanged(int color) {
                                tvText.setTextColor(color);

                            }
                        });
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();
            }
        });
        tvText = (TextView) findViewById(R.id.txt);

    }
}