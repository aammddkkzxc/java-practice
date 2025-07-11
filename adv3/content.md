- 고차 함수
  - 일반적인 함수 -> 데이터(값)을 입력으로 받고 반환
  - 고차 함수 -> 함수를 인자로 받거나 반환
- 타겟 타입
  - 람다는 익명 함수로서 특정 타입을 가지지는 않는다
  - 대입되는 참조 변수가 어떤 함수형 인터페이스를 가리키느냐에 따라 타입이 결정된다
  - 메소드 시그니쳐가 같은 함수형 인터페이스라도 타입이 다르면 상호 대입이 되지 않는다
  - 자바가 제공하는 기본 함수형 인터페이스 쓰자
- 함수형 인터페이스
  - 의도를 명시적으로 드러내는 함수형 인터페이스 쓰자 (특화 함수형 인터페이스를 씀으로써 의도 명확히)
  - 기본형 지원 함수형 인터페이스
    - 오토박싱/언박싱 성능 비용 개선
    - 제네릭 한계 (기본형 다룰 수 없음) 극복
- 스트림
  - 선언형 프로그래밍, 메서드 체인, 정적 팩토리 메서드, 내부 반복
- 람다 vs 익명 클래스
  - 상속 관계
    - 익명 클래스는 일반적인 클래스 처럼 다양한 인터페이스와 클래스 구현, 상속 가능
    - 람다는 함수형 인터페이스 만을 구현 가능, 상태(필드, 멤버 변수)나 추가적인 메서드 오버라이딩은 불가능
  - this
    - 익명 클래스 내부에서 this 는 익명 클래스 자신
    - , 람다 내부의 this 는 람다가 선언된 외부 클래스의 this 와 동일 (별도의 컨텍스트 x)
  - 생성 방식
    - 익명 클래스 -> 컴파일 시 클래스 파일 생성, 일반적인 클래스와 같은 방식
    - 람다 -> invokeDynamic 이라는 메커니즘을 사용하여 컴파일 타임에 실제 클래스 파일을 생성하지 않고, 런타임 시점에서 동적으로 필요한 코드를 처리
  - 상태
    - 함수인 람다는 기본적으로 필드(멤버 변수)가 없으므로 스스로 상태를 유지하지는 않는다.
- 메서드 참조
  - 이미 정의된 메서드를 그대로 참조하여 람다 표현식을 더 간결하게 작성
  - 메서드 참조에서 ()를 사용하지 않는 이유 -> 메서드 참조를 하는 시점에는 메서드를 호출X 단순히 메서드의 이름으로 해당 메서드를 참조만 한다
    1. 정적 메서드 참조
    2. 특정 객체의 인스턴스 메서드 참조
    3. 생성자 참조
    4. 임의 객체의 인스턴스 메서드 참조
- 스트림
  - 데이터 소스 변경 x, 일회성, 파이프라인, 지연연산, 병렬 처리 용이 (주의 해야 한다)
  - 단축 평가가 되는 이유에 대해서 생각해보자
- 다운 스트림 컬렉터를 이해하면, groupingBy() 나 partitioningBy() 로 그룹화/분할을 한 뒤 내부 요소를 어떻게 가공하고 수집할지 자유롭게 설계할 수 있다.
- Optional
  - orElse(), orElseGet() 차이 이해하자 (즉시평가, 지연평가)
  - Optional.filter(predicate) vs Stream.filter(predicate) 차이
  - 베스트 프랙티스
    - 반환 타입으로만 사용하고, 필드에는 가급적 X
    - 메서드 매개변수로 Optional 을 사용 X
    - 컬렉션(Collection)이나 배열 타입을 Optional 로 감싸지 말기 -> 빈 컬렉션 사용
    - isPresent() 와 get() 조합을 직접 사용 X
    - 무조건 값이 있다고 판단되거나, 값이 없으면 예외를 던지거나 하는 것이 더 자연스러운 경우 아예 사용하지 않는 것이 더 좋을 수 있다
    - **클라이언트 입장**에서 코드를 작성하자
- 디폴트 메서드
  - 추상클래스 대신 인터페이스를 쓰는 이유가 무엇이었는지 생각해보자 (다이아몬드 문제, 추상 메서드, 일반 메서드)
  - 디폴트 메서드 도입 이유
    - 하휘 호환성, 라이브러리 확장성, 설계 유연성
  - 디폴트 메서드 주의점
    - 최소한으로 사용 -> 자칫 다이아몬드 문제 발생시킴. 인터페이스는 계약의 역할에 충실하는 것이 좋다
    - 상태를 두지 않기 -> 필요하다면 클래스로 옮기자
- Fork/Join
  - 작업 훔치기 알고리즘 -> 포크 조인 풀의 스레드는 각자 자신의 작업 큐를 가짐, 중요하진 않다
  - 적절한 작업 크기 선택 -> 작업의 복잡성, 균일성, 시스템 하드웨어 등 고려 -> 보통 스레드 수의 4~10배, 참고로만 알자
  - 공용 풀
    - 애플리케이션 내에서 단일 인스턴스로 공유되어 사용
    - 별도로 생성하지 않아도 생성됨, ForkJoinPool.commonPool() 을 통해 접근 가능
    - 기본적으로 시스템의 가용 프로세서 수에서 1을 뺀 값으로 병렬 수준(parallelism)이 설정
    - 공용 풀 vs 커스텀 풀
      - 커스텀 풀은 명시적으로 생성하고 관리해야 하지만, 공용 풀은 시스템에서 자동으로 관리 (jvm이 자동으로 종료)
- 병렬 스트림
  - 접 스레드를 만들 필요 없이 스트림에 parallel() 메서드만 호출하면, 스트림이 자동으로 병렬 처리
  - 실무에서 공용 풀은 **절대** I/O 바운드 작업을 하면 안된다
    - 공용 풀 병목 현상: 모든 병렬 스트림이 동일한 공용 풀을 공유하므로, 요청이 많아질수록 병목 현상이 발생
    - 자원 경쟁: 여러 요청이 제한된 스레드 풀을 두고 경쟁하면서 요청의 성능이 저하된다.
    - 예측 불가능한 성능: 같은 작업이라도 동시에 실행되는 다른 작업의 수에 따라 처리 시간이 크게 달라진다
  - 공용 풀은 반드시 CPU 바운드(계산 집약적인) 작업에만 사용해야 한다
    - 공용 풀은 애초에 cpu작업에 적합하도록 최적화 되어 있다는 것을 기억하자
    - 백엔드 개발자 로서 사실 잘 다룰 일이 없다
  - 실무에서 자주 하는 실수가 병렬 스트림을 I/O 대기 작업에 사용하거나, 또는 CompletableFuture 를 사용할 때 발생
    - 실무에서 복잡한 멀티스레드 코드를 작성할 때는 CompletableFuture 가 도움이 된다 (나중에 사용하게 될 때 학습하면 충분)
    - CompletableFuture 를 생성할 때는 별도의 스레드 풀을 반드시 지정해야 한다. 공용 풀이 대신 사용된다. 
    - **CompletableFuture 를 사용할 때는 반드시! 커스텀 풀을 지정해서 사용하자**
- 함수형 프로그래밍
  - 자바 함수형 프로그래밍 특징
  - 순수 함수(Pure Function)
  - 부수 효과(Side Effect) 최소화
  - 불변성(Immutable State) 지향 
  - 일급 시민(First-class Citizen) 함수 
  - 선언형(Declarative) 접근 
  - 함수 합성(Composition)
  - Lazy Evaluation(지연 평가) (선택적 특징)