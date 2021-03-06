package com.tpvoice;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class ListViewAdapter_Select extends BaseAdapter {
    static public SelectText st1 = new SelectText();
    private ArrayList<ListVO> listVO = new ArrayList<ListVO>() ;
    public ListViewAdapter_Select() {
    }

    @Override
    public int getCount() {
        return listVO.size() ;
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_listview, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.img) ;
        TextView title = (TextView) convertView.findViewById(R.id.title) ;
//        TextView Context = (TextView) convertView.findViewById(R.id.context) ;


        ListVO listViewItem = listVO.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        image.setImageDrawable(listViewItem.getImg());
        title.setText(listViewItem.getTitle());
//        Context.setText(listViewItem.getContext());


        //리스트뷰 클릭 이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == 0)
                {
                    Intent intent = new Intent(context, BeverageGrid.class);
                    ((Activity)context).finish();
                    context.startActivity(intent);
                }
                if( pos == 1){
                    Intent intent = new Intent(context, ShotGrid.class);
                    ((Activity)context).finish();
                    context.startActivity(intent);
                }
                if(pos == 2){
                    Intent intent = new Intent(context, HotIceGrid.class);
                    ((Activity)context).finish();
                    context.startActivity(intent);
                }
                if (pos == 3) {
                    Intent intent = new Intent(context, TakeoutGrid.class);
                    ((Activity)context).finish();
                    context.startActivity(intent);
                }
            }
        });


        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position ;
    }


    @Override
    public Object getItem(int position) {
        return listVO.get(position) ;
    }

    // 데이터값 넣어줌
    public void addVO(Drawable icon, String title){ //, String desc) {
        ListVO item = new ListVO();

        item.setImg(icon);
        item.setTitle(title);
//        item.setContext(desc);

        listVO.add(item);
    }
}
