# AndroidPrac3

### Intent

인텐트는 앱 컴포넌트가 무엇을 할 것인지 담는 메시지 객체.

메시지는 의사소통을 위해 보내고 받으며 사용되는 가장 큰 목적은 다른 액티비티,서비스,브로드캐스트 리시버,컨텐트 프로바이더 등을 실행한다.

인텐트는 인텐트사이에서 데이터를 주고 받기 위해서도 사용됨.



### 화면 전환

화면은 하나의 액티비티, 화면간 이동과정은 각각의 액티비티를 필요에 따라 띄우거나 닫는 과정.

단순히 액티비티를 띄워주는 것이 아니라 어떤 액티비티를 띄운 것인지, 띄웠던 액티비티로 부터 응답을 받아 처리하는 코드 필요.

액티비티를 듸우기 위해서 ``startActivity()``와 ``startActivityForResult()``가 정의 되어있다.

#### 예제에서는 아래와 같은 코드로 구현

**MainActivity**

```java
public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);
        /*str = et_test.getText().toString();
        * 해당 코드가 이 위치에 있을 경우 생명주기로 앱이 실행되었을때 저장된다.
        * 따라서 Intent 를 진행해도 빈화면이 나오는데 이는 생명주기를 onClick으로 옮겨서 버튼을 눌렀을때
        * 저장되도록 하면 해결 할 수 있다.*/


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                //현재 엑티비티와 이동할 액티비티를 써준다.
                intent.putExtra("str", str);
                //다음 액티비티에서 str(전)이라는 별명으로 str(후)값을 쓴다.
                startActivity(intent); //액티비티 이동
            }
        });
    }
}
```



```java
Intent intent = new Intent(MainActivity.this, SubActivity.class);
```

다음과 같이 현재 액티비티 정보와 호출할 컴포넌트를 담아 인텐트를 생성하여

startActivity()에 intent를 파라미터로 넘겨주면 새로운 화면이 띄워진다.

> 참고로 MainActivity.this는 getApplicationContext()와 동일하다. 해당 액티비티 정보를 가지고 있는 것이기 때문에 동일하다.

### startActivity()와 startActivityForResult()의 차이

- startActivity() 
  - 새로 띄우는 액티비티로부터 받는 응답이 필요 없을때
- startActivityForResult()
  - 새로 띄우는 액티비티로 부터 응답을 받아 처리할 경우 사용

startAcitivtyForResult()의 경우는 인텐트 객체 intent 뿐아니라 정수형태 코드 값을 파라미터로 전달한다.

이유는 새로 띄운 여러 액티비티 중에서 어떤 것으로부터 온 응답인지 구분하기 위해서 사용한다.

임의 값을 줄 수 있고 중복되지 않도록 사용한다.

```java
Intent intent = new Intent(getApplicationContext(),SubActivity.class);
startActivitiyForResult(intent,REQUEST_CODE);
```

위와 같이 정보를 요청하고

onActivityResult()로 requestCode와 resultCode, Intent data를 받아야한다.



SubAcitvity에서는 setResult()로 resultCode(정수형 코드)와 intent를 던져준다.



### 암시적 인텐트

보통 Action과 data라는 속성으로 구성되어있음. Component라는 속성을 지정할 경우 컴포넌트 클래스 이름을 명시적으로 지정하게 되면 명시적이므로, 컴포넌트를 제외한 나머지 속성으로 구성되고 속성들에 부합하는 컴포넌트가 실행됨.

```java
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
startActivity(intent);
```

해당 코드 실행시 네이버로 연결하기 위해 실행 가능한 컴포넌트가 여려개 있을때 선택할 수 있도록 한다.



### 인텐트 필터

안드로이드 개발시 manifests라는 파일이 있고 안에 보면 intent-filter가 존재한다

```xml
<intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```

컴포넌트 A에서 컴포넌트 B로 인텐트를 보냈을대 명시적 인텐트라면 컴포넌트인  B는 바로 인텐트를 받는다.

하지만 암시적이라면 B는 해당 인텐트가 자신의 속성과 부합하는지 확인 해야하고 이러한 확인 작업을 위해서 존재한다.

 