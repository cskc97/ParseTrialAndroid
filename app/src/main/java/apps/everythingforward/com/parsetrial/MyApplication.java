package apps.everythingforward.com.parsetrial;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by santh on 5/8/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this);
    }
}
