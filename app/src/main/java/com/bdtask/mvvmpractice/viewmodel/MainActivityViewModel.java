package com.bdtask.mvvmpractice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bdtask.mvvmpractice.model.UserRepository;
import com.bdtask.mvvmpractice.model.UserResponse;


public class MainActivityViewModel extends AndroidViewModel {
    UserRepository userRepository;
    private LiveData<UserResponse> articleResponseLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository=new UserRepository();
        articleResponseLiveData=userRepository.getUserData();
    }

    public LiveData<UserResponse> getAllUserData(){
        return articleResponseLiveData;
    }

//    MutableLiveData<String> resultLiveData;
//    public MutableLiveData<String> additionFunction(String value1,String value2){
//
//        int number1= Integer.parseInt(value1);
//        int number2= Integer.parseInt(value2);
//        int result=number1+number2;
//
//        if (resultLiveData==null){
//            resultLiveData=new MutableLiveData<>();
//        }
//        resultLiveData.setValue(String.valueOf(result));
//        return resultLiveData;
//    }
}
