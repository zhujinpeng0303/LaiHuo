package com.example.jason_jukes.laihuo;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected Context context;
    private Toast toast;
    private Dialog dialogProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //判断当前设备版本号是否为4.4以上，如果是，则通过调用setTranslucentStatus让状态栏变透明
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			setTranslucentStatus(true);
//		}

        /**如果是纯色标题栏的情况，需要动态设置paddingView的高度**/
        /*View paddingView = findViewById(R.id.paddingView);
        ViewGroup.LayoutParams params = paddingView.getLayoutParams();
		params.height = getStatusBarHeight();*/

        context = getApplicationContext();

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_progressbar, null);
        dialogProgress = new Dialog(this);
        dialogProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogProgress.setContentView(view);
        dialogProgress.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialogProgress.setCanceledOnTouchOutside(false);

    }

    public void startIntent(Class clazz) {
        Intent intent = new Intent(BaseActivity.this, clazz);
        startActivity(intent);
    }


    public void showToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(this, string, Toast.LENGTH_SHORT);
        } else {
            toast.setText(string);
        }
        toast.show();
    }

    public String getText(TextView v) {
        return v.getText().toString().trim();
    }

    protected void showProgressDialog() {

        dialogProgress.show();

    }

    protected void hideProgressDialog() {

        dialogProgress.dismiss();

    }


    //键盘回收机制
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {

                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }


    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}

