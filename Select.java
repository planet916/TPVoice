package com.tpvoice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;

public class Select extends Activity {
    String ttt = BeverageGrid.st1.getBeverage();

    private ListView listview ;
        private ListViewAdapter_Select adapter;
        private String[] Title = {"음료","샷추가","핫/아이스","Take Out"};
        private int[] img = {R.drawable.coffee,R.drawable.coffee_plus,R.drawable.hotice,R.drawable.takeout};


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select);
            if(ttt!=null){
                Title[0]=ttt;
            }

            //변수 초기화
            adapter = new ListViewAdapter_Select();
            listview = (ListView) findViewById(R.id.List_view_Select);

        //어뎁터 할당
        listview.setAdapter(adapter);
        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,img[i]),Title[i]);
        }
    }
}