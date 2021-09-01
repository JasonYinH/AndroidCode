package com.base.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


import com.base.myapplication.aidl.Book;

import java.util.concurrent.CopyOnWriteArrayList;
/**
*服务端
*/
public class BookManagerService extends Service {
//    CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();
    private Binder mbinder = new Binder();
    public BookManagerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mbinder;
    }
}