package com.tpvoice;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tpvoice.R;

import org.w3c.dom.Text;


public class ShotGrid extends Activity {
    static public SelectText st1 = new SelectText();
    Activity act = this;
    GridView gridView;
    //이미지 배열 선언
    ArrayList<Bitmap> picArr = new ArrayList<Bitmap>();
    //텍스트 배열 선언
    ArrayList<String> textArr = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        int[] img = {R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5,R.drawable.item6};
        for(int i=0; i<img.length; i++){
            Bitmap bm = BitmapFactory.decodeResource(getResources(), img[i]);
            picArr.add(bm);
        }

        for (int i = 0 ; i < img.length ; i++) {
            textArr.add(Data.beverage_arr[i]);
        }
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new gridAdapter());
    }



    public class gridAdapter extends BaseAdapter {
        LayoutInflater inflater;
        public gridAdapter() {
            inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return picArr.size();    //그리드뷰에 출력할 목록 수
        }

        @Override
        public Object getItem(int position) {
            return picArr.get(position);    //아이템을 호출할 때 사용하는 메소드
        }
        @Override
        public long getItemId(int position) {
            return position;    //아이템의 아이디를 구할 때 사용하는 메소드
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.row, parent, false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
            TextView textView = (TextView) convertView.findViewById(R.id.textView1);
            imageView.setImageBitmap(picArr.get(position));
            textView.setText(textArr.get(position));
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0; i<Data.beverage_arr.length; i++) {
                        if (pos == i) {
                            st1.setBeverage(Data.beverage_arr[i]);

                            Toast.makeText(context, st1.getBeverage() + "가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, Select.class);
                            finish();
                            context.startActivity(intent);
                        }
                    }
                }
            });
            return convertView;
        }
    }
}


