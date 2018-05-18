package travkina.vv.mygraduationproject; /**
 * Created by Анастасия on 16.05.2018.
 */

import java.util.ArrayList;
import android.content.Context;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import travkina.vv.mygraduationproject.MyFile;
import travkina.vv.mygraduationproject.R;


public class FileAdapter extends ArrayAdapter<MyFile> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<MyFile> myFileList;
    ArrayList<String> serch;

    FileAdapter(Context context, int resource, ArrayList<MyFile> myfile) {
        super(context, resource, myfile);

        this.myFileList = myfile;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return this.myFileList.size();
    }

    // элемент по позиции
  //  @Override
  //  public Object getItem(int position) {
  //      return this.MyFileList.get(position);
  //  }


    @Nullable
    @Override
    public MyFile getItem(int position) {
        return super.getItem(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }
    MyFile getProduct(int position) {
        return ((MyFile) getItem(position));
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        final ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final MyFile product = myFileList.get(position);

        viewHolder.nameView.setText(product.getNameFile());


        viewHolder.cbBuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });




        return convertView;
    }



    private class ViewHolder {
        final CheckBox cbBuy;
        final TextView nameView;
        ViewHolder(View view){

            nameView = (TextView) view.findViewById(R.id.nameView);
            cbBuy = (CheckBox)  view.findViewById(R.id.booleanView);
        }
    }



}

