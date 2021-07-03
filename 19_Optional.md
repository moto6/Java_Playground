
- Optional
  - 객체를 편리하게 처리하기 위해 만든 클래스
  - new로 객체를 생성하지 않는다. empty(), of(), ofNullable()의 메서드로 객체를 생성한다.
  - 데이터가 없는 Optional 객체를 생성하려면 empty()를 사용
  - null이 추가될 수 있는 상황이라면 ofNullable() 사용
  - 반드시 데이터가 들어가 수 있는 상황에는 of()를 사용한다.
  - isPresent()로 Optional 클래스가 비어있는지 확인한다.
  - Optional 클래스는 null 처리를 ㅗ다 간편하게 하기 위해 만들어졌다.
