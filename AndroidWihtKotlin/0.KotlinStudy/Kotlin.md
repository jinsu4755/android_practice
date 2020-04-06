# Kotlin

jetBrains 에서 만들어진 JVM 환경에서 동작하는 언어.

자바와 호환 운용이 가능한 언어이다.



## Kotlin과 Java 비교

### 함수 처리 방식

```java
//java code
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}
}
```

```kotlin
// Kotlin code
fun main(args: Array<String>) {
	println("Hello, world!")
}
```

코틀린에서는 main 함수를 만들 필요가 없으며 코틀린에서는 println함수가 아니므로 System.out을 작성하지 않아도 된다.

