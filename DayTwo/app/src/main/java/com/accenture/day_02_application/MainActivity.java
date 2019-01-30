package com.accenture.day_02_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edit;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewFour);
        edit = findViewById(R.id.edit);

        Intent intentService = new Intent(MainActivity.this, ChxService.class);
        startService(intentService);

        String time = getDate();
        textView.setText(time);

        Toast.makeText(MainActivity.this,"背景#ebedec",Toast.LENGTH_LONG).show();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn = findViewById(R.id.button);
        View btn = this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String editText = getEditText();

                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                intent.putExtra("EditText", editText);

               // startActivityForResult(intent, 1);

                startActivity(intent);
            }
        });
    }

    public String getEditText() {
        String editText = edit.getText().toString();
        return editText;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM");

        Date date = new Date(System.currentTimeMillis());
        Date date1 = new Date(System.currentTimeMillis());

        String day = simpleDateFormat.format(date);
        String month = simpleDateFormat1.format(date1);

        switch(month) {
            case "01": month = "Jan";
            break;
            case "02": month = "Feb";
            break;
            case "03": month = "Mar";
            break;
            case "04": month = "Apr";
                break;
            case "05": month = "May";
                break;
            case "06": month = "Jun";
                break;
            case "07": month = "July";
                break;
            case "08": month = "Aug";
                break;
            case "09": month = "Sept";
                break;
            case "10": month = "Otc";
                break;
            case "11": month = "Nov";
                break;
            case "12": month = "Dec";
                break;
        }
        String dateTime = "Today"+"(" + day+ " " + month +"月" + ")";
        return dateTime;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("run","reShow");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

//返回桌面
/*    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //启动一个意图,回到桌面
            Intent intent = new Intent();// 创建Intent对象
            intent.setAction(Intent.ACTION_MAIN);// 设置Intent动作
            intent.addCategory(Intent.CATEGORY_HOME);// 设置Intent种类
            startActivity(intent);// 将Intent传递给Activity
            return true;
        }
        return super.onKeyDown(keyCode, event); }
}*/

