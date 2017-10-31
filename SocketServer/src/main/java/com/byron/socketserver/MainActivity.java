package com.byron.socketserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vilyever.socketclient.util.IPUtil;

public class MainActivity extends AppCompatActivity {

    private TestServer testServer;
    private TextView mTvIp;
    private TextView mTvReceiveClient;
    private Button mBtnSendClient;

    protected TestServer getTestServer() {
        if (this.testServer == null) {
            this.testServer = new TestServer();
        }
        return this.testServer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        mTvIp = findView(R.id.tv_ip); //显示IP信息
        mBtnSendClient = findView(R.id.btn_send);//发送到手机端
        mTvReceiveClient = findView(R.id.tv_receive_client); //接收的数据
    }

    private void initData() {
        int port = getTestServer().beginListen();//开始监听端口
        initLocalhostIp(port);
    }

    /**
     * 初始化本机IP
     */
    private void initLocalhostIp(int port) {
        String ipAddress = IPUtil.getLocalIPAddress(true);
        mTvIp.setText("本机IP: " + ipAddress + " 端口: " + port);
    }

    private void initListener() {

    }

    protected <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }
}
