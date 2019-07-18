<%@page import="com.SchoolManagement.ApiUri.SessionUri"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta name="description" content="Responsive Admin Template" />
<meta name="author" content="SmartUniversity" />
<title>Quick EDU</title>
<!-- google font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet" type="text/css" />
<!-- icons -->
<link href="fonts/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="fonts/material-design-icons/material-icon.css"
	rel="stylesheet" type="text/css" />
<!--bootstrap -->
<link href="../assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- data tables -->
<link
	href="../assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<!-- Material Design Lite CSS -->
<link rel="stylesheet"
	href="../assets/plugins/material/material.min.css">
<link rel="stylesheet" href="../assets/css/material_style.css">
<!-- Theme Styles -->
<link href="../assets/css/theme/light/theme_style.css" rel="stylesheet"
	id="rt_style_components" type="text/css" />
<link href="../assets/css/theme/light/style.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/css/responsive.css" rel="stylesheet"
	type="text/css" />
<link href="../assets/css/theme/light/theme-color.css" rel="stylesheet"
	type="text/css" />
<!-- favicon -->
<link rel="shortcut icon" href="../assets/img/favicon.ico" />
		<link rel="stylesheet"
	href="../assets/plugins/jquery-toast/dist/jquery.toast.min.css">
</head>
<!-- END HEAD -->

<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white white-sidebar-color logo-indigo">
	<div class="page-wrapper">
		<!-- start header -->
		<div class="page-header navbar navbar-fixed-top">
			<div class="page-header-inner ">
				<!-- logo start -->
				<div class="page-logo">
					<a href="index"> <span
						class="logo-default">Quick EDU</span>
					</a>
				</div>
				<!-- logo end -->
				<ul class="nav navbar-nav navbar-left in">
					<li><a href="#" class="menu-toggler sidebar-toggler"><i
							class="icon-menu"></i></a></li>
				</ul>
				<form class="search-form-opened" action="#" method="GET">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search..."
							name="query"> <span class="input-group-btn"> <a
							href="javascript:;" class="btn submit"> <i
								class="icon-magnifier"></i>
						</a>
						</span>
					</div>
				</form>
				<!-- start mobile menu -->
				<a href="javascript:;" class="menu-toggler responsive-toggler"
					data-toggle="collapse" data-target=".navbar-collapse"> <span></span>
				</a>
				<!-- end mobile menu -->
				<!-- start header menu -->
				<div class="top-menu">
					<ul class="nav navbar-nav pull-right">
						<li><a href="javascript:;" class="fullscreen-btn"><i
								class="fa fa-arrows-alt"></i></a></li>
						<!-- start language menu -->

						<!-- end language menu -->
						<!-- start notification dropdown -->
						<!-- end notification dropdown -->
						<!-- start message dropdown -->
						<!-- end message dropdown -->
						<!-- start manage user dropdown -->
						<li class="dropdown dropdown-user"><a href="javascript:;"
							class="dropdown-toggle" data-toggle="dropdown"
							data-hover="dropdown" data-close-others="true"> <img alt=""
								class="img-circle " src="../assets/img/dp.jpg" /> <span
								class="username username-hide-on-mobile"> <%= session.getAttribute(SessionUri.TecherName) %> </span> <i
								class="fa fa-angle-down"></i>
						</a>
							<ul class="dropdown-menu dropdown-menu-default">
								<li><a href="user_profile"> <i class="icon-user"></i>
										Profile
								</a></li>
								<li><a href="logout"> <i class="icon-logout"></i>
										Log Out
								</a></li>
							</ul></li>
						<!-- end manage user dropdown -->

					</ul>
				</div>
			</div>
		</div>
		<!-- end header -->
		<!-- start color quick setting -->
		<!-- end color quick setting -->
		<!-- start page container -->
		<div class="page-container">
			<!-- start sidebar menu -->
			<div class="sidebar-container">
				<div class="sidemenu-container navbar-collapse collapse fixed-menu">
					<div id="remove-scroll" class="left-sidemenu">
						<ul class="sidemenu  page-header-fixed slimscroll-style"
							data-keep-expanded="false" data-auto-scroll="true"
							data-slide-speed="200" style="padding-top: 20px">
							<li class="sidebar-toggler-wrapper hide">
								<div class="sidebar-toggler">
									<span></span>
								</div>
							</li>
							<li class="sidebar-user-panel">
								<div class="user-panel">
									<div class="pull-left image">
										<img src="../assets/img/dp.jpg"
											class="img-circle user-img-circle" alt="User Image" />
									</div>
									<div class="pull-left info">
										<p> <%= session.getAttribute(SessionUri.TecherName) %></p>
										<a href="#"><i class="fa fa-circle user-online"></i><span
											class="txtOnline"> Online</span></a>
									</div>
								</div>
							</li>
							<li class="nav-item start "><a href="index"
								class="nav-link nav-toggle"> <i class="material-icons">dashboard</i>
									<span class="title">Dashboard</span>
							</a>
							</li>
						
							<li class="nav-item"><a href="#" class="nav-link nav-toggle">
									<i class="material-icons">person</i> <span class="title">Professors</span>
									<span class="arrow"></span>
							</a>
								<ul class="sub-menu">
									<li class="nav-item"><a href="all_professors"
										class="nav-link "> <span class="title">All
												Professors</span>
									</a></li>
									<li class="nav-item"><a href="add_professor"
										class="nav-link "> <span class="title">Add
												Professor</span>
									</a></li>
								
								</ul></li>
							<li class="nav-item"><a href="#" class="nav-link nav-toggle"><i
									class="material-icons">group</i> <span class="title">Students</span><span
									class="arrow"></span></a>
								<ul class="sub-menu">
									<li class="nav-item"><a href="all_students"
										class="nav-link "> <span class="title">All Students</span>
									</a></li>
									<li class="nav-item"><a href="add_student"
										class="nav-link "> <span class="title">Add Student</span>
									</a></li>
									
								</ul></li>
							<li class="nav-item active open"><a href="#"
								class="nav-link nav-toggle"><i class="material-icons">group</i>
									<span class="title">Parents</span><span class="selected"></span>
									<span class="arrow open"></span> </a>
								<ul class="sub-menu">
									<li class="nav-item active"><a href="all_parents"
										class="nav-link "> <span class="title">All Parents</span>
											<span class="selected"></span>
									</a></li>
									<li class="nav-item"><a href="add_parent"
										class="nav-link "> <span class="title">Add Parent</span>
									</a></li>
									
								</ul></li>
							<li class="nav-item"><a href="#" class="nav-link nav-toggle">
									<i class="material-icons">school</i> <span class="title">Attendance</span>
									<span class="arrow"></span> <span
									class="label label-rouded label-menu label-success">new</span>
							</a>
								<ul class="sub-menu">
									
									<li class="nav-item"><a href="add_attendance"
										class="nav-link "> <span class="title">Add Attendance</span>
									</a></li>
									
								</ul></li>
							<li class="nav-item"><a href="#" class="nav-link nav-toggle">
									<i class="material-icons">business</i> <span class="title">Departments</span>
									<span class="arrow"></span>
							</a>
								<ul class="sub-menu">
									
									<li class="nav-item"><a href="add_department"
										class="nav-link "> <span class="title">Add
												Department</span>
									</a></li>
								
								</ul></li>
							<li class="nav-item"><a href="#" class="nav-link nav-toggle">
									<i class="material-icons">email</i> <span class="title">Email</span>
									<span class="arrow"></span> <span
									class="label label-rouded label-menu label-danger">new</span>
							</a>
								<ul class="sub-menu">
									<li class="nav-item"><a href="email_inbox"
										class="nav-link "> <span class="title">Inbox</span>
									</a></li>
									<li class="nav-item"><a href="email_view"
										class="nav-link "> <span class="title">View Mail</span>
									</a></li>
									<li class="nav-item"><a href="email_compose"
										class="nav-link "> <span class="title">Compose Mail</span>
									</a></li>
								</ul></li>
							<li class="nav-item"><a href="#" class="nav-link nav-toggle">
									<i class="material-icons">monetization_on</i> <span
									class="title">Fees</span> <span class="arrow"></span>
							</a>
								<ul class="sub-menu">
								
									<li class="nav-item"><a href="add_fees"
										class="nav-link "> <span class="title">Add Fees </span>
									</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- end sidebar menu -->
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">All Parents List</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Parents</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">All Parents List</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="tabbable-line">
								<ul class="nav customtab nav-tabs" role="tablist">
									<li class="nav-item"><a href="#tab1"
										class="nav-link active" data-toggle="tab">List View</a></li>
									<li class="nav-item"><a href="#tab2" class="nav-link"
										data-toggle="tab">Grid View</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active fontawesome-demo" id="tab1">
										<div class="row">
											<div class="col-md-12">
												<div class="card card-box">
													<div class="card-head">
														<header>All Parents List</header>

													</div>
													<div class="card-body ">
														<div class="row">
															<div class="col-md-6 col-sm-6 col-6">
																<div class="btn-group">
																	<a href="/add_parent" id="addRow" class="btn btn-info">
																		Add New <i class="fa fa-plus"></i>
																	</a>
																</div>
															</div>

														</div>
														<div class="table-scrollable">
															<table
																class="table table-striped table-bordered table-hover table-checkable order-column valign-middle"
																id="example4">
																<thead>
																	<tr>
																		<th></th>
																		<th>Name</th>
																		<th>Students Name</th>
																		<th>Mobile</th>
																		<th>Email</th>
																		<th>Action</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="abc" items="${studentList}">
																		<tr class="odd gradeX">
																			<td class="patient-img"><img
																				src="../assets/img/std/std10.jpg" alt=""></td>

																			<td>${abc.name } &nbsp;${abc.lastName }</td>
																			<td class="left">${abc.stu.name }</td>
																			<td>${abc.mobileNo }</td>
																			<td>${abc.emialID }</td>

																			<td><a href="/editParent?id=${abc.id }"
																				class="btn btn-primary btn-xs"> <i
																					class="fa fa-pencil"></i>
																			</a>
																				<button class="btn btn-danger btn-xs">
																					<i class="fa fa-trash-o "></i>
																				</button></td>
																		</tr>
																	</c:forEach>

																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab2">
										<div class="row">
											<c:forEach var="abc" items="${studentList}">
											<div class="col-md-4">
												<div class="card card-box">
													<div class="card-body no-padding ">
														<div class="doctor-profile">
															<img src="../assets/img/std/std10.jpg" class="doctor-pic"
																alt="">
															<div class="profile-usertitle">
																<div class="doctor-name">${abc.name } &nbsp;${abc.lastName }</div>
																<div class="name-center">${abc.stu.name }</div>
															</div>
															
															<div>
																<p>
																	<i class="fa fa-phone"></i>
																		${abc.mobileNo }
																</p>
															</div>
															<div>
																<p>
																	<i class="fa fa-envelope-o"></i>
																		${abc.emialID }
																</p>
															</div>
															<div class="profile-userbuttons">
																<a href="professor_profile"
																	class="btn btn-circle deepPink-bgcolor btn-sm">Read
																	More</a>
															</div>
														</div>
													</div>
												</div>
											</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end page content -->
			<!-- start chat sidebar -->
			<div class="chat-sidebar-container" data-close-on-body-click="false">
				<div class="chat-sidebar">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a href="#quick_sidebar_tab_1"
							class="nav-link active tab-icon" data-toggle="tab"> <i
								class="material-icons">chat</i>Chat <span
								class="badge badge-danger">4</span>
						</a></li>
						<li class="nav-item"><a href="#quick_sidebar_tab_3"
							class="nav-link tab-icon" data-toggle="tab"> <i
								class="material-icons">settings</i> Settings
						</a></li>
					</ul>
					<div class="tab-content">
						<!-- Start User Chat -->
						<div class="tab-pane active chat-sidebar-chat in active show"
							role="tabpanel" id="quick_sidebar_tab_1">
							<div class="chat-sidebar-list">
								<div class="chat-sidebar-chat-users slimscroll-style"
									data-rail-color="#ddd" data-wrapper-class="chat-sidebar-list">
									<div class="chat-header">
										<h5 class="list-heading">Online</h5>
									</div>
									<ul class="media-list list-items">
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof3.jpg" width="35" height="35"
											alt="..."> <i class="online dot"></i>
											<div class="media-body">
												<h5 class="media-heading">John Deo</h5>
												<div class="media-heading-sub">Spine Surgeon</div>
											</div></li>
										<li class="media">
											<div class="media-status">
												<span class="badge badge-success">5</span>
											</div> <img class="media-object" src="../assets/img/prof/prof1.jpg"
											width="35" height="35" alt="..."> <i class="busy dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Rajesh</h5>
												<div class="media-heading-sub">Director</div>
											</div>
										</li>
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof5.jpg" width="35" height="35"
											alt="..."> <i class="away dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Jacob Ryan</h5>
												<div class="media-heading-sub">Ortho Surgeon</div>
											</div></li>
										<li class="media">
											<div class="media-status">
												<span class="badge badge-danger">8</span>
											</div> <img class="media-object" src="../assets/img/prof/prof4.jpg"
											width="35" height="35" alt="..."> <i class="online dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Kehn Anderson</h5>
												<div class="media-heading-sub">CEO</div>
											</div>
										</li>
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof2.jpg" width="35" height="35"
											alt="..."> <i class="busy dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Sarah Smith</h5>
												<div class="media-heading-sub">Commerce</div>
											</div></li>
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof7.jpg" width="35" height="35"
											alt="..."> <i class="online dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Vlad Cardella</h5>
												<div class="media-heading-sub">Civil</div>
											</div></li>
									</ul>
									<div class="chat-header">
										<h5 class="list-heading">Offline</h5>
									</div>
									<ul class="media-list list-items">
										<li class="media">
											<div class="media-status">
												<span class="badge badge-warning">4</span>
											</div> <img class="media-object" src="../assets/img/prof/prof6.jpg"
											width="35" height="35" alt="..."> <i
											class="offline dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Jennifer Maklen</h5>
												<div class="media-heading-sub">Engineering</div>
												<div class="media-heading-small">Last seen 01:20 AM</div>
											</div>
										</li>
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof8.jpg" width="35" height="35"
											alt="..."> <i class="offline dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Lina Smith</h5>
												<div class="media-heading-sub">Science</div>
												<div class="media-heading-small">Last seen 11:14 PM</div>
											</div></li>
										<li class="media">
											<div class="media-status">
												<span class="badge badge-success">9</span>
											</div> <img class="media-object" src="../assets/img/prof/prof9.jpg"
											width="35" height="35" alt="..."> <i
											class="offline dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Jeff Adam</h5>
												<div class="media-heading-sub">Music</div>
												<div class="media-heading-small">Last seen 3:31 PM</div>
											</div>
										</li>
										<li class="media"><img class="media-object"
											src="../assets/img/prof/prof10.jpg" width="35" height="35"
											alt="..."> <i class="offline dot"></i>
											<div class="media-body">
												<h5 class="media-heading">Anjelina Cardella</h5>
												<div class="media-heading-sub">Physiotherapist</div>
												<div class="media-heading-small">Last seen 7:45 PM</div>
											</div></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- End User Chat -->
						<!-- Start Setting Panel -->
						<div class="tab-pane chat-sidebar-settings" role="tabpanel"
							id="quick_sidebar_tab_3">
							<div class="chat-sidebar-settings-list slimscroll-style">
								<div class="chat-header">
									<h5 class="list-heading">Layout Settings</h5>
								</div>
								<div class="chatpane inner-content ">
									<div class="settings-list">
										<div class="setting-item">
											<div class="setting-text">Sidebar Position</div>
											<div class="setting-set">
												<select
													class="sidebar-pos-option form-control input-inline input-sm input-small ">
													<option value="left" selected="selected">Left</option>
													<option value="right">Right</option>
												</select>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Header</div>
											<div class="setting-set">
												<select
													class="page-header-option form-control input-inline input-sm input-small ">
													<option value="fixed" selected="selected">Fixed</option>
													<option value="default">Default</option>
												</select>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Footer</div>
											<div class="setting-set">
												<select
													class="page-footer-option form-control input-inline input-sm input-small ">
													<option value="fixed">Fixed</option>
													<option value="default" selected="selected">Default</option>
												</select>
											</div>
										</div>
									</div>
									<div class="chat-header">
										<h5 class="list-heading">Account Settings</h5>
									</div>
									<div class="settings-list">
										<div class="setting-item">
											<div class="setting-text">Notifications</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-1"> <input type="checkbox"
														id="switch-1" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Show Online</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-7"> <input type="checkbox"
														id="switch-7" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Status</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-2"> <input type="checkbox"
														id="switch-2" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">2 Steps Verification</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-3"> <input type="checkbox"
														id="switch-3" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
									</div>
									<div class="chat-header">
										<h5 class="list-heading">General Settings</h5>
									</div>
									<div class="settings-list">
										<div class="setting-item">
											<div class="setting-text">Location</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-4"> <input type="checkbox"
														id="switch-4" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Save Histry</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-5"> <input type="checkbox"
														id="switch-5" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
										<div class="setting-item">
											<div class="setting-text">Auto Updates</div>
											<div class="setting-set">
												<div class="switch">
													<label
														class="mdl-switch mdl-js-switch mdl-js-ripple-effect"
														for="switch-6"> <input type="checkbox"
														id="switch-6" class="mdl-switch__input" checked>
													</label>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end chat sidebar -->
		</div>
		<c:if test="${not empty msg }">
			<c:choose>
				<c:when test="${msg.code eq 200}">
					<div id="msgID" onload="sucMsg('${msg.message}')"></div>
				</c:when>
				<c:otherwise>
					<div id="msgID" onload="errorMsg('${msg.message}')"></div>
				</c:otherwise>
			</c:choose>

		</c:if>
		</div>
		<!-- end page container -->
		<!-- start footer -->
		<div class="page-footer">
			<div class="page-footer-inner">
				2019 &copy; Quick EDU BY Appsack
			</div>
			<div class="scroll-to-top">
				<i class="icon-arrow-up"></i>
			</div>
		</div>
		<!-- end footer -->
	</div>
	<!-- start js include path -->
	<script src="../assets/plugins/jquery/jquery.min.js"></script>
	<script src="../assets/plugins/popper/popper.js"></script>
	<script src="../assets/plugins/jquery-blockui/jquery.blockui.min.js"></script>
	<script src="../assets/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>
	<!-- bootstrap -->
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../assets/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
	<!-- data tables -->
	<script src="../assets/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap4.min.js"></script>
	<script src="../assets/js/pages/table/table_data.js"></script>
	<!-- Common js-->
	<script src="../assets/js/app.js"></script>
	<script src="../assets/js/layout.js"></script>
	<script src="../assets/js/theme-color.js"></script>
	<!-- Material -->
	<script src="../assets/plugins/material/material.min.js"></script>
	<script src="../assets/plugins/jquery-toast/dist/jquery.toast.min.js"></script>
	<script src="../assets/js/Tost.js"></script>
	<!-- end js include path -->
</body>

</html>