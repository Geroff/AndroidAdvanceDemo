package com.android.lgf.demo.activity.chapterone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.android.lgf.demo.R;

/**
 * Created by lgf on 17-12-4.
 */

public class CardViewActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private CardView cardView;
    private SeekBar sbSetRoundCorner;
    private SeekBar sbSetImageSpacing;
    private SeekBar sbSetShadow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        cardView = (CardView) findViewById(R.id.card_view);
        sbSetRoundCorner = (SeekBar) findViewById(R.id.sb_set_round_corner);
        sbSetImageSpacing = (SeekBar) findViewById(R.id.sb_set_image_spacing);
        sbSetShadow = (SeekBar) findViewById(R.id.sb_set_shadow);

        sbSetRoundCorner.setOnSeekBarChangeListener(this);
        sbSetImageSpacing.setOnSeekBarChangeListener(this);
        sbSetShadow.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_set_round_corner:
                cardView.setRadius(progress);
                break;
            case R.id.sb_set_shadow:
                cardView.setCardElevation(progress);
                break;
            case R.id.sb_set_image_spacing:
                cardView.setContentPadding(progress, progress, progress, progress);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
