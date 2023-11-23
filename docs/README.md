입력

- [ ] 로또 구입 금액
    - 예외 사항
    - [ ] 1000원 단위로 떨어질 것
- [ ] 로또 당첨 번호
    - 생성 시 예외 사항
    - [ ] 각 숫자는 1 ~ 45 범위.
    - [ ] 중복 번호 X
    - [ ] 6자리
- [ ] 로또 보너스 번호
    - [ ] 각 숫자는 1 ~ 45 범위.
    - [ ] 로또 당첨 번호와 중복 X
- [ ] 공통 처리
    - [ ] 잘못된 값을 입력할 경우 예외 발생 및 메세지 출력 후 재입력

domain 및 기능

- [ ] 입력한 금액 만큼 로또(`Lotto`) 구매 및 저장(`Lottos`)

- [ ] 당첨 번호 및 보너스 번호로 `WinningLotto` 생성 및 저장

- [ ] 구매한 모든 로또(`Lotto`) 당첨 번호 추첨

- [ ] 추첨 결과 및 수익률 저장

---

입력

`Controller` - `InputManager` - `InputView`

처리

`Controller` - `LottoService` - `LottoRepository`

출력

`Controller` - `OutputView`

