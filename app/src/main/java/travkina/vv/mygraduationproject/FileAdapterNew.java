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


public class FileAdapterNew extends ArrayAdapter<MyFile> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<MyFile> MyFileList;
    ArrayList<String> serch;

    FileAdapterNew(Context context, int resource, ArrayList<MyFile> myfile) {
        super(context, resource, myfile);

        this.MyFileList = myfile;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return this.MyFileList.size();
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
        ViewHolder holder;


        holder = new ViewHolder();

        holder.cbBuy = (CheckBox) convertView.findViewById(R.id.nameView);
        holder.nameView = (TextView) convertView.findViewById(R.id.nameView);
        convertView.setTag(holder);

        final MyFile product = MyFileList.get(position);

        holder.nameView.setText(product.getNameFile());


/*        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }



        holder.cbBuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // меняем данные товара (в корзине или нет)
                getProduct((Integer) buttonView.getTag()).flag = isChecked;
                serch.add(getProduct((Integer) buttonView.getTag()).getNameFile());
            }
        });

*/


        return convertView;
    }



    static class ViewHolder {
         CheckBox cbBuy;
         TextView nameView;

    }

    // обработчик для чекбоксов
  /*  OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // меняем данные товара (в корзине или нет)
            getMyFile((Integer) buttonView.getTag()).box = isChecked;
        }
    };
    */
}




