package com.example.jason_jukes.laihuo.tool;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/**
 * Created by DIY on 2017/3/3.
 */

public class XUtil {
    private static SSLContext s_sSLContext = null;

    /**
     * 发送get请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Get(String url, Map<String, String> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    /**
     * 发送post请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Post(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
//        params.setMultipart(true);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }

//            /** 判断https证书是否成功验证 */
//            SSLContext sslContext = getSSLContext(App.getInstance());
//            if (null == sslContext) {
//                if (BuildConfig.DEBUG)
//                    Log.d("dddddddddddd", "Error:Can't Get SSLContext!");
//                return null;
//            }
//            params.setSslSocketFactory(sslContext.getSocketFactory()); //绑定SSL证书(https请求)

        }

        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    /**
     * 上传文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable UpLoadFile(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    /**
     * 下载文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable DownLoadFile(String url, String filepath, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
//设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(filepath);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }


    private static SSLContext getSSLContext(Context context) {

        CertificateFactory certificateFactory = null;
        InputStream inputStream = null;
        Certificate cer = null;
        KeyStore keystore = null;
        TrustManagerFactory trustManagerFactory = null;
        try {

            certificateFactory = CertificateFactory.getInstance("X.509");
            inputStream = context.getAssets().open("zhengshu.cer");//这里导入SSL证书文件

            try {
                //读取证书
                cer = certificateFactory.generateCertificate(inputStream);
//                LogManager.i(TAG, cer.getPublicKey().toString());
                Log.e("ccccccccc", "证书有木有");

            } finally {
                inputStream.close();
            }

            //创建一个证书库，并将证书导入证书库
            keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(null, null); //双向验证时使用
            keystore.setCertificateEntry("trust", cer);

            // 实例化信任库
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            // 初始化信任库
            trustManagerFactory.init(keystore);

            s_sSLContext = SSLContext.getInstance("TLS");
            s_sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

            //信任所有证书 （官方不推荐使用）
//         s_sSLContext.init(null, new TrustManager[]{new X509TrustManager() {
//
//              @Override
//              public X509Certificate[] getAcceptedIssuers() {
//                  return null;
//              }
//
//              @Override
//              public void checkServerTrusted(X509Certificate[] arg0, String arg1)
//                      throws CertificateException {
//
//              }
//
//              @Override
//              public void checkClientTrusted(X509Certificate[] arg0, String arg1)
//                      throws CertificateException {
//
//              }
//          }}, new SecureRandom());

            return s_sSLContext;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}

class JsonResponseParser implements ResponseParser {
    //检查服务器返回的响应头信息
    @Override
    public void checkResponse(UriRequest request) throws Throwable {
    }

    /**
     * 转换result为resultType类型的对象
     *
     * @param resultType  返回值类型(可能带有泛型信息)
     * @param resultClass 返回值类型
     * @param result      字符串数据
     * @return
     * @throws Throwable
     */
    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultClass);
    }
}

class MyCallBack<ResultType> implements Callback.CommonCallback<ResultType> {
    @Override
    public void onSuccess(ResultType result) {

//可以根据公司的需求进行统一的请求成功的逻辑处理
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
//可以根据公司的需求进行统一的请求网络失败的逻辑处理
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }


}
