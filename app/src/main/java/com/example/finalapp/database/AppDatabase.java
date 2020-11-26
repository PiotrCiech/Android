package com.example.finalapp.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.example.finalapp.database.model.Flat;
import com.example.finalapp.database.model.FlatsData;


@Database(entities = {Flat.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "dbflat.db";
    private static AppDatabase sInstance;

    public abstract  FlatDao flatDao();

    public static AppDatabase getInstance(final Context context){
        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,AppDatabase.DATABASE_NAME)
                        .addCallback(new Callback(){
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db){
                                super.onCreate(db);
                                AppExecutors.getInstance().diskIO()
                                        .execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        getInstance(context).flatDao()
                                                .insertAll(FlatsData
                                                        .populateFlatData());
                                    }
                                });
                            }
                        }).build();
            }
        }
        return sInstance;
    }
}
