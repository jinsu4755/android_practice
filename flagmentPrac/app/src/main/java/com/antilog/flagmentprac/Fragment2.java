package com.antilog.flagmentprac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    public Fragment2() {

    }

    /*Fragment가 실행되었을때 자신의 UI를 그릴때 호출*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return 값으로 inflater로 xml로 정의된 view 혹은 menu를 객체화 하여 return
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}
