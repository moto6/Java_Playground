# 자바 제네릭
### 목표
- 제네릭이 필요한 이유와 어디서 쓰이는지
- 제네릭 클래스 선언하는 방법
- 선언되어 있는 제네릭 클래스 사용법

# 제네릭을 사용하는 이유
- Generic이란 : Class, Interface, Method(C,I,M을) 를 정의할 때 (C,I,M의 유형)유형이 parameters(입력 매개변수)가 되어 알맞게 정의하는 방식입니다
> 제네릭이 필요한 이유 1 : C,I,M의 유형을 입력받아서 사용자가 원하는데로 써먹을수 있다!
- 예시1 : CrudRepository
    ```java
    @NoRepositoryBean
    public interface CrudRepository<T,ID>
    extends Repository<T,ID>
    ```
- 예시2 : ArrayList
    ```java
    public class ArrayList<E>
    extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, Serializable
    ```
- 예시3 : 과거 자바(1.4)이전 소스코드 (제네릭 없는 자바 컬렉션)

  ```java
  // 4개의 원소를 제거하는 코드입니다
  // c 의 원소들은 무조건 String으로 들어오길 기도하면서 돌려야합니다.
  static void expurgate(Collection c) {
      for (Iterator i = c.iterator(); i.hasNext(); )
        if (((String) i.next()).length() == 4)
          i.remove();
  }
  ```
  : 위 코드를 Generics를 사용해 변환해 보겠습니다

  ```java
  // 4개의 문자열을 제거하는 코드
  static void expurgate(Collection<String> c) {
      for (Iterator<String> i = c.iterator(); i.hasNext(); )
        if (i.next().length() == 4)
          i.remove();
  }
  ```
> 제네릭이 필요한 이유 2 : 실수 방지 in DTO
- DTO 클래스에 private변수, getter, setter, Serializable을 구현되어 있을때 
  ```
  예제코드 넣어라
  ```
- Object로 받았을때 형변환해야 하는 문제점을 컴파일 할 때 없애기 위해 제네릭이 나왔다.
- 형변환을 할 필요가 없어진다. (get()메서드에서 )

### 제네릭 타입 이름 정하기

  - 제네릭 타입을 선언 할 때에는 꺽쇠안에  <어떤단어> 든 들어있어도 가능하다
    - 하지만, 자바에서 정의한 규칙이 있고 따르기를 권장하면서
  - 타입 이름
    - E : 요소 (자바 컬렉션에서 주로 사용)
    - K : 키
    - N : 숫자
    - T : 타입
    - V : 값



- Collection에서 요소를 가져 오는 경우 Collection에 저장된 요소 유형으로 Type Casting(형변환) 해야합니다. 
- 불편하고,코드가 지저분하고, 안전하지 않습니다. 
- 컴파일러는 Cast(형변환)의 결과가 컬렉션의 유형과 동일한 지 확인하지 않아요(아니 못해요)
- 그래서 런타임에 캐스트가 실패해 문제가 발생할 위험이 있습니다.
- 그래서! Generics는 컬렉션 유형을 컴파일러에 전달하여 확인할 수있는 방법입니다!
- 컴파일러가 컬렉션의 요소 유형을 알고 나면 컴파일러는 컬렉션을 일관되게 사용했는지 확인하고 컬렉션에서 가져온 값에 올바른 캐스트를 삽입 할 수 있습니다.


### 제네릭에 물음표(?) 기호의 의미

- 메소드의 매개변수로 넘어가는 제네릭에 대하여 공부
- 제네릭을 선언하는 클래스

```
package d.generic;

public class WildcardGeneric<W> {
  W wildcard;
public void setWildcard(W wildcard) {
    this.wildcard = wildcard;
}

public W getWildcard() {
    return wildcard;
}
}
```

- 제네릭을 사용하는 소스코드

```java
package d.generic;

public class WildcardSample {
public static void main(String[] args) {
    WildcardSample sample = new WildcardSample();
    sample.callWildcardMethod();
}

public void callWildcardMethod() {
    WildcardGeneric<String> wildcard = new WildcardGeneric<>();
    wildcard.setWildcard("A");
    wildcardStringMethod(wildcard);
}

public void wildcardStringMethod(WildcardGeneric<String> c){
    System.out.println(c.getWildcard());
}
}
```

```

```



- 
- 
- 위 코드의 문제점...
  - wildcardStringMethod의 매개 변수로 String형의 WildcardGeniric 객체만 올 수 있다는 것...
  - 제네릭한 클래스의 타입만 바꾼다고 오버로딩이 불가능하다 그럼 어찌하지?? 해서 나온게 '?'다.
  - String 대신 ?를 적어주면 어떤 타입이 제네릭 타입이 되더라도 상관 없다.
    - instanceof 사용해서
- 메서드의 매개변수로 제네릭을 쓰려면 ?(wildcard)를 지정해야 한다.
- 매개변수로 오는 제네릭한 클래스의 타입만 바꾼다고 Overriding 되지 않는다.
- 매개변로 <>에 오는 것을 특정한 타입 대신 ?로 적어주면 어떤 타입의 제네릭이라도 상관없다. (어떤 값인지 모르기 때문에 Object로 넘어옴))
- 매개 변수로 넘어오는 타입이 두세 가지로 정해진다면, 메서드 내에서 instanceof 예약어를 사용해 타입을 확인한다.
- 와일드 카드는 메서드의 매게변수로만 사용하자.
- 어떤 객체를 wildcard로 선언하고, 그 객체의 값은 가져올 수 있지만, whildcard로 객체를 선언했을 때는 특정 타입으로 값을 지정하는것은 불가능하다.

- 제네릭 선언에 사용하는 타입의 범위 지정(Bounded Wildcards)

  - ? 대신 ? extends 타입으로 선택해 하면 된다. extends 뒤에 오는거 상속받은 모든 클래스를 다 사용할 수 있다.

- 메서드를 제네릭하게 선언

  - 앞선 방법에 문제가 있는데 매개 변수로 사용된 객체의 값을 추가할 수 없다는 문제...
  - 메서드 선언시 리턴 타입 앞에 제네릭한 타입을 선언해 주고, 그 타입을 매개 변수에 사용하면 컴파일에 문제없다.
  - 매개변수에 값도 할당해 줄 수 있다. (앞선 방식은 매개변수로 사용된 객체에 값을 추가할 수 없다)
  - ?를 사용하는 Wildcard처럼 타입을 두루뭉실하는 것보단 아래처럼 명시적으로 메서드 선언시 타입을 지정해주면 보다 코드가 견고해진다.

  ```
  public<T extends Car> void callWildcardMethod(WildcardGeneric<T> c, T addValue) {
      c.setWildcard(addValue);
      T value = c.getWildcard();
      System.out.println(value);
  }
  ```

