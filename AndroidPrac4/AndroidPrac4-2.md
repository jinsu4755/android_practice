# AndroidPrac4-2

### Manifest

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.antilog.androidprac4">
    <!--
	package에는 기본적으로 프로젝트에서 사용되는 페키지 정보가 들어간다.
    -->

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".SubActivity"></activity>
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

```xml
android:icon="@mipmap/ic_launcher"
```

해당 앱의 아이콘을 설정할 수 있다. 

위 링크는 기본 링크이며 drawable이나 mipmap에 아이콘 추가후 지정하여 바 꿀 수 있다.

---

```xml
android:label="@string/app_name"
```

위 링크를 따라 들어가면 아래와 같은 파일이 나온다.

```xml
<resources>
    <string name="app_name">AndroidPrac4</string>
</resources>
```

앱 이름을 설정하는 옵션이며 원하는 이름으로 바꾸면 빌드후 원하는 이름으로 설정할 수 있다.

---

```xml
android:roundIcon="@mipmap/ic_launcher_round"
```

icon이랑 동일하나 특정 버전이나 환경에서 모서리가 둥근 처리가된 경우 아이콘을 설정할 수 있다.

---

```xml
android:theme="@style/AppTheme"
```

위 링크로 이동하면 아래와 같은 파일을 볼 수 있다.

```xml
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
```

앱에서 기본적으로 사용할 색깔을 설정할 수 있다.

---

```xml
<activity android:name=".SubActivity"></activity>
```

액티비티를 만들고 해당 소스와 연결

---

```xml
<intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```

해당 액티내용이 들어간 액티비티가 main이며 런처임을 알린다.

런처는 앱을 시작했을때 처음으로 실행되는 액티비티

---

---

프로젝트 구조

java

-com.antilog.adroidprac4

주로 자바 관련 소스코드가 들어간다.

res

-drawable

주로 이미지 관련 파일이 들어간다.

-layout

주로 액티비티와 연결하는 레이아웃 파일을 담당

-mipmap

주로 앱 아이콘관련한 사진과 파일이 들어간다.

내부에 hdpi,mdpi,xhdpi 등은 핸드폰 해상도 따라서 따로 사진 폴더를 만들어줘야한다.

-values

--colors.xml

내부에서 사용할 색상을 설정 가능

--strings.xml

앱 이름을 바꿀 수 있으며 공통적으로 사용되는 문구를 정리하여 사용할 수 있고

@String/name으로 가져올 수 있다.

--styles.xml

앱 태마를 지정할 수 있다.



