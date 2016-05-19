package com.example.test;

import android.app.Activity;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
=======
>>>>>>> origin/master
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.pinball83.maskededittext.MaskedEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {
=======
public class MainActivity extends Activity {
>>>>>>> origin/master

    private Button button;
    private EditText text;

<<<<<<< HEAD
    private final String KEY = "trnsl.1.1.20160519T070455Z.d9ae92529e899214.738ad6e32979c235e14ceb5b0f473f996f07e520";
=======
    private final String KEY = "trnsl.1.1.20160518T214956Z.30df98be3ed52d6a.8864882a3a17734ebc30922b57e6a83cfe86e0f6";
>>>>>>> origin/master

    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://translate.yandex.ru")
            .build();

    private API intf = retrofit.create(API.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.editText);
        MaskedEditText phone = (MaskedEditText) findViewById(R.id.masked_edit_text);

<<<<<<< HEAD
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

=======
>>>>>>> origin/master
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("key", KEY);
                mapJson.put("text", text.getText().toString());
                mapJson.put("lang", "en-ru");

                Call<Object> call = intf.translate(mapJson);

                try {
                    retrofit2.Response<Object> response = call.execute();

                    Map<String, String> map = gson.fromJson(response.body().toString(), Map.class);

                    for(Map.Entry e : map.entrySet()) {
                        System.out.println(e.getKey() + " " + e.getValue());
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}
