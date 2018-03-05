/**
 * 05.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */

package com.eun1310434.orientation01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String data ="";
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        logIn("onCreate");//textView 객체 생성 후

        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = editText.getText().toString();
                logIn("save data : "+data);
            }
        });

        // savedInstanceState 에 저장되었던 값 복원
        if (savedInstanceState != null) {
            data = savedInstanceState.getString("data");
            logIn("get data : "+data);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data", data);// 저장
    }

    @Override
    protected void onStart() {
        super.onStart();
        logIn("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logIn("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logIn("onDestroy");
    }

    public void logIn(String Log_data) {
        textView.append(Log_data+"\n");
        //Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
