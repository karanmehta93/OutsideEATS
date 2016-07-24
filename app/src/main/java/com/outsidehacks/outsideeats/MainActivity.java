package com.outsidehacks.outsideeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView l1;
    String[] t1 = {"4505 Meats", "Azalina's", "Beast and the Hare", "Charles Chocolates", "Escape From New York Pizza",
            "Smoothie Detour"};
    int[] i1 = {R.drawable.meats, R.drawable.azalina, R.drawable.beastandhare, R.drawable.charleschocolates,
            R.drawable.escapefromnewyorkpizza, R.drawable.smoothiedetour};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = (ListView)findViewById(R.id.list);
        l1.setAdapter(new dataListAdapter(t1, i1));
    }

    class dataListAdapter extends BaseAdapter {

        String[] Name;
        int[] imge;

        dataListAdapter() {

            Name=null;
            imge=null;
        }

        public dataListAdapter(String[] n, int[] i)
        {
            Name = n;
            imge = i;
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return Name.length;
        }

        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolderItem viewHolderItem;

            if(convertView == null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.restaurant_list_item, parent, false);

                viewHolderItem = new ViewHolderItem();
                viewHolderItem.mVendorName = (TextView)convertView.findViewById(R.id.vendor_name);
                viewHolderItem.mVendorImage = (ImageView) convertView.findViewById(R.id.vendor_bg);

                convertView.setTag(viewHolderItem);

            }else{
                viewHolderItem = (ViewHolderItem)convertView.getTag();
            }


            viewHolderItem.mVendorName.setText(Name[position]);
            viewHolderItem.mVendorImage.setImageResource(imge[position]);

            return convertView;
        }
    }

    static class ViewHolderItem{
        TextView mVendorName;
        ImageView mVendorImage;
    }
}
