<h4>상속, 구현</h4>

<details>
<summary>오버로딩과 오버라이딩의 규칙과 쓰임새</summary>
- 매개변수, 리턴타입, 접근제어자, 예외, 다형성
</details>

<details>
<summary>인터페이스와 추상 클래스의 차이</summary>
- 순수 추상클래스, 다중 상속/구현, 다이아몬드 문제, 일반 메서드, 추상 메서드, 계약
</details>

<details>
<summary>디폴트 메서드는 왜 등장했는가?</summary>
</details>

<h4>String</h4>

<details>
<summary>String클래스가 불변으로 설계 된 이유</summary>
- 공유 참조, 사이드 이펙트, 문자열 풀
</details>

<details>
<summary>불변인 String클래스 단점을 해결하기 위한 클래스와 언제 사용하면 좋은지</summary>
- StringBuilder, StringBuffer
</details>


<h4>열거</h4>

<details>
<summary>열거형이 왜 필요한지, 실제 구현은 어떻게 되어있는지</summary>
- 상수, private 생성자
</details>

<h4>중첩 클래스</h4>

<details>
<summary>지역 클래스 지역 변수 캡쳐</summary>
- 생명주기, 변경 가능성
</details>

<h4>예외 처리</h4>

<details>
<summary>예외/예외 처리가 필요한 이유</summary>
- 코드 정상 흐름, 오류 흐름, 코드 스파게티
</details>

<details>
<summary>예외 처리 방안</summary>
- 처리할 수 없는 예외, 예외 처리 지옥, 공통 처리, instanceof 사용 해서 케이스 분기도 가능
</details>

<details>
<summary>try-with-resources 장점, 사용하려면</summary>
- 리소스 누수 방지(finally 누락 방지), 코드 간결, 스코프 한정, 조금 더 빠른 자원해제 <br>
- autocloseable 구현하여 사용
</details>

<h4>제네릭</h4>

<details>
<summary>제네릭과 와일드 카드의 차이</summary>
- 타입 결정 여부, 반환 시 결정되는 타입
</details>

<details>
<summary>타입 이레이저 동작 방식, 그에 따른 제약</summary>
- 컴파일 타임, instanceof, new
</details>

<h4>컬렉션</h4>

<details>
<summary>제네릭과 와일드 카드의 차이</summary>
- 타입 결정 여부, 반환 시 결정되는 타입
</details>

<details>
<summary>배열 리스트 vs 연결 리스트 시간 복잡도와 실제 성능</summary>
- 배열, 노드, 실무에서 주로 배열 리스트인 이유
</details>

<details>
<summary>해시 알고리즘</summary>
- 해시코드 hashCode(), 동등성 equals(), 메모리 낭비 방지 -> 인덱스 변환(나머지), 해시 충돌, 75%
</details>

<details>
<summary>Iterable/Iterator설명, 필요한 이유</summary>
- 사용 시에 순회 방법에 대해서 몰라도 됨, 향상된 for, map은 제외
</details>

<details>
<summary>Comparable/Comparator설명, 필요한 이유</summary>
- 기본 자연 순서 제공, 자연 순서 외에 다른 정렬 기준, tree 구조에는 꼭 필요
</details>

<h4>프로세스, 스레드</h4>

<details>
<summary>스레드의 상태 5가지 간략한 설명</summary>
- Blocked는 synchronized에서만 사용되는 특별한 상태
</details>

<details>
<summary>interrupt, isInterrupted, interrupted</summary>
- 대기 상태의 스레드 직접 깨우기, InterruptedException -> sleep메소드, 인터럽트 상태 유지(상태만 확인), 인터럽트 상태 확인하고 정상(false)으로 변경
</details>

<details>
<summary>쓰레드가 Runnable상태 일 때, 운영체제의 스케줄링이 갖을 수 있는 상태와 yield 의 동작 방식</summary>
- Running(실행 상태), Ready(실행 대기 상태), 스레드가 CPU를 양보 -> 스케쥴링 큐에 들어가고 다른 스레드가 실행(Runnable은 유지), 강제적인 실행 순서 지정X
</details>

<h4>메모리 가시성</h4>

<details>
<summary>volatile, 메모리 가시성</summary>
- 캐시 메모리, 메인메모리, happens-before
</details>

<h4>동기화</h4>

<details>
<summary>synchronized 동기화 필요한 이유, 한계</summary>
- 경합 조건, 데이터 일관성, BLOCKED상태(synchronized에서만 사용), BLOCKED 상태 -> 락을 얻을 때까지 무한 대기(인터럽트 x), 공정성
</details>

<details>
<summary>synchronized 한계 해결법</summary>
- Lock, ReentrantLock -> 다양한 메서드 사용하여 락 획득 제어 가능, 스레드 공정 획득 모드 제공
</details>

<details>
<summary>자바의 모든 인스턴스가 멀티 스레드와 임계 영역을 다루기 위해 가지는 3가지 기본 요소</summary>
- 모니터 락, 락 대기 집합, 스레드 대기 집합
</details>

<h4>생산자, 소비자 문제</h4>

<details>
<summary>생산자 소비자 문제에서 Object.wait(), Object.notify()가 필요한 이유, 한계</summary>
- 임계 영역에서 생산/소비를 수행하지 못하여 락을 가지고 무한 대기하는 문제를 해결할 수 있다 <br>
- 인스턴스 내부의 쓰레드 대기집합에 같은 종류의 쓰레드를 깨울 경우 비효율이 발생 (대기 집합이 하나 뿐, 쓰레드 구별 못함) <br>
- 쓰레드 기아 문제 -> notifyAll()로 막을 수는 있지만 비효율적
</details>

<details>
<summary>Object.wait(), Object.notify() 한계 해결법</summary>
- ReentrantLock을 사용하는 스레드 대기공간 Condition 두 개 사용
</details>

<details>
<summary>위의 문제들을 쉽게 해결하기 위한 멀티스레드 자료구조</summary>
- BlockingQueue
</details>

<details>
<summary>BlockingQueue의 작업큐가 가득 찼을 때의 문제를 해결하기 위한 4가지 선택지</summary>
- 예외로 처리, 대기하지 않고 즉시 false반환, 대기, 특정 시간 동안 대기, 각각 선택지를 위한 메서드가 전부 구현되어 있다
</details>

<details>
<summary>Executor 프레임워크 / 스레드 풀이 필요한 이유</summary>
- 스레드 생성 비용(메모리 할당(호출 스택), 운영체제 자원 사용(커널수준, 시스템콜), 운영체제 스케줄러 설정), 스레드 관리
</details>

<details>
<summary>ExecutorService 우아한 종료 방식 설명</summary>
- 애플리케이션이 갑자기 재시작 된다면? -> 이상적인 방향은 shutdown() 으로 새로운 주문 요청은 막고, 이미 진행중인 주문은 모두 완료한 다음에 서버를 재시작 <br>
- 갑자기 요청이 너무 많이 들어와서 큐에 대기중인 작업이 너무 많아 작업 완료 어렵거나, 작업이 너무 오래 걸리거나, 또는 버그가 발생해서 특정 작업이 끝나지 않을 수 있다 <br>
- 이럴 때는 보통 우아하게 종료하는 시간을 정한다. 예를 들어서 60초까지는 작업을 다 처리할 수 있게 기다리는 것. 그리고 60초가 지나면, 무언가 문제가 있다고 가정하고 shutdownNow() 를 호출해서 작업들을 강제로 종료 <br>
- close() 의 경우 위의 방식대로 구현되어 있음
</details>

<details>
<summary>Executor 스레드 풀 관리 방식</summary>
- ThreadPoolExecutor -> corePoolSize, maximumPoolSize, keepAliveTime, 작업큐. 응답시간이 아주 중요한 서버라면 스레드 미리 생성도 가능(ThreadPoolExecutor)
</details>

<details>
<summary>Executor 스레드 풀 전략 (고정, 캐시, 사용자 정의, 실무 전략)</summary>
- 고정 풀 -> 리소스 예측 가능하나 요청이 증가할 때 대응하기 힘듦 <br>
- 캐시 풀 -> SynchronousQueue사용 (내부 저장공간 없고 스레드간 직거래 시키는 특수한 큐), 리소스 최대한 사용하나 임계점 넘으면 서버 다운 <br>
- 사용자 정의 -> 일반 / 긴급 / 거절 로 세분화 (ex 기본 스레드 100, 최대 스레드 200, 작업 큐 사이즈 1000), 무한대 사이즈 큐(LinkedBlockingQueue) 사용하지 않도록 주의 <br>
- 실무 전략 -> 일반적인 상황에서는 고정 풀, 캐시 풀 두 전략이면 충분. 사실 대부분 상황에서 트래픽은 예측 가능하다. 일어나지 않을 일을 위한 최적화를 하지 않도록 경계
</details>

<details>
<summary>Executor 예외 정책</summary>
-  ThreadPoolExecutor 는 작업을 거절하는 다양한 정책을 제공 -> AbortPolicy, DiscardPolicy, CallerRunsPolicy, 사용자 정의
</details>

<h4>문자 인코딩</h4>

<details>
<summary>한글이 깨지는 가장 큰 2가지 이유</summary>
- EUC-KR(MS949), UTF-8 서로 호환 X <br>
- EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 ISO-8859-1 로 디코딩
</details>

<details>
<summary>한글이 깨지는 가장 큰 2가지 이유</summary>
- EUC-KR(MS949), UTF-8 서로 호환 X <br>
- EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 ISO-8859-1 로 디코딩
</details>

<h4>IO</h4>

<details>
<summary>IO작업에서 버퍼가 필요한 이유</summary>
- 성능 향상(하드웨어 접근 최소화, 시스템 호출 감소), 읽기/쓰기 속도 불균형 해소, 편의성(줄단위 작업)
</details>

<details>
<summary>버퍼를 직접 다루는 것 보다 BufferedXxx의 성능이 떨어지는 이유</summary>
- 동기화 처리 되어 있음
</details>

<details>
<summary>기본 스트림, 보조 스트림 특징과 주의점</summary>
- 단독 사용 / 보조 기능 제공 -> 대상 스트림 반드시 있어야 한다, 마지막에 연결한 스트림을 닫아야 한다. 연쇄적으로 close, flush 호출되며 자원정리
</details>

<h4>파일</h4>

<details>
<summary>절대 경로 / 정규 경로</summary>
- 경로의 처음부터 내가 입력한 모든 경로를 다 표현 (여러가지 가능) / 경로의 계산이 모두 끝난 경로 (하나만 존재)
</details>

<h4>네트워크</h4>

<details>
<summary>ServerSocket, Socket, Session 역할</summary>
- ServerSocket : 클라이언트와 서버의 TCP 연결만 지원하는 특별한 소켓, 포트 지정해서 바인딩 / 서버 소켓만으로 TCP연결은 완료된다. <br>
- Socket : 실제 데이터 송수신 객체 (스트림 사용), 포트 랜덤 바인딩(지정 가능은 함) <br>
- Session : 각 클라이언트와 데이터 송수신 하는 역할(서버와 별도의 스레드)
</details>

<details>
<summary>네트워크 자원정리 try-with-resources 심화</summary>
- 자원 정리 순서 반영, finally 구문 에서 자원정리 중 예외 발생시 -> 다음 자원 정리 x, 핵심 예외가 부가 예외로 바뀌어 버림. 두가지 문제 해결 (Suppressed) <br>
- try-with-resources는 사용과 해제를 함께 묶어서 처리할 때 사용. <br>
- 생명주기가 다른 때(세션 종료 / 서버 종료)에 자원을 정리하고자 할 때는 어쩔 수 없이 finally를 통해서 정리해야 한다
</details>

<details>
<summary>shutdownhook</summary>
- 자바 프로세스가 종료될 때 자원 정리같은 종료 작업을 마무리하고 프로세스가 종료되도록 돕는 기능 <br>
- 정상 종료시 작동 O / 강제 종료는 작동 X
</details>

<details>
<summary>네트워크 예외 (ip, port, timeout)</summary>
- UnknownHostException(ip / dns 주소 틀렸을 때) <br>
- ConnectException: Connection refused (ip서버 컴퓨터에 접속은 했지만, 사용하지 않는 포트 번호여서 TCP연결 거절) <br>
- SocketTimeoutException: Connect timed out / Read timed out (TCP 연결/소켓 타임아웃) <br>
- 외부 서버와 통신을 하는 경우 꼭 커스텀 해서 설정해 줘야 한다 ( socket.connect(InetSocketAddress, time) / socket.setSoTimeout(time) )
</details>

<details>
<summary>네트워크 종료 과정, 특징, 처리</summary>
- 4 way handshake <br>
- 정상 종료 : FIN 패킷을 받은 클라이언트의 소켓은 더는 서버를 통해 읽을 데이터가 없다는 의미로 EOF 반환 (읽는 방식에 따라 -1, null, EOFException) <br>
- 강제 종료 : FIN 패킷을 받은 클라이언트의 소켓이 서버에 메서지 전달을 시도하면 PUSH 패킷이 서버에 전달된다. 서버는 TCP 연결에 문제가 있다고 판단, 즉각 연결을 종료하라는 RST 패킷을 클라이언트에 전송. -> 그 후 read, write시도 시 SocketException <br>
- SocketException , EOFException 은 모두 IOException 의 자식임을 기억하자
</details>

<details>
<summary>NullObjectPattern / CommandPattern</summary>
- null 대신 사용할 수 있는 특별한 객체 생성 / 작업을 호출하는 객체와 작업을 수행하는 객체가 분리, 복잡성 증가 (단순 if문 몇개로 해결 가능하면 오히려 안좋은 선택)
</details>

<h4>HTTP 서버</h4>

<details>
<summary>http 서버 설명 (소켓, url, servlet)</summary>
- HTTP 통신도 socket 통신. 다만 HTTP 요청이 끝나면 해당 socket 통신을 끊어버리는 차이가 있다. (클라이언트가 서버로 요청을 보낼 때마다 새로운 소켓 연결이 이루어지고, 응답을 받은 후에는 즉시 연결이 종료되는 방식) <br>
- HTTP는 매우 보수적, 호환성을 최우선에 둠. -> URL엔 아스키만 가능 (메시지 바디에는 UTF8가능) -> 발생하는 문제 퍼센트인코딩으로 -> URLEncoder.encode() , URLDecoder.decode 를 사용하면 % 인코딩, 디코딩을 처리할 수 있다 <br>
- HTTP, Server, Applet의 줄임말(HTTP 서버에서 실행되는 작은 자바 프로그램(애플릿)) -> service() 메서드에 서비스 개발과 관련된 부분을 구현하면 된다.
</details>

<h4>리플랙션, 어노테이션</h4>

<details>
<summary>리플랙션/어노테이션 설명</summary>
- 런타임 시점에 클래스의 정보(메서드, 필드, 생성자 등)에 접근하고 조작 <br>
- 일반 주석과 달리, 컴파일러나 런타임에서 해석될 수 있는 메타데이터를 제공
</details>

<details>
<summary>어노테이션과 상속</summary>
- 애노테이션은 다른 애노테이션이나 인터페이스를 직접 상속할 수 없다. 오직 java.lang.annotation.Annotation 인터페이스만 묵시적으로 상속 <br>
- 애노테이션을 정의시 @Inherited 메타 애노테이션 -> 애노테이션을 적용한 클래스의 자식도 해당 애노테이션을 부여 <br>
- @Inherited는 클래스 상속에만 적용, 인터페이스 구현체에는 X 
</details>

<details>
<summary>리플랙션/어노테이션이 스프링 프레임워크에서 사용되는 예시</summary>
- 의존성 주입, ORM 매핑, AOP, 설정의 자동화, 트랜잭션 관리
</details>

<h4>람다, 스트림</h4>

<details>
<summary>람다/익명 클래스 차이점</summary>
- 상속, this, 생성방식, 상태(필드)
</details>

<details>
<summary>스트림 api 특징</summary>
- 데이터 소스 변경 x, 일회성, 파이프라인, 지연연산, 병렬 처리 용이 <br>
- 단축 평가 (지연 연산, 파이프라인)
</details>

<details>
<summary>Optional 베스트 프랙틱스, orElse/orElseGet</summary>
- 리턴 타입으로만 사용 <br>
- 즉시평가 / 지연평가
</details>

<details>
<summary>Fork/Join 공용 풀, 병렬 스트림</summary>
- 애플리케이션 내에서 단일 인스턴스, jvm 관리 <br>
- 스트림에 parallel() 메서드, 공용풀 사용, **절대** I/O 바운드 작업을 하면 안된다
</details>

<details>
<summary>Fork/Join 프레임워크 CPU 바운드 작업에만 사용해야 하는 이유</summary>
- 스레드 블로킹에 따른 CPU 낭비 (제한된 스레드 개수로 I/O 작업으로 스레드 블로킹 시 cpu가 놀게 됨) <br>
- 작업 훔치기 기법 무력화 (작업을 훔쳐서 쉬는 스레드 없이 계속 작업 하도록 설계된 것 무의미해짐) <br>
- 분할-정복(작업 분할) 이점 감소 (I/O 병목이 발생하면 CPU 병렬화 이점이 크게 줄어든다. 오히려 분할된 작업들이 각기 I/O 대기를 반복하면서, fork() , join() 에 따른 오버헤드만 증가)
</details>