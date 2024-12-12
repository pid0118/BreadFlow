# SpringBoot-Project BreadFlow
스프링부트를 이용한 공급망관리시스템SCM 프로세스 구축

## 🖥️ 프로젝트 소개
제빵제과 프렌차이즈 기업의 원활한 자재&공급망 관리를위한  SCM프로그램 BreadFlow Project

## 🕰️개발 기간
2024-11-13 ~ 2024-12-2 총14일 (주말제외)

### 🧑‍🤝‍🧑맴버소개및 역활
- 조장 김건휘 : 주문발주 및 재고관리파트
- 부조장 박진석 : 계정관리 및 생산일정관리파트
- git 박인득 : 원부재료 및 제품 파트
- 개발환경 조민성 : 입출고 및 불량관리파트
- DB 공승원 :  매출정보조회 및 pos기기파트

### ⚙️개발환경


- FRONT : HTML / CSS / JS / AJAX / BOOTSTRAP / grid
- BACK : SpringBoot 3.2.11 / Spring Security / Java21 / Mybatis 3.0.0 / Lombok / Maven /
- IDE : Eclipse / Visual Studio Code / ORACLE Sqldeveloper
- DATABASE :  Oracle
- 배포 : AWS, docker, jenkins

BACK / IDE / 배포
=========
<table>
  <tr>
    <td>
      <img src="https://img.icons8.com/?size=100&id=13679&format=png&color=000000">
    </td>
    <td>
      <img src="https://img.icons8.com/?size=100&id=90519&format=png&color=000000">
    </td>
    <td>
      <img src="https://velog.velcdn.com/images/shinhyocheol/post/1362c283-9f91-41f6-9f2b-d4d1b27a8931/image.jpeg" style="width: 100px;">
    </td>
    <td>
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpjACmZWDnK2UI_vpKRBO4NZXNKlAGpqkECQ&s" style="width: 100px;">
    </td>
    <td>
      <img src="data:image/png;base64,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"  style="width: 100px;">
    </td>
    <td>
      
    </td>
    <td>
      
    </td>
  </tr>
  <tr>
    <td>Java21</td>
    <td>SpringBoot<br>3.2.11</td>
    <td>Lombok</td>
    <td>Spring Security</td>
    <td>mybatis</td>
    <td>Spring Security</td>
    <td>Spring Security</td>
  </tr>
  
</table>

FRONT / 협업 / 라이브러리
=========================

### 📌 주요 기능

