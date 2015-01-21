package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Convert(View v)
    {
        EditText et = (EditText)findViewById(R.id.etInput);
        String s = et.getText().toString();

        Double temp = Double.parseDouble(s);

        RadioGroup from = (RadioGroup)findViewById(R.id.rgFrom);
        int selfrom = from.getCheckedRadioButtonId();

        RadioGroup to = (RadioGroup)findViewById(R.id.rgTo);
        int selto = to.getCheckedRadioButtonId();

        if(selfrom == R.id.rbFrmC)
        {
            if(selto == R.id.rbToF)
            {
               temp = (temp*9/5)+32;
            }

            if(selto == R.id.rbToK)
            {
                temp = temp+273.15;
            }
        }

        if(selfrom == R.id.rbFrmF)
        {
            if(selto == R.id.rbToC)
            {
                temp = (temp-32)*5/9;
            }

            if(selto == R.id.rbToK)
            {
                temp = (temp+459.67)*5/9;
            }
        }

        if(selfrom == R.id.rbFrmK)
        {
            if(selto == R.id.rbToC)
            {
                temp = temp - 273.15;
            }

            if(selto == R.id.rbToF)
            {
                temp = (temp*9/5)-459.67;
            }
        }

        TextView out = (TextView)findViewById(R.id.tvOutput);
        String outtext = String.format("%.2f",temp);
        out.setText(outtext);
    }


}
