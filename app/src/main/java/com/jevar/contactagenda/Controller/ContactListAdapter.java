package com.jevar.contactagenda.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jevar.contactagenda.R;
import com.jevar.contactagenda.dto.Contact;

import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private ArrayList<Contact> recordList;

    public ContactListAdapter(Context context, int layout, ArrayList<Contact> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPhone;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = row.findViewById(R.id.txtName);
            holder.txtPhone = row.findViewById(R.id.txtPhone);
            holder.imageView = row.findViewById(R.id.imgIcon);
            row.setTag(holder);

        }
        else {
            holder = (ViewHolder)row.getTag();
        }

        Contact contact = recordList.get(position);

        holder.txtName.setText(contact.getName());
        holder.txtPhone.setText(contact.getPhone());

        byte[] recordImage = contact.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }

}
