package com.hongyan.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.hongyan.loading.LoadingDialog;


/**
 * Created by wangning on 2018/3/20.
 */

public class BaseFragment extends Fragment {

    private LoadingDialog dialog;

    public void showSuccessToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void showErrorToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void startLoading() {
        if (dialog == null) {
            dialog = new LoadingDialog(getActivity());
        }
        dialog.show();
    }

    public void cancelLoading() {
        if (dialog == null) {
            cancelLoading();
        }
        dialog.dismiss();
    }
}
