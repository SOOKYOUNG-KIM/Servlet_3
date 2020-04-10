# Servlet_3
 
 ## 기능
 
 #### = like point table
 - 공지사항(Notice) 게시판
 - 글쓰기, 수정, 삭제 id가 admin 만 가능  // FNC 홈페이지 참고
 - 글 리스트 페이지, 최신순으로 출력
 - 리스트페이지에서 글쓰기 버튼을 클릭하면 글쓰기로 이동 ->admin외에는 글쓰기 버튼이 보이면 안됨 
 - 리스트 페이지에서 글 제목을 클릭하면 글상세보기로 이동
 - 글 상세보기에서 글수정, 글삭제 버튼 존재 -> 삭제 수정 버튼도 admin외에는 버튼이 보이면 안됨 (체크시 로그인하고 들어가야함)
 - 글 삭제버튼을 클릭하면 확인&취소 창을 띄우고 확인클릭 시 삭제, 취소는 그대로 
 - 글 수정버튼을 클릭하면 글수정 페이지로 이동
 - 날짜는 date 클래스로
 - 날짜는 현재시간으로 넣기
 - 글번호는 자동으로 1씩 증가
 - 조회수는 컬럼만 만들어 놓기
 - [option] 조회수, 글 상세보기로 들어오면 조회수를 1증가
 
 - *멤버가 널이 아닌 애들중에서 아이디가 어드민인사람으로 검색 * -> 멤버가 널이 아니라면 아이디가 어드민인사람찾아서 뫄뫄해줘라
 
 
 ### Notice
 - notice list 출력
 - notice Add 등록
 - notice Update 수정
 - notice Delete 삭제
 
 
 ## JSP
 - noticeList.jsp		: List 출력
 - noticeAdd.jsp		: 입력 폼
 - noticeSelect.jsp		: point 하나의 상세정보 출력
 - noticeUpdate.jsp		: point 수정 폼


 ## URL 주소					/  JSP 				/ Method
 ### /WEB-INF/views/notice/**
 - /notice/noticeList		/  noticeList.jsp	/ GET
 - /notice/noticeAdd		/  noticeAdd.jsp	/ GET
 - /notice/noticeAdd		/  					/ POST
 - /notice/noticeSelect		/  noticeSelect.jsp	/ GET
 - /notice/noticeUpdate		/  noticeUpdate.jsp	/ GET
 - /notice/noticeUpdate		/  					/ POST
 - /notice/noticeDelete		/  					/ GET

 
 
 
 
  ### Member
 - 회원가입(insert) 
 - 로그인(Select One)
 - 회원수정(update)
 - 회원탈퇴(Delete)
 - myPage
 
 
 ## JSP
 
 
 ## URL 주소				/  JSP 				/ Method
 ### /WEB-INF/views/member/**
 - /member/memberJoin	/  memberJoin.jsp	/ GET
 - /member/memberJoin	/  					/ POST
 - /member/memberLogin	/  memberLogin.jsp	/ GET
 - /member/memberLogin	/  					/ POST
 - /member/memberPage	/  memberPage.jsp	/ GET
 - /member/memberUpdate	/  memberUpdate.jsp	/ GET
 - /member/memberUpdate	/  					/ POST
 - /member/memberDelete	/  					/ GET

 
 
 
  ### Point
 - point list 출력
 - point 등록
 - point 상세정보
 - point 수정
 - point 삭제
 
 ## JSP
 - pointList.jsp	: List 출력
 - pointAdd.jsp		: 입력 폼
 - pointSelect.jsp	: point 하나의 상세정보 출력
 - pointMod.jsp		: point 수정 폼
 
 
 ## URL 주소				/  JSP 				/ Method
 ### /WEB-INF/views/point/**
 - /point/pointList		/  pointList.jsp	/ GET
 - /point/pointAdd		/  pointAdd.jsp		/ GET
 - /point/pointAdd		/  					/ POST
 - /point/pointSelect	/  pointSelect.jsp	/ GET
 - /point/pointMod		/  pointMod.jsp		/ GET
 - /point/pointMod		/  					/ POST
 - /point/pointDelete	/  					/ GET
