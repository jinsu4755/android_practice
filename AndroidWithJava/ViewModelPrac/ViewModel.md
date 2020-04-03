# ViewModel

## ViewModel이란?

ViewModel 클래스는 수명주기를 고려하여 UI괄년 데이터를 저장하고 관리할 수 있게 만들어짐.

ViewModel 클래스를 사용하면 화면전환과 같이 구성 변경시에도 데이터를 유지할 수 있음.



### 사용 이유

Android 프레임 워크는 활동 및 Fragment와 같은 UI  컨트롤러의 수명주기를 관리한다.

시스템에서 UI컨트롤러를 제거하거나 다시 만들면 컨트롤러에 저장된 일시적 데이터가 손실된다.

> ex)
>
> 앱은 활동중 하나의 사용자 목록을 포함한다. 구성 변경을 위해 활동을 다시 생성하면 새 활동은 사용자 목록을 다시 가져와야함.
>
> 데이터가 단순한 경우 onSaveInstaceState() 메소드로 onCreate()의 번들에서 데이터를 복원 할 수 있으나 사용자 목록이나 비트맵 같은 대용량 데이터가 아닌, 직렬화-> 역직렬화가 가능한 소량의 데이터에 적합하다.

다른 문제로는 UI 컨트롤러가 반환하는데 시간이 걸릴 수 있는 비동기 호출을 자주 해야한다는 점.

UI컨트롤러는 비동기 호출을 관리하며, 메모리 누출 가능성을 방지하기 위해서 시스템에서 호출 폐기후 호출 정리가 이루어지는지 확인해야한다. 이부분에서 많은 유지보수가 필요하며 구성 변경시 개체가 다시 생성될때 이미 실행된 호출을 다시 해야하는 상황에서 리소스 낭비.



활동과 Fragment같은 UI 컨트롤러는 주로 UI데이터 표시, 사용자 작업에 대한 반응, 권한 요청 같은 운영체제 커뮤니케이션 처리를 위해 있음.

UI 컨트롤러에 DB나 네트워크에서 데이터 로드를 담당하도록 요구하면 클래스가 팽창되고 홀로 작업 처리를 하려할 수 있으며 이경우 테스트가 어려워짐.

UI 컨트롤러 로직에서 뷰 데이터 소유권을 분리하는 방법이 더 효율적이므로 사용한다.



## ViewModel 구현하는 방법

> 기존애는 아래와 같이 구현하였다.
>
> ```java
> homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
> ```
>
> ViewModelProviders가 deprecated되어 대체하여 사용해야한다.

```java
//without Factory
homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
//with Factory
homeViewModel = new ViewModelProvider(this, ViewModelFactory).get(HomeViewModel.class);
```

