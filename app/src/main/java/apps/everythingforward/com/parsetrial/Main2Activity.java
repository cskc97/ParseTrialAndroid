package apps.everythingforward.com.parsetrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.editText)EditText text;
    public static String taskColumn = "Tasks";
    public static String taskKey = "task";
    public static String userKey = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)void onAddTask()
    {
        String taskContent = text.getText().toString();
        if(!taskContent.isEmpty())
        {
            if(ParseUser.getCurrentUser().isAuthenticated()) {
                ParseObject task = new ParseObject(taskColumn);

                task.put(taskKey, taskContent);
                task.put(userKey, ParseUser.getCurrentUser().getEmail());
                task.setACL(new ParseACL(ParseUser.getCurrentUser()));
                task.saveInBackground();
            }
        }

    }
}
