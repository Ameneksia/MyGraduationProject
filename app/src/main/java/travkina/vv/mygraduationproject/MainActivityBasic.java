package travkina.vv.mygraduationproject;

import android.content.Intent;
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
    ArrayList<MyFile> products = new ArrayList<MyFile>();
    BoxAdapter boxAdapter;

    SimpleDateFormat sdf;
    ToggleButton t,d,p,a,m3,m4;
    // EditText editText;
    Button button;
    boolean txt,jpg,doc;
    int k, m;
    File[] file;
    File f1;
    File file_for_d;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
//-------------------------------------------------------
        //Создаем новый поток:

//--------------------------------------------------------------------------------------------------------
        button = (Button) findViewById(R.id.button_s);
        sdf = new SimpleDateFormat("dd/MM/yyyy");

        Listaner1 listaner1 = new Listaner1();
        t = (ToggleButton)findViewById(R.id.txt) ;
        d = (ToggleButton)findViewById(R.id.doc) ;
        p = (ToggleButton)findViewById(R.id.pdf) ;
        a = (ToggleButton)findViewById(R.id.avi) ;
        m3 = (ToggleButton)findViewById(R.id.mp3) ;
        m4 = (ToggleButton)findViewById(R.id.mp4) ;
        // editText = (EditText) findViewById(R.id.editText2) ;

      //  f1 = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())); // получаем путь
// editText.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
      //  file = f1.listFiles();
       // k = file.length;

        button.setOnClickListener(listaner1);

        // создаем адаптер
       // fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.fileList);
        lvMain.setAdapter(boxAdapter);
    }



    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (MyFile p : boxAdapter.getBox()) {
            if (p.flag) {
                result += "\n" + p.getNameFile();
                Toast.makeText(this, "1", Toast.LENGTH_LONG).show();
                 file_for_d = new File(f1.getAbsolutePath()+"/"+p.getNameFile());
                 Toast.makeText(this, "2", Toast.LENGTH_LONG).show();
                 file_for_d.delete();

              //  m =  products.indexOf(p.getNameFile());
               // Toast.makeText(this, m, Toast.LENGTH_LONG).show();
             //  products.remove(m);
               // Toast.makeText(this, "tcnm", Toast.LENGTH_LONG).show();
                //f1.getAbsolutePath()+
            }
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        zapolnenie();
       // Show_f();
    }

public void zapolnenie(){

    f1 = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())); // получаем путь
// editText.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
    file = f1.listFiles();
    k = file.length;
    //String str;
    // editText.setText("");
    Toast toast = Toast.makeText(getApplicationContext(),
            "Прошол1!", Toast.LENGTH_SHORT);
    toast.show();
    products.clear();
    if (t.isChecked()) {
        // действия если включена
    search("txt");
    }
    if (d.isChecked()) {
        // действия если включена
        search("doc");
    }
    if (p.isChecked()) {
        // действия если включена
        search("pdf");
    }
    if (a.isChecked()) {
        // действия если включена
        search("avi");
    }
    if (m3.isChecked()) {
        // действия если включена
        search("mp3");
    }
    if (m4.isChecked()) {
        // действия если включена
        search("mp4");
    }
    Show_f();
}


void search(String format){
    String str;
    for (int i = 0; i < k; i++) {

        if (file[i].getName().contains(format)) {

            str = file[i].getName();
            products.add(new MyFile(str));
            //  editText.append(file[i].getName() + "\n");
        }
    }

}

    class Listaner1 implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            zapolnenie();

        }



    }



    public void Show_f(){
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.fileList);
        lvMain.setAdapter(boxAdapter);
    }



}


