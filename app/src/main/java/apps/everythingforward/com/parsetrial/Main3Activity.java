package apps.everythingforward.com.parsetrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ParseUser user = ParseUser.getCurrentUser();


        if(user!=null)
        {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Tasks");
            query.whereEqualTo("user",user.getEmail());
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if(e==null)
                    {
                        Log.e("User",String.valueOf(objects.size()));
                        for(int counter=0;counter<objects.size();counter++)
                        {

                            String task = objects.get(counter).getString(Main2Activity.taskKey);
                            Toast.makeText(Main3Activity.this, task, Toast.LENGTH_SHORT).show();
                        }
                    }


                }
            });
        }


    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
