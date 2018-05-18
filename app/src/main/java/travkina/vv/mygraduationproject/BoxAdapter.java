package travkina.vv.mygraduationproject; /**
 * Created by Анастасия on 16.05.2018.
 */

import java.util.ArrayList;
import android.content.Context;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import travkina.vv.mygraduationproject.MyFile;
import travkina.vv.mygraduationproject.R;

class ProductAdapter extends ArrayAdapter<MyFile> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<MyFile> MyFileList;

    ProductAdapter(Context context, int resource, ArrayList<MyFile> myfile) {
        super(context, resource, myfile);
        this.MyFileList = myfile;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
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
        final MyFile product = MyFileList.get(position);

        viewHolder.nameView.setText(product.getNameFile());

       // ((TextView) view.findViewById(R.id.nameView)).setText(p.getNameFile());

       // CheckBox cbBuy = (CheckBox) view.findViewById(R.id.booleanView);
        // присваиваем чекбоксу обработчик
      //  cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        // пишем позицию
      //  cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
      //  cbBuy.setChecked(p.box);
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
