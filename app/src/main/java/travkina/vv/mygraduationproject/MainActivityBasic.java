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
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivityBasic extends AppCompatActivity {
    ArrayList<MyFile> products = new ArrayList<MyFile>();
    BoxAdapter boxAdapter;

    SimpleDateFormat sdf;
    ToggleButton t,d,p,a,m3,m4;

    Button button;

    int k, m;
    File[] file;
    File f1;
    File file_for_d;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        button = (Button) findViewById(R.id.button_s);
        sdf = new SimpleDateFormat("dd/MM/yyyy");

        Listaner1 listaner1 = new Listaner1();
        t = (ToggleButton)findViewById(R.id.txt) ;
        d = (ToggleButton)findViewById(R.id.doc) ;
        p = (ToggleButton)findViewById(R.id.pdf) ;
        a = (ToggleButton)findViewById(R.id.avi) ;
        m3 = (ToggleButton)findViewById(R.id.mp3) ;
        m4 = (ToggleButton)findViewById(R.id.mp4) ;

        button.setOnClickListener(listaner1);

        boxAdapter = new BoxAdapter(this, products);

        ListView lvMain = (ListView) findViewById(R.id.fileList);
        lvMain.setAdapter(boxAdapter);
    }



    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Удалены: ";
        for (MyFile p : boxAdapter.getBox()) {
            if (p.isFlag()) {
                result += "\n" + p.getNameFile();

                 file_for_d = new File(f1.getAbsolutePath()+"/"+p.getNameFile());

                 file_for_d.delete();

            }
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        zapolnenie();
       // Show_f();
    }

public void zapolnenie(){

    f1 = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())); // получаем путь
    file = f1.listFiles();
    k = file.length;

    products.clear();
    if (t.isChecked()) {
    search("txt");
    }
    if (d.isChecked()) {
        search("doc");
    }
    if (p.isChecked()) {
        search("pdf");
    }
    if (a.isChecked()) {
        search("avi");
    }
    if (m3.isChecked()) {
        search("mp3");
    }
    if (m4.isChecked()) {
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


