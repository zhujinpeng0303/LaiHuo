package com.example.jason_jukes.laihuo.tool;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Administrator on 2017/11/20 0020.
 */


//edittext 只能输入中文
public class LimitTextWatcher implements TextWatcher {

    private String text;
    private EditText editText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LimitTextWatcher(String text, EditText editText) {
        this.text = text;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String editable = editText.getText().toString();
        String str = stringFilter(editable.toString());
        if(!editable.equals(str)){
            editText.setText(str);
            //设置新的光标所在位置
            editText.setSelection(str.length());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public static String stringFilter(String str)throws PatternSyntaxException {
        // 汉字
        String   regEx  =  "[^\u4E00-\u9FA5^·]";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }

}
