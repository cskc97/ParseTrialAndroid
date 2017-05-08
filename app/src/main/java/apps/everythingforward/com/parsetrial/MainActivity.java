package apps.everythingforward.com.parsetrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;

public class MainActivity extends AppCompatActivity {

    public static final int LOGIN_CODE=0;
    ParseUser user=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser.logOut();
        ParseLoginBuilder builder = new ParseLoginBuilder(MainActivity.this);
        startActivityForResult(builder.build(), LOGIN_CODE);



    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case LOGIN_CODE:
            {



                if(ParseUser.getCurrentUser()!=null)
                {
                    user=ParseUser.getCurrentUser();
                }
                else
                {
                    Toast.makeText(this, "Failed To Login!!", Toast.LENGTH_SHORT).show();
                }


            }
        }


    }
}
