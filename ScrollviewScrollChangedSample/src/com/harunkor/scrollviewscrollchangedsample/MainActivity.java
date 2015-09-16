package com.harunkor.scrollviewscrollchangedsample;



import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	 private boolean isChanged=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ScrollView scr=(ScrollView)findViewById(R.id.myScroll);
		TextView txt=(TextView) findViewById(R.id.textView1);
		
		
		
		txt.setMovementMethod(new ScrollingMovementMethod());
		
		
		
		
		
		scr.getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onScrollChanged() {
				// TODO Auto-generated method stub
				 int scrollY = scr.getScrollY();			
			
			if(!isChanged)
			{
				if(scrollY>500)
				{
					
					scr.setBackgroundColor(Color.parseColor("#fab000"));
					
					 Toast.makeText(getApplicationContext(), "ScrollY:   "+scrollY, 100).show();
					 isChanged=true;
				}
				
				
			}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
