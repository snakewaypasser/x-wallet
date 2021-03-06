/**
 * Copyright (c) 2019 by snakeway
 * <p>
 * All rights reserved.
 */
package com.xcash.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import com.xcash.base.BaseActivity;
import com.xcash.wallet.R;

public class ClipboardTool {

    public static void copyToClipboard(Context context, String content) {
        if (content == null || content.equals("")) {
            return;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Label", content);
            clipboardManager.setPrimaryClip(clipData);
            BaseActivity.showShortToast(context, context.getString(R.string.normal_copySuccess_tips));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
