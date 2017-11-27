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

    private static boolean readyToClose = false;
    private static Handler handler = new Handler();
    private static Runnable runnable = () -> readyToClose = false;

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     */
    public static void now(Activity context){
        if (context!=null){
            if (!readyToClose) {
                makeText(context, "Press back again to close");
                readyToClose = true;
                handler.postDelayed(runnable,3000);
            }else context.finish();
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
            if (!readyToClose) {
                makeText(context, message);
                readyToClose = true;
                handler.postDelayed(runnable,3000);
            }else context.finish();
        }
    }

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     * @param time    the time before it resets whereby user is required to press back twice again
     */
    public static void now(Activity context, long time){
        if (context!=null && time!=0){
            if (!readyToClose) {
                makeText(context, "Press back again to close");
                readyToClose = true;
                handler.postDelayed(runnable,time);
            }else context.finish();
        }
    }

    /**
     * Static method to be called that handles closing of the app interactively
     *
     * @param context the Activity as a context
     * @param message the message to be displayed
     * @param time    the time before it resets whereby user is required to press back twice again
     */
    public static void now(Activity context, String message, long time){
        if (context!=null && !message.isEmpty() && time!=0){
            if (!readyToClose) {
                makeText(context, message);
                readyToClose = true;
                handler.postDelayed(runnable,time);
            }else context.finish();
        }
    }

    private static void makeText(Activity context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
