package com.example.administrator.commentdialog;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.commentdialog.comment.CommentDialog;
import com.example.administrator.commentdialog.comment.CommentView;
import com.example.administrator.commentdialog.share.ShareDialog;

public class MainActivity extends AppCompatActivity {

    CommentView commentView;
    CommentDialog commentDialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (commentDialog != null) {
                commentDialog.cancel();
                Toast.makeText(MainActivity.this, "评论成功~", Toast.LENGTH_SHORT).show();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button shareBtn = (Button) findViewById(R.id.share);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareDialog(v.getContext()).show();
            }
        });

        commentView = (CommentView) findViewById(R.id.comment_view);
        commentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog = new CommentDialog(MainActivity.this).setListener(new CommentDialog.Listener() {
                    @Override
                    public void commentContent(String content) {
//                        TODO 发表评论 发表成功后取消Dialog
                        handler.sendEmptyMessageDelayed(1, 2000);

                    }
                });
                commentDialog.show();
            }
        });
    }
}
