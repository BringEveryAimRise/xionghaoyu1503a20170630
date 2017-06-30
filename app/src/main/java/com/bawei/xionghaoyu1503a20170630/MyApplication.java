package com.bawei.xionghaoyu1503a20170630;

import android.app.Application;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/6/30 0030
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler catchHandler = CrashHandler.getInstance();
        catchHandler.init(getApplicationContext());
    }

}
