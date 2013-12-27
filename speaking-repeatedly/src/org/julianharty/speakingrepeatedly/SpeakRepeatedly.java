package org.julianharty.speakingrepeatedly;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SpeakRepeatedly extends Activity implements OnClickListener, OnInitListener
{
    private static final int MY_DATA_CHECK_CODE = 19; // Can be any value we recognise later when the Activity Completes.
	private Button oneButton;
	private Button twoButton;
	private Button threeButton;
	private Button fourButton;
	private TextView statusMsg;
	private static TextToSpeech tts; 

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
        
        statusMsg = (TextView) findViewById(R.id.status_msg);
        
        if (tts == null) {
        	tts = new TextToSpeech(this, this);
        	// TODO: Log whether the TTS object was created successfully.
        } else {
        	// TODO: log the result in a Queue
        	statusMsg.setText(R.string.tts_already_running);
        }
        
        // TODO: Test with Gingerbread - do we ever reach this point? on devices without TTS voice data?
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
        
        // TODO: Check which engines and languages are available. Maybe we can pick the voice to say each phrase in?
    }

	@Override
	public void onClick(View v) {
		int rc;
		switch (v.getId()) {
		case R.id.button1:
			rc = tts.speak(getText(R.string.one_word).toString(), TextToSpeech.QUEUE_ADD, null);
			break;
		case R.id.button2:
			rc = tts.speak(getText(R.string.two_words).toString(), TextToSpeech.QUEUE_ADD, null);
			break;
		case R.id.button3:
			rc = tts.speak(getText(R.string.three_words).toString(), TextToSpeech.QUEUE_ADD, null);
			break;
		case R.id.button4:
			rc = tts.speak(getText(R.string.four_words).toString(), TextToSpeech.QUEUE_ADD, null);
			break;
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == MY_DATA_CHECK_CODE) {
			if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
				statusMsg.setText(R.string.tts_data_installed_ok);
			}
		}

	}
	
	@Override
	public void onInit(final int status) {
		switch (status) {
			case TextToSpeech.SUCCESS:
				statusMsg.setText(R.string.tts_data_installed_ok);
				break;
			default:
				statusMsg.setText(R.string.tts_problem + String.format(", rc[%d]", status));
				break;
		}
	}
	

}
