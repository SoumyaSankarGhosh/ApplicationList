package com.example.kiit.app_list.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kiit.app_list.R;

import java.util.List;

/**
 * Created by kiit on 08-12-2016.
 */
public class ApkAdapter extends BaseAdapter {
    List<PackageInfo> packageList;
    Context context;
    PackageManager packageManager;
    private LayoutInflater inflater;

    public ApkAdapter(List<PackageInfo> packageList, Context context, PackageManager packageManager) {
        this.packageList = packageList;
        this.context = context;
        this.packageManager = packageManager;
        inflater = LayoutInflater.from(context);
    }
    private class ViewHolder {
        TextView apkName;
    }
    public int getCount() {
        return packageList.size();
    }

    public Object getItem(int position) {
        return packageList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.apklist_item, null);
            holder = new ViewHolder();

            holder.apkName = (TextView) convertView.findViewById(R.id.appname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PackageInfo packageInfo = (PackageInfo) getItem(position);

        Drawable appIcon = packageManager.getApplicationIcon(packageInfo.applicationInfo);

        String appName = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();

        appIcon.setBounds(0, 0, 40, 40);

        holder.apkName.setCompoundDrawables(appIcon, null, null, null);

        holder.apkName.setCompoundDrawablePadding(15);

        holder.apkName.setText(appName);

        return convertView;
    }
}
