package nz.co.paperkite.espressocircleci;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editText) EditText fieldOne;
    @Bind(R.id.editText2) EditText fieldTwo;
    @Bind(R.id.button) Button buttonOne;
    @Bind(R.id.textView) TextView viewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
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

    @OnClick(R.id.button) void submit() {
        if(fieldOne.getText().toString().length() == 0 || fieldTwo.getText().toString().length() == 0) {
            AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Error").setMessage("Please fill in all fields").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create();
            dialog.show();
        } else {
            viewOne.setText(String.format(Locale.US, "%s %s", fieldOne.getText().toString(), fieldTwo.getText().toString()));
            viewOne.setVisibility(View.VISIBLE);
        }
    }
}
