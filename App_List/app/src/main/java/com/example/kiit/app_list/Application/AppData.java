package com.example.kiit.app_list.Application;

import android.app.Application;
import android.content.pm.PackageInfo;

/**
 * Created by kiit on 08-12-2016.
 */
public class AppData extends Application {

    PackageInfo packageInfo;

    public PackageInfo getPackageInfo(){
        return packageInfo;
    }
    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }
}
