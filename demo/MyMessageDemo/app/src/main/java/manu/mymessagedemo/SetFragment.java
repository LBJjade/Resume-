package manu.mymessagedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by weedys on 17/7/13.
 * 设置
 */
public class SetFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vs = inflater.inflate(R.layout.fragment_set, container, false);
        initView(vs);
        return vs;
    }



    private void initView(View v) {
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
