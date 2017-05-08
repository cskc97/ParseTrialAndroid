package apps.everythingforward.com.parsetrial;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santh on 5/8/2017.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {


    private ArrayList<ParseObject> objectArrayList=null;

    public TasksAdapter(List<ParseObject> objects)
    {
        objectArrayList = (ArrayList<ParseObject>) objects;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(objectArrayList.get(position).getString(Main2Activity.taskKey));


    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }



     static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
        }
    }

    public boolean isEmpty()
    {
        return objectArrayList.size()==0;
    }




}
