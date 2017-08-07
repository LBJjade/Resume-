package manu.mymessagedemo;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

/**
 * Created by weedys on 16/7/20.
 */
public class BaseFragment extends Fragment {
    private ProgressDialog progressDialog =null;
    public void showProgressDialog(String msg){
        if(getContext()==null){
            return;
        }
        if(progressDialog==null){
            progressDialog = new ProgressDialog(getContext());

        }
        progressDialog.setMessage(msg);
        progressDialog.setProgressStyle(R.style.progressDialog);
        progressDialog.show();
    }

    public void showProgressDialog(){
        if(getContext()==null){
            return;
        }
        if(progressDialog==null){
            progressDialog = new ProgressDialog(getContext());

        }
        progressDialog.setMessage(getString(R.string.progress_dialog_msg));
        progressDialog.setProgressStyle(R.style.progressDialog);
        progressDialog.show();
    }
    public void showProgressDialog(String msg, boolean cancel){
        if(getContext()==null){
            return;
        }
        if(progressDialog==null){
            progressDialog = new ProgressDialog(getContext());

        }
        progressDialog.setMessage(msg);
        progressDialog.setProgressStyle(R.style.progressDialog);
        progressDialog.setCanceledOnTouchOutside(cancel);
        progressDialog.show();
    }
    public void hiddenDialog(){
        if(progressDialog!=null){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }

    public void showErrorView(View errorView, View rV, int status) {
        if (errorView != null) {
            if (status == 0) {//正常状态
                errorView.setVisibility(View.GONE);
                rV.setVisibility(View.VISIBLE);
            } else if (status == 1) {
                errorView.setVisibility(View.VISIBLE);
                rV.setVisibility(View.GONE);
                TextView errorTv = (TextView) errorView.findViewById(R.id.tv_layout_err);
                errorTv.setText("暂无数据喔~");
                errorTv.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_err_nodata, 0, 0);
            } else if (status == 2) {
                errorView.setVisibility(View.VISIBLE);
                TextView errorTv = (TextView) errorView.findViewById(R.id.tv_layout_err);
                errorTv.setText("获取数据出错，请检查网络");
                errorTv.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_network, 0, 0);
                rV.setVisibility(View.GONE);
            }
        }
    }
}
