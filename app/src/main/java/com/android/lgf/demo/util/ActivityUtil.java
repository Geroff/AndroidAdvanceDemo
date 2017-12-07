package com.android.lgf.demo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

/**
 * Created by lgf on 17-12-6.
 */

public class ActivityUtil {
    public static void startActivity(Context context, Class<?> cls) {
        if (context == null || cls == null) {
            return;
        }

        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        List<ResolveInfo> resolveInfoList = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfoList != null && resolveInfoList.size() > 0) {
            context.startActivity(intent);
        }
    }
}
