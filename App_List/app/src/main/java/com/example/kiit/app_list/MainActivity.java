package com.example.kiit.app_list;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kiit.app_list.adapter.ApkAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    PackageManager packageManager;
    ListView apkList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageManager = getPackageManager();
        List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        List<PackageInfo> packageList1 = new ArrayList<PackageInfo>();

         for (PackageInfo pi:packageList){
             boolean b=isSystemPackage(pi);
             if(!b){
                 packageList1.add(pi);
             }
         }

        apkList=(ListView)findViewById(R.id.applist);
        apkList.setAdapter(new ApkAdapter(packageList1,this,packageManager));

    }
    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true
                : false;
    }
}
