# RockScissorsPaper
<table>
  <tr><td>가위</td><td>-1</td></tr>
  <tr><td>바위</td><td>0</td></tr>
  <tr><td>보</td><td>1</td></tr>
</table>

#### 내 값 - 상대방 값 

<table width=1>
  <tr>
    <td>나\상대</td>
    <td>가위</td>
    <td>바위</td>
    <td>보</td>
  </tr>
  <tr>
    <td >가위</td>
    <td bgcolor="yellow" >-1\-1 = 0</td>
    <td bgcolor="red">-1\0 = -1</td>
    <td bgcolor="green">-1\1 = -2</td>
  </tr>
  <tr>
    <td>바위</td>
    <td bgcolor="green">0\-1 = 1</td>
    <td bgcolor="yellow" >0\0 = 0</td>
    <td bgcolor="red">0\1 = -1</td>
  </tr>
  <tr>
    <td>보</td>
    <td bgcolor="red">1\-1 = 2</td>
    <td bgcolor="green">1\0 = 1</td>
    <td  bgcolor="yellow">1\1 = 0</td>
  </tr>
</table>

#### 가위 바위 보를 각각 -1,0,1 로 바꾸고
#### 내가 낸값과 상대방이 낸 값을 빼줌
#### 값을 뺀결과 
#### 0 무승부
#### 1,-2 승리
#### -1,2 패배
