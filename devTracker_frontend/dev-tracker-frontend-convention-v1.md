# Dev Tracker Frontend Convention v1.0

## 1. 목적

Dev Tracker 프론트엔드는 다음 목표를 따릅니다:

-   기능 단위 구조 유지
-   UI와 로직의 명확한 분리
-   AI 비동기 흐름에 대응 가능한 구조
-   확장 가능하고 리팩토링 가능한 설계

------------------------------------------------------------------------

## 2. 기본 기술 스택

-   React + TypeScript
-   Zustand (필요 시에만 전역 상태 관리)
-   MUI (Theme 기반 통일)
-   기능 단위 폴더 구조

------------------------------------------------------------------------

## 3. 폴더 구조

    src/
     ├─ app/              # 전역 설정
     ├─ shared/           # 공용 컴포넌트 / 유틸
     ├─ features/         # 기능 단위 모듈
     ├─ pages/            # 라우팅 전용 컴포넌트
     ├─ layouts/          # 공통 레이아웃

### 기능 단위 예시

    features/
     └─ devRecord/
         ├─ components/
         ├─ hooks/
         ├─ api/
         ├─ types/
         └─ index.ts

------------------------------------------------------------------------

## 4. 네이밍 규칙

### 컴포넌트

-   PascalCase 사용
-   예: DevRecordWrite, DevRecordDetail

### Hook

-   반드시 use 접두어 사용
-   예: useDevRecordWrite, useAiAnalysis

### API 함수

-   동사 + 대상
-   예: createDevRecord, fetchDevRecordList

------------------------------------------------------------------------

## 5. 컴포넌트 작성 원칙

-   컴포넌트는 UI 조립만 담당
-   비즈니스 로직은 Hook으로 분리
-   API 직접 호출 금지

예:

``` tsx
export default function DevRecordWrite() {
  const { form, handleChange, handleSubmit } = useDevRecordWrite()

  return (
    <div>
      <input value={form.title} onChange={handleChange} />
      <button onClick={handleSubmit}>저장</button>
    </div>
  )
}
```

------------------------------------------------------------------------

## 6. Hook 작성 원칙

Hook은 다음 순서로 작성합니다:

1.  상태 선언
2.  파생 값 계산
3.  이벤트 핸들러 정의
4.  API 호출 함수
5.  return

예:

``` ts
export function useDevRecordWrite() {
  const [form, setForm] = useState({ title: "" })

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm(prev => ({ ...prev, title: e.target.value }))
  }

  const handleSubmit = async () => {
    await createDevRecord(form)
  }

  return { form, handleChange, handleSubmit }
}
```

------------------------------------------------------------------------

## 7. 상태관리 규칙

### 로컬 상태

-   대부분은 useState 사용

### 전역 상태

-   로그인 정보
-   테마 정보
-   전역 알림 상태

Zustand는 최소한으로 사용합니다.

------------------------------------------------------------------------

## 8. AI 기능 전용 규칙

AI 호출은 일반 CRUD와 분리합니다.

    features/aiAnalysis/
     ├─ hooks/useAiAnalysisRequest.ts
     ├─ hooks/useAiAnalysisPolling.ts
     └─ api/aiAnalysisApi.ts

-   로딩 상태 명확히 분리
-   실패 처리 반드시 구현

------------------------------------------------------------------------

## 9. 라우팅 규칙

pages는 조립만 수행합니다.

``` tsx
export default function DevRecordWritePage() {
  return (
    <MainLayout>
      <DevRecordWrite />
    </MainLayout>
  )
}
```

------------------------------------------------------------------------

## 10. PR 체크리스트

-   UI와 로직이 분리되었는가?
-   API 직접 호출이 존재하지 않는가?
-   네이밍 규칙을 따르는가?
-   불필요한 전역 상태가 없는가?
-   비동기 에러 처리가 구현되었는가?

------------------------------------------------------------------------

## 11. 확장 전략

-   기능 추가 시 features 하위에 모듈 생성
-   Hook 중심 설계 유지
-   AI 비동기 흐름은 별도 모듈로 분리

------------------------------------------------------------------------

Dev Tracker Frontend Convention v1.0
