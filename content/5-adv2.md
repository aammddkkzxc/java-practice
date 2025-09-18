## adv2

### 문자 인코딩
- 한글이 깨지는 가장 큰 2가지 이유
  - UTF-8과 EUC-KR(MS949)의 불일치
    - UTF-8로 인코딩된 데이터를 MS949로 해석하거나, 그 반대의 경우 글자가 깨진다.
  - 한글 미지원 인코딩 사용
    - UTF-8이나 EUC-KR로 인코딩된 한글 데이터를 한글을 지원하지 않는 ISO-8859-1과 같은 인코딩으로 디코딩할 때 문제가 발생
- UTF-8이 사실상 표준이 된 이유 2가지 생각해보자
- 자바는 언어 내부적으로 문자 다룰 때 UTF-16 사용

### IO

#### 바이트 스트림
- InputStream/OutputStream 상속하는 클래스
- 파일/소켓/메모리 등 모두 일관된 방식으로 데이터 주고 받도록 함
- 버퍼링을 통한 성능 최적화
  - read()나 write()를 호출할 때마다 운영체제에 **시스템 콜(System Call)**이 발생, 상당한 오버헤드 유발
  - 버퍼를 사용한 최적화
  - 4KB(4096 바이트) 또는 8KB(8192 바이트)에 맞춰 버퍼 크기를 설정
    - 디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본 단위가 보통 4KB 또는 8KB이기 때문에, 한 번에 쓴다고해서 무작정 빠른 것은 아님
  - BufferedXxx `BufferedOutputStreamMain 클래스`
    - BufferedXxx 클래스들은 동기화 코드가 들어 있어 스레드 안전(thread-safe)하게 설계되어 있다 -> 약간의 성능 저하
    - 자원 정리시 주의해야 한다. 마지막에 연결한 스트림 close() 호출해주면 -> 내부적으로 flush()호출, 연쇄적인 close() 하여 자원 전부 정리
  - 성능이 중요하고, 큰 파일 나누어 처리해야 한다면 버퍼 직접 다루면 된다 `FileOutputStreamMain 클래스`
    - 일반적인 상황이라면 큰 성능 문제X 

#### 문자 스트림 (문자 다루기)
- Reader/Writer 상속하는 클래스
- 문자를 바이트 스트림으로 직접 전달할 수는 없다. 변환 과정이 반드시 필요
  - 직접 인코딩 지정하여 변환하거나 String.getBytes(UTF_8)
  - Reader/Writer 클래스 사용 `FileWriterMain 클래스`
    - FileWriter 는 사실 내부에서 스스로 FileOutputStream 을 하나 생성해서 사용하고 있다
- 기본(기반, 메인) 스트림
  - File, 메모리, 콘솔등에 직접 접근, 단독 사용 가능
- 보조 스트림
  - 기본 스트림을 도와주는 스트림, 대상 스트림 있어야함

#### IO 활용
- 데이터 저장 방식의 발전
  - 메모리 저장 -> 휘발성
  - 파일 저장
    - 텍스트 파일 저장 (Reader / Writer) -> 데이터 타입 변환 과정, 구분자 관리 번거로움
    - 데이터 스트림 (DataOutputStream / DataInputStream) -> 객체의 각 필드를 개별적으로 저장, 바이트 기반이라 파일 읽고 해석 어려움
    - 객체 스트림과 직렬화 (ObjectOutputStream / ObjectInputStream) `ObjectMemberRepository 클래스`
      - Serializable 인터페이스 구현 (마커 인터페이스), 나름 편리함 `Member 클래스`
      - 플랫폼 종속( Java), 버전 관리 (클래스 변경) 등 이슈
- 웹 환경에서 데이터를 교환할 때 JSON이 사실상 표준 기술이 됨

### 파일
- 절대 경로
  - 경로의 처음부터 내가 입력한 모든 경로를 다 표현
  - 여러가지 방법으로 표현 가능
- 정규 경로
  - 경로의 계산이 모두 끝난 경로. 정규 경로는 하나만 존재
- Files
  - File 클래스 기능 개선
  - 문자 파일을 매우 간단하게 읽고 쓸 수 있는 메서드를 제공하여, 과거의 복잡한 스트림 사용을 대체 (내부적으로 스트림 사용)
  - Path -> 경로 다루기
  - 파일을 다루어야 할 일이 있다면 항상 Files 의 기능을 먼저 찾아보자
  - 파일의 정보를 읽어서 처리해야 하거나, 스트림을 통해 네트워크에 전달해야 한다면 앞서 설명한 스트림을 직접 사용
- 파일 복사와 최적화
  - Java 메모리 사용 `FilesCopyPractice1 클래스`
    - FileInputStream으로 파일의 모든 데이터를 읽어 byte 배열에 저장한 뒤, FileOutputStream으로 쓰는 방식
    - 이 과정은 파일 → Java 메모리 → 파일 순서로 데이터가 이동
    - transferTo() 메서드 : Java 9에 도입된 InputStream의 메서드로, 읽은 데이터를 바로 OutputStream으로 전달 (최적화)
  - Files.copy() 메서드 `FilesCopyPractice2 클래스`
    - 운영체제(OS)의 네이티브 파일 복사 기능을 직접 사용, 데이터를 Java 메모리로 가져오는 중간 과정을 생략
    - 가장 빠름

### 네트워크
- 소켓(Socket): 클라이언트와 서버 간의 연결점(endpoint)으로, 데이터 통신을 위한 InputStream과 OutputStream을 제공
- IP 주소
  - 자바의 InetAddress 클래스를 사용하면 호스트 이름으로 대상 IP를 찾을 수 있다
  - 시스템의 호스트 파일을 먼저 확인 (C:\Windows\System32\drivers\etc\hosts)
    - 호스트 파일에 정의되어 있지 않다면, DNS 서버에 요청해서 IP 주소 옫눈더
- ServerSocket
  - 서버 소켓은 단지 클라이언트와 서버의 TCP 연결만 지원하는 특별한 소켓
- 클라이언트-서버 연결 과정
  - 서버 대기: 서버는 ServerSocket을 생성, 지정된 포트(예: 12345)에서 클라이언트의 연결을 기다린다 
  - 클라이언트 연결 시도 : 클라이언트는 서버의 IP 주소와 포트 번호로 Socket 객체를 생성하여 연결을 시도
    - 클라이언트 자신의 포트는 지정하지 않으면 남아있는 포트 중 하나가 랜덤으로 할당
  - TCP 3-Way Handshake 및 Backlog Queue
    - 운영체제(OS) 수준에서 TCP 3-way handshake가 일어나 연결이 성립
    - 연결 정보는 서버의 OS backlog queue에 저장 (클라이언트의 IP, PORT, 서버의 IP, PORT 정보가 모두 들어있다)
    - 실제 클라이언트와 서버가 정보를 주고 받으려면 Socket 객체가 필요
      - 소켓 객체 없이 서버 소켓만으로도 TCP 연결은 완료된다는 점에 주의하자 (서버 소켓은 연결만 담당한다)
      - 서버와 TCP 연결만 되어도 서버로 메세지를 보낼 수는 있다 (제대로 된 수신은 불가능)
      - 하지만 연결 이후에 서로 메시지를 주고 받으려면 서버에도 Socket 객체가 필요 (연결 요청하는 클라이언트 마다 각각)
  - accept() 호출과 소켓 생성
    - 서버에서 serverSocket.accept() 메서드를 호출하면, backlog queue에 있는 연결 정보를 기반으로 통신용 Socket 객체가 생성되고 반환
    - 이 정보는 큐에서 제거. 만약 큐에 연결 정보가 없다면, accept()는 새로운 연결이 들어올 때까지 블로킹(대기) 상태
- 다중 클라이언트 처리 (Session) `network.tcp.mutilconnect 패키지`
  - accept()로 연결을 수락한 후, 해당 클라이언트와의 통신이 끝나기 전까지 다른 클라이언트의 연결 요청을 받을 수 없다 -> 역할 분리
  - Session 객체 : 클라이언트와 연결된 Socket 객체를 전달받아, 해당 클라이언트와의 데이터 송수신을 전담

#### 예외 처리와 자원 정리 `network.autocloseable 패키지`
- `ResourceCloseMainV1 클래스` : 로직 시점 발생하는 예외 때문에 자원 정리 코드가 정상 호출되지 않는 경우
- `ResourceCloseMainV2 클래스` : 로직 시점 발생하는 예외에 대비한 경우, 자원 정리 중 예외 발생 하는 경우 (두가지 핵심 문제)
  - close() 시점에 예외가 발생하면, 이후 다른 자원을 닫을 수 없는 문제 발생
  - finally 블럭 안에서 자원을 닫을 때 예외가 발생하면, 핵심 예외가 finally 에서 발생한 부가 예외로 바뀌어 버린다. 그리고 핵심 예외가 사라진다.
- `ResourceCloseMainV3 클래스` : 앞선 버전의 두가지 핵심 문제는 해결하지만, 여전한 4가지 부가 문제 존재
  - resource 변수를 선언하면서 동시에 할당할 수 없음(try , finally 코드 블록과 변수 스코프가 다른 문제)
  - catch 이후에 finally 호출, 자원 정리가 조금 늦어진다.
  - 개발자가 실수로 close() 를 호출하지 않을 가능성
  - 개발자가 close() 호출 순서를 실수, 보통 자원을 생성한 순서와 반대로 닫아야 함
- `ResourceCloseMainV4 클래스` : autocloseable 사용
  - 자원을 생성한 순서에 따라 반대로 닫아 주는 것 까지 해줌
  - try-with-resources 를 사용하는 중에 핵심 로직 예외와 자원을 정리하는 중에 발생하는 부가 예외가 모두 발생하면
    - 부가 예외는 핵심 예외안에 Suppressed 로 담아서 반환. 사용도 가능
  - try-with-resources 장점 정리해서 생각해보자

#### 네트워크 프로그램 자원 정리
- try-with-resources 를 항상 사용할 수 있는 것은 아니고, finally 에서 직접 자원을 정리해야 하는 경우가 많이 있다
  - try-with-resources는 사용과 해제를 함께 묶어서 처리할 때 사용
    - 이 방식은 try 블록의 범위를 벗어날 때 자원이 정리, try 블록 외부에서 자원을 제어해야 하는 경우에는 사용할 수 없다
    - 생명주기가 다른 때(세션 종료 or 서버 종료)에 자원을 정리하고자 할 때는 어쩔 수 없이 finally를 통해서 정리
      - 유틸리티 클래스 만들어서 사용하자 `SocketCloseUtil 클래스`
- shutdownhook `network.tcp.shutdownhook 패키지`
  - 서버에서 콘솔 입력을 통한 종료는 잘 하지 않으므로, 서버를 직접 종료하면서 자원도 함께 정리 하는 방법
  - 자바 프로세스가 종료될 때 자원 정리같은 종료 작업을 마무리하고 프로세스가 종료되도록 돕는 기능
  - 정상 종료의 경우 셧다운 훅 작동, 강제 종료 시에는 작동하지 않는다
  - 모든 세션들을 찾아서 종료하려면 생성한 세션을 보관하고 관리할 객체가 필요 `SessionManger 클래스`
  - 세션의 자원 정리 close() 메서드는 세션 종료시, 서버 종료시 두 곳에서 호출될 수 있다
    - 세션 종료 방식이든 서버 종료 방식이든 일관성 있게 해주도록 두 방법 모두 close()메소드 사용하도록 하는게 자연스럽다
    - 대신 동시성 문제 발생

#### 네트워크 예외 `network.exception 패키지`
- 연결 시도 예외 `Connect 클래스`
  - UnknownHostException: IP 주소나 도메인 이름이 유효하지 않을 때 발생
  - ConnectException : Connection refused: 대상 IP 주소는 유효하지만, 해당 포트에서 실행 중인 서버 애플리케이션이 없어 연결이 거부될 때 발생 (해당 서버 컴퓨터에 접속은 했다는 뜻)
- TCP 연결 타임 아웃 `ConnectTCPTimeOut 클래스`
  - 서버로부터 아무런 응답이 없을 때 발생. OS마다 기본 대기 시간이 다르다
  - java.net.SocketTimeoutException: Connect timed out
- 소켓 타임 아웃 `ConnectSocketTimeOutXxx 클래스`
  - 서버와 연결은 성공했지만, 서버의 과부하 등으로 인해 데이터를 읽는 작업(read())에서 응답이 지연될 때 발생
  - java.net.SocketTimeoutException: Read timed out
- 외부 서버와 통신을 하는 경우 반드시 연결 타임아웃과 소켓 타임아웃을 지정하자

#### 네트워크 종료 `network.close 패키지`
- 정상 종료 (EOF) `NormalColseXxx 클래스`
  - 상대방이 연결을 종료한 경우 데이터를 읽으려고 하면 EOF가 발생
  - 각각의 상황에 따라 EOF를 해석하는 방법이 다르다
    - -1, null , EOFException
  - EOF가 발생하면 상대방이 FIN 메시지를 보내면서 소켓 연결을 끊었다는 뜻
  - 이 경우 FIN 메시지를 받은 클라이언트도 close() 를 호출해서 상대방에 FIN 메시지를 보내고 소켓 연결을 끊어야 한다
- 강제 종료 `ResetCloseXxx 클래스`
  - 서버는 이미 FIN으로 종료를 요청했는데, PUSH 패킷으로 데이터가 전송
    - 서버가 기대하는 값은 FIN 패킷이다.
    - 서버는 TCP 연결에 문제가 있다고 판단하고 즉각 연결을 종료하라는 RST 패킷을 클라이언트에 전송
  - java.net.SocketException: Connection reset
    - RST 패킷을 받은 이후에 read() 호출
  - java.net.SocketException: Broken pipe
    - RST 패킷을 받은 이후에 write() 호출
  - java.net.SocketException: Socket is closed
    - 자신이 소켓을 닫은 이후에 read() , write() 호출
- 네트워크에서 이런 예외를 다 따로따로 이해하고 다루어야 할까? 사실 어떤 문제가 언제 발생할지 자세하게 다 구분해서 처리하기는 어렵다 
- 따라서 기본적으로 정상 종료, 강제 종료 모두 자원 정리하고 닫도록 설계
- 예를 들어 SocketException , EOFException 은 모두 IOException 의 자식이다. 따라서 IOException 이 발생하면 자원을 정리

### 채팅 프로그램 `chatprogram 패키지`
- 클라이언트 측 설계 : I/O 블로킹 문제 해결
  - 클라이언트 측 설계에서 중요한 과제는 프로그램의 흐름을 막지 않고 입출력(I/O) 작업을 처리하는 것
  - 콘솔로부터 사용자 입력을 받는 것(scanner.nextLine())과 서버로부터 데이터를 읽는 것(input.readUTF())은 모두 블로킹(blocking) 연산
  - 두 개의 독립적인 스레드로 분리 (`ReadHandler, WriteHandler`)
  - 핸들러에 close() 메서드를 두는 이유 
    - 자원 해제 책임의 분할 때문 
    - ReadHandler와 WriteHandler는 각각 DataInputStream과 DataOutputStream을 직접 멤버 변수로 가지고 사용. 이는 각 핸들러가 해당 스트림을 통해 데이터를 읽고 쓰는 실제 I/O 작업의 주체임을 의미
    - WriteHandler의 경우, System.in (콘솔 입력)과 관련된 Scanner의 종료 책임 또한 가지고 있다. System.in.close()는 WriteHandler의 고유한 종료 로직이며, 이는 Client 클래스가 직접 관리하기 어려운 부분
    - 즉, 각 핸들러는 자신이 직접 사용하는 I/O 스트림 및 관련 리소스에 대한 종료 시점의 책임을 가진다
- 서버 측 설계 : 클라이언트 연결 관리
  - 서버의 주요 역할은 세션(session)이라고 불리는 모든 활성 클라이언트 연결을 관리하는 것
  - 세션 관리, 메시지 브로드캐스팅, 연결 종료 처리
- 명령어 처리 : 디자인 패턴 적용
  - 커맨드 패턴 (Command Pattern) : 수많은 if-else 문을 사용하는 대신, 각 명령어를 별도의 객체로 캡슐화
  - 널 객체 패턴 (Null Object Pattern) : 존재하지 않는 명령어가 입력되었을 때, null을 반환하는 대신 "알 수 없는 명령어"와 같은 기본 동작을 수행하는 객체를 반환
  - CommandManager에 동시성 컬렉션 사용 안해도 되는 이유? -> 변경이 일어나지 않음 (조회만 함)

### http 서버
- `HttpServer 클래스`
  - ExecutorService를 사용해 정해진 수(예: 10개)의 스레드를 가진 스레드 풀을 생성
  - 요청 처리 객체(HttpRequestHandler)만들고, 스레드 풀에 작업 위임
- `HttpRequestHandler 클래스`
  - 데이터 처리 클래스(BufferedReader/PrintWriter) 생성, HTTP 요청/응답 메시지 객체에 전달
  - ServletManager에 실제 작업 수행토록 위임
  - http 응답 전달
- `HttpRequest/HttpResponse 클래스`
  - http 요청/응답 캡슐화 객체
- `ServletManager 클래스`
  - URL 경로와 해당 경로를 처리할 HttpServlet 구현체를 Map으로 관리 
  - execute() 메서드를 통해 요청된 URL에 맞는 서블릿을 찾아 실행
  - 페이지를 찾지 못하거나(PageNotFoundException) 내부 오류 발생 시 미리 지정된 오류 처리 서블릿을 실행하는 등 서블릿의 생명주기 관리
- HTTP 서비스(프로젝트)를 만들어도 was.httpserver 부분의 코드를 그대로 재사용 할 수 있고, 또 전혀 변경하지 않아도 된다
  - HTTP 서버 관련 부분 `was.httpserver 패키지`
    - HttpServer, HttpRequestHandler, HttpRequest, HttpResponse, HttpServlet 등은 어떤 프로젝트에서든 재사용 가능한 공통 라이브러리 역할
  - 서비스 개발 로직 `was.servlet 패키지`
    - HomeServlet, SearchServlet 등은 특정 애플리케이션에 종속된 비즈니스 로직
    - HTTP, Server, Applet의 줄임말이다. (HTTP 서버에서 실행되는 작은 자바 프로그램(애플릿))
    - 이 인터페이스의 service() 메서드가 있는데, 여기에 서비스 개발과 관련된 부분을 구현하면 된다
- HTTP 통신도 socket 통신을 사용. 대신에 HTTP 요청이 끝나면 해당 socket 통신을 끊어버리는 차이가 있다. (클라이언트가 서버로 요청을 보낼 때마다 새로운 소켓 연결이 이루어지고, 응답을 받은 후에는 즉시 연결이 종료되는 방식)
- HTTP는 매우 보수적, 호환성을 최우선에 둠 -> URL엔 아스키만 가능 (메시지 바디에는 UTF8가능)
  - 발생하는 문제 퍼센트인코딩으로 -> URLEncoder.encode() , URLDecoder.decode 를 사용하면 % 인코딩, 디코딩을 처리할 수 있다

### 리플랙션  `reflection 패키지`
- 클래스의 정보, 즉 메타데이터(metadata)를 담고 있는 Class 객체를 얻을 수 있다
- 리플렉션을 이용한 동적 작업
  - 메서드 탐색과 동적 호출
  - 필드 탐색과 값 변경
  - 생성자 탐색과 객체 생성
- 기존 Servlet 방식의 문제점 해소 `was.httpserver.servlet.reflection 패키지`
  - 기능별 클래스 생성의 번거로움 해소
    - 하나의 클래스 안에 여러 기능을 메서드로 구현하고, 요청에 따라 필요한 메서드만 동적으로 호출
  - URL과 기능의 수동 매핑 작업 제거
    - 새로운 기능을 추가할 때마다 URL 경로와 클래스를 직접 연결하는 코드를 작성해야 하는 번거로움을 해결
- 스프링 프레임워크나 다른 프레임워크 기술들을 사용해보면, 내가 만든 클래스를 프레임워크가 대신 생성해 줄 때가 있다. -> 리플렉션과 동적 객체 생성 방법

### 애노테이션 `annotation 패키지`
- 주석은 코드가 아니다. 따라서 컴파일 시점에 모두 제거
- 애노테이션
  - 프로그램 실행 중(런타임)에 읽어서 사용할 수 있는 특별한 주석 이라고 볼 수 있다
- 메타 애노테이션
  - 애노테이션을 정의하는데 사용하는 특별한 애노테이션
- 애노테이션과 상속
  - 애노테이션은 다른 애노테이션이나 인터페이스를 직접 상속할 수 없다. 오직 java.lang.annotation.Annotation 인터페이스만 상속
  - 따라서 애노테이션 사이에는 상속이라는 개념이 존재하지 않는다
  - 애노테이션을 정의할 때 @Inherited 메타 애노테이션을 붙이면, 애노테이션을 적용한 클래스의 자식도 해당 애노테이션을 부여 받을 수 있다.
    - 이 기능은 클래스 상속에서만 작동, 인터페이스의 구현에는 적용 X
    - 논리적 기반, 다이아몬드 문제
- 기존 Servlet 방식의 문제점 해소 `was.httpserver.servlet.annotation 패키지`
  - 유연한 매핑
  - 메타데이터 활용 (검증기도 가능)

#### 리플랙션 / 애노테이션
- 프레임워크들은 리플렉션과 애노테이션을 활용하여 마법 같은 기능들을 제공
- "마법"의 이면에는 리플렉션과 애노테이션을 활용한 복잡한 메타프로그래밍이 숨어 있다


### 고민했던 부분
- DataOutputStream 의 writeUTF도 블로킹 메서드 인가
  - DataInputStream.readUTF() (읽기 작업)
    - readUTF()는 네트워크(또는 파일)로부터 데이터를 받아와야 한다
    - 호출 시점에 읽을 데이터가 스트림에 존재하지 않으면, readUTF()는 해당 데이터가 도착할 때까지 호출 스레드를 블록
    - 네트워크 통신에서 이것은 "상대방으로부터 응답이 올 때까지" 기다리는 상황에 해당. 데이터가 완전히 읽히거나, 스트림의 끝(EOFException), 또는 I/O 오류가 발생할 때까지 반환되지 않는다.
  - DataOutputStream.writeUTF() (쓰기 작업)
    - writeUTF()는 데이터를 네트워크(또는 파일)로 보내야 한다.
    - writeUTF() 역시 블로킹 메서드. 이는 데이터를 기반 스트림에 완전히 쓰는 작업이 완료될 때까지 호출 스레드를 블록
    - 하지만 readUTF()처럼 "상대방의 응답"을 직접적으로 기다리는 것은 아니다.
    - writeUTF()가 블록되는 주요 이유:
      - 내부 버퍼가 가득 찼을 때: DataOutputStream은 내부 버퍼를 가질 수 있다. writeUTF()가 호출되었을 때 이 버퍼가 가득 차 있다면, 버퍼에 있는 데이터가 실제로 물리적인 출력 장치(네트워크 소켓, 파일 등)로 쓰여질 때까지 블록될 수 있다.
      - 기반 스트림의 쓰기 지연: 데이터를 쓰는 대상(예: 네트워크 소켓)이 현재 데이터를 받아들일 수 없는 상태이거나, 쓰기 작업 자체가 느린 경우(예: 네트워크 혼잡, 디스크 I/O 병목), writeUTF()는 이 쓰기 작업이 완료될 때까지 블록.
      - 즉, 데이터가 애플리케이션의 메모리에서 사라져 네트워크 스택 또는 운영체제 버퍼로 완전히 전달될 때까지 기다림