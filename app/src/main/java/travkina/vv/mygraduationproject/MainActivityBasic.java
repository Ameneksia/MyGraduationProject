package travkina.vv.mygraduationproject;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivityBasic extends AppCompatActivity {

    SimpleDateFormat sdf;
    ToggleButton t;
    ToggleButton j;
    ToggleButton d;
   // EditText editText;
    Button button;
    boolean txt,jpg,doc;
    int k;
    File[] file;

    ArrayList<MyFile> products = new ArrayList();

    ListView myFileList;
    FileAdapter adapter;
    ToggleButton toogleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_basic);

        button = (Button) findViewById(R.id.button_s);
        sdf = new SimpleDateFormat("dd/MM/yyyy");

        Listaner1 listaner1 = new Listaner1();
        t = (ToggleButton)findViewById(R.id.toggleButton1) ;
        j = (ToggleButton)findViewById(R.id.toggleButton2) ;
        d = (ToggleButton)findViewById(R.id.toggleButton3) ;
       // editText = (EditText) findViewById(R.id.editText2) ;

        File f1 = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())); // получаем путь
// editText.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
        file = f1.listFiles();
        k = file.length;


     //   products.add(new MyFile("Картофель"));
      //  products.add(new MyFile("Чай"));

       // myFileList = (ListView) findViewById(R.id.fileList);
       //  adapter = new FileAdapter(this, R.layout.list_item, products);
       // myFileList.setAdapter(adapter);
      //  Show_f();

        button.setOnClickListener(listaner1);



    }

    class Listaner1 implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            txt = t.isChecked();
            jpg = j.isChecked();
            doc = d.isChecked();
            String str;
           // editText.setText("");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Прошол1!", Toast.LENGTH_SHORT);
            toast.show();

            if (txt) {
                // действия если включена
                for (int i = 0; i < k; i++) {

                    if (file[i].getName().contains("txt")) {

                        str = file[i].getName();
                        products.add(new MyFile(str));
                      //  editText.append(file[i].getName() + "\n");
                    }
                }
            }

            /*
            if (jpg) {
                // действия если включена
                for (int i = 0; i < k; i++) {

                    if (file[i].getName().contains("jpg")) {
                        products.add(new MyFile(file[i].getName()));
                      //  editText.append(file[i].getName() + "\n");
                    }
                }
            }
            if (doc) {
                // действия если включена
                for (int i = 0; i < k; i++) {

                    if (file[i].getName().contains("doc")) {
                        products.add(new MyFile(file[i].getName()));
                        //editText.append(file[i].getName() + "\n");
                    }
                }
            }

*/

            Show_f();
        }





    }

public void Show_f(){
    myFileList = (ListView) findViewById(R.id.fileList);
    adapter = new FileAdapter(this, R.layout.list_item, products);
     myFileList.setAdapter(adapter);
}





}