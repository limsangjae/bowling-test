<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<!-- Brand Logo -->
		<a href="index3.html" class="brand-link"> <img
			src="../../../dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
			class="brand-image img-circle elevation-3" style="opacity: .8">
			<span class="brand-text font-weight-light">AdminLTE 3</span>
		</a>

		<!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user panel (optional) -->
			<div class="user-panel mt-3 pb-3 mb-3 d-flex">
				<div class="image">
					<img src="${path}/dist/img/user2-160x160.jpg"
						class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<a href="#" class="d-block">Alexander Pierce</a>
				</div>
			</div>

			<!-- SidebarSearch Form -->
			<div class="form-inline">
				<div class="input-group" data-widget="sidebar-search">
					<input class="form-control form-control-sidebar" type="search"
						placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-sidebar">
							<i class="fas fa-search fa-fw"></i>
						</button>
					</div>
				</div>
			</div>

			<!-- Sidebar Menu -->
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
					<li class="nav-item has-treeview menu-open"><a href="#"
						class="nav-link active"> <i
							class="nav-icon fas fa-tachometer-alt"></i>
							<p>
								기본 게시판 <i class="right fas fa-angle-left"></i>
							</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a href="${path}/article/write"
								class="nav-link active"> <i class="far fa-circle nav-icon"></i>
									<p>글쓰기</p>
							</a></li>

							<li class="nav-item"><a href="${path}/article/list"
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>글목록</p>
							</a></li>
						</ul></li>

					<li class="nav-item has-treeview menu-open"><a href="#"
						class="nav-link active"> <i
							class="nav-icon fas fa-tachometer-alt"></i>
							<p>
								페이징 게시판 <i class="right fas fa-angle-left"></i>
							</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a href="${path}/article/paging/write"
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>페이징 글쓰기</p>
							</a></li>
							<li class="nav-item"><a href="${path}/article/paging/list"
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>페이징 목록</p>
							</a></li>
						</ul></li>
					<li class="nav-item has-treeview menu-open"><a href="#"
						class="nav-link"> <i class="nav-icon fas fa-tachometer-alt"></i>
							<p>
								검색 게시판 <i class="right fas fa-angle-left"></i>
							</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a
								href="${path}/article/paging/search/write" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>글쓰기</p>
							</a></li>
							<!-- List Paging 목록 버튼 추가 -->
							<li class="nav-item"><a
								href="${path}/article/paging/search/list" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>검색 페이징 목록</p>
							</a></li>
						</ul></li>

				</ul>
			</nav>
			<!-- /.sidebar-menu -->
		</div>
		<!-- /.sidebar -->
	</aside>
</body>
</html>