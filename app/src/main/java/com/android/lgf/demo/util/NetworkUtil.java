package com.android.lgf.demo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.lgf.demo.BuildConfig;
import com.android.lgf.demo.R;
import com.android.lgf.demo.manager.AppContextManager;
import com.android.lgf.demo.manager.ImageManager;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by lgf on 17-12-9.
 */

public class NetworkUtil {
    private static RequestQueue requestQueue;

    public static void sendRequest2String() {
        Context context = AppContextManager.getInstance().getContext();
        if (context == null) {
            return;
        }

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (BuildConfig.DEBUG) {
                    LogUtils.info("NetworkUtil.onResponse() ## response-->" + response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null) {
                    NetworkResponse networkResponse = error.networkResponse;
                    if (networkResponse != null) {
                        if (BuildConfig.DEBUG) {
                            LogUtils.info("NetworkUtil.onErrorResponse() ## code-->" + networkResponse.statusCode);
                        }
                    }

                    if (BuildConfig.DEBUG) {
                        LogUtils.info("NetworkUtil.onErrorResponse() ## message-->" + error.getMessage());
                    }
                }
            }
        });
        requestQueue.add(stringRequest);
    }

    public static void sendRequest2JSON() {
        Context context = AppContextManager.getInstance().getContext();
        if (context == null) {
            return;
        }
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, "http://guolin.tech/api/china", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response != null) {
                    if (BuildConfig.DEBUG) {
                        LogUtils.info("NetworkUtil.onResponse() ## response-->" + response);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonRequest);
    }

    public static void sendRequestImage(final ImageView ivView) {
        Context context = AppContextManager.getInstance().getContext();
        if (context == null) {
            return;
        }
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                if (BuildConfig.DEBUG) {
                    LogUtils.info("NetworkUtil.getBitmap() ## 尝试获取图片缓存");
                }
                ivView.setVisibility(View.VISIBLE);
                return ImageManager.getInstance().getBitmap(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                if (BuildConfig.DEBUG) {
                    LogUtils.info("NetworkUtil.putBitmap() ## 没有获取到图片缓存时调用");
                }

                ImageManager.getInstance().putBitmap(url, bitmap);
            }
        });
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(ivView, R.drawable.ic_launcher, R.drawable.ic_launcher);
        imageLoader.get("http://n.sinaimg.cn/ent/transform/20170628/-t7f-fyhneam4911119.jpg", listener);
    }

    public static void sendRequestImage(final NetworkImageView ivView) {
        Context context = AppContextManager.getInstance().getContext();
        if (context == null) {
            return;
        }
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                if (BuildConfig.DEBUG) {
                    LogUtils.info("NetworkUtil.getBitmap() ## 尝试获取图片缓存");
                }
                ivView.setVisibility(View.VISIBLE);
                return ImageManager.getInstance().getBitmap(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                if (BuildConfig.DEBUG) {
                    LogUtils.info("NetworkUtil.putBitmap() ## 没有获取到图片缓存时调用");
                }

                ImageManager.getInstance().putBitmap(url, bitmap);
            }
        });

        ivView.setDefaultImageResId(R.drawable.ic_launcher);
        ivView.setErrorImageResId(R.drawable.ic_launcher);
        ivView.setImageUrl("http://n.sinaimg.cn/ent/transform/20170628/-t7f-fyhneam4911119.jpg", imageLoader);
    }
}
