package com.example.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import com.github.pinball83.maskededittext.MaskedEditText;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OneActivity extends Fragment {

    private View view;
    private Button buttonPay;
    private MaskedEditText textNumber;

    public static final String BASE_URL = "https://api.prostor-sms.ru";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();

    private ServiceAPI interf = retrofit.create(ServiceAPI.class);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        textNumber = (MaskedEditText) view.findViewById(R.id.maskedEditText);
        buttonPay = (Button) view.findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = getPhoneNumber();

                if(str.length() == 10) {
                    AsyncRequest asyncTask = new AsyncRequest(str);
                    asyncTask.execute();
                }
                else {
                    DialogWindow dialog = new DialogWindow((MainActivity) getActivity());
                    dialog.showDialog();
                }

                //}

                /*Call<Object> call = interf.sendRequest(("%2B7" + getPhoneNumber()), "test", "ap136013", "756379");
                Log.i("TAG", call.toString());*/

                /*Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("phone", "%2B79056471378");
                mapJson.put("text", "test");
                mapJson.put("login", "ap136013");
                mapJson.put("password", "756379");*/



                /*Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(("phone"), ("%2B7" + getPhoneNumber()));
                parameters.put("text", "test");
                parameters.put("login", "ap136013");
                parameters.put("password", "756379");
                Call<Object> call = interf.send(parameters);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        String str = response.body().toString();
                        Log.i("TAG", str);
                    }
                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                    }
                });*/
            }
        });

        return view;
    }

    private String getPhoneNumber() {
        String phoneResult = textNumber.getText().toString();
        phoneResult = phoneResult.replaceAll("[^0-9]", "");
        phoneResult = phoneResult.replaceFirst("7", "");
        return phoneResult;
    }

    private void showToast(String t) {
        Toast toast = Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT);
        toast.show();
    }
}
