# reflection

## 자바 리플렉션
- 자바는 정적인 언어라 부족한 부분이 많은데 이 동적인 문제를 해결하기 위해서 리플렉션을 사용
- 리플렉션은 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드, 타입, 변수들에 접근할 수 있도록 해주는 자바 API
  - 구체적인 클래스 타입을 알지 못해도 : 나중에 구현 클래스를 만들껀데 >> 내가 아닌 다른사람이 만든 클래스가 내 코드속에서 동작되기 위해
- 원래 Java는 컴파일언어/정적인 언어라 동적으로 객체를 생성할수 없는데(new Object가 없으면 실체화 불가능), 이걸 가능하게 해주는게 바로 Reflection
- 애플리케이션 개발에서보다는 프레임워크, 라이브러리에서 많이 사용
  - 프레임워크, 라이브러리는 사용하는 사람이 어떤 클래스를 만들지 모른다
  - 이럴 때 사용자가 만든 코드를 동적으로 프레임워크 속에서 돌아가도록 ,연결해주기(IoC,DI) 위해서 리플렉션 사용
  - 대표적인 사용 예로는 스프링의 DI(dpendency injection), Proxy, ModelMapper 등등...



### 스프링 코드 예시
- 간단한 컨트롤러로 예시를 들면
```java
@Controller
@RequestMapping("/articles")
public class ArticleController {    

    @Autowired    
    private ArticleService articleService;       
    
    // 중략...

    @PostMapping
    public String write(UserSession userSession, ArticleDto.Request articleDto){
       // 중략...
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
       //중략...
    }
}
```
- @Controller 를 붙이면 내가 인스턴스를 생성 하지 않아도 스프링이 알아서 생성해서 빈으로 관리해줍니다.
  - 그러니까 이런짓 한적이 없는데 어떻게 실체화되서 돌아가냐? 이말이다!
  ```java
  ArticleController articleController = new ArticleController();
  ```
  - 스프링은 ArticleController의 존재를 어떻게 알고 만들어주는 것일까요?
  - ArticleService 라는 필드는 어떻게 주입해주는 걸까요?
  - 모든 메소드의 파라미터 개수, 타입이 다른데 어떻게 알고 해당하는 값을 바인딩 해줄까요?
  - ArticleController을 작성한 개발자는 클래스의 정보를 알겠지만, 스프링은 모릅니다.
- 위 문제를 해결하기 위해서 리플렉션을 사용합니다. 
  - 스프링이 ArticleController의 정보를 알아내기 위해서 사용 (reflection은 반사가 아니라 투영이였다 : 그림자를 어떤 물체 위에 비추는 일/ 도형이나 입체를 다른 평면에 옮기는 일)
  - Spring Framework 는 @Controller 를 갖고있는 클래스를 스캔해서
  - @Controller 를 갖고있는 클래스의 **`인스턴스 생성`** 를 스프링이 한다음에 
  - 위에서 실체화 필드 DI



## 출처
- https://dublin-java.tistory.com/53

## 잡설

### Reflection을 사용하는 이유
  - 컴파일 언어(정적인 언어)인 자바에 없는 동적으로 객체를 생성하는 기술을 Reflection으로 대신한다.
- 정적인 언어 : Compile 시점에 타입을 결정하는 언어 (Java, C/C++)
- 동적인 언어 : Runtime 시점에 타입을 결정하는 언어 (Javascript, Python)

### 게임분야(언리얼C++, C#)에서도 동일한 개념의 리플렉션이 등장한다
- https://youtu.be/VpEe9DbcZIs : 언리얼 엔진을 통해 살펴보는 리플렉션과 가비지 컬렉션