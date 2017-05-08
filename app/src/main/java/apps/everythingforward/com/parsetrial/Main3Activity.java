package apps.everythingforward.com.parsetrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.rv)RecyclerView recyclerView;
    TasksAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

//        ParseUser user = ParseUser.getCurrentUser();


     /*   if(user!=null)
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

        */

        getTasks();



    }

    @Override
    protected void onResume() {
        super.onResume();




    }

    public void getTasks()
    {

        ParseUser user = ParseUser.getCurrentUser();

        Log.e("TaskAdapter",user.getEmail());



        if(user!=null)
        {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Tasks");

            query.whereEqualTo("user",user.getEmail());
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {


                    if(e==null)
                    {
                       adapter = new TasksAdapter(objects);

                        Log.e("TaskAdapter",String.valueOf(objects.size()));
                        if(!adapter.isEmpty()) {

                            Toast.makeText(Main3Activity.this, "Finished Loading", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Main3Activity.this, "It's empty " + adapter.getItemCount(), Toast.LENGTH_SHORT).show();
                        }



                    }

                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



                }
            });
        }
    }
}
