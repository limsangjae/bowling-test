<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="ko">
<%@ include file="../include/head.jsp"%>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="../include/main_header.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../include/left_column.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Starter Page</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Starter Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header with-border">
								<h3 class="card-title">댓글 작성</h3>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="form-group col-sm-8">
										<input class="form-control input-sm" id="newReplyText"
											type="text" placeholder="댓글 입력...">
									</div>
									<div class="form-group col-sm-2">
										<input class="form-control input-sm" id="newReplyWriter"
											type="text" placeholder="작성자">
									</div>
									<div class="form-group col-sm-2">
										<button type="button"
											class="btn btn-primary btn-sm btn-block replyAddBtn">
											<i class="fa fa-save"></i> 저장
										</button>
									</div>
								</div>
							</div>
							<div class="card-footer">
								<ul id="replies">

								</ul>
							</div>
							<div class="card-footer">
								<nav aria-label="Contacts Page Navigation">
									<ul
										class="pagination pagination-sm no-margin justify-content-center m-0">

									</ul>
								</nav>
							</div>
						</div>
					</div>

					<div class="modal fade" id="modifyModal" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">댓글 수정창</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="replyNo">댓글 번호</label> <input
											class="form-control" id="replyNo" name="replyNo" readonly>
									</div>
									<div class="form-group">
										<label for="replyText">댓글 내용</label> <input
											class="form-control" id="replyText" name="replyText"
											placeholder="댓글 내용을 입력해주세요">
									</div>
									<div class="form-group">
										<label for="replyWriter">댓글 작성자</label> <input
											class="form-control" id="replyWriter" name="replyWriter"
											readonly>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default pull-left"
										data-dismiss="modal">닫기</button>
									<button type="button" class="btn btn-success modalModBtn">수정</button>
									<button type="button" class="btn btn-danger modalDelBtn">삭제</button>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
			<div class="p-3">
				<h5>Title</h5>
				<p>Sidebar content</p>
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<%@ include file="../include/main_footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<%@ include file="../include/plugin_js.jsp"%>
</body>
<script>
//3번째 게시글
var articleNo = 3;

// 댓글 목록 호출
getReplies();

// 댓글 목록 출력 함수
function getReplies() {

    $.getJSON("${path}/replies/all/" + articleNo, function (data) {

        console.log(data);

        var str = "";

        $(data).each(function () {
            str += "<li data-reply_no='" + this.replyNo + "' class='replyLi'>"
                +   "<p class='replyText'>" + this.replyText + "</p>"
                +   "<p class='replyWriter'>" + this.replyWriter + "</p>"
                +   "<button type='button' class='btn btn-xs btn-success' data-toggle='modal' data-target='#modifyModal'>댓글 수정</button>"
                + "</li>"
                + "<hr/>";

        });

        $("#replies").html(str);

    });

}

</script>
</html>
