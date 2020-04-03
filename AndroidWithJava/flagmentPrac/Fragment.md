# Fragment

## Fragment란?

fragment는 보통 하나의 Activity안에서 여러 UI를 구성할때 사용한다.

따라서 fragment는 항상 Activity내에 포함되고 수명주기도 호스트 Activity 생명주기에 영향을 받는다.

Activity가 일시정지되면 그안에 fragment도 일시정지

Activity가 소멸되면 fragment도 소멸

각 fragment들은 Activity가 실행중일때는 독립적 조작이 가능하나 그렇지 않은경우는 Activity상태를 따른다.

![fragment 생명주기](https://developer.android.com/images/fragment_lifecycle.png)

fragment는 위와 같은 생명주기를 가지며

Fragment가 실행시 ``onCreate()``메소드가 호출되고

Fragment가 자신의 UI를 그릴때 ``onCreateView()``메소드를 호출한다. UI를 그리기 위해서 메소드는 View를 Return하며 UI 미제공시 null 반환

사용자가 Fragment를 떠나면 ``onPause()`` 호출

---

## FragmentManager

Activity 내에서 Fragment를 관리하기 위해서는 FragmentManager를 사용해야한다.

FragmentManager는 아래와 같은 일을 할 수 있다.

``findFragmentId()``or``findFragmentByTag()``로 Fragment를 가져온다.

``popBackStack()``으로 Fragment를 BackStack에서 꺼낼 수 있다.

``beginTransaction()``으로 FragmentTransaction을 가져올 수 있다.

```java
FragmentManager fragmentManager = getFragmentManager();
//위와 같이 선언하여 사용할 수 있다.
```

---

## FragmentTransaction

FragmentTransaction API를 사용하면 Fragment의 추가, 제거, 변경의 작업을 할 수 있다.

> Transaction은 컴퓨터 과학분야에서 "쪼개질 수 없는 업무처리 단위"를 의미한다.(데이터 베이스)
>
> RollBack: 부분작업이 실패하면 트랜잭션 실행 전으로 되돌린다.
>
> Commit: 모든 부분 작업이 정상적 완료시 변경사항을 모두 반영
>
> ACID - 데이테 베이스 트랜젝션이 안전하게 수행된다는 것을 보장하는 성질들의 약어
>
> Atomicity[원자성] : 트렌젝션에 속한 작업들이 모두 수행되었는가, 모두 실행 되지 않았는가를 보장하는 성질.
>
> (중간단계 실행중 실패하는 일은 없다.)
>
> Consistency[일관성] : 트랜젝션이 실행을 성공적으로 완료시 언제나 일관성 있는 데이터 베이스 상태로 유지
>
> Isolation[고립성] : 트랜젝션을 수행시 다른 트랜잭션의 연산 작업이 끼어들지 못하게 한다.
>
> Durability[지속성] : 성공적 수행된 트랜젝션은 영원히 반영되어야한다.

```java
FragmentManager fragmentManager = getFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

or
FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
```

위와 같이 FragmentTransaction을 호출한다.

`.add()`는 Fragment의 추가를 담당하고

`.remove()`는 Fragment의 제거

`.replace()`는 Fragment의 변경

모든 Tracsaction작업이 끝나면 반드시 `.commit()`을 호출해야 적용된다.

