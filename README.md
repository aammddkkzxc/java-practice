### 자바 학습
- 자바 개인 학습 레포지토리
- [김영한의 실전 자바 로드맵](https://www.inflearn.com/roadmaps/744)을 학습 후 정리하고 싶은 내용들만 포함되어 있습니다
- 각 디렉토리 content.md에 내용 정리
- 중요도가 더 높거나 헷갈리기 쉽다고 판단한 내용들은 최상위 [question.md](https://github.com/aammddkkzxc/java-practice/blob/master/question.md) 파일에 정리

### 학습 내용
- 객체지향 및 언어 핵심 **(basic, mid1)**
  - 상속 및 구현, 다형성에 대한 이해
  - Objcet, String, 불변 객체
  - 열거형 패턴
  - 중첩 클래스
  - 예외/예외 처리의 필요성, try-with-resources
- 제네릭, 컬렉션 **(mid2)**
  - 제네릭과 와일드카드, 타입 이레이저
  - 컬렉션의 시간 복잡도 및 실제 성능 차이
  - 해시 알고리즘
  - Iterable/Iterator를 통한 순회
  - Comparable/Comparator를 통한 정렬
- 멀티스레딩 및 동기화 **(adv1)**
  - 스레드, 스레드 상태, 스레드 깨우기, 인터럽트 상태 확인 및 변경
  - 메모리 가시성, volatile, happens-before
  - 동기화, synchronized, Lock, ReentrantLock을 통한 synchronized 한계 극복
  - 생산자-소비자 문제, Object.wait(), Object.notify(), Condition, BlockingQueue
  - Executor 프레임워크, 스레드 풀 필요성 (스레드 생성/관리 비용), ExecutorServic 우아한 종료, ThreadPoolExecutor 관리 방식, 스레드 풀 전략, Executor 예외 정책
- I/O 및 네트워크 **(adv2)**
  - 문자 인코딩, 한글 깨짐
  - 기본/보조 스트림, 버퍼
  - 파일, Files
  - 네트워크, ServerSocket, Socket, 네트워크 자원 정리, shutdownhook, 네트워크 예외, 네트워크 종료
  - HTTP 서버, Servlet, WAS
- 리플렉션, 어노테이션, 람다, 스트림 **(adv3)**
  - 컴파일/런타임 메타데이터, 어노테이션 상속, 스프링 프레임워크 활용 예시
  - 람다와 익명 클래스 차이, 스트림 API, Optional
  - Fork/Join, 공용 풀, 병렬 스트림

### 느낀점
- 마법처럼 느껴지는 동작들이 결국 모두 자바 코드 동작한다는 것
- 개발자의 실수를 줄이고 안정성을 보장하기 위한 제약과 원칙이 중요하다
- 이해도를 높이고 유연하며 편리한 구조를 위한 기술, 디자인 패턴, 그리고 철학이 반영됨을 깨달음
- 기존 방식의 한계를 극복하고 문제를 해결하는 자바의 발전 과정을 알 수 있었다

### 수료증
- https://www.inflearn.com/certificate/1325255-333308-13007657
- https://www.inflearn.com/certificate/1325255-333482-13027792
- https://www.inflearn.com/certificate/1325255-334352-13027791
- https://www.inflearn.com/certificate/1325255-334977-13214578
- https://www.inflearn.com/certificate/1325255-336672-14125124
