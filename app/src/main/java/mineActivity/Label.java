package mineActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alin.gogogo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Label extends AppCompatActivity {
    private ListView list_item;
    private EditText input_et;
    private List<String> list=new ArrayList<>();
    private ArrayAdapter<String>adapter;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);
        list_item=(ListView)findViewById(R.id.list_item);

        file = new File(this.getFilesDir(),"label.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
            String data;
            while((data=bufferedReader.readLine())!=null){
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }




        input_et=(EditText)findViewById(R.id.input_et);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        list_item.setAdapter(adapter);
        list_item.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
       @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
           list.remove(i);
           adapter.notifyDataSetChanged();
           return false;
       }
   });

    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.laod_back:
                file.delete();
                file = new File(Label.this.getFilesDir(),"label.txt");
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file,true);
                    for (int i1 = 0; i1 < list.size(); i1++) {
                        fos.write((list.get(i1)+"\n").getBytes());
                    }
                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();
                break;
            case R.id.add_bt:

                String text = input_et.getText().toString();
                input_et.setText("");
                list.add(text);
                File file = new File(Label.this.getFilesDir(),"label.txt");
                FileOutputStream fo = null;
                try {
                    fo = new FileOutputStream(file,true);
                    fo.write((text+"\n").getBytes());
                    fo.flush();
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
                break;

        }

    }
}
