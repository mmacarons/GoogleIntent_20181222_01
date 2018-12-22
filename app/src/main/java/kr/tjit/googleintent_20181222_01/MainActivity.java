package kr.tjit.googleintent_20181222_01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    EditText phoneNumEdt;
    Button dialBtn;
    Button callBtn;
    EditText contentEdt;
    Button smsBtn;
    Button kakaoMarketLinkBtn;
    Button naverWebLinkBtn;
    Button tjeItMapBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                폰번 에딧텍스트의 입력값을 받고
                String inputPhoneNum = phoneNumEdt.getText().toString();

//                그 입력값을 전화를 거는데 사용

                Uri uri = Uri.parse(String.format("tel:%s", inputPhoneNum));
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                사용자가 입력한 폰번을 받아서 저장
                String inputPhoneNum = phoneNumEdt.getText().toString();

                Uri uri = Uri.parse(String.format("tel:%s", inputPhoneNum));

                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                사용자가 입력한 폰번을 저장
                String inputNumber = phoneNumEdt.getText().toString();

//                사용자가 입력한 내용을 저장
                String inputContent = contentEdt.getText().toString();

//                SMS 발송
                Uri uri = Uri.parse(String.format("smsto:%s", inputNumber));

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", inputContent);
                startActivity(intent);
            }
        });

        kakaoMarketLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kakaoLinkUrl = "com.kakao.talk";
                Uri uri = Uri.parse(String.format("market://details?id=%s", kakaoLinkUrl));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        naverWebLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naverUrl = "http://www.naver.com";
                Uri uri = Uri.parse(naverUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        tjeItMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                위도 / 경도 값을 삽입
                Uri uri = Uri.parse("geo:37.569289,126.985314");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        dialBtn = findViewById(R.id.dialBtn);
        phoneNumEdt = findViewById(R.id.phoneNumEdt);
        callBtn = findViewById(R.id.callBtn);
        contentEdt = findViewById(R.id.contentEdt);
        smsBtn = findViewById(R.id.smsBtn);
        kakaoMarketLinkBtn = findViewById(R.id.kakaoMarketLinkBtn);
        naverWebLinkBtn = findViewById(R.id.naverWebLinkBtn);
        tjeItMapBtn = findViewById(R.id.tjeItMapBtn);

    }
}
