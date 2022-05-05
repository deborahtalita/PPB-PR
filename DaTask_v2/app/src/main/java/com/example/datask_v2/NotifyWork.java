//package com.example.datask_v2;
//
//import android.content.Context;
//
//import androidx.annotation.NonNull;
//import androidx.work.Worker;
//import androidx.work.WorkerParameters;
//
//public class NotifyWork extends Worker {
//    public NotifyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
//        super(context, workerParams);
//    }
//
//    @NonNull
//    @Override
//    public Result doWork() {
//        int id = getInputData().getInt();
//        return Result.success();
//    }
//}
