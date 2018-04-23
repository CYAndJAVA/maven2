<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <!-- 登录模态框（Modal） -->
            <%
            String remembername = "";
            String rememberpassword = "";
            Cookie[] cookies = request.getCookies();
            if(cookies!=null && cookies.length>0){
                for(Cookie c:cookies){
                    if("login".equals(c.getName())){
                        String value = c.getValue();
                        String uname = value.split(":")[0];
                        //对uname可能为中文的进行二级解码
                        remembername = URLDecoder.decode(URLDecoder.decode(uname, "UTF-8"),"UTF-8");
                        rememberpassword = value.split(":")[1];
                    }
                }
            }
            request.setAttribute("remU", remembername);
            request.setAttribute("remP", rememberpassword);
        %>
        <div class="modal fade" id="myLoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                        <h4 class="modal-title" id="myModalLabel">
                    用户登录
                </h4>
                    </div>
                    <div class="modal-body">
                        <!--登录的form表单-->
                        <form class="form-horizontal" role="form" action="">
                            <div class="form-group has-feedback">
                                <label for="userName" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-5">

                                    <input type="text" value="${remU}" class="form-control" id="userName" placeholder="请输入用户名" 
                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="la1" class="alert-success"></label>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="userPassword" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="userPassword" placeholder="请输入密码" 
                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')" value="${remP}">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="la2" class="alert-success"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input id="rememberMe" type="checkbox">请记住我
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <input type="button" onclick="checkLogin()" class="btn btn-primary" value="登录">
                            </div>
                        </form>
                        <!--form结束-->
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
        </div>
        <!-- 登录modal end/.modal -->
        <!-- 注册begin -->
        <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                        <h4 class="modal-title" id="myModalLabel">
                    用户注册
                </h4>
                    </div>
                    <div class="modal-body">
                        <!--登录的form表单-->
                        <form action="${path }/user/check/registering" class="form-horizontal" role="form" method="post">
                            <div class="form-group has-feedback">
                                <label for="newUserName" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-5">
                                    <input name="cUserName" type="text" class="form-control" id="newUserName" 
                                    onblur="checkRegister(1)" onkeyup="this.value=this.value.replace(/[, ]/g,'')" required placeholder="小写字母开头,不含中文.">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab1" class=""></label>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="newPassword" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-5">
                                    <input name="cPassword" type="password" class="form-control" id="newPassword"  
                                    onblur="checkRegister(2)" onkeyup="this.value=this.value.replace(/[, ]/g,'')" 
                                    required placeholder="密码长度1-8位" minlength="1" maxlength="8">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab2" class=""></label>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="copyPassword" 
                                    onblur="checkRegister(3)" required minlength="1" maxlength="8" placeholder="和密码保持一致">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab3" class=""></label>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-5">
                                    <input name="cEmail" type="email" class="form-control" id="newEmail" 
                                    onblur="checkRegister(4)" onkeyup="this.value=this.value.replace(/[, ]/g,'')" required placeholder="合法邮箱格式">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab4" class=""></label>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">电话</label>
                                <div class="col-sm-5">
                                    <input name="cPhone" type="tel" class="form-control" id="newPhone" 
                                    onblur="checkRegister(5)" onkeyup="this.value=this.value.replace(/[, ]/g,'')" required placeholder="合法手机格式">
                                    <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab5" class=""></label>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">公司</label>
                                <div class="col-sm-5">
                                    <input name="cCompany" type="text" class="form-control" id="newCompany"
                                     onblur="checkRegister(6)" required onkeyup="this.value=this.value.replace(/[, ]/g,'')" placeholder="请输入公司地址">
                                    <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab6" class=""></label>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label">地址</label>
                                <div class="col-sm-5">
                                    <input name="cAddress" type="text" class="form-control" id="newAddress" 
                                    onblur="checkRegister(7)" required placeholder="请输入收货地址">
                                    <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                </div>
                                <div class="col-sm-3" style="padding-top: 10px;">
                                    <label id="lab7" class=""></label>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button onclick="refreshClass()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <input id="cRegisterBut" disabled = "true" type="submit"  class="btn btn-primary" value="注册">
                            <!--disabled = "disabled"  -->
                            </div>
                        </form>
                        <!--form结束-->
                    </div>
                </div>
            </div>
        </div>
        <!-- 注册end -->
                <!-- /.modal-content -->
                <script src="${path}/js/checkUser.js"></script>
