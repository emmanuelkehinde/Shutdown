/*
 * Copyright (C) 2017 Emmanuel Kehinde
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.emmanuelkehinde.shutdown;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by emmanuel.kehinde on 22/11/2017.
 */
public class Shutdown{

    private static long DEFAULT_TIMEOUT = 3000;
    private static String DEFAULT_MESSAGE = "Press back again to close";
    private static long lastClickTime;


    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     */
    public static void now(Activity context){
        if (context!=null){
            init(context, DEFAULT_MESSAGE, DEFAULT_TIMEOUT);
        }
    }

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     * @param message the message to be displayed
     */
    public static void now(Activity context, String message){
        if (context!=null && !message.isEmpty()){
            init(context, message, DEFAULT_TIMEOUT);
        }
    }

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     * @param timeout the time before it resets, whereby user is required to press back twice again
     */
    public static void now(Activity context, long timeout){
        if (context!=null && timeout!=0){
            init(context, DEFAULT_MESSAGE, timeout);
        }
    }

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     * @param message the message to be displayed
     * @param timeout the time before it resets, whereby user is required to press back twice again
     */
    public static void now(Activity context, String message, long timeout){
        if (context!=null && !message.isEmpty() && timeout!=0){
            init(context, message, timeout);
        }
    }

    /**
     * Helper method
     *
     * @param context the Activity as a context
     * @param message the message to be displayed
     * @param timeout the time before it resets, whereby user is required to press back twice again
     */
    private static void init(Activity context, String message, long timeout){
        if ((lastClickTime + timeout)> System.currentTimeMillis()){
            context.finish();
        }else {
            makeText(context, message);
            lastClickTime = System.currentTimeMillis();
        }
    }

    /**
     * Shows a toast with the specified message in given context
     *
     * @param context the Activity as a context
     * @param message the message to be displayed
     */
    private static void makeText(Activity context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
