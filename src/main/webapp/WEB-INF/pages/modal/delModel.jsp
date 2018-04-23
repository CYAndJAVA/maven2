<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                <!--删除提示模态框 begin-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <!--如果没有选中任何一个商品的时候,出现-->
                    <div id="first_del" style="display: none;">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title text-warning" id="myModalLabel">抱歉!请您先选择商品!</h4>
                                </div>
                                <div class="modal-body">请选进行勾选!再执行删除删除!</div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                    </div>
                    <!--first_del  end-->
                    <!--如果没有选中了一个商品的时候,出现-->
                    
                    <!--two_del -->
                    <div id="two_del" style="display: none;">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title text-warning" id="myModalLabel">删除商品,慎重操作!</h4>
                                </div>
                                <div class="modal-body">此操作一旦进行,数据将不可恢复!</div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-danger" onclick="delRows(this)">确定删除</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                    </div>
                    <!--two_del  end-->
                </div>
                <!--删除提示模态框 end-->

