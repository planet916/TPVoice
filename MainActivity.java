package com.tpvoice;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.ListView;



public class MainActivity extends Activity {

    private ListView listview ;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.coffee,R.drawable.fastfood,R.drawable.cinema};
    private String[] Title = {"카페","패스트푸드","영화"};
//    private String[] Context = {"Cafe","Fast Food","Zzz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) findViewById(R.id.List_view);

        //어뎁터 할당
        listview.setAdapter(adapter);

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,img[i]),Title[i]);// ,Context[i]);
        }
    }
}