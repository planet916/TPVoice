package com.tpvoice;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import static android.speech.tts.TextToSpeech.ERROR;
import java.util.Locale;

public class Select extends Activity {
    String select_result = "";
    String select_beverage = ListViewAdapter_Select.st1.getBeverage();
    String select_shot = ListViewAdapter_Select.st1.getShot();
    String select_hotice = ListViewAdapter_Select.st1.getHot_ice();
    String select_takeout = ListViewAdapter_Select.st1.getTakeout();
    TextToSpeech tts;
    TextView ordertext;
    Button orderbtn;
    private ListView listview ;
        private ListViewAdapter_Select adapter;
        private String[] Title = {"음료","샷추가","핫/아이스","매장/포장"};
        private int[] img = {R.drawable.coffee,R.drawable.coffee_plus,R.drawable.hotice,R.drawable.takeout};


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select);
            ordertext = (TextView)findViewById(R.id.ordertext);
            orderbtn = (Button)findViewById(R.id.orderbtn);

            if(select_beverage!=null){
                Title[0]=select_beverage;
            }
            if(select_shot!=null){
                Title[1]=select_shot;
            }
            if(select_hotice!=null){
                Title[2] = select_hotice;
            }
            if(select_takeout!=null){
                Title[3] = select_takeout;
            }





            tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != ERROR) {
                        // 언어를 선택한다.
                        tts.setLanguage(Locale.KOREAN);

                    }
                }
            });
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(ordertext.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

            }
        });
        if(select_beverage!=null) {
            select_result += select_beverage +" 주문할건데";
            ordertext.setText(select_result);
        }
        if(select_shot!=null){
            if(select_shot  == Data.shot_arr[0]){

            }
            else {
                select_result += " 샷은 " + select_shot + "하고 ";
                ordertext.setText(select_result);
            }
        }
        if(select_hotice !=null){
            select_result += " "+select_hotice + " 주세요.";
            ordertext.setText(select_result);
        }
        if(select_takeout!=null){
            if(select_takeout == Data.takeout_arr[0]){
                select_result +=" "+ select_takeout +  "에서 마실게요.";
            }
            else{
                select_result +=" "+ select_takeout +  "해주세요.";
            }
            ordertext.setText(select_result);
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
