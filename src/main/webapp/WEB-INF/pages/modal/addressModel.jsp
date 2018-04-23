<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="myAddressModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">
					<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;添加新收货地址
				</h4>
			</div>
			<div class="modal-body">
				<!--登录的form表单-->
				<form action="" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-md-2 control-label" style="margin-right: 2.9%;">所在地区:</label>

						<div data-toggle="distpicker">
							<div class="form-group col-sm-12 col-md-3">
								<label class="sr-only" for="province1">Province</label> <select
									class="form-control" id="province1"></select>
							</div>
							<div class="form-group col-sm-12 col-md-3">
								<label class="sr-only" for="city1">City</label> <select
									class="form-control" id="city1"></select>
							</div>
							<div class="form-group col-sm-12 col-md-3">
								<label class="sr-only" for="district1">District</label> <select
									class="form-control" id="district1"></select>
							</div>
						</div>
					</div>
					
					<div class="form-group has-feedback" style="clear: both">
						<label for="lastname" class="col-sm-2 control-label">详细地址:</label>
						<div class="col-sm-5">
							<textarea class="form-control" id="addressdeatails"></textarea>
						</div>
					</div>
					
					<div class="form-group has-feedback">
						<label class="col-sm-2 control-label">邮政编码</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="addressyoubian" 
								placeholder="邮政编码"> 
							<span class="glyphicon glyphicon-hand-left form-control-feedback"></span>
						</div>
					</div>

					<div class="form-group has-feedback">
						<label class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="addressusername"
								placeholder="收货人姓名"> 
							<span class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
					</div>

					<div class="form-group has-feedback">
						<label class="col-sm-2 control-label">电话</label>
						<div class="col-sm-5">
							<input type="tel" class="form-control" id="addresstel"
								placeholder="合法手机格式">
						    <span class="glyphicon glyphicon-phone form-control-feedback"></span>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox" id="setDefaultAddr">
								<span class="text-success">设置默认地址</span>
								</label>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="button" class="btn btn-primary" value="提交地址" onclick="checkAddress()">
					</div>
				</form>
				<!--form结束-->
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
</div>

