package org.julianharty.speakingrepeatedly;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SpeakRepeatedly extends Activity implements OnClickListener
{
    private Button oneButton;
	private Button twoButton;
	private Button threeButton;
	private Button fourButton;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Wire up the buttons
        oneButton = (Button) findViewById(R.id.button1);
        twoButton = (Button) findViewById(R.id.button2);
        threeButton = (Button) findViewById(R.id.button3);
        fourButton = (Button) findViewById(R.id.button4);
        
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			break;
		case R.id.button2:
			break;
		case R.id.button3:
			break;
		case R.id.button4:
			break;
		}
	}

}
