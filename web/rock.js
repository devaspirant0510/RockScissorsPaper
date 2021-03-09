// html 에서 현재 상태를 가져올 태그의 클래스를 가져옴
let state = document.querySelector(".state");

let left = '0';
// 가위바위보 이미지를 웹어서 불러오고 크롭할 픽셀값을 객체형태로 만듦
let rsp = {
    바위: '0',
    가위: '-142px',
    보: '-284px'
};
// 버튼을 클릭했을때 이벤트처리를 위해 Button id 값을 연결시킴
let win = document.querySelector("#winner");
let lose = document.querySelector("#loser");
let draw = document.querySelector("#drawer");
// 게임시작핼때 승리수,패배수,무승부수 0으로 초기화
let winPoint = 0;
let losePoint = 0;
let drawPoint = 0;

// rsp 객체의 키값과 파라미터로 받은 키값을 비교해서 똑갘을시 그 인덱스의 밸류값을 리턴함
// 즉 이 메서드의 역할은 픽셀값을 받으면 rsp 객체와 비교해 키 값을 리턴함
function reverse_rsp(pos) {
    return Object.entries(rsp).find(function (v) {
        return v[1] === pos;
    })[0];
}

// setInterval 콜백함수 호출 (무한반복)
// 가위바위보를 계속 순환시켜 반복
// 순환시키는 간격 100ms
let interval = setInterval(function () {
    // 바위일때 바위로 바꿈
    if (left === rsp.바위) {
        left = rsp.가위;
    }
    // 가위일때 보로 바꿈
    else if (left === rsp.가위) {
        left = rsp.보;
    }
    // 보일때 바위로 바꿈
    else {
        left = rsp.바위;
    }
    // 웹에서 이미지 한개만 불러와 크롭시켜 보여줌
    document.querySelector('#computer').style.background = 'url("https://en.pimg.jp/023/182/267/1/23182267.jpg") ' + left + ' 0';

}, 100);

// 문자열 값을 정수로 바꿔줌
function rspToInt(user) {
    switch (user) {
        case "가위":
            return -1;
        case "바위":
            return 0;
        case "보":
            return 1;
        default:
            return null;
    }
}

// 가위바위보 로직
/**
 *      가위      바위      보
 * 가위 무:-1 -1 패: -1 0 승 -1 1
 * 바위 승:0 -1  무: 0 0 패 0 1
 * 보  패:1 -1  승 1 0  무 1 1
 * 승 1 -2
 * 무 0
 * 패 2 -1
 */

// 컴퓨터와 내가 낸걸 보고 결과를 판단해줌
function result(my, computer) {
    // 편한 비교를 위해 정수로 바꿔줌
    let myNum = rspToInt(my);
    let comNum = rspToInt(computer);
    // 가위 = -1 바위 = 0 보 = 1
    // 상대와 내가 같은경우
    // div 태그의 textContent 를 draw 로 바꾸고 리턴
    if (myNum === comNum){
        state.textContent = "draw";
        return 0;
    }
    // (내가낸 값 - 컴퓨터가 낸 값)이 1이거나 -2 일경우 이김
    // div 태그의 textContent 를 win 으로 바꾸고 리턴
    else if(myNum-comNum===1 || myNum-comNum===-2){
        state.textContent = "win";
        return 1;
    }
    // (내가낸 값 - 컴퓨터가 낸 값)이 -1 이거나 2일경우 짐
    // div 태그의 textContent 를 lose 로 바꾸고 리턴
    else{
        state.textContent = "lose";
        return 2;
    }


}
// 클래스가 btn 인 태그를 forEach 문으로 돌려서 클릭이벤트
document.querySelectorAll(".btn").forEach(function (btn) {
    btn.addEventListener("click", function () {
        console.log(reverse_rsp(left));
        // 버튼 클릭했을때 clearInterval 로 interval 종료시킴
        clearInterval(interval);
        // 결과를 보여주고 2초뒤 다시 setInterval 함수 실행
        setTimeout(function () {
            interval = setInterval(function () {
                if (left === rsp.바위) {
                    left = rsp.가위;
                } else if (left === rsp.가위) {
                    left = rsp.보;
                } else {
                    left = rsp.바위;
                }
                document.querySelector('#computer').style.background = 'url("https://en.pimg.jp/023/182/267/1/23182267.jpg") ' + left + ' 0';
                // 버튼 클릭시 리턴시킴
                result(btn.textContent, reverse_rsp(left));
            }, 100);
        }, 2000);
        // 결과에 따라 승리포인트,패배포인트,무승부포인트를 올림
        let state = result(btn.textContent, reverse_rsp(left));
        switch (state) {
            case 0:
                drawPoint += 1;
                draw.textContent = drawPoint;
                break;
            case 1:
                winPoint += 1;
                win.textContent = winPoint;
                break;
            case 2:
                losePoint += 1;
                lose.textContent = losePoint;
                break;
        }

    });

});
