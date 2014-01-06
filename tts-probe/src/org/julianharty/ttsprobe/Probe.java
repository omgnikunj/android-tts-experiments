package org.julianharty.ttsprobe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class Probe extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        json();
    }
    
    public void json() {
    	ObjectMapper a = new ObjectMapper();
    	
    	try {
			Julian julian = new Julian();
			julian.setI(67);
			String msg = a.writeValueAsString(julian);
			Log.d("Damien", msg);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    // Simple test class for JSON Serialization
    private class Julian {
    	int i;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
    }
}
