package com.android.mp.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.mp.R;

public class ChildThreadUpdateActivity extends Activity implements View.OnClickListener {
    private Button update_handler;
    private Button update_ViewPost;
    private Button update_handlerPost;
    private Button update_handlerPostDelay;
    private Button update_RunOnUiThread;
    private Button update_AsyncTask;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_thread);
        initView();
    }

    private void initView() {
        update_handler = findViewById(R.id.button1);
        update_ViewPost = findViewById(R.id.button2);
        update_handlerPost = findViewById(R.id.button3);
        update_handlerPostDelay = findViewById(R.id.button4);
        update_RunOnUiThread = findViewById(R.id.button5);
        update_AsyncTask = findViewById(R.id.button6);
        textView = findViewById(R.id.myword);

        update_handler.setOnClickListener(this);
        update_ViewPost.setOnClickListener(this);
        update_handlerPost.setOnClickListener(this);
        update_handlerPostDelay.setOnClickListener(this);
        update_RunOnUiThread.setOnClickListener(this);
        update_AsyncTask.setOnClickListener(this);

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(update_handler, "scaleX", 1f, 0.01f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(update_handler, "scaleY", 1f, 0.01f);
        AnimatorSet  bootAdAnimator = new AnimatorSet();
//        if (offset[0] == 0 && offset[1] == 0) {
//            bootAdAnimator.playTogether(scaleXAnimator, scaleYAnimator);
//        } else {
//            ObjectAnimator translateXAnimator = ObjectAnimator.ofFloat(view, "translationX", 0, offset[0]);
//            ObjectAnimator translateYAnimator = ObjectAnimator.ofFloat(view, "translationY", 0, offset[1]);
//            bootAdAnimator.playTogether(translateXAnimator, translateYAnimator, scaleXAnimator, scaleYAnimator);
//        }
        bootAdAnimator.playTogether(scaleXAnimator, scaleYAnimator);
        bootAdAnimator.setDuration(5000);
        bootAdAnimator.start();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                update_handler();
                break;
            case R.id.button2:
                update_ViewPost();
                break;
            case R.id.button3:
                update_handlerPost();
                break;
            case R.id.button4:
                update_handlerPostDelay();
                break;
            case R.id.button5:
                update_RunOnUiThread();
                break;
            case R.id.button6:
                new updateAsyncTask().execute();
                break;
        }

    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                textView.setText("小慕慕");
            }
        }
    };

    /*
    方法1
     */
    private void update_handler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    Message message = handler.obtainMessage();
                    message.what = 1;
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*
    方法2
     */
    private void update_ViewPost() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("小九九");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /*
    方法3
     */

    private void update_handlerPost() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("小酒酒");

          /*      handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("小酒酒");
                    }
                });*/
            }
        }).start();
    }

    /*
    方法4
     */
    private void update_handlerPostDelay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("九酒");
                    }
                }, 3000);
            }
        }).start();
    }

    /*
    方法5
     */
    private void update_RunOnUiThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("慕九");
                    }
                });

            }
        }).start();
    }

    /*
    方法6
     */
    class updateAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText("结束");
        }
    }
}
