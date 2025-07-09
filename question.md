<h4>상속, 구현</h4>

<details>
<summary>오버로딩과 오버라이딩의 쓰임새, 규칙</summary>
<ul>
    <li>오버로딩
        <ul>
            <li>비슷한 역할을 하는 메서드를 하나의 메서드 이름으로 활용</li>
            <li>매개변수 타입, 개수, 순서 중 하나 이상 달라야 함</li>
        </ul>
    </li>
    <li>오버라이딩
        <ul>
            <li>상위 타입이 정의한 메서드 동작을 하위 타입이 자신의 특성에 맞게 재정의</li>
            <li>상위 타입이 제공하는 메서드에서 기대되는 행위(계약) 을 깨트리지 않아야 한다 (LSP)</li>
            <li>메서드 시그니처 (이름, 매개변수 타입, 개수, 순서) 상위 타입과 정확히 같아야 한다</li>
            <li>더 제한적인 접근 제어자 불가, 더 많거나 상위 예외 던지기 불가</li>
        </ul>
    </li>
</ul>

</details>

<details>
<summary>추상 클래스, 인터페이스, 디폴트 메서드, 상속vs구현</summary>
<ul>
    <li>인터페이스
        <ul>
            <li>순수 추상 메서드로만 이루어진 추상 클래스 라고 볼 수 있다</li>
            <li>초기엔 일반 메서드가 없도록 설계 되었다. 다이아몬드 문제에서 자유롭다 -> 다중 구현 가능</li>
            <li>디폴트 메소드 -> 기존 코드를 깨트리지 않고 새기능 추가, 제한적으로 사용</li>
        </ul>
    </li>
    <li>상속, 구현
        <ul>
            <li>클래스, 추상 클래스, 인터페이스는 프로그램 코드, 메모리 구조상 모두 똑같다</li>
            <li>상속의 구조적 단점 -> 강한 결합, 한번 만들어지면 변경하기가 매우 어려워짐</li>
            <li>상속의 테스트 시 단점-> 격리된 테스트가 어렵다</li>
            <li></li>
        </ul>
    </li>
</ul>
</details>

<h4>String</h4>

<details>
<summary>String클래스가 불변으로 설계 된 이유 (문자열 풀)</summary>
<ul>
    <li>String 객체는 다른 어떤 객체보다 압도적으로 많이, 그리고 자주 사용 된다</li>
    <li>문자열 풀 : 동일한 문자열 리터럴을 메모리에서 **하나의 인스턴스**로 공유하는 메커니즘 -> 메모리 절약, 생성 시간/비용, 해시 알고리즘으로 빠른 검색 성능</li>
    <li>공유 참조 -> 사이드 이펙트 없어야함 -> 불변으로 설계</li>
</ul>
</details>

<details>
<summary>불변인 String클래스 단점을 해결하기 위한 클래스와 언제 사용하면 좋은지</summary>
<ul>
    <li>StringBuilder, StringBuffer
        <ul>
            <li>단순 더하기 연산 -> 과거에는 새로운 객체가 생성되는 방식(불변 클래스의 특징)이었으나, 이제 자바에서 최적화 해줌</li>
            <li>반복문의 루프 내에서는 런타임에 연결할 문자열 개수/내용이 결정된다 -> 컴파일러가 최적화 어려움</li>
            <li>반복문/조건 통하여 동적으로 문자열 조합/긴 대용량 문자열 다룰 때 -> StringBuilder 사용</li>
            <li>동기화 필요시 StringBuffer 사용</li>
        </ul>
    </li>
</ul>
</details>


<h4>열거</h4>

<details>
<summary>열거형이 왜 필요한지, 실제 구현은 어떻게 되어있는지</summary>
<ul>
    <li>서로 관련된 사용자 정의 타입형(클래스) 상수들의 집합</li>
    <li>private 생성자 -> 타입 안전성</li>
    <li>열거도 결국 클래스 이므로 추상 메서드 사용 가능, 인터페이스 구현 가능</li>
    <li>이미 java.lang.Enum을 상속받기 때문에 다른 클래스 상속은 불가</li>
</ul>
</details>

<h4>중첩 클래스</h4>

<details>
<summary>지역 클래스 지역 변수 캡쳐</summary>
<ul>
    <li>지역 클래스로 만든 객체도 인스턴스이기 때문에 힙 영역에 존재, 따라서 GC 전까지 생존</li>
    <li>지역 클래스를 호출한 메서드 지역 변서는 메서드 실행 동안에만 스택 영역에서 생존</li>
    <li>생명 주기가 다른 문제 -> 인스턴스에 지역변수 캡처하여 저장</li>
    <li>지역 변수/ 캡처 변수의 동기화는 매우 어렵다 -> 변경하지 못하도록 막아 근본적으로 차단(사실상 final)</li>
</ul>
</details>

<h4>예외 처리</h4>

<details>
<summary>예외 처리 방안</summary>
<ul>
    <li>자바 초기에는 체크 예외가 더 나은 선택이라고 여겨졌음</li>
    <li>시간이 지남에 따라 어플리케이션 단에서 해결 할 수 없는 예외가 너무 많아졌다 -> 예외처리 지옥</li>
    <li>런티임 예외를 사용하여 처리할 수 없을 경우 자연스럽게 던지도록, 예외를 공통으로 처리(주로 로깅)</li>
    <li>필요하다면 instanceof 사용해서 분기도 가능</li>
    <li>예시 : 네트워크 서버 문제, 데이터베이스 서버 문제, 외부 라이브러리 문제 등</li>
</ul>
</details>

<details>
<summary>try-with-resources 장점, 사용하려면</summary>
<ul>
    <li>리소스 누수 방지(finally 누락 방지), 코드 간결, 스코프 한정, 조금 더 빠른 자원해제</li>
    <li>autocloseable 구현하여 사용</li>
</ul>
</details>

<h4>제네릭</h4>

<details>
<summary>제네릭과 와일드 카드의 차이</summary>
<ul>
    <li>제네릭은 코드 재사용/ 안전성이 보장되는 클래스를 선언하기 위한 것. 와일드 카드는 와일드카드는 이미 만들어진 제네릭 타입을 활용할 때 사용</li>
    <li>타입 파라미터(제네릭 타입, 제네릭 메소드) 사용하면 전달한 타입을 명확하게 반환할 수 있다. 와일드 카드는 불가, 상한 제한의 경우 부모 타입으로 반환은 가능하다</li>
    <li>꼭 필요한 상황이 아니라면 와일드 카드 사용 권장</li>
    <li>타입 파라미터는 상한 가능, 와일드카드는 상한/하한 가능</li>
</ul>
</details>

<details>
<summary>타입 이레이저와 그에 따른 제약</summary>
<ul>
    <li>제네릭 타입을 도입하면서 하위 호환성을 유지하기 위해 적용된 컴파일러의 동작 방식</li>
    <li>타입 파라미터는 컴파일 시점에 모두 제거되고, 제한이 있는 경우 해당 제한 타입으로, 제한이 없는 경우에는 Object로 대체</li>
    <li>제네릭 클래스 작성시 instanceof / new 연산자 사용 불가하다</li>
</ul>
</details>

<h4>컬렉션</h4>

<details>
<summary>배열 리스트 vs 연결 리스트 시간 복잡도와 실제 성능</summary>
<ul>
    <li>이론적으로 LinkedList 의 중간 삽입 연산은 ArrayList 보다 빠를 수 있다. 그러나 실제 성능은 요소의 순차적 접근 속도, 메모리 할당 및 해제 비용, CPU 캐시 활용도 등 다양한 요소에 의해 영향</li>
    <li>ArrayList 는 요소들이 메모리 상에서 연속적으로 위치하여 CPU 캐시 효율이 좋고, 메모리 접근 속도가 빠르다</li>
    <li>LinkedList 는 각 요소가 별도의 객체로 존재하고 다음 요소의 참조를 저장</li>
    <li>ArrayList 의 경우 CAPACITY 를 넘어서면 배열을 복사하는 과정이 추가되지만 자주발생하진 않아 큰 영향을 주진x</li>
    <li>대부분의 경우에 배열 리스트 사용</li>
</ul>
</details>

<details>
<summary>해시 알고리즘 원리, hashCode, equals</summary>
<ul>
    <li>배열을 사용해 세트를 구현하면 데이터를 검색/추가/삭제할 때 모든 요소를 순회 -> 성능이 O(n) -> 해시 알고리즘으로 검색 성능 O(1)</li>
    <li>해시 인덱스 : 데이터의 값 자체를 배열의 인덱스로 활용하여 빠른 접근</li>
    <li>나머지 연산 : 메모리 낭비를 줄이기 위해 나머지 연산(%)을 사용하여 입력 값을 배열 크기 내의 해시 인덱스(hashIndex)로 변환</li>
    <li>해시 충돌 : 서로 다른 값이 나머지 연산을 통해 동일한 해시 인덱스를 갖게 되는 현상 -> 배열 저장공간을 단일 값 아닌 연결 리스트 사용</li>
    <li>hashCode() : 사용자 정의 객체를 고정된 길이(저장 공간 ex 4byte)의 해시코드로 만들어 준다. 재정의 하지 않으면 참조값 사용됨</li>
    <li>equals() : 논리적인 동등성 비교를 위해 필요. 재정의 하지 않으면 같은 인스턴스(같은 참조값)인 경우만 참</li>
    <li>통계적으로 입력한 데이터의 수가 배열의 크기를 75% 넘지 않으면 해시 인덱스는 자주 충돌하지 않는다</li>
</ul>
</details>

<details>
<summary>Iterable/Iterator, Comparable/Comparator</summary>
<ul>
    <li>Iterable/Iterator
        <ul>
            <li>컬렉션 프레임워크의 모든 자료 구조 일관된 방법으로 순회</li>
            <li>새로운 자료 구조를 만들지 않는 이상, 직접 구현해서 사용할 일은 거의 없다</li>
        </ul>
    </li>
    <li>Comparable/Comparator
        <ul>
            <li>자연 순서를 정의할 때 사용, 정렬할 객체 클래스에서 직접 구현</li>
            <li>다른 정렬 방법을 사용해야 하는 경우 Comparator를 별도로 구현해서 정렬 메서드에 전달</li>
            <li>TreeSet과 TreeMap: 이진 탐색 트리 구조를 사용하므로 데이터를 저장할 때부터 정렬이 필요</li>
            <li>비즈니스 로직에 따라 객체의 정렬 기준을 만들 일이 많기 때문에 직접 구현하여 사용할 일이 많다</li>
        </ul>
    </li>
</ul>
</details>


<h4>프로세스, 스레드</h4>

<details>
<summary>스레드의 상태 5가지</summary>
<ul>
    <li>New(스레드 생성), Runnable(실행중, 실행 준비된 상태. 운영체제 스케줄러의 실행 대기열에 있든, CPU에서 실제 실행되고 있든 같은 Runnable, 자바는 둘을 구분 못한다), Terminated(종료 상태)</li>
    <li>Blocked(락 대기 상태, synchronized에서만 사용), Waiting(스레드 무기한 대기), Timed Waiting(시간 제한 대기)</li>
</ul>
</details>

<details>
<summary>쓰레드 인터럽트와 관련 메소드 (interrupt, isInterrupted, interrupted) 발생 예외</summary>
<ul>
    <li>대기(WAITING , TIMED_WAITING) 상태의 쓰레드를 직접 깨울 수 있다 (interrupt)</li>
    <li>isInterrupted 메소드는 스레드가 인터럽트 상태를 확인만 한다.(변경하진 않음)</li>
    <li>interrupted 메소드는 인터럽트 상태를 확인하고, 현재 인터럽트 상태이면 true반환, 스레드의 인터럽트 상태는 false로 변경한다</li>
    <li>스레드가 인터럽트 상태를 유지하면 추후 블로킹 메소드(Thread.sleep())를 만날 때 InterruptedException이 발생하게 된다</li>
</ul>
</details>

<details>
<summary>yield() 의 동작 방식</summary>
<ul>
    <li>스레드가 CPU를 양보 -> 스케쥴링 큐에 들어가고 다른 스레드가 실행(Runnable은 유지), 강제적인 실행 순서 지정X (반드시 다른 스레드가 실행된다는 것은 아니라는것)</li>
    <li>Java 스레드의 Runnable 상태는 운영체제(OS)의 스케줄링 관점에서 Ready(준비) 상태와 Running(실행) 상태를 모두 포함</li>
</ul>
</details>

<h4>메모리 가시성</h4>

<details>
<summary>volatile, 메모리 가시성</summary>
<ul>
    <li>캐시 메모리, 메인메모리, happens-before</li>
</ul>
</details>

<h4>동기화</h4>

<details>
<summary>synchronized 동기화 필요한 이유, 한계</summary>
<ul>
    <li>경합 조건에서 공유 자원의 데이터 일관성을 위해서 필요하다, 단순하게 구현 가능</li>
    <li>BLOCKED 상태가 된 스레드는 락을 얻을 때까지 무한 대기 한다</li>
    <li>특정 시간을 지정할 수 없고, 인터럽트를 통해 RUNNABLE 상태로 만들 수 없다</li>
    <li>여러 스레드 중에 어떤 스레드가 락을 획득할 지 알 수 없다(공정성 문제, 기아 상태)</li>
</ul>
</details>

<details>
<summary>synchronized 한계 해결을 위한 Lock, ReentrantLock 특징</summary>
<ul>
    <li>객체 내부에 있는 모니터 락이 아닌 Lock기능의 락 사용한다. waiting 상태로 락 획득 대기한다 (Blocked상태 x)</li>
    <li>다양한 메서드 사용하여 락 획득 제어 가능 (락 획득 시도 후 무한대기(인터럽트x)/인터럽트 발생시 대기 포기, 락 획득 시도 후 즉시 성공 여부 반환, 주어진 시간 동안 획득 시도(인터럽트 발생 시 포기)</li>
    <li>공정성 모드 선택 가능</li>
</ul>
</details>

<details>
<summary>자바의 모든 인스턴스가 멀티 스레드와 임계 영역을 다루기 위해 가지는 3가지 기본 요소</summary>
<ul>
    <li>모니터 락, 락 대기 집합, 스레드 대기 집합</li>
</ul>
</details>

<h4>생산자, 소비자 문제</h4>

<details>
<summary>생산자 소비자 문제에서 Object.wait(), Object.notify()가 필요한 이유, 한계</summary>
<ul>
    <li>한정된 크기를 가진 임계 영역(버퍼)에서 생산/소비를 수행하지 못하여 락을 가지고 무한 대기하는 문제를 해결</li>
    <li>인스턴스 내부의 쓰레드 대기집합에 같은 종류의 쓰레드를 깨울 경우 비효율이 발생 (대기 집합이 하나 뿐, 쓰레드 구별 못함)</li>
    <li>쓰레드 기아 문제 -> notifyAll()로 막을 수는 있지만 비효율적</li>
</ul>
</details>

<details>
<summary>Object.wait(), Object.notify() 한계 해결법, 자료구조</summary>
<ul>
    <li>ReentrantLock을 사용하는 스레드 대기공간 Condition 두 개 사용</li>
    <li>BlockingQueue</li>
</ul>
</details>

<details>
<summary>BlockingQueue의 작업큐가 가득 찼을 때의 문제를 해결하기 위한 4가지 선택지</summary>
<ul>
    <li>예외로 처리, 대기하지 않고 즉시 false반환, 대기, 특정 시간 동안 대기, 각각 선택지를 위한 메서드가 전부 구현되어 있다</li>
</ul>
</details>

<h4>스레드 풀과 Executor 프레임워크</h4>

<details>
<summary>Executor 프레임워크 / 스레드 풀이 필요한 이유</summary>
<ul>
    <li>스레드 생성 비용(메모리 할당(호출 스택), 운영체제 자원 사용(커널수준, 시스템콜), 운영체제 스케줄러 설정), 스레드 관리</li>
</ul>
</details>

<details>
<summary>ExecutorService 우아한 종료 방식 설명</summary>
<ul>
    <li>애플리케이션이 갑자기 재시작 된다면? -> 이상적인 방향은 shutdown() 으로 새로운 주문 요청은 막고, 이미 진행중인 주문은 모두 완료한 다음에 서버를 재시작</li>
    <li>갑자기 요청이 너무 많이 들어와서 큐에 대기중인 작업이 너무 많아 작업 완료 어렵거나, 작업이 너무 오래 걸리거나, 또는 버그가 발생해서 특정 작업이 끝나지 않을 수 있다</li>
    <li>이럴 때는 보통 우아하게 종료하는 시간을 정한다. 예를 들어서 60초까지는 작업을 다 처리할 수 있게 기다리는 것. 그리고 60초가 지나면, 무언가 문제가 있다고 가정하고 shutdownNow() 를 호출해서 작업들을 강제로 종료</li>
    <li>close() 의 경우 위의 방식대로 구현되어 있음</li>
</ul>
</details>

<details>
<summary>Executor 스레드 풀 관리 방식</summary>
<ul>
    <li>ThreadPoolExecutor -> corePoolSize, maximumPoolSize, keepAliveTime, 작업큐. 응답시간이 아주 중요한 서버라면 스레드 미리 생성도 가능(ThreadPoolExecutor)</li>
</ul>
</details>

<details>
<summary>Executor 스레드 풀 전략 (고정, 캐시, 사용자 정의, 실무 전략)</summary>
<ul>
    <li>고정 풀 -> 리소스 예측 가능하나 요청이 증가할 때 대응하기 힘듦</li>
    <li>캐시 풀 -> SynchronousQueue사용 (내부 저장공간 없고 스레드간 직거래 시키는 특수한 큐), 리소스 최대한 사용하나 임계점 넘으면 서버 다운</li>
    <li>사용자 정의 -> 일반 / 긴급 / 거절 로 세분화 (ex 기본 스레드 100, 최대 스레드 200, 작업 큐 사이즈 1000), 무한대 사이즈 큐(LinkedBlockingQueue) 사용하지 않도록 주의</li>
    <li>실무 전략 -> 일반적인 상황에서는 고정 풀, 캐시 풀 두 전략이면 충분. 사실 대부분 상황에서 트래픽은 예측 가능하다. 일어나지 않을 일을 위한 최적화를 하지 않도록 경계</li>
</ul>
</details>

<details>
<summary>Executor 예외 정책 (작업 거절)</summary>
<ul>
    <li>ThreadPoolExecutor 는 작업을 거절하는 다양한 정책을 제공 -> AbortPolicy, DiscardPolicy, CallerRunsPolicy, 사용자 정의</li>
</ul>
</details>

<h4>문자 인코딩</h4>

<details>
<summary>한글이 깨지는 가장 큰 2가지 이유</summary>
<ul>
    <li>EUC-KR(MS949), UTF-8 서로 호환 X</li>
    <li>EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 ISO-8859-1 로 디코딩</li>
</ul>
</details>

<h4>IO</h4>

<details>
<summary>IO작업에서 버퍼가 필요한 이유</summary>
<ul>
    <li>성능 향상(하드웨어 접근 최소화, 시스템 콜 감소), 읽기/쓰기 속도 불균형 해소, 편의성(줄단위 작업)</li>
</ul>
</details>

<details>
<summary>버퍼를 직접 다루기 vs BufferedXxx</summary>
<ul>
    <li>BufferedXxx의 경우 동기화 처리 되어 있어, 싱글 스레드에서 사용할 경우 성능이 떨어질 수 있다</li>
</ul>
</details>

<details>
<summary>기본 스트림 / 보조 스트림 특징과 주의점</summary>
<ul>
    <li>단독 사용 / 보조 기능 제공, 대상 스트림 반드시 있어야 한다.</li>
    <li>마지막에 연결한 스트림을 닫아야 한다. 연쇄적으로 close, flush 호출되며 자원정리</li>
</ul>
</details>

<h4>파일</h4>

<details>
<summary>절대 경로 / 정규 경로</summary>
<ul>
    <li>경로의 처음부터 내가 입력한 모든 경로를 다 표현 (여러가지 가능)</li>
    <li>경로의 계산이 모두 끝난 경로 (하나만 존재)</li>
</ul>
</details>

<h4>네트워크</h4>

<details>
<summary>ServerSocket, Socket, Session 역할</summary>
<ul>
    <li>ServerSocket : 클라이언트와 서버의 TCP 연결만 지원하는 특별한 소켓, 포트 지정해서 바인딩 / 서버 소켓만으로 TCP연결은 완료된다</li>
    <li>Socket : 실제 데이터 송수신 객체 (스트림 사용), 포트 랜덤 바인딩(지정 가능은 함)</li>
    <li>Session : 각 클라이언트와 데이터 송수신 하는 역할(서버와 별도의 스레드)</li>
</ul>
</details>

<details>
<summary>네트워크 자원정리와 try-with-resources 심화</summary>
<ul>
    <li>자원 정리 순서 반영, finally 구문 에서 자원정리 중 예외 발생시 -> 다음 자원 정리 x, 핵심 예외가 부가 예외로 바뀌어 버림. 두가지 문제 해결 (Suppressed)</li>
    <li>try-with-resources는 사용과 해제를 함께 묶어서 처리할 때 사용</li>
    <li>생명주기가 다른 때(세션 종료 / 서버 종료)에 자원을 정리하고자 할 때는 어쩔 수 없이 finally를 통해서 정리해야 한다</li>
</ul>
</details>

<details>
<summary>shutdownhook</summary>
<ul>
    <li>자바 프로세스가 종료될 때 자원 정리같은 종료 작업을 마무리하고 프로세스가 종료되도록 돕는 기능</li>
    <li>정상 종료시 작동 O / 강제 종료는 작동 X</li>
</ul>
</details>

<details>
<summary>네트워크 예외 (ip, port, <b>timeout</b>>)</summary>
<ul>
    <li>UnknownHostException(ip / dns 주소 틀렸을 때)</li>
    <li>ConnectException: Connection refused (ip서버 컴퓨터에 접속은 했지만, 사용하지 않는 포트 번호여서 TCP연결 거절)</li>
    <li><b>SocketTimeoutException: Connect timed out / Read timed out (TCP 연결/소켓 타임아웃)</b></li>
    <li><b>외부 서버와 통신을 하는 경우 꼭 커스텀 해서 설정해 줘야 한다 ( socket.connect(InetSocketAddress, time) / socket.setSoTimeout(time) )</b></li>
</ul>
</details>

<details>
<summary>네트워크 종료 과정, 특징, 처리</summary>
<ul>
    <li>4 way handshake</li>
    <li>정상 전체 흐름 : 서버 -> 클라이언트 FIN, 클->서 ACK, 클->서 FIN+ACK, 서->클 ACK </li>
    <li>정상 종료 : FIN 패킷을 받은 클라이언트의 소켓은 더는 서버를 통해 읽을 데이터가 없다는 의미로, 블로킹 메소드에서 EOF 반환 (읽는 방식에 따라 -1, null, EOFException)</li>
    <li>강제 종료 : FIN 패킷을 받은 클라이언트의 소켓이 서버에 메서지 전달을 시도하면 PUSH 패킷이 서버에 전달된다. 서버는 TCP 연결에 문제가 있다고 판단, 즉각 연결을 종료하라는 RST 패킷을 클라이언트에 전송. -> 그 후 read, write시도 시 SocketException</li>
    <li>SocketException , EOFException 은 모두 IOException 의 자식임을 기억하자</li>
</ul>
</details>

<details>
<summary>NullObjectPattern / CommandPattern</summary>
<ul>
    <li>null 대신 사용할 수 있는 특별한 객체 생성</li>
    <li>작업을 호출하는 객체와 작업을 수행하는 객체가 분리, 복잡성 증가 (단순 if문 몇개로 해결 가능하면 오히려 안좋은 선택)</li>
</ul>
</details>

<h4>HTTP 서버</h4>

<details>
<summary>http 서버 설명 (소켓, url, servlet)</summary>
<ul>
    <li>HTTP 통신도 socket 통신. 다만 HTTP 요청이 끝나면 해당 socket 통신을 끊어버리는 차이가 있다. (클라이언트가 서버로 요청을 보낼 때마다 새로운 소켓 연결이 이루어지고, 응답을 받은 후에는 즉시 연결이 종료되는 방식)</li>
    <li>HTTP는 매우 보수적, 호환성을 최우선에 둠. -> URL엔 아스키만 가능 (메시지 바디에는 UTF8가능) -> 발생하는 문제 퍼센트인코딩으로 -> URLEncoder.encode() , URLDecoder.decode 를 사용하면 % 인코딩, 디코딩을 처리할 수 있다</li>
    <li>HTTP, Server, Applet의 줄임말(HTTP 서버에서 실행되는 작은 자바 프로그램(애플릿)) -> service() 메서드에 서비스 개발과 관련된 부분을 구현하면 된다</li>
</ul>
</details>

<h4>리플랙션, 어노테이션</h4>

<details>
<summary>리플랙션/어노테이션 설명</summary>
<ul>
    <li>런타임 시점에 클래스의 정보(메서드, 필드, 생성자 등)에 접근하고 조작</li>
    <li>일반 주석과 달리, 컴파일러나 런타임에서 해석될 수 있는 메타데이터를 제공</li>
</ul>
</details>

<details>
<summary>어노테이션과 상속</summary>
<ul>
    <li>애노테이션은 다른 애노테이션이나 인터페이스를 직접 상속할 수 없다. 오직 java.lang.annotation.Annotation 인터페이스만 묵시적으로 상속</li>
    <li>애노테이션을 정의시 @Inherited 메타 애노테이션 -> 애노테이션을 적용한 클래스의 자식도 해당 애노테이션을 부여</li>
    <li>@Inherited는 클래스 상속에만 적용, 인터페이스 구현체에는 X 이유 생각해보자</li>
</ul>
</details>

<details>
<summary>리플랙션/어노테이션이 스프링 프레임워크에서 사용되는 예시</summary>
<ul>
    <li>의존성 주입, ORM 매핑, AOP, 설정의 자동화, 트랜잭션 관리</li>
</ul>
</details>

<h4>람다, 스트림</h4>

<details>
<summary>람다/익명 클래스 차이점</summary>
<ul>
    <li>상속, this, 생성방식, 상태(필드)</li>
</ul>
</details>

<details>
<summary>스트림 api 특징</summary>
<ul>
    <li>데이터 소스 변경 x, 일회성, 파이프라인, 지연연산, 병렬 처리 용이</li>
    <li>단축 평가 (지연 연산, 파이프라인)</li>
</ul>
</details>

<details>
<summary>Optional 베스트 프랙틱스, orElse/orElseGet 차이, 이점</summary>
<ul>
    <li>리턴 타입으로만 사용</li>
    <li>즉시평가 / 지연평가 -> 생성 비용이 큰 연산을 미리 수행하지 않을 수 있다</li>
</ul>
</details>

<details>
<summary>Fork/Join 공용 풀, 병렬 스트림</summary>
<ul>
    <li>애플리케이션 내에서 단일 인스턴스, jvm 관리</li>
    <li>스트림에 parallel() 메서드, 공용풀 사용, **절대** I/O 바운드 작업을 하면 안된다</li>
</ul>
</details>

<details>
<summary>Fork/Join 프레임워크 CPU 바운드 작업에만 사용해야 하는 이유</summary>
<ul>
    <li>스레드 블로킹에 따른 CPU 낭비 (제한된 스레드 개수로 I/O 작업으로 스레드 블로킹 시 cpu가 놀게 됨)</li>
    <li>작업 훔치기 기법 무력화 (작업을 훔쳐서 쉬는 스레드 없이 계속 작업 하도록 설계된 것 무의미해짐)</li>
    <li>분할-정복(작업 분할) 이점 감소 (I/O 병목이 발생하면 CPU 병렬화 이점이 크게 줄어든다. 오히려 분할된 작업들이 각기 I/O 대기를 반복하면서, fork() , join() 에 따른 오버헤드만 증가)</li>
</ul>
</details>