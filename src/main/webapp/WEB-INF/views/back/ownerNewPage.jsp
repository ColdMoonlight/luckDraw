<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lottery</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
	<link rel="stylesheet" href="${APP_PATH}/static/back/css/style.css" />
	<link rel="stylesheet" href="${APP_PATH}/static/common/toastr/toastr.min.css">
</head>
<body>
	<div style="width: 100vw; height: 100vh; display: flex; align-items: center; justify-content: center;">
		<div class="btn btn-primary btn-set" data-value="1">1</div>
		<div class="btn btn-success btn-set" style="margin-left: 2rem;" data-value="2">2</div>
	</div>
    
    <script src="${APP_PATH}/static/common/jquery.min.js"></script>
    <script src="${APP_PATH}/static/back/lib/toastr/toastr.min.js"></script>

    <script>
		$('.btn-set').on('click', function() {
			var reqData = {
				'newGrade': $(this).data('value') || '0',
			};
			$.ajax({
				url: "${APP_PATH }/TbOwnerNew/tbOwnerNewIntoEffect",
				type: "post",
				data: JSON.stringify(reqData),
				dataType: "json",
				contentType: 'application/json',
				success: function (data) {
					if (data.code == 100) {
						toastr.success('重置成功');
					} else {
						toastr.error('重置失败');
					}
				},
				error: function() {
					toastr.error('重置失败');
				}
			});
		});
    </script>
</body>
</html>